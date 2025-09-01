console.log("Hello");
function trial(age){
let checki=
 age<20?"Underage"
:age>20 && age<24?"Eligible for drinks"
:age>24 && age<30?"Too old to drink"
:"Invalid input"

return checki;
}

console.log(trial(22));