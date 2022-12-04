package pl.sdacademy.unit.test.advance.exercises.task5;

import java.time.LocalDateTime;

public class PasswordResetService {
    private static final String BODY_TEMPLATE = "Twoje tymczasowe hasło wygenerowane dnia REPLACE_DATE o godzinie REPLACE_TIME to REPLACE_NEW_PASSWORD";
    private RandomPasswordProvider passwordProvider;
    private DateTimeProvider dateTimeProvider;

    public PasswordResetService(RandomPasswordProvider passwordProvider, DateTimeProvider dateTimeProvider) {
        this.passwordProvider = passwordProvider;
        this.dateTimeProvider = dateTimeProvider;
    }

    public String generateEmailBody() {
        String newPassword = passwordProvider.generateNewPassword();
        LocalDateTime currentDateTime = dateTimeProvider.currentDateTime();
        return BODY_TEMPLATE
                .replace("REPLACE_DATE", currentDateTime.toLocalDate().toString())
                .replace("REPLACE_TIME", currentDateTime.toLocalTime().toString())
                .replace("REPLACE_NEW_PASSWORD", newPassword);
    }
}
