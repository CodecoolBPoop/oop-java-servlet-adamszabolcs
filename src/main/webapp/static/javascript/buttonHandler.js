
$(".add").click(addToCart, event);

function addToCart(event) {
    var id = event.target.id;
    $.post("/addtocart", {id:id}, function (response) {
        alert(response);
    })
}

$(".remove").click(removeFromCart, event);

function removeFromCart(event) {
    var id = event.target.id;
    $.post("/remove", {id:id}, function (response) {
        alert(response);
    })
}