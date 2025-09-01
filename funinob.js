const account={
    accountnumber:1,
    holdername:"Bhargav",
    balance:120000,
    showdetails:function()
                {
                    console.log(`Account:${this.accountnumber} hoder:${this.holdername} balance:${this.balance}`);
                },
    deposit:function(amt){return this.balance+amt}
   
   
};
account.showdetails();
console.log(account.deposit(1000));