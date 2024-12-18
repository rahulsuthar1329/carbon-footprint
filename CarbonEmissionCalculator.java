class CarbonEmissionCalculator {
    private static final double SPAM_EMAIL_EMISSION = 0.03;
    private static final double SENT_EMAIL_EMISSION = 0.05;
    private static final double SHORT_EMAIL_ON_PHONE_EMISSION = 0.2;
    private static final double SHORT_EMAIL_ON_LAPTOP_EMISSION = 0.3;
    private static final double LONG_EMAIL_ON_LAPTOP_EMISSION = 17.0;
    private static final double EMAIL_BLAST_EMISSION = 26.0;

    public static double calculateEmissionInKG(EmailCategory category, int fileSize) {
        double emissionRate;
        switch (category) {
            case SPAM_EMAIL -> emissionRate = SPAM_EMAIL_EMISSION;
            case SENT_EMAIL -> emissionRate = SENT_EMAIL_EMISSION;
            case PHONE_SHORT_EMAIL -> emissionRate = SHORT_EMAIL_ON_PHONE_EMISSION;
            case LAPTOP_SHORT_EMAIL -> emissionRate = SHORT_EMAIL_ON_LAPTOP_EMISSION;
            case LAPTOP_LONG_EMAIL -> emissionRate = LONG_EMAIL_ON_LAPTOP_EMISSION;
            case EMAIL_BLAST -> emissionRate = EMAIL_BLAST_EMISSION;
            default -> emissionRate = 0.0;
        }
        return (emissionRate * fileSize) / 1000;
    }
}