let employee_form = document.getElementById('employee-validation');
window.onload = fetch_department;
window.onload = read_department;

async function fetch_department(){
    let response = await fetch("api/department/get");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);
    let department_option = document.getElementById('department');
    department_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<departments.length ; i++){
        department_option.innerHTML += '<option value="'+departments[i]+'">'+departments[i]+'</option>';
    }
}

async function read_department(){
    let response = await fetch("api/department/read");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);
    let department_option = document.getElementById('department-table').getElementsByTagName("tr");

    //department_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i < departments.length ; i++){
        let row = department_option.insertRow;

        let col1 = row.insertCell();
        col1.appendChild(departments[i]["dept_id"]);

        /*let dept_id = document.getElementById("dept_id");
        dept_id.innerHTML += departments[i]["dept_id"];
        let dname = document.getElementById("dname");
        dname.innerHTML += departments[i]["dname"];
        let capacity = document.getElementById("capacity");
        capacity.innerHTML += departments[i]["capacity"];
        department_option.innerHTML += "</tr>";*/

    }
}
/*employee_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (employee_form.checkValidity() === true) {
    let form_data = new FormData();
    form_data.append('email', document.getElementById('email').value);
    let response = await fetch('api/employee/login', {
      method: 'POST',
      body: form_data
    });
    let result = await response;
    console.log(result);
  }
});*/



/*
async function fetch_courses(){
    let response = await fetch("api/courses/get");
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);
    let courses_option = document.getElementById('courses');
    courses_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<courses.length ; i++){
        courses_option.innerHTML += '<option value="'+courses[i]+'">'+courses[i]+'</option>';
    }
}*/
