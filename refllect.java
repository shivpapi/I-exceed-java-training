import java.lang.reflect.Method;
class sampledemo{
    private String name = "shiv";

private void display(){
    System.out.println("Inside private method");
}
}
public class refllect{
    public static void main(String[] args) throws Exception {
        Class<?> s = Class.forName("sampledemo");  // Correct Class type
        Object b = s.getDeclaredConstructor().newInstance();  // Instantiate object
        Method m1 = s.getDeclaredMethod("display");  // Access private method
        m1.setAccessible(true);  // Make it accessible
        m1.invoke(b);  // Call the method on the object   
}
}