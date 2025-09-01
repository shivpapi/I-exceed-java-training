// class student{
//     private int age;
//     private String name;
//     private String area;

//     public String getName(){
//         return name;
//     }
//     public void setName(String newName){
//         name=newName;
//     }
//     public int getAge(){
//         return age;
//     }
//     public void setAge(int newAge){
//         if(newAge>0){
//             age=newAge;
//         }
//     }
//     public String getArea(){
//         return area;
//     }
//     public void setArea(String newArea){
//         area=newArea;
//     }

// }
// class encap1{
//     public static void main(String[] args) {
//         student s=new student();
//         s.setName("Shiv");
//         s.setAge(20);
//         s.setArea("Bangalore");
//         System.out.println(s.getName());
//         System.out.println(s.getAge());
//         System.out.println(s.getArea());
//     }
// }

class bank{
    private int balance;


    public void deposit(int amount){
        if(amount > 0){
            balance+=amount;
        }
    }
    public void withdraw(int amount){
        if(amount>0){
            balance-=amount;
        }
    }
    public int balance(){
        return balance;
    }
    }
    class encap1{
        public static void main(String[] args) {
            bank b=new bank();
            b.deposit(50);
            b.withdraw(20);
            b.deposit(30);
            b.withdraw(10);
            System.out.println(b.balance());

        }
    }
