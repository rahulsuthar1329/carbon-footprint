class EmailDetails {
    private int spamEmailCount;
    private int sentEmailCount;
    private int shortEmailOnPhoneCount;
    private int shortEmailOnLaptopCount;
    private int longEmailOnLaptopCount;
    private int emailBlastCount;

    public void setSpamEmailCount(int totalMails) {
        this.spamEmailCount = totalMails;
    }

    public void setSentEmailCount(int totalMails) {
        this.sentEmailCount = totalMails;
    }

    public void setPhoneShortEmailCount(int totalMails) {
        this.shortEmailOnPhoneCount = totalMails;
    }

    public void setLaptopShortEmailCount(int totalMails) {
        this.shortEmailOnLaptopCount = totalMails;
    }

    public void setLaptopLongEmailCount(int totalMails) {
        this.longEmailOnLaptopCount = totalMails;
    }

    public void setEmailBlastCount(int totalMails) {
        this.emailBlastCount = totalMails;
    }

    public int getSpamEmailCount() {
        return spamEmailCount;
    }

    public int getSentEmailCount() {
        return sentEmailCount;
    }

    public int getShortEmailOnPhoneCount() {
        return shortEmailOnPhoneCount;
    }

    public int getShortEmailOnLaptopCount() {
        return shortEmailOnLaptopCount;
    }

    public int getLongEmailOnLaptopCount() {
        return longEmailOnLaptopCount;
    }

    public int getEmailBlastCount() {
        return emailBlastCount;
    }
}