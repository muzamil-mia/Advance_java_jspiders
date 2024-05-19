const heading = document.getElementById("heading");
//console.log(heading);

const sentence = "Welcome To Shopify";

let characterIndex = 0;
updateText()

function updateText() {
  characterIndex++;
  heading.innerHTML = `
  <h1>${sentence.slice(0, characterIndex)}</h1>
  `
  if(characterIndex === sentence.length) {
    characterIndex = 0;
  }

  setTimeout(updateText, 200)
}

let button1 = document.getElementsByClassName("login1");
//console.log(button1);
let button2  = document.getElementsByClassName("login2");

button1[0].addEventListener("click", (e) => {
  let container = document.getElementsByClassName("login-block1");
  showBlock(container);
})

button2[0].addEventListener("click", (e) => {
  e.stopPropagation();
  let container = document.getElementsByClassName("login-block2");
  showBlock(container);
})

function showBlock(container) {
  console.log(container);
  let display = container[0].classList.toggle("true");
  if(display){
    container[0].style.display = "block";
  }else{
    container[0].style.display = "none";
  }
}

document.body.addEventListener('click', (event) => {
  // Check if the clicked element is NOT part of the login block
  // console.log(event.target);
  if (!event.target.closest('.login-block1') && !event.target.closest('.login-block2') && !event.target.classList.contains('login1') && !event.target.classList.contains('login2')) {
    // Hide the login blocks
    let container1 = document.querySelector(".login-block1");
    container1.style.display = "none";

    let container2 = document.querySelector(".login-block2");
    container2.style.display = "none";
}
});