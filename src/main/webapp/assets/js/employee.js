/*let employee_table = document.getElementById("employee-table");*/

window.onload = read_employees;

async function read_employees(){
    let params = new URLSearchParams(location.search);
    let dept_id = params.get('dept_id');
    let response = await fetch("api/department/"+dept_id+"/employees");
    let employees = await response.json(); // read response body and parse as JSON
    console.log(employees);

    // Add to the table.
    for(let i = 0 ; i < employees.length ; i++){
        var table = document.getElementById( 'employee-table' ),
            row = table.insertRow(-1),
            cell1 = row.insertCell(0),
            cell2 = row.insertCell(1),
            cell3 = row.insertCell(2),
            cell4 = row.insertCell(3),
            cell5 = row.insertCell(4),
            cell6 = row.insertCell(5);
        ;

        cell1.innerHTML = employees[i]["emp_id"];
        cell2.innerHTML = employees[i]["title"];
        cell3.innerHTML = employees[i]["first_name"];
        cell4.innerHTML = employees[i]["last_name"];
        cell5.innerHTML = employees[i]["email"];
        cell6.innerHTML = employees[i]["dept_id"]["dname"];
    }
}
