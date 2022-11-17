    
    let valor;

    function incrementar() {
        valor=valor + 2;
        let info=document.getElementById('info'); 
        info.innerHTML = "  Valor incrementado = "+valor;
    }

    function inicializar() {
        valor = 0;
        let botonSumar=document.getElementById("incrementar");
        botonSumar.addEventListener("click", incrementar);
    }

    document.addEventListener('DOMContentLoaded',inicializar);
    
    

    ("Información interna dato = "+dato);