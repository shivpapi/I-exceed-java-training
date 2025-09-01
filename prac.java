// class Vehicle{
//     String brand;
//     int year;
    
//     Vehicle(String brand,int year){
//         this.brand=brand;
//         this.year=year;
//     }
//     public void displayVehicle(){
//         System.out.println("Brand: "+brand);
//         System.out.println("Year: "+year);
//     }
// }
// class Car extends Vehicle{
//     String model;
//     Car(String brand, int year, String model){
//         super(brand, year);
//         this.model=model;
//     }
    
//     public void displayCar(){
//         System.out.println("Model: "+model);
//         displayVehicle();
//        // System.out.println("Model: "+model);
//     }
// }
// class Prac{
//     public static void main(String[] args) {
//         Car obj = new Car("Toyota",2020,"Corolla");
//         obj.displayCar();
//     }
// }

// class car{
//     String name;

//     car(String name){
//         this.name=name;
//     }
//     public void carName(){
//         System.out.println("name: "+ name);
//     }
// }
// class prac{
//     public static void main(String[] args) {
//         car obj = new car("bmw");
//         obj.carName();
//     }
// }

// class Book{
//     String title , isbn;
//     double price;
//     Author author;

//     Book(String title, String isbn, double price, Author author){
//         this.title=title;
//         this.isbn=isbn;
//         this.price=price;
//         this.author=author;
//     }
//     public void displayBook(){
//         System.out.println("Title: "+title);
//         System.out.println("ISBN: "+isbn);
//         System.out.println("Price: "+ price);
//         System.out.println("++++++Author Details++++++");
//         author.displayAuthor();
//     }
// }

// class Author{
//     String name, email, country;

//     Author(String name, String email, String country){
//         this.name=name;
//         this.email=email;
//         this.country=country;
//     }
//     public void displayAuthor(){
//     System.out.println("Name: "+name);
//     System.out.println("email: "+email);
//     System.out.println("country: "+country);
//     }
// }

// class prac{
//     public static void main(String[] args) {
//         Author obj = new Author("shivg", "shiv@mail.com","india");
//         Book obj1= new Book("danger", "idk", 36.2 , obj);
//         obj1.displayBook();
//     }
// }

abstract class Payment{
    abstract void processPayment(double amount);
      
    public void showPaymentType(){
        System.out.println("Payment Type: " + paymentType);
    }
}
class CreditCardPayment extends Payment{

}
class UPIPayment extends Payment{

}
class prac{
    public static void main(String[] args) {
        
    }
}