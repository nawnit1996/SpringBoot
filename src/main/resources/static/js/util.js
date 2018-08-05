function toogleNavbarContent() {
	if (document.getElementById("myNavbar").style.display == "block") {
		document.getElementById("myNavbar").style.display = "none";
		document.getElementById("mySidebar").style.display = "none"
	} else {
		document.getElementById("myNavbar").style.display = "block";
		document.getElementById("mySidebar").style.display = "none"
	}

}
function toogleSidebarContent() {
	if (document.getElementById("mySidebar").style.display == "block") {
		document.getElementById("mySidebar").style.display = "none"
		document.getElementById("myNavbar").style.display = "none";
	} else {
		document.getElementById("mySidebar").style.display = "block"
		document.getElementById("myNavbar").style.display = "none";
	}

}