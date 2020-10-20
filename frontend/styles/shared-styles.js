// eagerly import theme styles so as we can override them
import '@vaadin/vaadin-lumo-styles/all-imports';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>
  html {


        }

  






    paper-spinner {
          --paper-spinner-stroke-width: 6px;
          --paper-spinner-layer-1-color: var(--lumo-primary-color);
          --paper-spinner-layer-2-color: var(--lumo-error-color);
          --paper-spinner-layer-3-color: var(--lumo-primary-color);
          --paper-spinner-layer-4-color: var(--lumo-error-color);
         
        }

    paper-toggle-button {
      --paper-toggle-button-checked-bar-color:     var(--google-green-500);
      --paper-toggle-button-checked-button-color:  var(--lumo-primary-color);
    }
  
    

  
  
  </style>
</custom-style>


`;

document.head.appendChild($_documentContainer.content);
