// This is the shared phone
class Call {
    // Only ONE person can use the phone at a time
    synchronized public void callme(String msg) {
        System.out.print("[");
        System.out.print(msg);
        System.out.print("]");
    }
}

// This is a friend who wants to use the phone
class Caller extends Thread {
    Call phone;
    String message;

    Caller(Call phone, String message) {
        this.phone = phone;
        this.message = message;
        start(); // Start talking immediately
    }

    public void run() {
        phone.callme(message); // Use the phone to say message
    }
}

// This is the party where all friends try to talk
public class DemoSync {
    public static void main(String[] args) {
        Call sharedPhone = new Call();

        // Three friends sharing the same phone
        new Caller(sharedPhone, "hello");
        new Caller(sharedPhone, "hi");
        new Caller(sharedPhone, "welcome");
    }
}