import {menuTemplate} from './views/menu.js';
import {generateCard} from './views/cards.js';
import {generateFooter} from './views/footer.js';
import { generateGraph } from './graphs/graphs.js';

let peliculas_rankings = [
    { 
        img:'img/1.jpg',
        id: '1',
        title: 'El Padrino',
        duracion: '2h 55min',
        genero:['Crimen','Drama'],
        fecha_estreno:'20 de octubre de 1972',
        dirigida: 'Francis Ford Coppla',
        reparto: ['Marlon Brando', 'Al Pacino', 'James Caan'],
        resumen:'En el verano de 1945, se celebra la boda de Connie (Talia Shire) y Carlo Rizzi (Gianni Russo). Connie es la única hija de Don Vito Corleone (Marlon Brando), jefe de una de las familias que ejercen el mando de la Cosa Nostra en la ciudad de Nueva York. Don Vito además tiene otros tres hijos: su primogénito Sonny (James Caan), el endeble Fredo ...',
    },
    { 
        img:'img/2.jpg',
        id: '2',
        title: 'La lista de Schindler',
        duracion: '3h 15min',
        genero:['Histórico', 'Guerra'],
        fecha_estreno:' 28 de febrero de 2019',
        dirigida: 'Steven Spielberg',
        Reparto: ['Liam Neeson','Ben Kingsley','Ralph Fiennes'],
        Resumen:'Septiembre de 1939. Los nazis invaden Polonia. Los judíos son internados en guetos y enviados a campos de concentración. El empresario alemán Oskar Schindler (Liam Neeson), un dandy oportunista con talento para las relaciones públicas, aprovecha esta situación para prosperar económicamente. Comienza así una interesada relación con los ...',
    },
    { 
        img:'img/3.jpg',
        id: '3',
        title: 'El Padrino II',
        duracion: '3h 20min',
        genero:['Crimen','Drama'],
        fecha_estreno:'13 de octubre de 1975 ',
        dirigida: 'Francis Ford Coppla',
        Reparto: ['Kathleen Beller', 'Ignazio Pappalardo', 'Roman Coppola'],
        Resumen:'Tras la muerte de Don Vito Corleone , su hijo Michael se convierte en el cabeza de familia. Al tener que negociar con la mafia judía, pierde el apoyo de uno de sus hombres, Frankie Pentageli. Tras escapar por los pelos de un atentado, Michael trata de ...',
    },
    { 
        img:'img/4.jpg',
        id: '4',
        title: 'Cadena perpetua',
        duracion: '2h 22min',
        genero:['Crimen','Drama'],
        fecha_estreno:'24 de febrero de 1995',
        dirigida: ' Frank Darabont',
        Reparto: ['Tim Robbins','Morgan Freeman','Bob Gunton'],
        Resumen:'En 1947, Andy Dufresne (Tim Robbins), un joven banquero, es condenado a cadena perpetua por asesinar a su esposa y su amante. A pesar de declararse inocente, es encarcelado en Shawshank, el penitenciario más duro del estado de Maine. Allí se encontrará con Red Redding (Morgan Freeman), un hombre desilusionado, encarcelado desde hace más de ...',
    },
    { 
        img:'img/5.jpg',
        id: '5',
        title: 'La vida es bella',
        duracion: '1h 57min',
        genero: ['Comedia','Drama','Historico'],
        fecha_estreno:'26 de febrero de 1999',
        dirigida: 'Roberto Benigni',
        Reparto: ['Roberto Benigni', 'Horst Buchholz', 'Marisa Paredes'],
        Resumen:'La Segunda Guerra Mundial está a punto de estallar en Europa. Mientras tanto, Guido llega a un pueblo italiano con la intención de abrir una librería. Allí se enamora de la novia de un fascista italiano, Dora. Ésta sucumbirá a sus encantos y Guido consigue que se case con él. De la bonita unión nace un pequeño que tendrá que vivir en ...',
    },
    { 
        img:'img/6.jpg',
        id: '6',
        title: 'El Rey León',
        duracion: '1h 29min',
        genero: ['Aventura','Animación','Música','Disney'],
        fecha_estreno:'8 de noviembre de 1994',
        dirigida: ['Rob Minkoff', 'Roger Allers'],
        Reparto: [' Matthew Broderick', 'Jonathan Taylor', 'James Earl Jones'],
        Resumen:'Tras la muerte de su padre, Simba deberá enfrentarse a su tío para recuperar el trono de Rey de la Selva. Timón y Pumba le acompañarán en su misión.',
    },
    { 
        img:'img/7.jpg',
        id: '7',
        title: 'Uno de los nuestros',
        duracion: '2h 25min',
        genero : ['Crimen', 'Drama', 'Suspense'],
        fecha_estreno:'19 de octubre de 1990',
        dirigida: 'Martin Scorsese',
        Reparto: ['Ray Liotta',' Robert De Niro',' Joe Pesci'],
        Resumen:'Henry, un niño de trece años de Brooklyn, vive fascinado con el mundo de los gángsters. Su sueño se hace realidad cuando entra en la familia Pauline.',
    },
    { 
        img:'img/8.jpg',
        id: '8',
        title: 'Forrest Gump',
        duracion: '2h 20min',
        genero: ['Crimen','Drama', 'Comedia','Romance', 'Historico'],
        fecha_estreno:'23 de septiembre de 1994',
        dirigida: 'Robert Zemeckis',
        Reparto: [' Tom Hanks','Gary Sinise','Robin Wright'],
        Resumen:'Al tener el coeficiente intelectual de un niño, Forrest Gump siempre ha sido considerado el “tonto” de clase. Bajo las faldas de su madre se siente protegido y junto a su amiga Jenny es feliz, aunque en su propio mundo. Un problema en su columna vertebral no le impide convertirse en un ágil corredor. Ya más mayor, Forrest luchará en la ...',
    },
    { 
        img:'img/9.jpg',
        id: '9',
        title: 'Gladiator (El gladiador)',
        duracion: '2h 55min',
        genero:['Acción','Drama','Aventura'],
        fecha_estreno:'29 de junio de 2018',
        dirigida: 'Ridley Scott',
        Reparto: ['Russell Crowe', 'Joaquin Phoenix','Connie Nielsen'],
        Resumen:'En el año 180 el Imperio Romano controla todo el mundo conocido hasta la fecha. Máximo, interpretado por el ya conocido Russell Crowe, es un General romano muy importante para el Emperador Marco Aurelio, pues sólo él ha conseguido victoria tras victoria, destacando por su valentía, dedicación y lealtad al Imperio. Cómodo, el hijo de Marco ...',
    },
    { 
        img:'img/10.jpg', 
        id: '10',
        title: 'Pulp Fiction',
        duracion: '2h 34min',
        genero: ['Crimen, Drama','Suspense'],
        fecha_estreno:'13 de enero de 1995',
        dirigida: 'Quentin Tarantino',
        Reparto:['John Travolta, Samuel L. Jackson, Uma Thurman'],
        Resumen:'Jules Winnfield y Vincent Vega son dos asesinos a sueldo que trabajan a las órdenes del temido gángster Marsellus Wallace (Ving Rhames, Amanecer de los muertos), quien les encarga la importante misión de recuperar su misterioso maletín, que ha sido robado. Ahí empezarán todos sus ...',
    },
    
];


(()=>{

    document.addEventListener('DOMContentLoaded',()=>{
        
        let container = document.querySelector('#container');
        container.append(menuTemplate());
        
        let mainWindow = document.createElement("div");
        mainWindow.id = "main";
        mainWindow.classList.add("container");
        container.append(mainWindow);
       
        for (let i=0;i<10;i++) {
         mainWindow.append(generateCard(peliculas_rankings[i]));
        }
        /*mainWindow.append(generateGraph(peliculas_rankings));*/

        
        container.append(generateFooter());
    });

})();
