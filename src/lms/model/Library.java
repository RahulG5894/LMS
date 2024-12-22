package lms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Section, List<Book>> resources;
    private List<Book> booksList;
    private List<Member> members;
    private List<MemberCard> memberCards;
    private int totalBooks;
    private BookInventoryManager bookInventoryManager;
    private MemberManager memberManager;

    public Library() {
        this.members = new ArrayList<>();
        this.booksList = new ArrayList<>();
        this.memberCards = new ArrayList<>();
        this.resources = new HashMap<>();
        this.bookInventoryManager = new BookInventoryManager(booksList, members, memberCards, resources);
        this.memberManager = new MemberManager(memberCards, members);
    }

    public MemberManager getMemberManager() {
        return memberManager;
    }

    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public BookInventoryManager getBookInventoryManager() {
        return bookInventoryManager;
    }

    public void setBookInventoryManager(BookInventoryManager bookInventoryManager) {
        this.bookInventoryManager = bookInventoryManager;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public List<MemberCard> getMemberCards() {
        return memberCards;
    }

    public void setMemberCards(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Map<Section, List<Book>> getResources() {
        return resources;
    }

    public void setResources(Map<Section, List<Book>> resources) {
        this.resources = resources;
    }
}
