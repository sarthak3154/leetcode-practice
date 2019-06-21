public class MedianTwoSortedArrays {

    private double getEvenFinalArrayMedian(long[] medianElements) {
        return (medianElements[0] + medianElements[1]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long position = 0;
        long[] medianElements = new long[2];
        int itemIndex = 0;
        long finalArrayLength = nums1.length + nums2.length;
        boolean even = (finalArrayLength % 2 == 0);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                medianElements[itemIndex] = nums1[i++];
            } else {
                medianElements[itemIndex] = nums2[j++];
            }

            position++;
            if (itemIndex == 1) {
                return getEvenFinalArrayMedian(medianElements);
            }

            if (even && position == finalArrayLength / 2) {
                itemIndex = 1;
            } else if (position == (finalArrayLength + 1) / 2) {
                return medianElements[0];
            }
        }

        if (itemIndex == 1) {
            medianElements[itemIndex] = i != nums1.length ? nums1[i] : nums2[j];
            return getEvenFinalArrayMedian(medianElements);
        }

        int[] selectedArray = i != nums1.length ? nums1 : nums2;
        int k = (i != nums1.length ? i : j);
        while (k < selectedArray.length) {
            position++;
            medianElements[itemIndex] = selectedArray[k++];

            if (itemIndex == 1) {
                return getEvenFinalArrayMedian(medianElements);
            }

            if (even && position == finalArrayLength / 2) {
                itemIndex = 1;
            } else if (position == (finalArrayLength + 1) / 2) {
                return medianElements[0];
            }
        }

        throw new IllegalArgumentException("Solution not found");
    }

    public static void main(String[] args) {
        double median = new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(median);
    }
}
