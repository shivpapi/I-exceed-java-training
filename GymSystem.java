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

class MonthlyMembership extends Membership {
    private int months;

    public MonthlyMembership(int months, double price) {
        super("Monthly (" + months + " months)", price);
        this.months = months;
    }

    @Override
    public String getBenefits() {
        return "Access to gym equipment for " + months + " months.";
    }
}

class YearlyMembership extends Membership {
    public YearlyMembership(double price) {
        super("Yearly", price);
    }

    @Override
    public String getBenefits() {
        return "Access to gym equipment for 12 months plus free diet plan.";
    }
}

class PremiumMembership extends Membership {
    public PremiumMembership(double price) {
        super("Premium", price);
    }

    @Override
    public String getBenefits() {
        return "Includes gym equipment access, personal trainer, and spa services.";
    }
}

class Trainer {
    private String name;
    private int membersAssigned;

    public Trainer(String name) {
        this.name = name;
        this.membersAssigned = 0;
    }

    public String getName() {
        return name;
    }

    public int getMembersAssigned() {
        return membersAssigned;
    }

    public boolean assignMember() {
        if (membersAssigned < 5) {
            membersAssigned++;
            return true;
        }
        return false;
    }
}

class Member {
    private String name;
    private Membership membership;
    private Trainer trainer;

    public Member(String name, Membership membership, Trainer trainer) {
        this.name = name;
        this.membership = membership;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public Membership getMembership() {
        return membership;
    }

    public Trainer getTrainer() {
        return trainer;
    }
}

class GymManager {
    private Member[] members;
    private int count;
    private Trainer[] trainers;

    public GymManager(int size) {
        members = new Member[size];
        count = 0;
        trainers = new Trainer[] {
            new Trainer("John"),
            new Trainer("Emma"),
            new Trainer("Raj")
        };
    }

    public void addMember(Member member) {
        if (count < members.length) {
            members[count++] = member;
            System.out.println("Member added successfully!");
        } else {
            System.out.println("Gym is full. Cannot add more members.");
        }
    }

    public void displayMembers() {
        if (count == 0) {
            System.out.println("No members registered.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + members[i].getName() +
                    ", Membership: " + members[i].getMembership().getType() +
                    ", Trainer: " + members[i].getTrainer().getName());
        }
    }

    public Trainer chooseTrainer(Scanner sc) {
        while (true) {
            System.out.println("\nChoose a trainer (Max 5 members per trainer):");
            for (int i = 0; i < trainers.length; i++) {
                System.out.println((i + 1) + ". " + trainers[i].getName() + 
                    " (Currently " + trainers[i].getMembersAssigned() + " members)");
            }
            System.out.print("Enter trainer number: ");
            int trainerChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (trainerChoice >= 1 && trainerChoice <= trainers.length) {
                Trainer chosenTrainer = trainers[trainerChoice - 1];
                if (chosenTrainer.assignMember()) {
                    return chosenTrainer;
                } else {
                    System.out.println("❌ This trainer already has 5 members. Please choose another trainer.");
                }
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class GymSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GymManager manager = new GymManager(20);

        int choice;
        do {
            System.out.println("\n--- Gym Management System ---");
            System.out.println("1. Add Member");
            System.out.println("2. Display Members");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();

                    System.out.println("Choose Membership Type:");
                    System.out.println("1. Monthly");
                    System.out.println("2. Yearly");
                    System.out.println("3. Premium");
                    int mChoice = sc.nextInt();

                    Membership membership = null;

                    switch (mChoice) {
                        case 1:
                            System.out.print("Enter number of months: ");
                            int months = sc.nextInt();
                            double monthlyPrice = months * 1000;
                            sc.nextLine(); // consume newline
                            System.out.println("Price: " + monthlyPrice);
                            System.out.print("Do you agree to the price? (yes/no): ");
                            String confirmMonthly = sc.nextLine().trim().toLowerCase();
                            if (!confirmMonthly.equals("yes")) {
                                System.out.println("Membership not added.");
                                break;
                            }
                            membership = new MonthlyMembership(months, monthlyPrice);
                            break;

                        case 2:
                            double yearlyPrice = 10000;
                            sc.nextLine();
                            System.out.println("Price: " + yearlyPrice);
                            System.out.print("Do you agree to the price? (yes/no): ");
                            String confirmYearly = sc.nextLine().trim().toLowerCase();
                            if (!confirmYearly.equals("yes")) {
                                System.out.println("Membership not added.");
                                break;
                            }
                            membership = new YearlyMembership(yearlyPrice);
                            break;

                        case 3:
                            double premiumPrice = 20000;
                            sc.nextLine();
                            System.out.println("Price: " + premiumPrice);
                            System.out.print("Do you agree to the price? (yes/no): ");
                            String confirmPremium = sc.nextLine().trim().toLowerCase();
                            if (!confirmPremium.equals("yes")) {
                                System.out.println("Membership not added.");
                                break;
                            }
                            membership = new PremiumMembership(premiumPrice);
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }

                    if (membership != null) {
                        Trainer chosenTrainer = manager.chooseTrainer(sc);
                        Member member = new Member(name, membership, chosenTrainer);
                        manager.addMember(member);
                    }
                    break;

                case 2:
                    manager.displayMembers();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}
