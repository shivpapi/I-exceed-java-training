const letstry={
    name:"Shiv",
    age:20,
    amt:0,
    balance:function(amt){
      return this.amt+=amt;
    },
    balance1:function(amt){
        return this.amt-=amt;
    }
};
console.log(letstry.balance(500));
console.log(letstry.balance(2300));
console.log(letstry.balance1(400));