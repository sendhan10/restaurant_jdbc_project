import dao.MenuDAO;
import model.MenuItem;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int choice;
        do{
            System.out.println("\n===== RESTAURANT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Menu");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Exit");
            System.out.print("Enter choice: "); choice=sc.nextInt(); sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter name: "); String name=sc.nextLine();
                    System.out.print("Enter category: "); String cat=sc.nextLine();
                    System.out.print("Enter price: "); double price=sc.nextDouble();
                    System.out.println(MenuDAO.addMenuItem(new MenuItem(name,cat,price))?"Item added!":"Failed."); break;
                case 2:
                    System.out.println("\n--- MENU LIST ---");
                    MenuDAO.getAllMenuItems().forEach(System.out::println); break;
                case 3:
                    System.out.print("Enter ID to update: "); int id=sc.nextInt(); sc.nextLine();
                    System.out.print("New name: "); String n=sc.nextLine();
                    System.out.print("New category: "); String c=sc.nextLine();
                    System.out.print("New price: "); double p=sc.nextDouble();
                    System.out.println(MenuDAO.updateMenuItem(new MenuItem(id,n,c,p))?"Updated!":"Failed."); break;
                case 4:
                    System.out.print("Enter ID to delete: "); int d=sc.nextInt();
                    System.out.println(MenuDAO.deleteMenuItem(d)?"Deleted!":"Failed."); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        }while(choice!=5);
        sc.close();
    }
}