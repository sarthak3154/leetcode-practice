package amazon;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstNonRepeatingCharacterInString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> firstPos = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char item = charArray[i];
            if (!firstPos.containsKey(item)) {
                list.add(item);
                firstPos.put(item, i);
            } else {
                list.remove(Character.valueOf(item));
            }
        }

        return !list.isEmpty() ? firstPos.get(list.get(0)) : -1;
    }

    public static void main(String[] args) {
        int firstUniqChar = new FirstNonRepeatingCharacterInString().firstUniqChar("loveleetcode");
        System.out.println(firstUniqChar);
    }
}
