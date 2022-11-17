export{generateGraph};

function generateGraph(peliculas_rankings) {
    let $grafica = document.createElement("#grafica");
    grafica.id = 'header';
    grafica.classList.add("grafica");
    
    let titule_pel= ['El Padrino', 'La Lista de Schindler', 'EL Padrino II ','Cadena Perpetua','La Vida es Bella','El Rey León', 'Uno de los Nuestros','Forrest Gump','Gladiator','Pulp Fiction'];
    
    let datosPelicula_presupuesto = {
        precio_presupuesto : ' PRECIO PRESUPUESTO ',
        data : ['6000000','22000000','13000000','25000000','20000000','260000000','25000000','55000000','103000000','8000000'],
        backgroundColor: 'rgba(54, 162, 235, 0.2)',
        borderColor: 'rgba(54, 162, 235, 1)',
        borderWidth: 1,
    };

    let datosPelicula_recaudado = {
        precio_recaudado:' PRECIO RECAUDADO ',           
        data : ['248066986','322139355','93000000​','73300000','229163264','1656943394','46836394','677387716','457640427','213928762'],
        backgroundColor: 'rgba(255, 159, 64, 0.2)',
        borderColor: 'rgba(255, 159, 64, 1)',
        borderWidth: 1,
    }

    new Chart($grafica,{
        type: 'bar',// Tipo de gráfica
        data: {
            labels: etiquetas,
            datasets: [
                datosPelicula_presupuesto,
                datosPelicula_recaudado,
            ]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }],
            },
        }
    })
    

    return grafica;
}
