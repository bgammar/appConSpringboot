document.addEventListener('DOMContentLoaded',cargarEnemigos)

async function cargarEnemigos(){
    try{
        const response = await fetch('api/enemigo');
        const enemigos = await response.json();
        mostrarEnemigos(enemigos);
    }catch(error){
        console.error("Error all cargar usuarios "+error);
    }
    tablestyle.display();

    /*
    ??
    const tabla = document.getElementById('enemigosTable');
        if (tabla) { // Verificar si el elemento existe
            tabla.style.display = 'table';
        }
    */
}

async function mostrarEnemigos(enemigos){
    const tbody = document.getElementById('enemigosBody')

    tbody.innerHTML = '';

    if(enemigos.length === 0){
        console.log("no hay enemigos");
    }

    enemigos.forEach(enemigo => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${enemigo.id}</td>
            <td>${enemigo.nombre}</td>
            <td>${enemigo.pais}</td>
            <td>${enemigo.afiliacion}</td>
        `;
        tbody.appendChild(tr);
    });

    table.style.display = 'table';
}

document.addElementById('formInsertatrEnemigo').addEventListener('submit', insertarEnemigo)

async function insertarEnemigo(){
    const nombre = document.getElementById('nombre').value;
    const pais = document.getElementById('pais').value;
    const afiliacion = document.getElementById('afiliacion').value;
    const btnSubmit = document.getElementById('btnSubmit');
    const nuevoEnemigo;

    //Esto es mientras se procesa
    btnSubmit.disabled=true;
    btnSubmit.textContent='Enviando a francia...';

    try{
        const response = await fetch('api/enemigo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nombre: nombre,
                pais: pais,
                afiliacion: afiliacion
            })
        });

        if(response.ok){
            const nuevoEnemigo = await response.json();
            document.getElementById('formInsertarEnemigo')
            //await cargarEnemigos();
        }else{
            const error = await response.text();
            console.log(error);
        }

    }catch(error){
        console.log(error);
    }finally{
        btnSubmit.disable(false);
        btnSubmit.textContext='Agregar Enemigo';
    } //fin try-catch
} //fin insertar

