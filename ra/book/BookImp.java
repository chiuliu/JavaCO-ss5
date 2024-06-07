package session04;

import java.util.Scanner;

public class BookImp {
    static Book[] books = new Book[100];
    static Scanner sc = new Scanner(System.in);
    static int indexBook = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************MENU****************");
            System.out.println("1.Nhập thông tin n sách");
            System.out.println("2.Tính lợi nhuận các sách");
            System.out.println("3.Hiển thị thông tin sách");
            System.out.println("4.Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5.Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6.Tìm sách theo tên sách");
            System.out.println("7.Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8.Thống kê số lượng sách theo tác giả");
            System.out.println("9.Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    listInterest();
                    break;
                case 3:
                    listBook();
                    break;
                case 4:
                    sortPriceBook();
                    break;
                case 5:
                    sortInterest();
                    break;
                case 6:
                    searchBookName();
                    break;
                case 7:
                    countYear();
                    break;
                case 8:
                    countBookOfAuthor();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập trong khoảng 1-9");
            }
        } while (true);

    }

    public static void addNewBook() {
        System.out.println("Nhập vào số lượng sách cần thêm");
        int number = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < number; i++) {
            Book book = new Book();
            book.inputData();
            books[indexBook] = book;
            indexBook++;
            count++;
        }
        System.out.printf("Thêm thành công %d sản phẩm", count);
    }

    public static void listInterest() {
        if (indexBook == 0) {
            System.out.println("Chưa có sách nào trong hệ thống");
            return;
        }
        float interest = 0;
        for (int i = 0; i < indexBook; i++) {
            interest = books[i].getExportPrice() - books[i].getImportPrice();
            System.out.println(books[i].getBookName() + " có lợi nhuận là: " + interest);
        }
    }

    public static void listBook() {
        if (indexBook == 0) {
            System.out.println("Chưa có sách nào trong hệ thống");
            return;
        }
        for (int i = 0; i < indexBook; i++) {
            System.out.println(books[i]);
        }
    }

    public static void sortPriceBook() {
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (books[i].getExportPrice() > books[j].getExportPrice()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        listBook();
    }
    public static void sortInterest(){
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (books[i].getInterest() < books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        listBook();
    }
    public static void searchBookName(){
        System.out.println("Nhập tên sách muốn tìm");
        String bookName = sc.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < indexBook; i++) {
            if(books[i].getBookName().toLowerCase().contains(bookName)){
                System.out.println(books[i]);
                count++;
            }
        }
        if(count == 0){
            System.out.println("Không tìm thấy sách bạn muốn tìm");
        }
    }
    public static void countYear(){
        System.out.println("Nhập năm xuất bản");
        int year = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < indexBook; i++) {
            if(books[i].getYear() == year){
                count++;
            }
        }
        System.out.printf("Co %d sách được xuất bản năm %d\n",count,year);
    }
    public static void countBookOfAuthor(){
        System.out.println("Nhập tên tác giả");
        String author = sc.nextLine();
        int count =0;
        for (int i =0; i<indexBook;i++){
            if(books[i].getAuthor().equals(author)){
                count++;
            }
        }
        System.out.printf("tác giả %s có %d quyển sách\n",author,count);
    }
}
