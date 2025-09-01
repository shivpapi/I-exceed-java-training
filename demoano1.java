// abstract class sample{
//     abstract void display();
// }
// public class anony{
//     public static void main(String[] args) {
//         sample r = new sample(){
//         void display(){
//             System.out.println("meow");
//         }
//     };
//     r.display();
// }
// }

// abstract class Animal {
//     abstract void makeSound();
// }

// public class Zoo {
//     public static void main(String[] args) {
//         Animal a = new Animal() {
//             void makeSound() {
//                 System.out.println("Roarrr");
//             }
//         };

//         a.makeSound(); // prints: Roarrr
//     }
// }

abstract class student
{
   abstract public void displayStudent(String name,int age,String city);
}
abstract class teacher{
	abstract public void displayTeacher(String name, int age, String city);
}
class demoano1
{
    public static void main(String asd[])
	{

	  teacher t = new teacher(){
		public void displayTeacher(String name,int age,String city){
			System.out.println("name: "+name);
			System.out.println("Age: "+age);
			System.out.println("City: "+city);
		}
	  };
	  student d= new student(){
		public void displayStudent(String name,int age,String city)
			{
				System.out.println("Name: "+name);
	 			System.out.println("Age: "+age);
	  			System.out.println("City: "+city);
				System.out.println("-------------------");
			}	
		};
	  d.displayStudent("X",4,"blore");
	  t.displayTeacher("shiv",30,"bangalore");
	}
}