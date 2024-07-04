import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCases; test++) {
            String s = scanner.nextLine();
            System.out.println("Case #" + test + ": " + shortestAnswer(s));
        }
    }

    private static String shortestAnswer(String s) {
        List<Digit> digits = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            digits.add(new Digit(Integer.parseInt(s.charAt(i) + "")));
        }

        for (int i = 0; i < digits.size(); i++) {
            while (digits.get(i).current != 0) {
                int min = digits.get(i).current;

                int j = i + 1;
                for (; j < digits.size(); j++) {
                    Digit digit = digits.get(j);
                    if (digit.current == 0) {
                        break;
                    } else {
                        min = Math.min(min, digit.current);
                    }
                }

                digits.get(i).openNumber += min;
                digits.get(j - 1).closeNumber += min;
                for (int t = i; t < j; t++) {
                    digits.get(t).current -= min;
                }
            }
        }

        return buildAnswer(digits);
    }

    private static String buildAnswer(List<Digit> allDigits) {
        StringBuilder ans = new StringBuilder();
        for (Digit digit : allDigits) {
            for (int i = 0; i < digit.openNumber; i++) {
                ans.append("(");
            }
            ans.append(digit.initial);
            for (int i = 0; i < digit.closeNumber; i++) {
                ans.append(")");
            }
        }

        return ans.toString();
    }

    static class Digit {
        int initial;
        int current;
        int openNumber;
        int closeNumber;

        public Digit(int initial) {
            this.initial = initial;
            this.current = initial;
        }
    }
}
