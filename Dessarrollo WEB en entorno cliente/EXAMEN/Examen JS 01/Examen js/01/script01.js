(() => {

        function Interseccio_Objecte(var1,var2){
            let inter=var1.filter(i=>var2.includes(i));
            console.log(inter);
        };
       
        let var1 = ({a:1,b:2,c:3},{b:2,c:1});
        let var2 = ({a:1,b:2,c:3},{b:2,c:3});
    
       Interseccio_Objecte(var1,var2);
    
})




