package sa.bupa.sadirbootstrap.security.service.impl;

import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.security.service.OTPService;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class OTPServiceImpl implements OTPService {
    @Override
    public String generateOTP(String principal) {
        return generateOTPInternal();
    }

    @Override
    public boolean validateOTP(String principal, String otp) {
        return true;
    }

    private String generateOTPInternal(){
        var random = new Random();
        var otpBuilder = new StringBuilder();
        IntStream.range(0,7)
                .map(value -> random.nextInt(10))
                .forEach(value -> otpBuilder.append(value));
        return otpBuilder.toString();
    }

}
