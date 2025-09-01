let bankAccount ={};
Object.getProperty(bankAccount,"balance",{
get:function(){
return this.balance;
},
set:function(amt){
    if (!this._balance) this._balance=0;
    this._balance+=amt;
    console.log('amount credited: ${amt} and now the balance is: ${_balance}');
}
});

Object.getProperty(bankAccount,"withdraw",{
    
})