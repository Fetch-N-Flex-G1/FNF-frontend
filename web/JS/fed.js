document.addEventListener("DOMContentLoaded", function () {
    const sliderText = document.querySelector(".slider-text");
    const leftArrow = document.querySelector(".left-arrow");
    const rightArrow = document.querySelector(".right-arrow");

    let slideIndex = 0;

    // Function to show a specific slide
    function showSlide(index) {
        const slides = sliderText.querySelectorAll("p");
        if (index < 0) {
            slideIndex = slides.length - 1;
        } else if (index >= slides.length) {
            slideIndex = 0;
        }
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slides[slideIndex].style.display = "block";
    }

    showSlide(slideIndex);

    
    leftArrow.addEventListener("click", function () {
        slideIndex--;
        showSlide(slideIndex);
    })

    rightArrow.addEventListener("click", function () {
        slideIndex++;
        showSlide(slideIndex);
    });
});