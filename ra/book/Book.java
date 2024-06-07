package session04;

import java.util.Scanner;

public class Book {
    private static float importPriceTemp;
    static Scanner sc = new Scanner(System.in);
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public float interest(){
        this.interest = (this.exportPrice-this.importPrice);
        return this.interest;
    }
    public void inputData() {
        bookId = inputBookId();
        bookName = inputBookName();
        importPrice = inputImportPrice();
        exportPrice = inputExportPrice();
        author = inputAuthor();
        year = inputYear();
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", author='" + author + '\'' +
                ", interest=" + interest() +
                ", year=" + year +
                '}';
    }

    //Kiểm tra BookId
    public String inputBookId() {
        boolean isExist = true;
        do {
            System.out.println("Nhập vào mã sách");
            String bookId = sc.nextLine();
            if(BookImp.indexBook > 0){
                for (int i = 0; i < BookImp.indexBook; i++) {
                    if (bookId.equals(BookImp.books[i].getBookId())) {
                        isExist = false;
                        break;
                    } else {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    System.out.println("Mã sản phẩm đã tồn tại");
                }
            }else{
                return bookId;
            }
        } while (!isExist);
        return bookId;
    }

    // Kiểm tra BookName
    public String inputBookName() {
        do {
            boolean isExist = true;
            System.out.println("Nhập tên sách");
            String bookName = sc.nextLine();
            if (bookName.length() == 4) {
                if (bookName.charAt(0) == 'B') {
                    for (int i = 0; i < BookImp.indexBook; i++) {
                        System.out.println(BookImp.books[i].getBookName());
                        if (bookName.equals(BookImp.books[i].getBookName())) {
                            isExist = false;
                            break;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Tên sách đã tồn tại");
                    } else {
                        return bookName;
                    }
                } else {
                    System.out.println("Tên sách phải bắt đầu bằng chữ B");
                }
            } else {
                System.out.println("Tên sách phải có 4 ký tự");
            }
        } while (true);
    }

    //Kiểm tra giá nhập
    public float inputImportPrice() {
        while (true) {
            System.out.println("Nhập vào giá nhập của sách");
            float importPrice = Float.parseFloat(sc.nextLine());
            if (importPrice < 0) {
                System.out.println("Giá nhập không được bé hơn 0");
            } else {
                importPriceTemp = importPrice;
                return importPrice;
            }
        }
    }

    //Kiểm tra giá xuất
    public float inputExportPrice() {
        System.out.println(importPriceTemp);
        while (true) {
            System.out.println("Nhập giá xuất của sách");
            float exportPrice = Float.parseFloat(sc.nextLine());
            if (exportPrice < (importPriceTemp + importPriceTemp * 0.3)){
                System.out.println("Giá xuất phải cao hơn giá nhập ít nhất 30%");
            } else {
                return exportPrice;
            }
        }
    }

    //Kiểm tra tác giả
    public String inputAuthor() {
        while (true) {
            System.out.println("Nhập tên tác giả");
            String authorName = sc.nextLine();
            if (authorName.length() >= 6 && authorName.length() <= 50) {
                return authorName;
            } else {
                System.out.println("Tên tác giả phải nằm trong khoảng 6 đến 50 ký tự");
            }
        }
    }
    //Kiểm tra năm xuất bản
    public int inputYear(){
        while (true){
            System.out.println("Nhập năm xuất bản");
            int yearOfBook = Integer.parseInt(sc.nextLine());
            if(yearOfBook>2000){
                return yearOfBook;
            }else{
                System.out.println("Năm xuất bản không được nhỏ hơn 2000");
            }
        }
    }
}
