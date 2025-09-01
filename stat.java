// interface one
// {
//     static void display()
// 	{
// 	  System.out.println("inside the static method");
// 	}
//      public void show();
// }
 
// class sample implements one
// {
//     sample()
// 	{
// 	   System.out.println("inside the constructor");
// 	}
 
//     @Override
//     public void show()
// 	{
// 	   System.out.println("Inside the show");
// 	}
// }
 
// public class stat{

//    static public void main(String[] asd)
// 	{
// 	   sample obj=new sample();
// 	   obj.show();
// 	   obj.display();
 
// 	}
// }

interface inter1{
    static void display(){
        System.out.println("Im in first inteface and static");
    }
    void display1();
}
class RealMe implements inter1{
   public void display1(){
        System.out.println("Im in real class now");
    }
}
class stat{
    public static void main(String[] args) {
        RealMe r=new RealMe();
        r.display1();
        inter1.display();
    }
}
