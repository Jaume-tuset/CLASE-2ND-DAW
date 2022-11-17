//diferenecia de temperatura entre 2 meses
let diferenciaTemp = datos.map(mes => {
    return { 
        month:mes.month, 
        dif: parseInt(mes.maxTemp) - parseInt(mes.minTemp)
    }
});

console.log(diferenciaTemp);

//diferencia entre 2 meses 
// -> filter


//sacar la media de la lluvia de cada mes 
    // -> filter + reduce +	/ long mes

    // sacar los datos de la lluvia de cada mes 
    //primer element en acumulador y segon en el mesActual
    //falla per no ser dels mateixos unitats de mesura -> sol : ,0
    let avgRain = datos.reduce((acumulador,mesActual)=> 
    acumulador + parseFloat(mesActual.rainfall),0)/datos.lenght;    

    console.log(avgRain);



//test => jasmine github
/* <html>
 * script: src : test.js
 * script : spect : test01 
 *</HTML>
 <JS spect>
 * describe["test Matematiques",function(){
        it("suma",function(){
            expect(suma(2,3)).toBe(true);
        })
 * }]
 </JS>
 * 
 */

function suma(a,b){

}
