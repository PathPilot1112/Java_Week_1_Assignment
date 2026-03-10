import java.util.*;

public class Username_checker {

    HashMap<String, Integer> usernameMap = new HashMap<>();
    HashMap<String, Integer> attemptFrequency = new HashMap<>();

    boolean checkAvailability(String username) {
        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);
        return !usernameMap.containsKey(username);
    }

    void registerUser(String username, int userId) {
        usernameMap.put(username, userId);
    }

    List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String newName = username + i;
            if (!usernameMap.containsKey(newName))
                suggestions.add(newName);
        }

        return suggestions;
    }

    public static void main(String[] args) {

        Username_checker system = new Username_checker();

        system.registerUser("john_doe", 101);

        System.out.println("Available: " + system.checkAvailability("john_doe"));
        System.out.println("Available: " + system.checkAvailability("jane_smith"));

        System.out.println("Suggestions: " +
                system.suggestAlternatives("john_doe"));
    }
}