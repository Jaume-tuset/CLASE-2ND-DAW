function inicilizar() {
    console.log("inicilizar");

    let compMarca=document.getElementById("marca");
    compMarca=addEventListener("keypress",marcaModeloCoche);
   
    let compColor=document.getElementById("color");
    compColor.addEventListener("change", pintar);

    let compRev=document.getElementById("revoluciones");
    compRev.addEventListener("input", cambiarRevoluciones);

    let compVel=document.getElementById("velMax");
    compVel=addEventListener("focusin",quitarKM);
    compVel=addEventListener("focusout",ponerKM);

    let compFoto=document.getElementById("foto");
    compFoto.addEventListener("input",cambiarFoto);

    rellenarModelos();

    let compMarcas=document.getElementById("marca");
    compMarcas=addEventListener("change",MarcasModelos);


}


let bbddCoches={
    "Fiat":[ " tipo " , " 500 ", " 500x " ],
    "Reanult":[ " clio " , " seat ", " toledo " ," leon ", " ibiza ", "leon " ],
    "Citroen":[ " tipo2 " , " 2210 ", " 500y " ],
};

let lector;

function rellenarModelos() { 

    let compMarcas=document.getElementById("marca");
    let marca=compMarcas.value;
    let modelos=bbddCoches["Renault"];
    console.log(modelos);


   // modelos.forEach(i => console.log(i));
    
    for (let i = 0; i < modelos.length; i++) {
        console.log(modelos[i]);
    }

    
    let compModelo=document.getElementById("modelo");
  
    compModelo.removeChild();
    while (compModelo.firstChild) {
      compModelo.removeChild(compModelo.firstChild);
    }
  
  
    let nuevaOpciones = document.createElement("option");
    nuevaOpciones.value='Fiat';
    nuevaOpciones.innerHTML='Fiat';
    nuevaOpciones.value='Clio';
    nuevaOpciones.innerHTML='Clio';
    nuevaOpciones.value='Tipo';
    nuevaOpciones.innerHTML='Tipo';
  
    compModelo.appendChild(nuevaOpciones);


    
      /**
       * compModelo.innerHTML+='<option value="uno">uno</option>';
       */
  }

function cambiarFoto() {
    let compFoto=document.getElementById("foto_archivo");
    let botonSelFoto=document.getElementById("foto");
    let rutaFichero=botonSelFoto.files[0];

    let lector=new FileReader();
    lector.readAsDataURL(rutaFichero);

    /*setTimeout(function(){ 
        let comprImagen=document.getElementById("imagen");
        comprImagen.src=lector.result;
    },1000);*/

    lector.onload=addEventListener("onload", terminar);
        
    alert("Has elegido cambiar la foto "+rutaFichero);
}

function terminar() {
    let comprImagen=document.getElementById("imagen");
        comprImagen.src=lector.result;
}

function pintar() {
    let comp=document.getElementById("divColor");
    let compColor=document.getElementById("color");
    comp.style.backgroundColor = compColor.value;
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


function cambiarRevoluciones() {
    let compRev=document.getElementById("revoluciones");
    let valorElegido=compRev.value;
    let compMostrarRev=document.getElementById("muestraRev");
    compMostrarRev.innerHTML=" " +valorElegido+ " revoluciones/minutos";
}

document.addEventListener("DOMContentLoaded", inicilizar);