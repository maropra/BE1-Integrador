window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/students/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(student of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + student.id + '\"' +
                                  ' type="button" onclick="deleteBy('+student.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + student.id + '\"' +
                                  ' type="button" onclick="findBy('+student.id+')" class="btn btn-info btn_id">' +
                                  student.id +
                                  '</button>';

      let tr_id = 'tr_' + student.id;
      let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + student.name.toUpperCase() + '</td>' +
                '<td class=\"td_last_name\">' + student.lastname.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#studentTable tbody').append(studentRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/studentsList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})