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

    public Library() {
        resources = new HashMap<>();
        members = new ArrayList<>();
        booksList = new ArrayList<>();
        memberCards = new ArrayList<>();
        resources.put(Section.SCIENCE, new ArrayList<>());
        resources.put(Section.ARTS, new ArrayList<>());
        resources.put(Section.COMMERCE, new ArrayList<>());
    }

    public Member addMember(PersonalDetails details) {
        MemberCard card = new MemberCard(members.size()+1, details);
        memberCards.add(card);
        Member member = new Admin(booksList, members, memberCards, card);
        members.add(member);
        return member;
    }

    public void addBooks(List<Book> books) {
        for(Book book: books) {
            book.setbId(booksList.size()+1);
            booksList.add(book);
            resources.get(book.getSection()).add(book);
            totalBooks+=book.getQuantity();
        }
    }

}
