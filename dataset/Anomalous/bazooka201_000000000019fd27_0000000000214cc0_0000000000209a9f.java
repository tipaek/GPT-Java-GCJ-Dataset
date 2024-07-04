import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            String input = console.nextLine();
            ArrayList<String> list = new ArrayList<>();
            int n = 0;

            list.add(input.substring(0, 1));
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i - 1) == input.charAt(i)) {
                    list.set(n, list.get(n) + input.charAt(i));
                } else {
                    list.add(String.valueOf(input.charAt(i)));
                    n++;
                }
            }

            System.out.print("Case #" + run + ": ");
            int levelsIn = 0;

            for (String segment : list) {
                int targetLevel = Integer.parseInt(segment.substring(0, 1));
                while (levelsIn != targetLevel) {
                    if (levelsIn > targetLevel) {
                        System.out.print(")");
                        levelsIn--;
                    } else {
                        System.out.print("(");
                        levelsIn++;
                    }
                }
                System.out.print(segment.charAt(0));
            }

            while (levelsIn > 0) {
                System.out.print(")");
                levelsIn--;
            }

            System.out.println();
        }

        console.close();
    }
}