import java.util.ArrayList; 

  

public class Inventory { 

    private ArrayList<Book> mainInventory; 

    private ArrayList<Book> lendingInventory; 

  

    public Inventory() { 

        mainInventory = new ArrayList<>(); 

        lendingInventory = new ArrayList<>(); 

    } 

  

     

    public void addBook(Book book) { 

        mainInventory.add(book); 

    } 

  

   

    public boolean borrowBook(int id) { 

        for (Book book : mainInventory) { 

            if (book.getId() == id) { 

                lendingInventory.add(book); 

                mainInventory.remove(book); 

                return true; 

            } 

        } 

        return false; 

    } 

  

    public boolean returnBook(int id) { 

        for (Book book : lendingInventory) { 

            if (book.getId() == id) { 

                mainInventory.add(book); 

                lendingInventory.remove(book); 

                return true; 

            } 

        } 

        return false; 

    } 

  

   

    public void printAll() { 

        if (mainInventory.isEmpty()) { 

            System.out.println("No books available in the library."); 

            return; 

        } 

  

        for (Book book : mainInventory) { 

            book.printBookInfo(); 

        } 

    } 

  

   

    public void searchByTitle(String title) { 

        boolean found = false; 

  

        for (Book book : mainInventory) { 

            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) { 

                book.printBookInfo(); 

                found = true; 

            } 

        } 

  

        if (!found) { 

            System.out.println("No matching book found."); 

        } 

    } 

  

    public int getMainInventoryCount() { 

        return mainInventory.size(); 

    } 

} 

 
