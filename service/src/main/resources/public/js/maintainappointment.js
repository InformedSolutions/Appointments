$(document).ready(function() {
  console.log('Setting up update form');

  $("#search").click(function() {
      // Stop form from submitting normally
      event.preventDefault();
        console.log('SEARCH BUTTON PRESSED');
      let url = "http://localhost:8080/appointments/" + $("#id").val();
      $.get(url, function(appointment) {
         console.log('In post callback function - ', appointment);
         $("#appointment").empty();
          document.getElementById("id").value = appointment.id;
          document.getElementById("datetime").value = truncateString(appointment.datetime,"2020-03-03T04:23".length);
          document.getElementById("duration").value = appointment.duration;
          document.getElementById("provider").value = appointment.provider;
          document.getElementById("client").value = appointment.client;
          document.getElementById("cost").value = appointment.cost;
          document.getElementById("description").value = appointment.description;
          setFlagRadio(appointment.flag);
       });
       document.getElementById('add').innerText = 'Update';
  });

  $("#update-form").submit(function(event) {
      // Stop form from submitting normally
      event.preventDefault();
      console.log('UPDATE BUTTON PRESSED');
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

    $("#clear").click(function() {
      // Stop form from submitting normally
      event.preventDefault();
        console.log('CLEAR BUTTON PRESSED');
          document.getElementById("id").value = '';
          document.getElementById("datetime").value = '';
          document.getElementById("duration").value = '';
          document.getElementById("provider").value = '';
          document.getElementById("client").value = '';
          document.getElementById("client").value = '';
          document.getElementById("cost").value = '';
          document.getElementById("description").value = '';
          setFlagRadio("NULL");
          document.getElementById('add').innerText = 'Add';
      });
});

function truncateString(str, num) {
  // If the length of str is less than or equal to num
  // just return str--don't truncate it.
  if (str.length <= num) {
    return str
  }
  // Return str truncated with '...' concatenated to the end of str.
  return str.slice(0, num)
}

function setFlagRadio(str) {

    if (str == ("A")) {
        radiobtn = document.getElementById("flagA");
        radiobtn.checked = true;
    }
    else if (str == ("M")){
        radiobtn = document.getElementById("flagM");
        radiobtn.checked = true;
    }
    else if( str == ("C") || str == "" || str == "NULL"){
        radiobtnA = document.getElementById("flagA");
        radiobtnM = document.getElementById("flagM");
        radiobtnA.checked = false;
        radiobtnM.checked = false;
    }
}