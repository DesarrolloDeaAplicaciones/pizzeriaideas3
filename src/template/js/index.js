const doc = document;

const $btnFill = doc.getElementById("btn-fill"),
$btnPlus =  doc.getElementById("btn-plus"),
$pantalla = doc.getElementById("pantalla");

let contador = 0;
doc.addEventListener("click",(event)=>{

    if(event.target.matches("#btn-plus")) contador++;
        
    if(event.target.matches("#btn-fill")) contador--;

    if(contador <= 0){

        contador = 0;

    }

    $pantalla.innerHTML = contador;
    

    
}); 