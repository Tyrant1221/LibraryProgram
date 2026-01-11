import java.util.Scanner; 

  

public class Main { 

    public static void main(String[] args) { 

        Inventory inventory = new Inventory(); 

        Scanner scanner = new Scanner(System.in); 

        boolean running = true; 

  

        while (running) { 

            System.out.println("\n===== Library Menu ====="); 

            System.out.println("1. Add Book"); 

            System.out.println("2. Borrow Book"); 

            System.out.println("3. Return Book"); 

            System.out.println("4. Search by Title"); 

            System.out.println("5. Print All Books"); 

            System.out.println("6. Exit"); 

            System.out.print("Choose an option: "); 

  

            try { 

                int choice = scanner.nextInt(); 

                scanner.nextLine(); // clear buffer 

  

                switch (choice) { 

                    case 1: 

                        System.out.print("Enter ID: "); 

                        int id = scanner.nextInt(); 

                        scanner.nextLine(); 

  

                        System.out.print("Enter Title: "); 

                        String title = scanner.nextLine(); 

  

                        System.out.print("Enter Author: "); 

                        String author = scanner.nextLine(); 

  

                        System.out.print("Enter ISBN: "); 

                        String isbn = scanner.nextLine(); 

  

                        System.out.print("Enter Number of Pages: "); 

                        int pages = scanner.nextInt(); 

  

                        Book book = new Book(id, title, author, isbn, pages); 

                        inventory.addBook(book); 

                        System.out.println("Book added to the library."); 

                        break; 

  

                    case 2: 

                        System.out.print("Enter Book ID to borrow: "); 

                        int borrowId = scanner.nextInt(); 

  

                        if (inventory.borrowBook(borrowId)) { 

                            System.out.println("Book borrowed successfully."); 

                        } else { 

                            System.out.println("Book not found."); 

                        } 

                        break; 

  

                    case 3: 

                        System.out.print("Enter Book ID to return: "); 

                        int returnId = scanner.nextInt(); 

  

                        if (inventory.returnBook(returnId)) { 

                            System.out.println("Book returned successfully."); 

                        } else { 

                            System.out.println("Book not found in lending inventory."); 

                        } 

                        break; 

  

                    case 4: 

                        System.out.print("Enter title to search: "); 

                        String searchTitle = scanner.nextLine(); 

                        inventory.searchByTitle(searchTitle); 

                        break; 

  

                    case 5: 

                        inventory.printAll(); 

                        break; 

  

                    case 6: 

                        running = false; 

                        System.out.println("Exiting the program."); 

                        break; 

  

                    default: 

                        System.out.println("Invalid option. Please try again."); 

                } 

  

            } catch (Exception e) { 

                System.out.println("Invalid input. Please enter the correct data type."); 

                scanner.nextLine(); // clear invalid input 

            } 

        } 

  

        scanner.close(); 

    } 

} 
