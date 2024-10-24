package sa.bupa.sadirbootstrap.security.service;

public interface OTPService {
    String generateOTP(String principal);
    boolean validateOTP(String principal, String otp);
}
