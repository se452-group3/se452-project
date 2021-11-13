var updateURL = document.getElementById("imageurl-product");
var pictureProduct = document.getElementById("picture-product");

updateURL.addEventListener("input", (event) => pictureProduct.src = updateURL.value);
