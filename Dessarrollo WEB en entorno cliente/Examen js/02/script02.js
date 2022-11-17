(() => {

   function neteja(){
    let array = [1,2,3,0,null,undefined,NaN,false,"",4];
    let num=[1,2,3,4,5];
    let arrayLimpio=[];

        for(let i=0;i<array.length;i++){
            for(let j=0;j<num.length;j++){
                if(array[i]==num[j]){
                    arrayLimpio+=array[i]+",";
                }
            }
        }

        let arrayLimpio2=array.filter(array => Number.isInteger(array));

        
        console.log("[ "+arrayLimpio+"]");
        console.log("[ "+arrayLimpio2+"]");

    }

    neteja();

})();