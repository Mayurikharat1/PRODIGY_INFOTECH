import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhonenumber(){
        return phoneNumber;
    }
    public void setPhonenumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public String toString(){
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\n";
    }
}
public class ContactManagement {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("\nContact Management System");
            System.out.println("1. Add a New Contact");
            System.out.println("2. View Contact list");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                addContact();
                break;
                case 2:
                viewContactList();
                break;
                case 3:
                editContact();
                break;
                case 4:
                deleteContact();
                break;
                case 5:
                System.out.println("Program Ended!!");
                scanner.close();
                System.exit(0);
                default:
                System.out.println("Invalid Choice. Please Enter the Valid Choice.");
            }
        }
    }
    private static void addContact(){
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added Successfully.");
    }
    private static void viewContactList(){
        if(contacts.isEmpty()){
            System.out.println("Contact list is Empty.");
        }
        else{
            System.out.println("\nContact List: ");
            for(int i=0; i<contacts.size(); i++){
                System.out.println((i+1)+ ". " + contacts.get(i));
            }
        }
    }
    private static void editContact(){
        viewContactList();
        if(contacts.isEmpty()){
            return;
        }
        System.out.print("Enter the Index of Contact you want to Edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if(index<1 || index>contacts.size()){
            System.out.println("Invalid Index. Please Enter valid Index.");
        }
        else{
            System.out.println("Editing Contact at Index " + index + ":");
            Contact contact = contacts.get(index-1);

            System.out.print("Enter New Name: ");
            contact.setName(scanner.nextLine());
            System.out.print("Enter New Phone Number: ");
            contact.setPhonenumber(scanner.nextLine());
            System.out.print("Enter Email: ");
            contact.setEmail(scanner.nextLine());
            System.out.println("Contact Edited Successfully.");
        }
    }
    private static void deleteContact(){
        viewContactList();
        if(contacts.isEmpty()){
            return;
        }
        System.out.print("Enter the Index of the Contact You Want to Delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if(index<1 || index>contacts.size()){
            System.out.println("Invalid Index. Please Enter the Valid Index.");
        }
        else{
            Contact contact = contacts.remove(index-1);
            System.out.println("Contact Deleted Sccessfully.");
        }
    }
}