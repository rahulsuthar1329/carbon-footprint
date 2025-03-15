import java.util.*;

public class CharacterOccurenceFinder {
    public static void main(String[] args) {
        String givenString = "java";

        Map<Character, Integer> characterCounter = new HashMap<>();

        for (int i = 0; i < givenString.length(); i++) {
            characterCounter.put(givenString.charAt(i), characterCounter.getOrDefault(givenString.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterCounter.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
