package amazon.demotest;

public class GCD {
    private int gcd(int a, int b) {
        if (b >= a) {
            if (b % a == 0) return a;
            else return gcd(a, b - a);
        } else {
            if (a % b == 0) return b;
            else return gcd(a - b, b);
        }

    }

    public int generalizedGCD(int num, int[] arr) {
        if (num == 1) return arr[0];

        int minGCD = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                minGCD = Math.min(minGCD, gcd(arr[i], arr[j]));
            }
        }

        return minGCD;
    }

    public static void main(String[] args) {
        int gcd = new GCD().generalizedGCD(1, new int[]{3});
        System.out.println(gcd);
    }
}
