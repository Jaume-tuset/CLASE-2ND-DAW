function inicilizar() {
    console.log("ini");
    let compColor = document.getElementById("Color");
    compColor.addEventListener("change", pintar);

    let compRev = document.getElementById("revoluciones");
    compRev.addEventListener("input", cambiarRevoluciones);

    let compFot = document.getElementById("imagenElegida");
    compFot.addEventListener("change", cambiarFoto);
    
    let compMarcas = document.getElementById("marcas");
    compMarcas.addEventListener("change", rellenarModelos);
}


bbddCoches = {
    "Fiat": ["tipo", "500", "500x"],
    "Renault": ["tipo", "500", "500x"],
    "Ferrari": ["tipo", "500", "500x"],
    "Citroen": ["tipo", "500", "500x"],
    "Seat": ["toledo", "ibiza", "cordoba"],
    "Mercedez": ["tipo", "500", "500x"],
    "Bugati": ["tipo", "500", "500x"],
};

let lector;

function rellenarModelos() { 

 let compMarcas = document.getElementById("marcas");
            let compModelo = document.getElementById("modelo");

            while (compModelo.firstChild) {
                compModelo.removeChild(compModelo.firstChild);
            }
            
            let modelos = bbddCoches[compMarcas.value];

            modelos.forEach( function(model) {
                let nuevaOpcion = document.createElement("option");
                nuevaOpcion.value = model;
                nuevaOpcion.innerHTML = model;
                console.log("model"+model);
                compModelo.append(nuevaOpcion);
            }
                
            );
                /*let option = evt.currentTarget.selectedOptions[0];
                    infoElement.innerHTML = `<option>${option.dataset.info}</option> `;
    
                });
    
    
                let compModelo = document.getElementById("modelo");
                modelo.array.forEach((bbddCoches) => {
                    const optionElement = document.createElement("option");
                    optionElement.setAttribute("value", modelo.name);
                    optionElement.textContent = modelo.name;
    
                    optionElement.dataset.info = JSON.stringify(modelo);
                    compModelo.append(optionElement);
                });*/
            
}

function pintar() {
            let compCol = document.getElementById("Color");
            let valorElegido;
            valorElegido = compCol.value;
            let compMostrarColor = document.getElementById("colorDiv");
            compMostrarColor.innerHTML = "" + compCol.value;
            compMostrarColor.style.backgroundColor = compCol.value;
        }

        function cambiarRevoluciones() {
            let compRev = document.getElementById("revoluciones");
            let valorElegido;
            valorElegido = compRev.value;

            let compMostrarRev = document.getElementById("muestraRev");
            compMostrarRev.innerHTML = "" + valorElegido + "rev/min";
        }

        function cambiarFoto() {
            let botonSelFoto = document.getElementById("imagenElegida");
            const archivos = botonSelFoto.files;
            console.log("fichero a cargar");

            let compImg = document.getElementById("visualizacion");

            if (!archivos || !archivos.length) {
                compImg.src = "";
                return;
            }

            const primerArchivo = archivos[0];
            const objectURL = URL.createObjectURL(primerArchivo);
            compImg.src = objectURL;
}

function quitarKM() {
    let compVel=document.getElementById("velMax");
    if(compVel.value=" "){
        let compVel=compVel.value+" ";
    }
}

function ponerKM() {
    let compVel=document.getElementById("velMax");
    if(compVel.value=" "){
        let compVel=compVel.value+" "+"km/h";
    }
}

document.addEventListener("DOMContentLoaded", inicilizar);