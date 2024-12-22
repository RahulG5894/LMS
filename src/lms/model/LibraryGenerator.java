package lms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryGenerator {

    public static Member generate() {
        Library lib = new Library();
        BookInventoryManager bookInventoryManager = lib.getBookInventoryManager();
        List<Book> books = new ArrayList<>();
        books.add(new Book("Physics Magic", "Irodov", 120.89, Section.SCIENCE, 3));
        books.add(new Book("India's Ancient Past", "RS Sharma", 124.76, Section.ARTS, 1));
        books.add(new Book("Business Accounting", "Joe Ben Hoyle, C. J. Skender", 240.59, Section.COMMERCE, 2));
        bookInventoryManager.addBooks(books);
        MemberManager memberManager = lib.getMemberManager();
        Admin admin = memberManager.addAdmin(new PersonalDetails( "Prajakta", 26, Gender.FEMALE, "Trichi, India", "Bhagat Singh Library", LocalDateTime.now()));
        admin.setInventoryManager(lib.getBookInventoryManager());
        admin.setMemberManager(lib.getMemberManager());
        return admin;
    }
}
