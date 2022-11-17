(() => {

    let array=[
        {
            a:1,
            Op:(a,b)=>a+b,
            b:3
        },
        {
            a:2,
            Op:(a,b)=>a-b,
            b:10,
        },
        {
            a:14,
            Op:(a,b)=>a*b,
            b:3
        }
    ];

    function calculadora(array){
        let res1,res2,res3=0;
                res1=a+b;
                res2=a-b;
                res3=a*b;
        let arrayMat=array.reduce(Op(a,b),{
                return: res1,res2,res3,               
            });
            console.log(arrayMat);
    }
    
    function positivos(array) {
        let arrayPositivos=array.filter(Op(a,b),{
            return:
                Op(a,b)%2>=0,
        });
        console.log(arrayPositivos);
    }

    function ordenarUltima(array) {
        let arrayOrdenar=array.reduce(Op(a,b),{
            return: a*b,
        },0);
        console.log(arrayOrdenar);
    }
    
    /**
     * 
     * 
     * 
     */

    console.log(calculadora([{a:1,Op: (a,b) => a+b, b:3},{a:2,Op: (a,b) => a-b, b:10},{a:14,Op: (a,b) => a*b, b:3}]));
    console.log(positivos([{a:1,Op: (a,b) => a+b, b:3},{a:2,Op: (a,b) => a-b, b:10},{a:14,Op: (a,b) => a*b, b:3}]));
    console.log(ordenarUltima([{a:1,Op: (a,b) => a+b, b:3},{a:2,Op: (a,b) => a-b, b:10},{a:14,Op: (a,b) => a*b, b:3}]));

    calculadora(array);
    positivos(arrayMat);
    ordenarUltima(array);
    


})