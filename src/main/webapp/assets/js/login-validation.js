let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        let form_data = new FormData();
        form_data.append('email', document.getElementById('email').value);
        let response = await fetch('api/employee/login', {
            method: 'POST',
            body: form_data
        });
        let result = await response;
        console.log(result);
        if(result["status"]===200){
            location.href = "dashboard.html";
        }else{
            document.getElementById("login-alert").style.display = "block";
        }

    }
});