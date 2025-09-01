class trial extends Thread{
   trial(){
    System.out.println("Inside the thread contructor");
   }
   void display(){
    System.out.println("inside the method of threa class");
   }
   public void run(){
    //System.out.println("Im the work which is being done by the thread");
    for (int i = 0; i < 10; i++) {
        System.out.println(i);
        if(i==3){
            System.out.println("Hey siddhart");
        }
        if(i==5){
            System.out.println("HEY SHIVRAJ");
        }
        if(i==7){
            System.out.println("done");
        }
            //System.out.println("Thread is running: " + i);
            try {
                Thread.sleep(2000); // pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
   }
}
}
class threatdemo{
    public static void main(String[] args) {
        trial t=new trial();
        //Thread d=new Thread(d);
        t.start();
        //t.run();
    }
}