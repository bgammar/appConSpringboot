document.addEventListener('DOMContentLoaded',cargarEnemigos)

async function cargarEnemigos(){
    try{
        const response = await fetch('api/enemigo');
        const enemigos = await response.json();
        mostrarEnemigos(enemigos);
    }catch(error){
        console.error("Error all cargar usuarios "+error);
    }
}

async function mostrarEnemigos(enemigos){
    const tbody = document.getElementById('enemigosBody')
    const table = document.getElementById('enemigosTable')

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

document.getElementById('formInsertarEnemigo').addEventListener('submit', insertarEnemigo);
document.getElementById('formEditarEnemigo').addEventListener('submit', editarEnemigo);
document.getElementById('formBorrarEnemigo').addEventListener('submit', borrarEnemigo);


async function insertarEnemigo(e){
    e.preventDefault();
    const nombre = document.getElementById('nombreInsertar').value;
    const pais = document.getElementById('paisInsertar').value;
    const afiliacion = document.getElementById('afiliacionInsertar').value;
    const btnSubmit = document.getElementById('btnSubmitInsertar');


    //Esto es mientras se procesa
    btnSubmit.disabled=true;
    btnSubmit.textContent='Enviando a francia...';

    try{
        console.log('mandando post...')
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
            document.getElementById('formInsertarEnemigo').reset();
            await cargarEnemigos();
        }else{
            const error = await response.text();
            console.log(error);
        }

    }catch(error){
        console.log(error);
    }finally{
        btnSubmit.disabled=false;
        btnSubmit.textContent='Agregar Enemigo';
    } //fin try-catch
} //fin insertar


async function editarEnemigo(e){
    e.preventDefault();
    const id = document.getElementById('idEdit').value;
    const nombre = document.getElementById('nombreEdit').value;
    const pais = document.getElementById('paisEdit').value;
    const afiliacion = document.getElementById('afiliacionEdit').value;
    const btnSubmit = document.getElementById('btnSubmitEdit');


    //Esto es mientras se procesa
    btnSubmit.disabled=true;
    btnSubmit.textContent='Editando...';

    try{
        console.log('mandando put...')
        const response = await fetch('api/enemigo', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                id: parseInt(id),
                nombre: nombre,
                pais: pais,
                afiliacion: afiliacion
            })
        });

        if(response.ok){
            const enemigoEditado = await response.json();
            document.getElementById('formEditarEnemigo').reset();
            await cargarEnemigos();
        }else{
            const error = await response.text();
            console.log(error);
        }

    }catch(error){
        console.log(error);
    }finally{
        btnSubmit.disabled=false;
        btnSubmit.textContent='Editar Enemigo';
    } //fin try-catch
} //fin editar


async function borrarEnemigo(e){
    e.preventDefault();
    const id = document.getElementById('idBorrar').value;
    const btnSubmit = document.getElementById('btnSubmitBorrar');


    //Esto es mientras se procesa
    btnSubmit.disabled=true;
    btnSubmit.textContent='Eliminando...';

    try{
        console.log('mandando delete...')
        const response = await fetch('api/enemigo', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(parseInt(id))
        });

        if(response.ok){
            const nuevoEnemigo = await response.json();
            document.getElementById('formBorrarEnemigo').reset();
            await cargarEnemigos();
        }else{
            const error = await response.text();
            console.log(error);
        }

    }catch(error){
        console.log(error);
    }finally{
        btnSubmit.disabled=false;
        btnSubmit.textContent='Borrar Enemigo';
    } //fin try-catch
} //fin borrar
