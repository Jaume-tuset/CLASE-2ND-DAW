"use strict";

[()=>{
  
    function validar(dni) {
        let dniRegExp=/^[0-9]{8}$/; //expreió regular 
        let valid=dniRegExp.test(dni);
        return valid;   
        }
        console.log(validar("12345678"));

        let validarFletxa=dni=>/^[0-9]{8}$/.test(dni);

        function lletra(dni) {
            let lletraRegExp = "TRWAGMYFPDXBNJZSQVHLCKE".split(" ");
            return lletraRegExp[parseInt(dni%23)];
        }

        console.log(lletra(12345678));

        function validarLletra(dni) {
            if(validar(dni)){
                return dni+lletra(dni);
            }else{
                return false;           
            }
        }

        document.write(validarLletra(12345678));   // validar lletraRegExp (12345678)

        return validar(dni) ? dni+lletra(dni) : false;

        function array_DNI() {
            let nuevo_DNI=validar(dni).split(" ");
            return nuevo_DNI; 
        }

        for( nuevo_DNI of array_DNI){
            if(validar(dni)){
                document.write(dni);
                return dni+lletra(dni);
            }
        }

        /**
         * Ejercicio 4 
         * 
         * const array_DNI = {"12345678"," 123456754 "," sad212123", " 111111111"," 22222222"};
         *  
         *  function validarLletraArray(dniList){
         *     for(let dni on dniList){
         *      let dniLletra=validarLletra(dni);
         *      if(dniLletra){
         *      dniValidaList.push(dniLletra);
         *    }
         *  }
         *      return dniValidaList;
         * 
         *      console.log(validarLletraArray(array_DNI)); 
         * 
         *  //push : element dins de l'arrray
         *  //pop : element fora de l'array         
         * 
         **/

        // Ejercicio 5 

        let dniInput=createElement('input').type("text");
        dniInput.setAttribute('id','dni');
        
        let comprobar=document.getElementById("comprobar");
        comprobar.addEventListener("keypress",validar);
 
        function DNI(dni) {
            this.validar = (dni) => /^{0-9}[0]$/.test(dni);
            this.calcularLletra = function (dni){
                let lletres="TRWAGMYFPDXBNJZSQVHLCKE".split(" ");
                return lletres(parseInt(dni)%23);
            };
            this.numeros;
            this.dniComplet= this.validar(numeros) ? dni + this.calcularLletra(this.numeros) : false;
        }

        let llistaDNIObjecte=[];
        for ( let dni of array_DNI){
            let DNIObjecte = new DNI(dni);
            llistaDNIObjectes.push(DNIObjecte); 
        }

        console.log(llistaDNIObjecte);

        //Ejercicio 6 
        document.addEventListener("DOMContentLoaded",() =>
        {
            let lletraInpput=document.querySelector("#letra_dni");
            lletraInpput.addEventListener("DOMContentLoaded",() =>{
                let dniRandom=[];
                let cont=0;
                while (cont==20) {
                    let dniRandom=Math.random();
                    if(dniR)
                }
            }

        });

        document.addEventListener("DOMContentLoaded",() =>
        {
            let inputDNI=document.querySelector("#dni");
            let buttonDNI=document.querySelector("#button_dni");
            buttonDNI.addEventListener("click",()=>
            {
                let inputDNI=inputDNI.value;
                console.log(validarDNI);
                  
            });
    

}]();