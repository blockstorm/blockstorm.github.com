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
		setImg('img/slideshow02.png');
	}, 5000);
	
	setTimeout(function() {
		setImg('img/slideshow03.png');
	}, 10000);
	
	setTimeout(function() {
		setImg('img/slideshow01.png');
		slideshow();
	}, 15000);
}
