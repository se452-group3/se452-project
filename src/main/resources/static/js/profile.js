var updateURL = document.getElementById("imageurl-profile");
var profilePicture = document.getElementById("profilePicture");

updateURL.addEventListener("input", (event) => profilePicture.src = updateURL.value);
