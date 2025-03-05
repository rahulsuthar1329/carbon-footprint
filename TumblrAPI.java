public class TumblrAPI {
    public static void main(String[] args) {
        TumblrInputHandler inputHandler = new TumblrInputHandler();
        TumblrService tumblrService = new TumblrServiceImpl();
        
        try {
            String blogName = inputHandler.getBlogName();
            int[] range = inputHandler.getPostRange();
            tumblrService.fetchTumblrData(blogName, range[0], range[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            inputHandler.closeScanner();
        }
    }
}
