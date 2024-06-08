const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginbtn = document.getElementById('login');
registerBtn.addEventListener('click',()=>{
    container.classList.add("active");
});
loginbtn.addEventListener('click',()=>{
    container.classList.remove("active");
});