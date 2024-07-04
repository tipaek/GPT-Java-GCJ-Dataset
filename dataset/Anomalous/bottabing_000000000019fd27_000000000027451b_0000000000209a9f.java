import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCount = in.nextInt();

        for (int test = 1; test <= testCount; test++) {
            String input = in.next();
            StringBuilder sb = new StringBuilder();
            int capacity = 0;

            for (int position = 0; position < input.length(); position++) {
                int currentNum = Character.getNumericValue(input.charAt(position));
                int difference = currentNum - capacity;

                if (difference > 0) {
                    for (int i = 0; i < difference; i++) {
                        sb.append("(");
                    }
                } else if (difference < 0) {
                    for (int i = 0; i < -difference; i++) {
                        sb.append(")");
                    }
                }

                sb.append(currentNum);
                capacity = currentNum;
            }

            for (int i = 0; i < capacity; i++) {
                sb.append(")");
            }

            System.out.println("Case #" + test + ": " + sb.toString());
        }

        in.close();
    }
}