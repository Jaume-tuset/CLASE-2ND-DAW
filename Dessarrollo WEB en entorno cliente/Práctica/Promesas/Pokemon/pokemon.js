//convertir a visible : 
function pokemonTemplate(pokemon){
    let pokemonTemplate=
    `
    <div class="pokemon">
        <h2 class="name">${pokemon.name.english}</h2>
        <p>${pokemon.type}</p>
    </div>
    
    `;    
    return pokemonTemplate;
}

document.addEventListener('DOMContentLoaded',function(){
    //array de pokemonsArrays
    fetch ("pokedex.json").then((resposta)=>{
        return resposta.json();
    }).then((pokemonsArrays)=>{
        for(let p of pokemonTemplate){
            document.querySelector("#container").append(getPokemonTemplate(p));
        }
    })
    //resposta.json().then((pokemonsArrays) => console.log(pokemonsArrays));
    ;
})





