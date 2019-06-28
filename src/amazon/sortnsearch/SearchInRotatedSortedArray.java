package amazon.sortnsearch;

public class SearchInRotatedSortedArray {
    private int searchElement(int[] nums, int target, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    return searchElement(nums, target, l, mid - 1);
                }
                return searchElement(nums, target, mid + 1, h);
            } else if (target >= nums[l] || target < nums[mid]) {
                return searchElement(nums, target, l, mid - 1);
            }
            return searchElement(nums, target, mid + 1, h);
        } else if (l == h && nums[h] == target) {
            return l;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return searchElement(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int searchElementIndex = new SearchInRotatedSortedArray().search(new int[]{5,1,2,3,4}, 1);
        System.out.println(searchElementIndex);
    }
}
