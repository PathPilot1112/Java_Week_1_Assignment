import java.util.*;

public class MultiLevelCache {

    HashMap<String,String> L1 = new HashMap<>();
    HashMap<String,String> L2 = new HashMap<>();

    String getVideo(String id) {

        if (L1.containsKey(id))
            return L1.get(id);

        if (L2.containsKey(id)) {

            String data = L2.get(id);
            L1.put(id,data);

            return data;
        }

        String data = fetchFromDB(id);

        L2.put(id,data);

        return data;
    }

    String fetchFromDB(String id) {
        return "VideoData_"+id;
    }

    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache();

        System.out.println(cache.getVideo("video1"));
        System.out.println(cache.getVideo("video1"));
    }
}