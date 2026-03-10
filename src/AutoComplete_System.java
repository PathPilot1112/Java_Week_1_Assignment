import java.util.*;

public class AutoComplete_System {

    HashMap<String, Integer> queries = new HashMap<>();

    void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix))
                result.add(q);
        }

        result.sort((a,b) -> queries.get(b) - queries.get(a));

        return result;
    }

    public static void main(String[] args) {

        AutoComplete_System system = new AutoComplete_System();

        system.addQuery("java tutorial");
        system.addQuery("javascript");
        system.addQuery("java tutorial");

        System.out.println(system.search("jav"));
    }
}