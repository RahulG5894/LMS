package lms.model;

import java.util.List;

public class User extends Member {

    public User(MemberCard memCard) {
        super(memCard);
        this.setMemberType(MemberType.USER);
    }
}
