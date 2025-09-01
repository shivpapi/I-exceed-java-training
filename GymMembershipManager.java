import java.util.Scanner;

abstract class Membership {
    private String type;
    private double price;

    public Membership(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getBenefits();
}

// Monthly Membership (custom months)
class MonthlyMembership extends Membership {
    private int months;

    public MonthlyMembership(int months) {
        super("Monthly (" + months + " months)", months * 1500);
        this.months = months;
    }

    @Override
    public String getBenefits() {
        return "Access for " + months + " months, Free fitness assessment.";
    }
}

// Yearly Membership
class YearlyMembership extends Membership {
    private int years;

    public YearlyMembership(int years) {
        super("Yearly (" + years + " years)", years * 15000);
        this.years = years;
    }

    @Override
    public String getBenefits() {
        return "Access for " + years + " years, Free diet plan, Personal trainer for 1 month.";
    }
}
class Member {
    private String name;
    private int age;
    private Membership membership;

    public Member(String name, int age, Membership membership) {
        this.name = name;
        this.age = age;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Membership getMembership() {
        return membership;
    }
}
class GymManager {
    private Member[] members;
    private int count;

    public GymManager(int size) {
        members = new Member[size];
        count = 0;
    }

    public void addMember(Member m) {
        if (count < members.length) {
            members[count] = m;
            count++;
            System.out.println("Member added successfully!");
        } else {
            System.out.println("No more space to add members.");
        }
    }

    public void viewMembers() {
        if (count == 0) {
            System.out.println("No members registered yet.");
            return;
        }
        System.out.println("\n**** Gym Members List ****");
        for (int i = 0; i < count; i++) {
            Member m = members[i];
            System.out.println("Name: " + m.getName() +
                    ", Age: " + m.getAge() +
                    ", Membership: " + m.getMembership().getType() +
                    ", Price: Rs " + m.getMembership().getPrice());
            System.out.println("Benefits: " + m.getMembership().getBenefits());
            System.out.println("*************************************************");
        }
    }

    public Member searchMember(String searchName) {
        for (int i = 0; i < count; i++) {
            if (members[i].getName().equalsIgnoreCase(searchName)) {
                return members[i];
            }
        }
        return null;
    }

    public boolean deleteMember(String name) {
        for (int i = 0; i < count; i++) {
            if (members[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                members[j] = members[j + 1];
            }
                members[count - 1] = null;
                count--;
                return true; // deleted successfully
            }
        }
        return false; // not found
    }
}

public class GymMembershipManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GymManager manager = new GymManager(50); // Max 50 members
        int choice;

        do {
            System.out.println("\n--- Gym Membership Manager ---");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Search Member by Name");
            System.out.println("4. Delete Member by Name");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    System.out.println("Choose membership type:");
                    System.out.println("1. Monthly (Rs 1500 per month)");
                    System.out.println("2. Yearly (Rs 15000 per year)");
                    System.out.print("Enter choice: ");
                    int memType = sc.nextInt();

                    Membership membership = null;
                    boolean validInput = true;

                    if (memType == 1) {
                        System.out.print("Enter number of months: ");
                        int months = sc.nextInt();
                        if (months <= 0) {
                            System.out.println("Invalid number of months!");
                            validInput = false;
                            break;
                        }
                        double totalPrice = months * 1500;
                        System.out.println("Total amount for " + months + " month(s): Rs " + totalPrice);
                        System.out.print("Do you want to proceed? (yes/no): ");
                        sc.nextLine(); // consume newline
                        String confirm = sc.nextLine().trim().toLowerCase();
                        if (confirm.equals("yes")) {
                            membership = new MonthlyMembership(months);
                        } else {
                            System.out.println("Registration cancelled.");
                            validInput = false;
                        }

                    } else if (memType == 2) {
                        System.out.print("Enter number of years: ");
                        int years = sc.nextInt();
                        if (years <= 0) {
                            System.out.println("Invalid number of years!");
                            validInput = false;
                            break;
                        }
                        double totalPrice = years * 15000;
                        System.out.println("Total amount for " + years + " year(s): Rs " + totalPrice);
                        System.out.print("Do you want to proceed? (yes/no): ");
                        sc.nextLine(); // consume newline
                        String confirm = sc.nextLine().trim().toLowerCase();
                        if (confirm.equals("yes")) {
                            membership = new YearlyMembership(years);
                        } else {
                            System.out.println("Registration cancelled.");
                            validInput = false;
                        }
                    } else {
                        System.out.println("Invalid membership type!");
                        validInput = false;
                    }

                    if (validInput && membership != null) {
                        Member member = new Member(name, age, membership);
                        manager.addMember(member);
                    }
                    break;

                case 2:
                    manager.viewMembers();
                    break;

                case 3:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter member name to search: ");
                    String searchName = sc.nextLine();
                    Member found = manager.searchMember(searchName);
                    if (found != null) {
                        System.out.println("\n--- Member Found ---");
                        System.out.println("Name: " + found.getName());
                        System.out.println("Age: " + found.getAge());
                        System.out.println("Membership: " + found.getMembership().getType());
                        System.out.println("Price: Rs " + found.getMembership().getPrice());
                        System.out.println("Benefits: " + found.getMembership().getBenefits());
                        System.out.println("--------------------");
                    } else {
                        System.out.println("Member with name '" + searchName + "' not found.");
                    }
                    break;

                case 4:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter member name to delete: ");
                    String deleteName = sc.nextLine();
                    boolean deleted = manager.deleteMember(deleteName);
                    if (deleted) {
                        System.out.println("Member '" + deleteName + "' deleted successfully.");
                    } else {
                        System.out.println("Member with name '" + deleteName + "' not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
