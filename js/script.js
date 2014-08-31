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
	setImg('img/slideshow09.png');
    }, 6000);

    setTimeout(function() {
	setImg('img/slideshow10.png');
    }, 12000);
    
    setTimeout(function() {
	setImg('img/slideshow11.png');
    }, 18000);
    
    setTimeout(function() {
	setImg('img/slideshow04.png');
    }, 24000);

    setTimeout(function() {
	setImg('img/slideshow05.png');
    }, 30000);

    setTimeout(function() {
	setImg('img/slideshow08.png');
	slideshow();
    }, 36000);

}
