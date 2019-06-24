package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {

    private static Comparator<String> WordComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String[] splitO1 = o1.split("[\\s]");
            String[] splitO2 = o2.split("[\\s]");
            StringBuilder orderingO1 = new StringBuilder();
            StringBuilder orderingO2 = new StringBuilder();
            for (int i = 1; i < splitO1.length; i++) {
                orderingO1.append(splitO1[i]).append(i != splitO1.length - 1 ? " " : "");
            }

            for (int i = 1; i < splitO2.length; i++) {
                orderingO2.append(splitO2[i]).append(i != splitO2.length - 1 ? " " : "");
            }
            String c1 = orderingO1.toString();
            String c2 = orderingO2.toString();
            return c1.compareTo(c2) != 0 ? c1.compareTo(c2) : splitO1[0].compareTo(splitO2[0]);
        }
    };

    public String[] reorderLogFiles(String[] logs) {
        List<String> wordLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            String[] words = log.split("[\\s]");
            if (words[1].matches("[0-9]+")) {
                digitLogs.add(log);
            } else {
                wordLogs.add(log);
            }
        }

        wordLogs.sort(WordComparator);
        wordLogs.addAll(digitLogs);
        return wordLogs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] arrangedLogs = new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"});
        System.out.println(Arrays.asList(arrangedLogs).toString());
    }
}
