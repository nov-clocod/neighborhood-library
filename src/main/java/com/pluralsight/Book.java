package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return this.id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public String getCheckedOutTo() {
        return this.checkedOutTo;
    }

    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
        System.out.println(name + " Checked out!");
    }

    public void checkIn(String name) {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
        System.out.println("Thank you for checking in " + name);
    }
}
