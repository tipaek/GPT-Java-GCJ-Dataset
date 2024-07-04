import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String line = in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String result = "";
            int lastVal = 0;
            line = in.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                int newVal = Integer.parseInt(String.valueOf(c));
                for (int k = 0; k < Math.abs(newVal - lastVal); k++) {
                    result += (newVal > lastVal) ? "(" : ")";
                }
                lastVal = newVal;
                result += c;
            }

            for (int k = 0; k < lastVal; k++) {
                result += ")";
            }

            System.out.println("case #" + i + ": " + result);
        }
    }
}
