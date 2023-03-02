/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

console.log("cardValidation.js loaded");

const input_cardNumber= document.getElementById("cardNumber").value
const cardNumberWarning= document.getElementById("cardNumberWarning");
let result;
async function loadCards(){
	const response=await fetch("https://mocki.io/v1/f6777f82-291b-4252-8d6d-9cc8ceca9392")
	cards=await response.json()
        
        if(cards.find(c=> c.cardNumber!= input_cardNumber)){
            
            result=true;
            
        }else{
            result=false;
           
        }
        
        if(result){
            document.getElementById('cardNumberWarning').style.color = 'red';
                document.getElementById('cardNumberWarning').innerHTML
                  = '<span><i class="fa fa-times" aria-hidden="true"></i></span> Please check card details';
        }
        if(!result){
            document.getElementById('cardNumberWarning').style.color = 'green';
                document.getElementById('cardNumberWarning').innerHTML =
                    '<span><i style="color:green;" class="fa fa-check" aria-hidden="true"></i></span> Matched';
        }
        
//        cards.forEach((card)=>{
//            if (input_cardNumber != card.cardNumber) {
//                document.getElementById('cardNumberWarning').style.color = 'red';
//                document.getElementById('cardNumberWarning').innerHTML
//                  = '<span><i class="fa fa-times" aria-hidden="true"></i></span> Please check card details';
//               
//            } else {
//                document.getElementById('cardNumberWarning').style.color = 'green';
//                document.getElementById('cardNumberWarning').innerHTML =
//                    '<span><i style="color:green;" class="fa fa-check" aria-hidden="true"></i></span> Matched';
//                
//            }
//        })
	
	console.log(cards)
}




