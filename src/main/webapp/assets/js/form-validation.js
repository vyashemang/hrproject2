let employee_form = document.getElementById('employee-validation');
//window.onload = fetch_courses;

employee_form.addEventListener('submit', async (e) => {
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
});

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
