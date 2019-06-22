package amazon.sortnsearch;

public class KthLargestElementInArray {

    private void merge(int[] nums, int start, int mid, int end) {
        int fLen = mid - start + 1;
        int sLen = end - mid;

        int[] fNums = new int[fLen], sNums = new int[sLen];

        for (int i = 0; i < fLen; i++) {
            fNums[i] = nums[start + i];
        }

        for (int i = 0; i < sLen; i++) {
            sNums[i] = nums[mid + 1 + i];
        }

        int j = 0, k = 0, i = start;
        while (j < fLen && k < sLen) {
            // Whichever element is greater, replace with the first available index in original array
            // and increment the indices
            if (fNums[j] < sNums[k]) {
                nums[i++] = sNums[k++];
            } else {
                nums[i++] = fNums[j++];
            }
        }

        while (j < fLen) {
            nums[i++] = fNums[j++];
        }

        while (k < sLen) {
            nums[i++] = sNums[k++];
        }
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    public static void main(String[] args) {
        int kLargest = new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kLargest);
    }
}
