import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            int numberOfActivities = scanner.nextInt();
            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < numberOfActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    result.append("C");
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    result.append("J");
                } else {
                    isPossible = false;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}