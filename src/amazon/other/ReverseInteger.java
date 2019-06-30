package amazon.other;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;

        List<Integer> reversedNum = new ArrayList<>();
        int absNum = (x < 0) ? Math.abs(x) : x;
        if (x < 0 && absNum == x) return 0;

        while (absNum != 0) {
            reversedNum.add(absNum % 10);
            absNum = absNum / 10;
        }

        StringBuilder builder = new StringBuilder();
        boolean init = false;
        for (int i = 0; i < reversedNum.size(); i++) {
            if (reversedNum.get(i) == 0 && !init) {
                continue;
            } else {
                builder.append(reversedNum.get(i));
                init = true;
            }
        }

        String reversedStr = builder.toString();
        int highestCheck = (int) Math.pow(2, 31);
        if (reversedStr.length() >= String.valueOf(highestCheck).length()) {
            int compareResult = reversedStr.compareTo(String.valueOf(x > 0 ? highestCheck - 1 : highestCheck));
            if (compareResult > 0) {
                return 0;
            }
        }
        int reversedValue = Integer.parseInt(reversedStr);
        return (x < 0) ? -reversedValue : reversedValue;
    }

    public static void main(String[] args) {
        int reverseInteger = new ReverseInteger().reverse(-2147483648);
        System.out.println(reverseInteger);
    }
}
