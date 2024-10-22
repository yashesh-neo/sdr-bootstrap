package sa.bupa.sadirbootstrap.iam.api.dto;

public record CreateCustomerRequest(String nationalUnifiedNumber, String email, String phone, String cr) {
}
