// Obtener la referencia a la tabla y al modal
const tableBody = document.querySelector("#odontologoTable tbody");
const editModal = new bootstrap.Modal(document.getElementById("editModal"));
const editForm = document.getElementById("editForm");
let currentOdontologoId;
// Función para obtener y mostrar los odontólogos
function fetchOdontologos() {
  // listar los pacientes
  fetch(`http://localhost:8080/odontologo/buscartodos`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      // Limpiar el contenido actual de la tabla
      tableBody.innerHTML = "";

      // Insertar los datos en la tabla
      data.forEach((odontologo, index) => {
        const row = document.createElement("tr");

        row.innerHTML = `
              <td>${odontologo.id}</td>
              <td>${odontologo.apellido}</td>
              <td>${odontologo.nombre}</td>
              <td>${odontologo.nroMatricula}</td>
              <td>
                <button class="btn btn-primary btn-sm" onclick="editOdontologo(${odontologo.id}, '${odontologo.apellido}','${odontologo.nombre}', '${odontologo.nroMatricula}')">Modificar</button>
                <button class="btn btn-danger btn-sm" onclick="deleteOdontologo(${odontologo.id})">Eliminar</button>
              </td>
            `;

        tableBody.appendChild(row);
      });
    })
    .catch((error) => {
      console.error("Error fetching data:", error);
    });
}

// Función para abrir el modal y cargar los datos del paciente
editOdontologo = function (id, apellido, nombre, nroMatricula) {
  currentOdontologoId = id;
  document.getElementById("editApellido").value = apellido;
  document.getElementById("editNombre").value = nombre;
  document.getElementById("editNroMatricula").value = nroMatricula;
  editModal.show();
};

// Función para editar un paciente
editForm.addEventListener("submit", function (event) {
  event.preventDefault();
  const apellido = document.getElementById("editApellido").value;
  const nombre = document.getElementById("editNombre").value;
  const nroMatricula = document.getElementById("editNroMatricula").value;

  //modificar un paciente
  fetch(`http://localhost:8080/odontologo/modificar`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      id: currentOdontologoId,
      nombre,
      apellido,
      nroMatricula,
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("odontologo modificado con éxito");
      fetchOdontologo();
      editModal.hide();
    })
    .catch((error) => {
      console.error("Error editando odontologo:", error);
    });
});

// Función para eliminar un paciente
deleteOdontologo = function (id) {
  if (confirm("¿Está seguro de que desea eliminar este paciente?")) {
    // eliminar el paciente
    fetch(`http://localhost:8080/odontologo/eliminar/${id}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        alert("Odontologo eliminado con éxito");
        fetchOdontologo();
      })
      .catch((error) => {
        console.error("Error borrando odontologo:", error);
      });
  }
};

// Llamar a la función para obtener y mostrar los odontólogos
fetchOdontologos();
