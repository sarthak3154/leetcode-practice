package amazon;

import java.util.Stack;

public class IntegerToEnglish {

    private String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] tensAndOnes = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return ones[0];
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int i = 1;
        int value, lastDigit = -1;
        while (num != 0) {
            value = num % 10;
            if (i == 1) {
                stack.push(ones[value]);
            } else if (i == 2 || i == 5 || i == 8) {
                if (lastDigit == 0 || value == 1) stack.pop();
                if (value == 1) {
                    stack.push(tensAndOnes[lastDigit]);
                } else if (value > 1) {
                    stack.push(tens[value - 2]);
                }
            } else if (i % 3 == 0 && value > 0) {
                stack.push(ones[value] + " Hundred");
            } else if (i == 4 || i == 7 || i == 10) {
                if (i == 4) {
                    stack.push("Thousand");
                } else if (i == 7) {
                    if (stack.peek().equals("Thousand")) {
                        stack.pop();
                    }
                    stack.push("Million");
                } else {
                    if (stack.peek().equals("Million")) {
                        stack.pop();
                    }
                    stack.push("Billion");
                }
                stack.push(ones[value]);
            }
            num = num / 10;
            lastDigit = value;
            i++;
        }

        int size = stack.size();
        for (int j = 0; j < size; j++) {
            result.append(stack.pop()).append(j != size - 1 ? " " : "");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String numberToWords = new IntegerToEnglish().numberToWords(1000002);
        System.out.println(numberToWords);
    }
}
