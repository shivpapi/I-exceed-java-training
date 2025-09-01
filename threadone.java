class one extends Thread
  {
     public void run()
	{
	  for(var i=0;i<10;i++)
		{
	          System.out.println(Thread.currentThread().getName()+"-iteration"+i);
		 }
         //Thread.yield();
         }
         //Thread.yield();
   }
 
 
class demothreadyield
{
    public static void main(String asd[])
	{
	   one obj1=new one();
       obj1.setName("sako");
	   obj1.start();
	   //obj1.yield();
	   for(var i=0;i<10;i++)
		{
		   System.out.println("Main thread running");
           Thread.yield();
		}
        //Thread.yield();
	}  
}