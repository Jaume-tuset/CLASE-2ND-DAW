(() => {
    document.addEventListener("DOMContentLoaded",()=>{
        let peticion=fetch("https://api.punkapi.com/v2/beers")
        .then(data=>{return data.json()})
        .then(res=>{console.log(res)});
        

    })

    //a)mostrar foto / nomb / caracteristicas tecnicas / descripcion / lista / consejos
    function mostrarDatos() {
        let datosApi=document.querySelector("div");
        datosApi.classList.add("datos");
        datosApi.innerHTML=`
        <h2 class="name">${datosApi.name}</h2>
        <p>${datosApi.img}</p>
        `
    }
    
    


})();
