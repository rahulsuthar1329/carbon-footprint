import java.util.HashMap;
import java.util.Map;

class CarbonEmissionReportGenerator {
    private final EmailDetails emailDetails;

    public CarbonEmissionReportGenerator(EmailDetails emailDetails) {
        this.emailDetails = emailDetails;
    }

    public Map<String, Double> generateReport() {
        Map<String, Double> report = new HashMap<>();
        double shortEmailOnPhoneWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.PHONE_SHORT_EMAIL, emailDetails.getShortEmailOnPhoneCount());

        double shortEmailOnLaptopWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.LAPTOP_SHORT_EMAIL, emailDetails.getShortEmailOnLaptopCount());

        double longEmailOnLaptopWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.LAPTOP_LONG_EMAIL, emailDetails.getLongEmailOnLaptopCount());

        double emailBlastWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.EMAIL_BLAST, emailDetails.getEmailBlastCount());

        double sentWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.SENT_EMAIL, emailDetails.getSentEmailCount());

        double spamWeightInKg = CarbonEmissionCalculator.calculateEmissionInKG(
                EmailCategory.SPAM_EMAIL, emailDetails.getSpamEmailCount());

        double inboxWeightInKg = shortEmailOnPhoneWeightInKg + shortEmailOnLaptopWeightInKg + longEmailOnLaptopWeightInKg + emailBlastWeightInKg;

        report.put("Inbox", inboxWeightInKg);
        report.put("Sent", sentWeightInKg);
        report.put("Spam", spamWeightInKg);

        return report;
    }
}