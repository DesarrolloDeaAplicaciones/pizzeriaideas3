import '../css/style.css'

const doc = document;


const desaparacerAdvertencia = ($adver) =>{
    
    const $advertencia = doc.getElementById($adver);

    $advertencia.addEventListener('click',(event)=>{
        
        if(event.target.matches(`#boton`)){

            $advertencia.classList.add('desaparece');
            $advertencia.style= 'display:none';

        }

    });
}

const desplazarAside = ($btn,$asd) =>{

    const $boton = doc.getElementById($btn),
    $aside = doc.getElementById($asd);

    $boton.addEventListener('click',(event)=>{

        $aside.classList.toggle('aside-active');

    });
}


doc.addEventListener('DOMContentLoaded',()=>{

    desaparacerAdvertencia('advertencia'); 
    desplazarAside('heaader-button','aside');

});