package amazon.sortnsearch;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum2SortedInputArray {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> indicesMap = new HashMap<>();
        if (numbers.length > 1) {
            for (int i = 0; i < numbers.length; i++) {
                if (indicesMap.containsKey(target - numbers[i])) {
                    return new int[]{indicesMap.get(target - numbers[i]), i + 1};
                } else {
                    indicesMap.put(numbers[i], i + 1);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = new TwoSum2SortedInputArray().twoSum(new int[]{2, 3}, 9);
        System.out.println(Arrays.toString(indices));
    }
}
