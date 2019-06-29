package amazon.mock;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonDays{
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, String> values = new HashMap<>();
        boolean hasCycle = false;
        for (int i = 0; i < N; i++) {
            cells = nextDay(cells);
            String value = Arrays.toString(cells);
            if (!values.containsValue(value)) {
                values.put(i, value);
            } else {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            N = (N - 1) % values.size();
            String[] strings = values.get(N).substring(1, values.get(N).length() - 1).split(",");
            int[] result = new int[cells.length];
            for (int i = 0; i < strings.length; i++) {
                result[i] = Integer.parseInt(strings[i].trim());
            }

            return result;
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] temp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] prison = new PrisonDays().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
        System.out.println(Arrays.toString(prison));
    }
}
