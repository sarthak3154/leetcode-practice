import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> checkRepeatChars = new HashMap<>();
        StringBuilder tempLongSubstring = new StringBuilder();
        int tempStartIndex = 0, index = 0;
        int longestSubStringLen = 0;
        char[] string = s.toCharArray();

        for (int i = 0; i < string.length; i++) {
            if (!checkRepeatChars.containsKey(string[i]) || checkRepeatChars.get(string[i]) < tempStartIndex) {
                checkRepeatChars.put(string[i], i);
                tempLongSubstring.append(string[i]);

                if (tempLongSubstring.toString().length() > longestSubStringLen) {
                    longestSubStringLen = tempLongSubstring.toString().length();
                }
            } else {
                index = checkRepeatChars.get(string[i]) + 1;
                tempLongSubstring.delete(0, index - tempStartIndex);
                tempLongSubstring.append(string[i]);
                checkRepeatChars.replace(string[i], i);
                tempStartIndex = checkRepeatChars.get(tempLongSubstring.toString().toCharArray()[0]);
            }
        }

        return longestSubStringLen;
    }

    public static void main(String[] args) {
        int value = new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("bbtablud");
        System.out.println(value);
    }
}
