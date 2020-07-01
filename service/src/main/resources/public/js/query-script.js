$(document).ready(function() {
  console.log('Setting up query form');
  $("#query-form").submit(function(event) {
    let url = "http://localhost:8080/appointments/" + $("#id").val();
    console.log('Invoking: ' + url);
    $.get(url, function(appointment) {
       console.log('In post callback function - ', appointment);
       $("#appointment").empty();
       let html = "<h3 class='title'>" + appointment.id + "</h3>";
       html += "<ul>"
       html += "<li>datetime: " + appointment.datetime + "</li>";
       html += "<li>duration: " + appointment.duration + "</li>";
       html += "<li>provider: " + appointment.provider + "</li>";
       html += "<li>client: " + appointment.client + "</li>";
       html += "<li>cost: " + appointment.cost + "</li>";
       html += "<li>description: " + appointment.description + "</li>";
       html += "<li>flag: " + appointment.flag + "</li>";
       html += "</ul>"
       $("#appointment").append($(html));
     });
    event.preventDefault();
  });
});
