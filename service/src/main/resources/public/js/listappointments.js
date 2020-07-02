$(document).ready(function() {
  $("#show").click(function() {
    console.log("running click on show");
    event.preventDefault();
    $.get("http://localhost:8080/appointments/list", function(appointments) {
          $("#appointmentlist").empty();
          let html = "<div class='appointment'>";
          $.each(appointments, function(i, appointment) {
              console.log(appointment);
              html += "<h3 class='title'>Appointment " + appointment.id + "</h3>";
              html += "<ul>"
              html += "<li>datetime: " + appointment.datetime + "</li>";
              html += "<li>duration: " + appointment.duration + "</li>";
              html += "<li>provider: " + appointment.provider + "</li>";
              html += "<li>client: " + appointment.client + "</li>";
              html += "<li>cost: " + appointment.cost + "</li>";
              html += "<li>description: " + appointment.description + "</li>";
              html += "<li>flag: " + appointment.flag + "</li>";
              html += "</ul>";
            });
            html += "</div>";
            $("#appointmentlist").append($(html));
      });
    });
  });
