import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        String[] output = new String[tc];

        for (int i = 0; i < tc; i++) {
            String input = sc.nextLine();
            StringBuilder tempOut = new StringBuilder();
            int[] resInt = input.chars().map(c -> c - '0').toArray();
            
            int currentDepth = 0;
            for (int num : resInt) {
                while (currentDepth < num) {
                    tempOut.append("(");
                    currentDepth++;
                }
                while (currentDepth > num) {
                    tempOut.append(")");
                    currentDepth--;
                }
                tempOut.append(num);
            }
            while (currentDepth > 0) {
                tempOut.append(")");
                currentDepth--;
            }
            output[i] = tempOut.toString();
        }

        for (int h = 0; h < tc; h++) {
            System.out.println("Case #" + (h + 1) + ": " + output[h]);
        }
    }
}