var slideIndex = 1;
showSlide(slideIndex);


function plusSlides(n){
showSlide(slideIndex += n);
}

function currentSlide(n) {
showSlide(slideIndex = n);

}


function showSlide(n){

var i;
var slides = document.getElementsByClassName("imageholder");



if (n > slides.length) { slideIndex = 1};

if (n < 1) { slideIndex = slides.length};

for (i=0;i<slides.length;i++) {

slides[i].style.display = "none";

};



slides[slideIndex-1].style.display = "block";



}

		
		
 		
		
		
 		

		
		
 		