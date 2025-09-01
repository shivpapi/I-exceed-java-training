class Subject{
    String subjectName;
    
    void displaySubject(){
        System.out.println("Subject name: "+ subjectName);
    }
}
class Teacher{
    String subject;
    Teacher(String subject){
        this.subject=subject;
    }
    Subject s=new Subject();
    void trial(){
    s.displaySubject();
    System.out.println("Subject is displayed");
    }
}
class agg{
    public static void main(String[] args) {
        Teacher t=new Teacher("maths");
       // t.displaySubject("Maths");
        t.trial();
       // System.out.println(t.trial);
    }
}