package amazon.dynamicprogramming;

public class LongestPalindromicSubstring {
    private void storeLongestPalindromePosition(int[] longestPalPosition, int x, int y) {
        longestPalPosition[0] = x;
        longestPalPosition[1] = y;
    }

    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return s;
        }

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] longestPalPosition = new int[]{0, 0};
        int longestPalLength = 1;

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                isPalindrome[i][i + 1] = true;
                storeLongestPalindromePosition(longestPalPosition, i, i + 1);
                longestPalLength = 2;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                int k = j + i;
                if (chars[j] == chars[k] && isPalindrome[j + 1][k - 1]) {
                    storeLongestPalindromePosition(longestPalPosition, j, k);
                    isPalindrome[j][k] = true;
                    longestPalLength = Math.max(longestPalLength, k - j + 1);
                }
            }
        }

        return s.substring(longestPalPosition[0], longestPalPosition[1] + 1);
    }

    public static void main(String[] args) {
        String longestPalindrome = new LongestPalindromicSubstring().longestPalindrome("abababa");
        System.out.println(longestPalindrome);
    }
}
