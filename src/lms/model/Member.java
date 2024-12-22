package lms.model;

public class Member {
    private MemberCard memCard;
    private MemberType memberType;
    public Member(MemberCard memCard) {
        this.memCard = memCard;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public MemberCard getMemCard() {
        return memCard;
    }

    public void setMemCard(MemberCard memCard) {
        this.memCard = memCard;
    }
}
