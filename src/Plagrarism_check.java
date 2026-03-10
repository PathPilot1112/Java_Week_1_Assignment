import java.util.*;

public class Plagrarism_check {

    HashMap<String, Set<Integer>> ngramMap = new HashMap<>();

    void addDocument(int id, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i+1] + " " + words[i+2];

            ngramMap.putIfAbsent(ngram, new HashSet<>());
            ngramMap.get(ngram).add(id);
        }
    }

    int checkSimilarity(String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i+1] + " " + words[i+2];

            if (ngramMap.containsKey(ngram))
                matches++;
        }

        return matches;
    }

    public static void main(String[] args) {

        Plagrarism_check detector = new Plagrarism_check();

        detector.addDocument(1, "I love machine learning and AI");

        int similarity = detector.checkSimilarity(
                "machine learning and AI are powerful");

        System.out.println("Matching ngrams: " + similarity);
    }
}