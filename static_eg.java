public class static_eg {
    static int i;   // Static variable: shared among all objects of the class
    int x;          // Instance variable: separate for each object

    static_eg(){
        i++;  // Increments shared static variable
        System.out.println("From static_int :"+i);

        x++;  // Increments the instance variable specific to the current object
        System.out.println("From int :"+x);
    }

    public static void main(String[] args) {
        static_eg statobj1 = new static_eg();  // Constructor runs
        static_eg statobj2 = new static_eg();
        //static_eg statobj3 = new static_eg();  // Constructor runs
        //static_eg statobj4 = new static_eg();  // Constructor runs again
    }
}