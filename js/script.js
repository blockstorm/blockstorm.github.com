$(document).ready(function() {
	slideshow();
})

function setImg(img) {
	$('#current-image')
	.fadeOut(500, function() {
		$('#current-image').attr('src', img);
	})
	.fadeIn(700);
}

function slideshow() {    
    setTimeout(function() {
	setImg('img/slideshow04.png');
    }, 6000);

    setTimeout(function() {
	setImg('img/slideshow06.png');
    }, 12000);
    
    setTimeout(function() {
	setImg('img/slideshow07.png');
    }, 18000);
    
    setTimeout(function() {
	setImg('img/slideshow05.png');
	slideshow();
    }, 24000);
}
