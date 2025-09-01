let now = new Date();
console.log(now);

let d1 = new Date(2025, 7, 20, 15, 30, 0);
console.log(d1.toLocaleTimeString);

let d2 = new Date("August 20, 2025 15:30:00");
console.log(d2.toString());

let d = new Date();
console.log(d.getMonth()+1);

let d4 = new Date();
console.log(d4.toString());

let d5 = new Date();
console.log(d5.toDateString());

setInterval(() => {
  let now = new Date();
  console.log(now.toLocaleTimeString());
}, 1000)