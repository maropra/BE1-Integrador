window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_student_form');
    formulario.addEventListener('submit', function (event) {
        let studentId = document.querySelector('#student_id').value;
        const formData = {
            id: document.querySelector('#student_id').value,
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,

        };
        const url = '/students';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/students'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let student = data;
              document.querySelector('#student_id').value = student.id;
              document.querySelector('#nombre').value = student.name;
              document.querySelector('#apellido').value = student.lastname;

              document.querySelector('#div_student_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }