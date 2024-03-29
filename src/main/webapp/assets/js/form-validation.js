let department_create_form = document.getElementById('department-create');
let department_update_form = document.getElementById('department-update');
let department_delete_form = document.getElementById('department-delete');

window.onload = read_department;

async function read_department(){
    let response = await fetch("api/department/read");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);

    // Add to the update drop down
    let department_option = document.getElementById('select_department_update');
    department_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<departments.length ; i++){
        department_option.innerHTML += '<option value="'+departments[i]["dept_id"]+'">'+departments[i]["dname"]+'</option>';
    }

    // Add to the delete drop down
    let department_option_delete = document.getElementById('select_department_delete');
    department_option_delete.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 1; i<departments.length ; i++){
        department_option_delete.innerHTML += '<option value="'+departments[i]["dept_id"]+'">'+departments[i]["dname"]+'</option>';
    }

    // Add to the table.
    for(let i = 0 ; i < departments.length ; i++){
        var table = document.getElementById( 'department-table' ),
            row = table.insertRow(-1),
            cell1 = row.insertCell(0),
            cell2 = row.insertCell(1),
            cell3 = row.insertCell(2),
            cell4 = row.insertCell(3);

        cell1.innerHTML = departments[i]["dept_id"];
        cell2.innerHTML = departments[i]["dname"];
        cell3.innerHTML = departments[i]["capacity"];
        cell4.innerHTML = "<input type='button' class=\"btn btn-primary btn-block\" onclick='showEmployee("+departments[i]["dept_id"]+");'  value='Show employees' />";
    }
}

function showEmployee(param){
    window.open("http://localhost:8080/hrproject2_war/employee.html?dept_id=" + param, '_blank');
}

department_delete_form.addEventListener('submit', async (e) =>{
    e.preventDefault();
    e.stopPropagation();

    if(department_delete_form.checkValidity() === true){
        let selected_dept_id_delete = document.getElementById('select_department_delete');
        console.log(selected_dept_id_delete.value);
        let response = await fetch('api/department/'+selected_dept_id_delete.value+'/delete', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }});
        console.log(response);
        window.alert("Department Deleted successfully!");
        location.reload();
    }
});

department_create_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (department_create_form.checkValidity() === true) {
      let cap = document.getElementById("capacity_create").value;
      if(cap <= 0){
          window.alert("Capacity needs to be more than 0");
      }
      else {
          let response = await fetch('api/department/create', {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json;charset=utf-8'
              },
              body: JSON.stringify({
                  dept_id: 1,
                  dname: document.getElementById('dname_create').value,
                  capacity: document.getElementById('capacity_create').value,
              })
          });
          console.log(response);
          window.alert("Department created!");
          location.reload();
      }
  }
});

department_update_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (department_update_form.checkValidity() === true) {
        let cap = document.getElementById("capacity_update").value;
        if(cap <= 0){
            window.alert("Capacity needs to be more than 0");
        }
        else {
            let selected_dept_id_update = document.getElementById('select_department_update');
            console.log(selected_dept_id_update.value);
            console.log(selected_dept_id_update.options[selected_dept_id_update.selectedIndex].text);
            let response = await fetch('api/department/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    dept_id: selected_dept_id_update.value,
                    dname: selected_dept_id_update.options[selected_dept_id_update.selectedIndex].text,
                    capacity: document.getElementById('capacity_update').value,
                })
            });
            console.log(response);
            window.alert("Data updated successfully!");
            location.reload();
        }
    }

});
