import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] start = new int[1000];
        int[] end = new int[1000];
        char[] person = new char[1000];

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            boolean fail = false;
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
                char currentChar = 'C';
                char alternateChar = 'J';
                boolean conflict = false;

                for (int k = 0; k < i; k++) {
                    if ((start[i] < end[k] && start[i] >= start[k]) || (end[i] <= end[k] && end[i] > start[k])) {
                        if (!conflict) {
                            conflict = true;
                            currentChar = person[k];
                            alternateChar = (person[k] == 'C') ? 'J' : 'C';
                        } else if (person[k] != currentChar) {
                            fail = true;
                            break;
                        }
                    }
                }

                if (fail) {
                    break;
                }
                ans.append(alternateChar);
                person[i] = alternateChar;
            }

            if (fail) {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (z + 1) + ": " + ans);
            }
        }
        scanner.close();
    }
}