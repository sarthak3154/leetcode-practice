package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[\\s,?!.;']+");
        int maxOccurrence = 0;
        String mostOccurWord = null;
        HashMap<String, Integer> wordsCount = new HashMap<>();
        HashSet<String> bannedWordSet = new HashSet<>(Arrays.asList(banned));
        for (String word : words) {
            if (!bannedWordSet.contains(word)) {
                wordsCount.put(word, !wordsCount.containsKey(word) ? 1 : wordsCount.get(word) + 1);
                if (wordsCount.get(word) > maxOccurrence) {
                    maxOccurrence = wordsCount.get(word);
                    mostOccurWord = word;
                }
            }
        }

        return mostOccurWord;
    }

    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String frequentWord = new MostCommonWord().mostCommonWord(paragraph, new String[]{"a"});
        System.out.println(frequentWord);
    }
}
