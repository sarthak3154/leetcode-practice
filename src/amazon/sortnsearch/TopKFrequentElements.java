package amazon.sortnsearch;

import java.util.*;

/**
 * Runtime error on the solution on Leetcode
 */
public class TopKFrequentElements {
    private static HashMap<Integer, Integer> numCount = new HashMap<>();

    private static Comparator<Integer> FrequencyComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(numCount.get(o2), numCount.get(o1));
        }
    };

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();

        for (int num : nums) {
            if (numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
            } else {
                numCount.put(num, 1);
                numsList.add(num);
            }
        }

        if (nums.length == 1 || numsList.size() == k) {
            return numsList;
        }

        numsList.sort(FrequencyComparator);
        List<Integer> kFrequentNums = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kFrequentNums.add(numsList.get(i));
        }

        return kFrequentNums;
    }

    public static void main(String[] args) {
        List<Integer> kFrequent = new TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2);
        System.out.println(kFrequent.toString());
    }
}
