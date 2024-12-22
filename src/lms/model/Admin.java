package lms.model;

public class Admin extends Member{
    private BookInventoryManager inventoryManager;
    private MemberManager memberManager;
    public Admin(MemberCard memCard) {
        super(memCard);
        this.setMemberType(MemberType.ADMIN);
    }

    public void setInventoryManager(BookInventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    public BookInventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public MemberManager getMemberManager() {
        return memberManager;
    }
}
