package com.pluralsight;
import java.util.Scanner;

public class NeighborhoodLibrary {
    private static Book[] libraryBook = new Book[20];

    public static void main(String[] args) {
        libraryBook[0] = new Book(1, "978-1-23456-789-7", "The Last Ember", false, "");
        libraryBook[1] = new Book(2, "978-1-23456-790-3", "Shadows of Tomorrow", false, "");
        libraryBook[2] = new Book(3, "978-1-23456-791-0", "Whispers in the Fog", false, "");
        libraryBook[3] = new Book(4, "978-1-23456-792-7", "The Glass Horizon", false, "");
        libraryBook[4] = new Book(5, "978-1-23456-793-4", "Echoes of the Forgotten", false, "");
        libraryBook[5] = new Book(6, "978-1-23456-794-1", "Beneath the Silent Waves", false, "");
        libraryBook[6] = new Book(7, "978-1-23456-795-8", "A Kingdom of Ash and Light", false, "");
        libraryBook[7] = new Book(8, "978-1-23456-796-5", "The Clockmaker’s Paradox", false, "");
        libraryBook[8] = new Book(9, "978-1-23456-797-2", "Midnight at the Iron Gate", false, "");
        libraryBook[9] = new Book(10, "978-1-23456-798-9", "The Dream Cartographer", false, "");
        libraryBook[10] = new Book(11, "978-1-23456-799-6", "Threads of Eternity", false, "");
        libraryBook[11] = new Book(12, "978-1-23456-800-9", "The Silent Archive", false, "");
        libraryBook[12] = new Book(13, "978-1-23456-801-6", "Rivers of Starlight", false, "");
        libraryBook[13] = new Book(14, "978-1-23456-802-3", "The Cipher of Winter", false, "");
        libraryBook[14] = new Book(15, "978-1-23456-803-0", "Wanderers of the Void", false, "");
        libraryBook[15] = new Book(16, "978-1-23456-804-7", "Ashes and Auras", false, "");
        libraryBook[16] = new Book(17, "978-1-23456-805-4", "The Memory Alchemist", false, "");
        libraryBook[17] = new Book(18, "978-1-23456-806-1", "Labyrinth of Forgotten Kings", false, "");
        libraryBook[18] = new Book(19, "978-1-23456-807-8", "Voices Beyond the Veil", false, "");
        libraryBook[19] = new Book(20, "978-1-23456-808-5", "The Infinite Orchard", false, "");

        Scanner myScanner = new Scanner(System.in);

        boolean inLibrary = false;

        while (!inLibrary) {
            System.out.println("Welcome to the library software");
            System.out.println("--------------------------------");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit\n");
            System.out.print("Enter your choice (1-3): ");
            int command = myScanner.nextInt();
            myScanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println();
                    listAllBooks();
                    checkoutABook(myScanner);
                    break;
                case 2:
                    System.out.println();
                    showCheckedOutBooks(myScanner);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Thank you for visiting the library, I'll see you again");
                    inLibrary = true;
                    break;
                default:
                    System.out.println("Invalid Input! Please choose from numbers (1-3)\n");
            }
        }

        myScanner.close();

    }

    public static void showCheckedOutBooks(Scanner scanner) {

        boolean found = false;

        // I believe the use of for each loop is the best in my case when the array is nearly full
        // I can also use another variable to store the actual number of books for a wider use case
        // The prompt to check in the book is skipped if there are no books checked out
        for (Book book : libraryBook) {
            if (book.getIsCheckedOut()) {
                System.out.println("Checked Out Books");
                System.out.println("------------------");
                System.out.println(book + " | " + book.getCheckedOutTo());
                found = true;
                System.out.println();

                System.out.print("Press \"C\" to check in a book or \"X\" to go back to the library: ");
                String checkIn = scanner.nextLine();

                if (checkIn.equalsIgnoreCase("C")) {
                    System.out.println();
                    System.out.print("Enter the id of the book you want to check in: ");
                    int bookCheckInId = scanner.nextInt();

                    libraryBook[bookCheckInId - 1].checkIn(libraryBook[bookCheckInId - 1], libraryBook[bookCheckInId - 1].getTitle());
                } else if (checkIn.equalsIgnoreCase("X")) {
                    System.out.println();
                } else {
                    System.out.println("Invalid Input! Returning to the library \n");
                }
            }
        }

        if (!found) {
            System.out.println("There are no books checked out! Returning to the library\n");
        }
    }

    public static void checkoutABook(Scanner scanner) {
        System.out.print("Enter the id of the book you want to check-out (0 to cancel): ");
        int idOfBook = scanner.nextInt();
        scanner.nextLine();

        if (idOfBook > 0 && idOfBook < libraryBook.length) {
            System.out.print("Enter your name: ");
            String checkoutName = scanner.nextLine();

            libraryBook[idOfBook - 1].checkOut(checkoutName, libraryBook[idOfBook - 1].getTitle());
        } else {
            System.out.println("Please choose an id number of the book that is available\n");
        }
    }

    public static void listAllBooks() {
        System.out.println("Available Books");
        System.out.println("-------------------");

        // Also applied for each loop here for my use case
        for (Book book : libraryBook) {
            if (!book.getIsCheckedOut())
                System.out.println(book);
        }

        System.out.println("-------------------\n");
    }
}
