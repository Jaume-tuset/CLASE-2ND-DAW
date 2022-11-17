let promesaDatos=new Promise((resolve, reject) => {
    //cuando se descarge el archivo ejecuta resolve y si falla reject
    fetch("datos.json")
    //descargar de ninguna parte del servidor
    //fetch("httpd://10.10.10.10/datos.json");
    .then(response=>{
        //si el servidor no esta operativo salta el error de servidor
        if(response.status !== 200){
            reject(response);
        }
        return  resolve(response);
    })
    .catch(reject);
    //implicita 
    //.then(response => resolve(response));
});

//resposta de la promesaDatos 
promesaDatos.then(response => {
    //console.log(response);
    //va transformant el json en un objecte
    response.json()
    //mostra els datos 
    .then(datos => console.log(datos));
}).catch(error => console.log("ERROR",error));

//demanar algo que no existeix
/*
promesaDatos.then(response => {
    -> console.log(response); => no funciona per este console.log();
    response.json()
    .then(datos => console.log(datos));
}).catch(error => console.log(error));
*/

//simplificat
let promesa=fetch("datos.json")
.then((response)=>{
    //fallo de conexion al servidor 
    if(response.status !== 200){
        //promesa que falla
        return Promise.reject(response);
    }
    return  response.json();
})
.catch(reject);

promesa
.then(datos => console.log(datos))
.catch(error=> console.log("ERROR",error));

//async await

async function descargar(url) {
    let response=await fetch(url);
        //fallo de conexion al servidor 
        //if(response.status !== 200){
            //promesa que falla
           //return Promise.reject(response);
        //}else{
            let datos=await response.json();
        //}
       //console.log(datos);
        
       return datos;
}

//recargar datos de los archivos de forma asyncrona y per promesa
//let datos = descargar("datos.json").then(datos => console.log(datos));
descargar("datos.json").then(datos=> console.log(datos));
console.log(datos);