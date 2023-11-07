function showGreyBox() {
    const redBoxElement = document.querySelector(".grey-box");
    redBoxElement.style.display = "block";
    }

    const image = document.querySelector(".top img");
    image.addEventListener("click", showGreyBox);

    document.addEventListener("click", function(event) {
    if (event.target !== document.querySelector(".top img") && event.target !== document.querySelector(".grey-box")) {
        document.querySelector(".grey-box").style.display = "none";
        document.querySelector(".grey-box").classList.add("disabled");
    }
    });