import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> find = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (find.containsKey(nums[i])) {
                return new int[]{find.get(nums[i]), i};
            }

            find.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] solution = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(solution != null ? Arrays.toString(solution) : "Solution not found");
    }
}
