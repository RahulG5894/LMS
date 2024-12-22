package lms.model;

import java.util.List;

public class User implements Member {
    private MemberCard memCard;
    private final MemberType memberType;
    private final List<Book> booksList;
    public User(MemberCard memCard, List<Book> booksList) {
        this.memCard = memCard;
        this.memberType = MemberType.USER;
        this.booksList =  booksList;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public MemberCard getMemCard() {
        return memCard;
    }

    public void setMemCard(MemberCard memCard) {
        this.memCard = memCard;
    }

}
