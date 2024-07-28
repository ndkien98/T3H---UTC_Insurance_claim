$(document).ready(function() {
    console.log("jquery start")
    $.ajax({
        url: 'http://localhost:8080/user/profile',
        type: 'GET',
        success: function(response) {
            console.log("call api success: " + response)
        },
        error: function(error) {
            console.log("call api error: " + error)
        }
    });
});