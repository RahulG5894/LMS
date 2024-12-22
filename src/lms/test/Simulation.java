package lms.test;

import lms.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        // Library Object created for env setup
        Admin admin = LibraryGenerator.generate();
        admin.addMember(MemberType.USER, new PersonalDetails("Tarun", 20, Gender.MALE, "WestBenal, India", "ShaShib College of Tech", LocalDateTime.now()));

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bhagat Singh Library \nPlease select 1 for Admin Login and 2 for User Login");
        int id = sc.nextInt();
        switch (id) {
            case 1 -> {
                System.out.println("Books available:");
                for(Book book: admin.getBooksList()) {
                    System.out.println(book.toString());
                }
                System.out.println("Registered Users List : ");
                for(MemberCard card: admin.getMemberCards()) {
                    if(card.getMemberId() != admin.getCard().getMemberId()) {
                        System.out.println("Card Id: " + card.getMemberId()+"\n" + card.getDetails());
                    }
                }
                while(true) {
                    System.out.println("Please select below options to proceed:" +
                            "\n1 -> Enable the user" +
                            "\n2 -> Disable the user" +
                            "\n3 -> Lend books to the user " +
                            "\n4 -> Return books to the Library" +
                            "\n5 -> Logout");
                    int input = sc.nextInt();
                    if (input == 5) {
                        break;
                    }
                    if (input == 4) {
                        System.out.println("You are lending books to the user, Please enter the Card Id");
                        int cardId = sc.nextInt();
                        System.out.println("Please enter the ID of books being returned:");
                        List<Integer> booksId = new ArrayList<>();
                        int bookId = sc.nextInt();
                        while (bookId != -1) {
                            booksId.add(bookId);
                            System.out.println("Enter -1 once listed all the books, else continue entering the book Id");
                            bookId = sc.nextInt();
                        }
                        System.out.println("RETURN BOOKS : " + admin.returnBooks(cardId, booksId));
                    }
                    if (input == 3) {
                        System.out.println("You are lending books to the user, Please enter the Card Id");
                        int cardId = sc.nextInt();
                        System.out.println("Please enter the ID of books being lend to the User:");
                        List<Integer> booksId = new ArrayList<>();
                        int bookId = sc.nextInt();
                        while (bookId != -1) {
                            booksId.add(bookId);
                            System.out.println("Enter -1 once listed all the books, else continue entering the book Id");
                            bookId = sc.nextInt();
                        }
                        System.out.println("BORROW BOOKS : " + admin.borrowBooks(cardId, booksId));
                    }
                    if (input == 2) {
                        System.out.println("Please enter the card id to enable the user:");
                        List<Long> cardIds = new ArrayList<>();
                        long cardId = sc.nextLong();
                        while (cardId != -1) {
                            cardIds.add(cardId);
                            System.out.println("Enter -1 once listed all the users, else continue entering the User Id");
                            cardId = sc.nextInt();
                        }
                        List<String> errors = admin.enableUser(cardIds, Boolean.FALSE);
                        if(errors.size() > 0) {
                            for(String err: errors) {
                                System.out.println(err);
                            }
                        }
                    }
                    if (input == 1) {
                        System.out.println("Please enter the card id to enable the user:");
                        List<Long> cardIds = new ArrayList<>();
                        long cardId = sc.nextLong();
                        while (cardId != -1) {
                            cardIds.add(cardId);
                            System.out.println("Enter -1 once listed all the users, else continue entering the User Id");
                            cardId = sc.nextInt();
                        }
                        List<String> errors = admin.enableUser(cardIds, Boolean.TRUE);
                        if(errors.size() > 0) {
                            for(String err: errors) {
                                System.out.println(err);
                            }
                        }
                    }
                }
            }
            case 2 -> {
                break;
            }
        }

    }
}
