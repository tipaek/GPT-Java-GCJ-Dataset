import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        String[] output = new String[tc];

        for (int i = 0; i < tc; i++) {
            String input = sc.nextLine();
            StringBuilder tempout = new StringBuilder();
            int[] resint = input.chars().map(Character::getNumericValue).toArray();

            int currentDepth = 0;
            for (int j = 0; j < resint.length; j++) {
                while (currentDepth < resint[j]) {
                    tempout.append('(');
                    currentDepth++;
                }
                while (currentDepth > resint[j]) {
                    tempout.append(')');
                    currentDepth--;
                }
                tempout.append(resint[j]);
            }

            while (currentDepth > 0) {
                tempout.append(')');
                currentDepth--;
            }

            output[i] = tempout.toString();
        }

        for (int h = 0; h < tc; h++) {
            System.out.println("Case #" + (h + 1) + ": " + output[h]);
        }
    }
}