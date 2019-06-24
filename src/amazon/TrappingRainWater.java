package amazon;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int lMaxHeight = 0, rMaxHeight = 0;
        int l = 0, r = height.length - 1;
        int trappedWater = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lMaxHeight = Math.max(lMaxHeight, height[l]);
                if (height[l] < lMaxHeight) trappedWater += lMaxHeight - height[l];
                l++;
            } else {
                rMaxHeight = Math.max(rMaxHeight, height[r]);
                if (height[r] < rMaxHeight) trappedWater += rMaxHeight - height[r];
                r--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int trappedWater = new TrappingRainWater().trap(new int[]{0, 7, 1, 4, 6});
        System.out.println(trappedWater);
    }
}
