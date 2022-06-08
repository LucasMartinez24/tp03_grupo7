const list = document.querySelectorAll('.list');
function activeLink(){
  list.forEach((item) => 
  item.classList.remove('active'));
  this.classList.add('active');
}
list.forEach((item) => 
item.addEventListener('mouseover',activeLink));
list.forEach((item) => 
item.addEventListener('mouseout',activeLink));

//modal
function confirmarEliminar(dni) {
  jQuery.noConflict();
  $('#modalEliminar').modal('show');
  $("#identificadorUsuarioHiddenInput").val(dni);
}
function eliminarUsuario() {
  var id = $("#identificadorUsuarioHiddenInput").val();
  window.location = "eliminarUsuario/" + dni;
}

//eliminar
function confirmarEliminar(id) {
  $("#identificadorDeUsuario").val(id);
  $('#modalEliminar').modal('show');
}

function eliminarUsuario() {
  var id = $("#identificadorDeUsuario").val();
  window.location = "/eliminarUsuario/" + id;
}