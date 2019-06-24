package amazon.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /**
     * Incomplete solution - 32/36 test cases passing
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] splitIndices = new int[s.length()];
        Arrays.fill(splitIndices, 0);

/*
        HashSet<String> wordsSet = new HashSet<>();
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            wordsSet.add(word);
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
*/

        int initWordIndex = 0;
        for (int i = 0; i < splitIndices.length; i++) {
            if (wordDict.contains(s.substring(initWordIndex, i + 1))) {
                splitIndices[i] = s.substring(initWordIndex, i + 1).length();
                initWordIndex = i + 1;
            }
        }
        int backtrackIndex = s.length() - 1;
        if (initWordIndex == splitIndices.length) {
            while (splitIndices[backtrackIndex] != 0) {
                backtrackIndex -= splitIndices[backtrackIndex];

                if (backtrackIndex < 0) {
                    break;
                }
            }
        }

        return backtrackIndex < 0;
    }


    public boolean workBreakSolutionTwo(String s, List<String> wordDict) {
        boolean[] wordBreak = new boolean[s.length() + 1];

        wordBreak[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordBreak[j]) {
                    if (wordDict.contains(s.substring(j, i + 1))) {
                        wordBreak[i + 1] = true;
                    }
                }
            }
        }

        return wordBreak[s.length()];
    }

    public static void main(String[] args) {
        boolean wordBreak = new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        System.out.println(wordBreak);
    }
}
