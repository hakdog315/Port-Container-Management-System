import java.util.*;

class Container{
	private String ID;
	private String desc;
	private int weight;
	
	public Container (String ID, String desc, int weight) {
	this.ID = ID;
	this.desc = desc;
	this.weight= weight;
	}
	public String toString() {
		return ID + "|" + desc + "|" + weight;
	}
}

class Ship {
	private String Name;
	private String Captain;
	
	
	public Ship (String Name, String Captain) {
		this.Name = Name;
		this.Captain = Captain;
		
	}
	
	public String toString() {
		return Name + "| Capt." + Captain;
	}
}

public class PortSiya {
	private static ArrayDeque <Container> containerStack = new ArrayDeque <>();
	private static ArrayDeque <Ship> shipStack = new ArrayDeque<>();
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String[]args) {
		String choice;
		
		do {
			System.out.println("\n=== Port Container Management System ===");
			System.out.println("[1] Store container");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            int choice2 = sc.nextInt();
            sc.nextLine();
            
            switch (choice2) {
            
            case 1: storeContainer(); break;
            case 2: viewContainer(); break;
            case 3: registerShip(); break;
            case 4: viewShips(); break;
            case 5: loadShips(); break;
            case 0: System.out.println ("Exiting program..."); return;
            
            	default: System.out.println("Invalid Choice. Try again");
            }
            System.out.println("Do you want to continue? [y/n]");
            choice = sc.nextLine().trim().toLowerCase();
		}while (choice.equals("y"));
	}
	
	private static void storeContainer() {
		System.out.print("Enter container ID: ");
		String ID = sc.nextLine();
		System.out.print("Enter description: ");
		String desc = sc.nextLine();
		System.out.print("Enter wieght (kg): ");
		int weight = sc.nextInt();
		sc.nextLine();
		
		Container c = new Container (ID, desc, weight);
		containerStack.push(c);
		System.out.println("Stored:" + c);
		
	}
	
	private static void viewContainer() {
		if (containerStack.isEmpty()) {
			System.out.println("No containers at port");
			return;
		}else {
			System.out.print("TOP >");
			for (Container c: containerStack) {
				System.out.println(c);
			}
			System.out.println("< Bottom");
		}
	}
	private static void registerShip() {
		System.out.print("Enter Ship name: ");
		String name = sc.nextLine();
		System.out.print("Enter Captain name: ");
		String Captain = sc.nextLine();
		
		Ship s = new Ship (name, Captain);
		shipStack.offer(s);
		System.out.println("Registered: " + s);
		
	}
	private static void viewShips() {
		if (shipStack.isEmpty()) {
			System.out.println("No ships waiting");
			return;
		}else {
			System.out.println("Front > ");
			for (Ship s: shipStack) {
				System.out.println(s);
			}
			System.out.println("< Rear");
		}
	}
	private static void loadShips() {
		if (containerStack.isEmpty()) {
			System.out.println("No containers available to load");
			return;
		}
		if (shipStack.isEmpty()) {
			System.out.println("No ships waiting to be loaded");
			return;
		}
		Container c = containerStack.pop();
		Ship s = shipStack.poll();
		
		System.out.println("Loaded:" + c + "> " + s);
		System.out.println("Remaining containers: " + containerStack.size());
		System.out.println("Remaining ships:" + shipStack.size());
	}
}
