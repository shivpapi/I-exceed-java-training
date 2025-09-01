class battery{
    void getPower(){
        System.out.println("");
    }
}
class phone{
    private battery b = new battery();
    //b.getPower();
void startPhone(){
    b.getPower();
    System.out.println("phone is starting");
}
}
class compo{
    public static void main(String[] args) {
        phone p = new phone();
        p.startPhone();
    }
}