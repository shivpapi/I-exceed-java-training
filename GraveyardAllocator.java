import java.util.*;

class Grave {
    private int plotId;
    private String name;
    private String reasonOfDeath;
    private long burialTime; // Stores the burial time in milliseconds
    private boolean isOccupied;

    public Grave(int plotId) {
        this.plotId = plotId;
        this.isOccupied = false;
    }

    public int getPlotId() {
        return plotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void bury(String name, String reasonOfDeath) {
        this.name = name;
        this.reasonOfDeath = reasonOfDeath;
        this.burialTime = System.currentTimeMillis();
        this.isOccupied = true;
    }

    public void emptyGrave() {
        this.name = null;
        this.reasonOfDeath = null;
        this.burialTime = 0;
        this.isOccupied = false;
    }

    public String getName() {
        return name;
    }

    public String getReasonOfDeath() {
        return reasonOfDeath;
    }

    public long getBurialTimeSeconds() {
        if (!isOccupied) return 0;
        return (System.currentTimeMillis() - burialTime) / 1000;
    }

    public boolean checkAndFreeIfExpired() {
        if (isOccupied && (System.currentTimeMillis() - burialTime) >= 60000) { // 2 minutes = 120000 ms
            emptyGrave();
            return true;
        }
        return false;
    }
}

class Graveyard {
    private List<Grave> graves;

    public Graveyard(int size) {
        graves = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            graves.add(new Grave(i));
        }
    }

    public void allocateGrave(String name, String reasonOfDeath, int plotId) {
        Grave grave = getGraveById(plotId);
        if (grave != null && !grave.isOccupied()) {
            grave.bury(name, reasonOfDeath);
            System.out.println("Grave allocated successfully to " + name + " in Plot " + plotId);
        } else {
            System.out.println("Plot already occupied or invalid.");
        }
    }

    public void freeGrave(int plotId) {
        Grave grave = getGraveById(plotId);
        if (grave != null && grave.isOccupied()) {
            grave.emptyGrave();
            System.out.println("Grave in Plot " + plotId + " is now empty.");
        } else {
            System.out.println("Plot is already empty or invalid.");
        }
    }

    public void viewGraves() {
        System.out.println("\n--- Graveyard Status ---");
        for (Grave grave : graves) {
            grave.checkAndFreeIfExpired(); // Auto free expired graves
            if (grave.isOccupied()) {
                System.out.println("Plot " + grave.getPlotId() + " → " + grave.getName() +
                        " (Reason: " + grave.getReasonOfDeath() + ", Buried " +
                        grave.getBurialTimeSeconds() + " seconds ago)");
            } else {
                System.out.println("Plot " + grave.getPlotId() + " → Empty");
            }
        }
        System.out.println("------------------------\n");
    }

    public void searchGrave(String name) {
        boolean found = false;
        for (Grave grave : graves) {
            grave.checkAndFreeIfExpired(); // Auto free expired graves
            if (grave.isOccupied() && grave.getName().equalsIgnoreCase(name)) {
                System.out.println("" + name + " is buried in Plot " + grave.getPlotId());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No grave found for: " + name);
        }
    }

    private Grave getGraveById(int plotId) {
        for (Grave grave : graves) {
            if (grave.getPlotId() == plotId) return grave;
        }
        return null;
    }
}

public class GraveyardAllocator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graveyard graveyard = new Graveyard(5);

        System.out.println("Welcome to Graveyard Allocator ⚰");
        System.out.println("Don't worry if the graves are full, they empty automatically after 1 minute!\n");

        while (true) {
            System.out.println("1. Allocate Grave");
            System.out.println("2. Free Grave");
            System.out.println("3. View Graves");
            System.out.println("4. Search Grave by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Plot ID(1-5): ");
                    int plotId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name of Deceased: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Reason of Death: ");
                    String reason = sc.nextLine();

                    System.out.println("Burial cost is Rs. 9500. Do you agree? (yes/no): ");
                    String agree = sc.nextLine();

                    if (!agree.equalsIgnoreCase("yes")) {
                        System.out.println("For you, special price: Rs. 7000. Do you agree? (yes/no): ");
                        String specialAgree = sc.nextLine();
                        if (!specialAgree.equalsIgnoreCase("yes")) {
                            System.out.println("Allocation cancelled.");
                            break;
                        }
                    }

                    graveyard.allocateGrave(name, reason, plotId);
                    break;

                case 2:
                    System.out.print("Enter Plot ID to free: ");
                    int freeId = sc.nextInt();
                    graveyard.freeGrave(freeId);
                    break;

                case 3:
                    graveyard.viewGraves();
                    break;

                case 4:
                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();
                    graveyard.searchGrave(searchName);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
