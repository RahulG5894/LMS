package lms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookInventoryManager {

    private List<Book> booksList;
    private List<Member> members;
    private List<MemberCard> memberCards;
    private Map<Section, List<Book>> resources;

    public BookInventoryManager(List<Book> booksList, List<Member> members, List<MemberCard> memberCards, Map<Section, List<Book>> resources) {
        this.booksList = booksList;
        this.members = members;
        this.memberCards = memberCards;
        this.resources = resources;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<MemberCard> getMemberCards() {
        return memberCards;
    }

    public void setMemberCards(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }

    public Map<Section, List<Book>> getResources() {
        return resources;
    }

    public void setResources(Map<Section, List<Book>> resources) {
        this.resources = resources;
    }

    public void addBooks(List<Book> books) {
        for(Book book: books) {
            book.setbId(booksList.size()+1);
            booksList.add(book);
            Section section = book.getSection();
            if(!resources.containsKey(section)) {
                addSection(List.of(section));
            }
            resources.get(section).add(book);
        }
    }

    public void addSection(List<Section> sections) {
        for(Section section: sections) {
            resources.put(section, new ArrayList<Book>());
        }
    }

    public String borrowBooks(int cardId, List<Integer> books) {
        MemberCard memCard = null;
        for(MemberCard card: memberCards) {
            if(card.getMemberId() == cardId) {
                memCard = card;
                if(!card.isEnabled()) {
                    return "card is disabled!";
                }
                if(card.getBorrowedBooks().size() >= 5) {
                    return "More than 5 books cannot be granted!";
                } else {
                    for(Integer bookId: books) {
                        for(Book book: booksList) {
                            if(book.getbId() == bookId) {
                                card.addBooks(bookId);
                                System.out.println("Added book "+bookId);
                            }
                        }
                    }
                }
            }
        }
        if(memCard == null) {
            return "No user found with provided cardId";
        }
        return "total books assigned " + memCard.getBorrowedBooks().size();
    }

    public String returnBooks(int cardId, List<Integer> books) {
        MemberCard memCard = null;
        for(MemberCard card: memberCards) {
            if(card.getMemberId() == cardId) {
                memCard = card;
                if(!card.isEnabled()) {
                    return "card is disabled!";
                }
                for(Integer bookId: books) {
                    List<Integer> borrowedBooks = card.getBorrowedBooks();
                    if(borrowedBooks.contains(bookId)) {
                        borrowedBooks.remove(bookId);
                    } else {
                        System.out.println("BookId "+bookId+ " not found for this card!");
                    }
                }
            }
        }
        if(memCard == null) {
            return "No user found with provided cardId";
        }
        return "total books assigned " + memCard.getBorrowedBooks().size();
    }

}
