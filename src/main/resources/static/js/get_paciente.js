/*$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/pacientes",
            success: function(response){
              $.each(response, (i, paciente) => {

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' +
                                            paciente.id +
                                            '</button>';

                let tr_id = 'tr_' + paciente.id;

                let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_first_name\">' + paciente.nombre.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + paciente.apellido + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.dni + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.fechaAlta + '</td>' +
                          '<td class=\"td_matricula\">' + "" + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.domicilio.calle + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.domicilio.numero + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.domicilio.ciudad + '</td>' +
                          '<td class=\"td_matricula\">' + paciente.domicilio.pais + '</td>' +
                          '</tr>';
                $('#tablaPacietesBody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});*/

window.addEventListener('load', function (event) {

  event.preventDefault();
  const url = '/pacientes';
  const settings = {
    method: 'GET'
  }

  fetch(url, settings)
    .then(response => response.json())
    .then(data => {
      for (paciente of data) {
        console.log(paciente)

        let deleteButton =
                    `<button id= "btn_delete_${paciente.id}" type="button" onclick="pacienteDeleteBy(${paciente.id})" class="btn btn-danger btn_delete">
                        &times
                     </button>`;

        let get_More_Info_Btn =
            `<button id="btn_id_${paciente.id}" type="button" onclick="findPacienteBy(${paciente.id})" class="btn btn-info btn_id">
                ${paciente.id}
            </button>`;

        let tr_id = 'tr_' + paciente.id;
        let pacienteRow =
        `<tr id=${tr_id}>
            <td>${get_More_Info_Btn}</td>
            <td class=td_nombre>${paciente.nombre}</td>
            <td class=td_apellido>${paciente.apellido} </td>
            <td class=td_dni>${paciente.dni}</td>
            <td class=td_fecha>${paciente.fechaIngreso}</td>

            <td>${deleteButton}</td>
        </tr>`;
        console.log("pacienteRow" + pacienteRow);
        console.log($('#pacienteTable tbody'));
        $('#pacienteTable tbody').append(pacienteRow);
      };

    })
})

