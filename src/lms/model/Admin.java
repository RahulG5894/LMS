package lms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Admin implements Member{

    private List<Book> booksList;
    private List<Member> members;
    private List<MemberCard> memberCards;
    private MemberType memberType;
    private MemberCard card;
    private List<Book> borrowedBooks;

    public Admin(List<Book> booksList, List<Member> members, List<MemberCard> memberCards, MemberCard card) {
        this.booksList = booksList;
        this.members = members;
        this.memberCards = memberCards;
        this.memberType = MemberType.USER;
        this.card = card;
    }

    public MemberCard getCard() {
        return card;
    }

    public void setCard(MemberCard card) {
        this.card = card;
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

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public void addMember(MemberType type, PersonalDetails details) {
        MemberCard card = new MemberCard(members.size()+1, details);
        memberCards.add(card);
        Member member = new User(card, booksList);
        members.add(member);
    }

    public String borrowBooks(int cardId, List<Integer> books) {
        MemberCard c = null;
        for(MemberCard card: memberCards) {
            if(card.getMemberId() == cardId) {
                c = card;
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
        if(c == null) {
            return "No user found with provided cardId";
        }
        return "total books assigned " + c.getBorrowedBooks().size();
    }


    public String returnBooks(int cardId, List<Integer> books) {
        MemberCard c = null;
        for(MemberCard card: memberCards) {
            if(card.getMemberId() == cardId) {
                c = card;
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
        if(c == null) {
            return "No user found with provided cardId";
        }
        return "total books assigned " + c.getBorrowedBooks().size();
    }

    public List<String> enableUser(List<Long> memberId, boolean enable) {
        List<String> errors = new ArrayList<>();
        for(Long id: memberId) {
            for(MemberCard mem: memberCards) {
                if(mem.getMemberId() == id) {
                    if(!enable && mem.getBorrowedBooks().size()>0) {
                        errors.add( "Cannot disable card "+ id +" until books are returned.");
                    }
                    mem.setEnabled(enable);
                }
            }
        }
        return errors;
    }
}
