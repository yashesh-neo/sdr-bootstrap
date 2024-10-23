package sa.bupa.sadirbootstrap.iam.domain.enums;

public enum DefaultRole {
    ADMIN("ROLE_ADMIN"), CUSTOMER("ROLE_CUSTOMER");
    private final String role;
    DefaultRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return role;
    }
}
