import java.util.*;

public class DNS_Cache {

    static class Entry {
        String ip;
        long expiry;

        Entry(String ip, long ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl;
        }
    }

    HashMap<String, Entry> cache = new HashMap<>();

    String resolve(String domain) {

        if (cache.containsKey(domain)) {
            Entry e = cache.get(domain);

            if (System.currentTimeMillis() < e.expiry)
                return e.ip;

            cache.remove(domain);
        }

        String ip = queryDNS(domain);
        cache.put(domain, new Entry(ip, 300000));

        return ip;
    }

    String queryDNS(String domain) {
        return "172.217.14.206";
    }

    public static void main(String[] args) {

        DNS_Cache dns = new DNS_Cache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}