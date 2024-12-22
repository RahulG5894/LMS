package lms.model;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {

    private List<MemberCard> memberCards;
    private List<Member> members;

    public MemberManager(List<MemberCard> memberCards, List<Member> members) {
        this.memberCards = memberCards;
        this.members = members;
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

    public Admin addAdmin(PersonalDetails details) {
        MemberCard card = new MemberCard(memberCards.size()+1, details);
        memberCards.add(card);
        Admin admin = new Admin(card);
        members.add(admin);
        return admin;
    }

    public User addUser(PersonalDetails details) {
        MemberCard card = new MemberCard(memberCards.size()+1, details);
        memberCards.add(card);
        User user = new User(card);
        members.add(user);
        return user;
    }

    public List<String> enableMember(List<Long> memberId, boolean enable) {
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
