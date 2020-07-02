$(document).ready(function() {
  console.log('Setting up cancel form');
  $("#cancel-form").submit(function(event) {
    event.preventDefault();
    let appointment = $("#id").val();
    let ok = confirm('Are you sure you want to cancel the appointment with id: ' + appointment);
    console.log('ok:', ok);
    if (ok) {
        let url = "http://localhost:8080/appointments/cancel/" + appointment;
        console.log('Invoking: ' + url);

         //Using long hand form - some browsers don't support short hand version
        $.ajax({
            type : "POST",
            url : url,
            success: function (result) {
                   console.log(result);
                   alert('Appointment Cancelled');
                   document.getElementById("id").value = '';
            },
            error: function (e) {
                console.log(e);
                alert('Something went wrong');
            }
        });
    }
  });
});