var exampleModal = document.getElementById('modalEliminar')
const openModal = document.querySelectorAll('.hero_cta');
console.log(openModal);
const modal = document.querySelector('.modal');
const closeModal = document.querySelector('.modal_close');
for (i = 0; i < openModal.length; i++) {
	openModal[i].addEventListener('click', (e)=>{
    e.preventDefault();
    modal.classList.add('modal--show');
});
}


closeModal.addEventListener('click', (e)=>{
    e.preventDefault();
    modal.classList.remove('modal--show');
});

function confirmarEliminar(id) {
	$("#identificadorDeCurso").val(id);
}

function eliminarCurso() {
	var id = $("#identificadorDeCurso").val();
	window.location = "/eliminarcurso/" + id;
}