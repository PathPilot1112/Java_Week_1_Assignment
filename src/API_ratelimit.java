import java.util.*;

public class API_ratelimit {

    static class TokenBucket {
        int tokens;

        TokenBucket(int max) {
            tokens = max;
        }
    }

    HashMap<String, TokenBucket> clients = new HashMap<>();
    int maxTokens = 5;

    boolean allowRequest(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(maxTokens));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        API_ratelimit limiter = new API_ratelimit();

        for (int i = 0; i < 7; i++) {

            boolean allowed = limiter.allowRequest("client1");

            System.out.println("Request " + i + ": " + allowed);
        }
    }
}