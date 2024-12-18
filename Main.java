import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String entityType = "email";
        String emailId = "rahulsuthar@gmail.com";

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setSpamEmailCount(2000);
        emailDetails.setSentEmailCount(450);
        emailDetails.setPhoneShortEmailCount(300);
        emailDetails.setLaptopShortEmailCount(240);
        emailDetails.setLaptopLongEmailCount(10);
        emailDetails.setEmailBlastCount(3);

        CarbonEmissionReportGenerator reportGenerator = new CarbonEmissionReportGenerator(emailDetails);
        Map<String, Double> report = reportGenerator.generateReport();

        System.out.println("Email ID: " + emailId);
        System.out.println("Source: " + entityType);
        for (Map.Entry<String, Double> entry : report.entrySet()) {
            System.out.printf("%s: %.2f KG%n", entry.getKey(), entry.getValue());
        }
    }
}