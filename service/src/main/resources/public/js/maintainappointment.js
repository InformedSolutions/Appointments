$(document).ready(function() {
  console.log('Setting up update form');
  $("#update-form").submit(function(event) {
      // Stop form from submitting normally
      event.preventDefault();

      let url = "http://localhost:8080/appointments";

      let obj = $(this).serializeJSON();
      let data = JSON.stringify(obj);
      console.log(data)

      $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(result) {
            console.log(result);
            alert('Appointment Updated');
        },
        failure: function(errMsg) {
           alert(errMsg);
        },
        contentType: "application/json; charset=utf-8",
        dataType: "json"
      });
  });
});