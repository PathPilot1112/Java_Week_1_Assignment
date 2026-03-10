import java.util.*;

public class Website_analytics {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String, Integer> trafficSources = new HashMap<>();

    void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source,
                trafficSources.getOrDefault(source, 0) + 1);
    }

    public static void main(String[] args) {

        Website_analytics analytics = new Website_analytics();

        analytics.processEvent("/news", "user1", "google");
        analytics.processEvent("/news", "user2", "facebook");
        analytics.processEvent("/sports", "user3", "direct");

        System.out.println(analytics.pageViews);
    }
}