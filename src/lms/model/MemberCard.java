package lms.model;

import java.util.ArrayList;
import java.util.List;

public class MemberCard {
    private long memberId;
    private boolean enabled;
    private List<Integer> borrowedBooks;
    private PersonalDetails details;

    public MemberCard(long memberId, PersonalDetails details) {
        this.memberId = memberId;
        this.details = details;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public PersonalDetails getDetails() {
        return details;
    }

    public void setDetails(PersonalDetails details) {
        this.details = details;
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBooks(Integer bookId) {
        borrowedBooks.add(bookId);
    }
}
