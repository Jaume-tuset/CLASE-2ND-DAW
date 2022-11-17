		/* PON TUS VARIABLES JS AQU� */
		let elementJustificar;
		let posXDown;

		function jugar() {

			elementos = document.getElementsByTagName("div");

			let min = Number.MAX_SAFE_INTEGER;
			let max = -min;

			for (let i = 0; i < elementos.length; i++) {
				let zic = getComputedStyle(elementos[i]).zIndex;
				let zi = parseInt(zic);
				if (zi > max) max = zi;
				if (zi < min) min = zi;
			};


			let zimin = parseInt(min);
			let zimax = parseInt(max);


			for (let zi = zimin; zi <= zimax; zi++)
				for (let i = 0; i < elementos.length; i++) {
					let zestec = getComputedStyle(elementos[i]).zIndex;
					let zeste = parseInt(zestec);
					if (zeste == zi)
						console.log("div : " + i);

				};
		}

		function clickPalo(evento) {
			//	console.log(event);

			let elemento = evento.target;
			zIndexElemento = parseInt(getComputedStyle(elemento).zIndex);

			let otros = document.getElementsByTagName("div");

			/* es el zIndexElemento igual al mayor dels zIndex
			dels otros */

			let maxzIndex = parseInt(getComputedStyle(otros[0]).zIndex);

			for (let i = 0; i < otros.length; i++) {
				let zIndexEste = parseInt(getComputedStyle(otros[i]).zIndex);
				if (zIndexEste > maxzIndex)
					maxzIndex = zIndexEste;
			}


			if (maxzIndex > zIndexElemento) return;

			let nodoPadre = elemento.parentNode;

			nodoPadre.removeChild(elemento)


		}


		let posX = 100;
		let posY = 200;

		function anyadir() {

			let otros = document.getElementsByTagName("div");

			/* es el zIndexElemento igual al menor dels zIndex
			dels otros */

			let minzIndex = parseInt(getComputedStyle(otros[0]).zIndex);
			let elementMin = otros[0];
			for (let i = 0; i < otros.length; i++) {
				let zIndexEste = parseInt(getComputedStyle(otros[i]).zIndex);
				let elementEste = otros[i];
				if (zIndexEste < minzIndex) {
					minzIndex = zIndexEste;
					elementMin = elementEste;
				}

			}
			let nuevozIndex = minzIndex - 1;

			let nuevoElemento = document.createElement("div");

				nuevoElemento.style.backgroundColor = "red";

				nuevoElemento.style.position = "absolute";

				nuevoElemento.style.left = posX + "px";

				nuevoElemento.style.top = posY + "px";

				nuevoElemento.style.zIndex = nuevozIndex;


				document.body.appendChild(nuevoElemento);

				posX += 10;
				posY += 20;
				
				nuevoElemento.addEventListener("click",clickPalo);

			if (elementMin.classList.contains("hor")) {

				nuevoElemento.classList += "ver";

			} else{

				nuevoElemento.classList += "hor";	

			}

			window.setTimeout(anyadir,1000);

		}

		/************ FUNCI�N INICIALIZAR *******************/
		function inicializar() {

			elementos = document.getElementsByTagName("div");
			for (let i = 0; i < elementos.length; i++) {
				var randomColor = "#" + ((1 << 24) * Math.random() | 0).toString(16);
				elementos[i].style.background = randomColor;

				elementos[i].addEventListener("click", clickPalo);

			}


			window.setTimeout(anyadir, 2000);
			document.addEventListener("click", jugar);

		}

		/********** DOMContentLoaded ***********************/
		document.addEventListener("DOMContentLoaded", inicializar);

