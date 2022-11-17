function contador() {
    let contador = 0;
    let sumador = 0;
    (() => {
      let sumador = 1;
      if (contador === 0) {
        let contador = 1;
        console.log(contador);
      }
      console.log(contador);
      sumador++;
    })();
    return () => console.log(contador, sumador);
   }
   contador()();