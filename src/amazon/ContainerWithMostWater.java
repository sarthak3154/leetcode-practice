package amazon;

public class ContainerWithMostWater {
    /**
     * 1st Solution - Complexity O(n^2)
     *
     * @param height
     * @return
     */
    public int maxAreaSolutionOne(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 2nd Solution
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);

            if (height[i] <= height[j]) {
                int leftHeight = height[i];
                while (i < j && height[i] <= leftHeight) {
                    i++;
                }
            } else {
                int rightHeight = height[j];
                while (i < j && height[j] <= rightHeight) {
                    j--;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int maxArea = new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(maxArea);
    }
}
