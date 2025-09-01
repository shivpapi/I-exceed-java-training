class sample			// super class
{
     sample()
	{
 
	}
     public void display()
	{
		System.out.println("display in super class");
	}
}
 
 
class sample1 extends sample  	// derived class
{
     sample1()
	{
 
	}
     public void display()
	{
	   System.out.println("display in derived class");
	}
}
 
 
class demooverride
{
    public static void main(String asd[])
	{
	    sample ref;
		sample objs=new sample();
		sample1 objd=new sample1();
		ref=objd;
        //ref=objs;
		ref.display();       
	}
}

