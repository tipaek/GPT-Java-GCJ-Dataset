import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        in.nextLine();

        for (int k = 1; k <= testCases; k++) {
            String name = in.nextLine();
            StringBuilder ans = new StringBuilder();
            int currentLevel = 0;

            for (int i = 0; i < name.length(); i++) {
                int num = Character.getNumericValue(name.charAt(i));

                while (currentLevel < num) {
                    ans.append('(');
                    currentLevel++;
                }

                while (currentLevel > num) {
                    ans.append(')');
                    currentLevel--;
                }

                ans.append(num);
            }

            while (currentLevel > 0) {
                ans.append(')');
                currentLevel--;
            }

            System.out.println("Case #" + k + ": " + ans.toString());
        }

        in.close();
    }
}