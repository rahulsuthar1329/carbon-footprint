class TumblrInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String getBlogName() {
        System.out.print("Enter the Tumblr blog name: ");
        return scanner.nextLine();
    }

    public int[] getPostRange() {
        System.out.print("Enter the range (start-end): ");
        String range = scanner.nextLine();
        try {
            String[] parts = range.split("-");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            if (start < 1 || end < start) {
                throw new IllegalArgumentException(
                        "Invalid range. Ensure start is at least 1 and end is greater than or equal to start.");
            }
            return new int[] { start, end };
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input format. Please enter the range in 'start-end' format.");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}