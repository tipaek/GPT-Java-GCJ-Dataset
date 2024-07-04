import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= cases; i++) {
            String next = in.nextLine();
            StringBuilder result = new StringBuilder();
            int previous = Character.getNumericValue(next.charAt(0));
            result.append(generate(previous, 0, 0));

            for (int j = 1; j < next.length(); j++) {
                int current = Character.getNumericValue(next.charAt(j));
                if (previous < current) {
                    String s = generate(current, previous, 0);
                    result = new StringBuilder(join(result.toString(), s, previous, 0));
                    previous = current;
                } else if (previous > current) {
                    String s = generate(current, current, 0);
                    result = new StringBuilder(join(result.toString(), s, current, 0));
                    previous = current;
                } else {
                    String s = generate(current, current, 0);
                    result = new StringBuilder(join(result.toString(), s, current, 0));
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String join(String result, String next, int f, int s) {
        return result.substring(0, result.length() - f) + next.substring(s);
    }

    public static String generate(int num, int l, int r) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num - l; i++) {
            result.append("(");
        }
        result.append(num);
        for (int j = 0; j < num - r; j++) {
            result.append(")");
        }
        return result.toString();
    }
}