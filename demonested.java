class karnataka
{
   private String cm,capital;
   private double area_state;
 
    class mysuru
	{
	   String collector_name;
	   int area_dist;
	    mysuru(String collector_name,int area_dist)
		{
			this.collector_name=collector_name;								this.area_dist=area_dist;
		}
           public void displayMysuru()
		{
	           System.out.println("Name of CM"+cm);
		   System.out.println("Name of the collector"+collector_name);
		   System.out.println("District area"+area_dist);
		}
	   }
  }
 
class demonested
  {
     public static void main(String asd[])
	{
	     karnataka.mysuru my=new karnataka().new mysuru("x",54543543);
	     my.displayMysuru();
	}
}