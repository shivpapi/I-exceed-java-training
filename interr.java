interface ree{
    default void fromFirst(){
        System.out.println("From first interface");
    }
}
interface two extends ree{
    void fromSec();
      //  System.out.println("From second interface");
    
}
class three implements two{
    public void fromFirst(){
        //System.out.println("from first inter");
    }
    public void fromSec(){
        System.out.println("from the second");
    }
}
class interr{
    public static void main(String[] args) {
        three r=new three();
        r.fromFirst();
        r.fromSec();
    }
    
}
