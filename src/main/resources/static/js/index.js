const doc = document;


const $pizzas = doc.querySelectorAll("[data-pizza]"),
$empanadas =  doc.querySelectorAll("[data-empanada]"),
$bebidas =  doc.querySelectorAll("[data-bebida]"),
$postres = doc.querySelectorAll("[data-postre]");


$pizzas.forEach((i) =>{

    let contador = 0;


    i.addEventListener("click" ,(event)=>{

        if(contador <= 0){

            contador = 1;
        }
        

        if(event.target.matches("#btn-plus")){
            
            contador++;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }
        
        if(event.target.matches("#btn-fill")){

            contador--;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }

        
    });


});


$empanadas.forEach((i) =>{

    let contador = 0;


    i.addEventListener("click" ,(event)=>{

        if(contador <= 0){

            contador = 1;
        }
        

        if(event.target.matches("#btn-plus")){
            
            contador++;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }
        
        if(event.target.matches("#btn-fill")){

            contador--;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }

        
    });


});

$bebidas.forEach((i) =>{

    let contador = 0;


    i.addEventListener("click" ,(event)=>{

        if(contador <= 0){

            contador = 1;
        }
        

        if(event.target.matches("#btn-plus")){
            
            contador++;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }
        
        if(event.target.matches("#btn-fill")){

            contador--;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }

        
    });


});


$postres.forEach((i) =>{

    let contador = 0;


    i.addEventListener("click" ,(event)=>{

        if(contador <= 0){

            contador = 1;
        }
        

        if(event.target.matches("#btn-plus")){
            
            contador++;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }
        
        if(event.target.matches("#btn-fill")){

            contador--;
            
            i.querySelector(".footer-container #pantalla").innerHTML = contador;

        }

        
    });


});
