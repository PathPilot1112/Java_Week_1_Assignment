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
            String suggestion = username + i;
            if (!usernameMap.containsKey(suggestion))
                suggestions.add(suggestion);
        }

        return suggestions;
    }
}