/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

console.log("cardValidation.js loaded");

const input_cardNumber = document.getElementById("cardNumber");
//const cardNumberWarning = document.getElementById("cardNumberWarning");
let result;
async function loadCards() {
    const response = await fetch("https://mocki.io/v1/f6777f82-291b-4252-8d6d-9cc8ceca9392")
    cards = await response.json()
    let i=0;
    for(i=0; i<2; i++){
//        alert(i);
        if(input_cardNumber.value==cards[i].cardNumber){
        document.getElementById('cardNumberWarning').style.color = 'green';
                document.getElementById('cardNumberWarning').innerHTML =
                    '<span><i style="color:green;" class="fa fa-check" aria-hidden="true"></i></span> Valid card';
            return;
    }
    else {
        document.getElementById('cardNumberWarning').style.color = 'red';
                document.getElementById('cardNumberWarning').innerHTML
                  = '<span><i class="fa fa-times" aria-hidden="true"></i></span> Invalid card';
    }
    }
    
    i=0;
    console.log(cards)
}




