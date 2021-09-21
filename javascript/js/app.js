alert("Hola Mundo!");// ventana emergente
console.log("Estamos en la consola"); // Consola del navegador

let nombre = "Nombre Nombre";
var numero = 100;
const PI = 3.1416;
let hayClases = true;
let esFeriado = true;

console.log(numero + 25 + nombre); // -> 125Nombre Nombre

console.log((5 > 3) ? "Es correcto": "No es correcto");//Ternario
if(hayClases && !esFeriado){ console.log("Me conecto a la vllamda");}
else{console.log("No me conecto a la vllamada");}

let saludo = "Hola, como está?";
let saludar = saludo + " " + nombre;

/*interacción con objetos del HTML*/

const rowDiv = document.getElementById("rowId");
//console.log(rowDiv);
rowDiv.innerHTML = '<h2 class="text-danger">' + saludar + '</h2>'; // Similar a "documentWrite"