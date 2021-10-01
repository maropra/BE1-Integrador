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
            <td class=td_direccion>${paciente.domicilio.calle} ${paciente.domicilio.numero}</td>
            <td class=td_localidad>${paciente.domicilio.localidad}</td>
            <td class=td_provincia>${paciente.domicilio.provincia}</td>

            <td>${deleteButton}</td>
        </tr>`;
        console.log("pacienteRow" + pacienteRow);
        console.log($('#pacienteTable tbody'));
        $('#pacienteTable tbody').append(pacienteRow);
      };

    })
})

