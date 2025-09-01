function functionname(parameters)
 {
    //body of the function
 }
 
 let username="Rakesh";
 
 function displayMe()
  {
    let username="sivam"; // local variable
    console.log("welcome\t"+username);
  }
 
  console.log(username);
  displayMe();
 
  function addition(x,y,z)
  {
    return x+y+z;
  }
  console.log(addition(1,2,3));
 
  function displayData(name,age,city=null)
  {
    console.log(name);
    console.log(age);
    console.log(city);
  }
 
  displayData("Rakesh",21);

 
 
 
 
 