import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            List<String> list = new ArrayList<>();
            StringBuilder starts = new StringBuilder();
            StringBuilder middle = new StringBuilder();
            StringBuilder ends = new StringBuilder();
            boolean possible = true;

            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                list.add(sc.next());
            }

            for (int j = 0; j < N; j++) {
                String rule = list.get(j);

                if (rule.charAt(0) != '*') {
                    // Logic for handling starts part
                }

                if (rule.charAt(rule.length() - 1) != '*') {
                    // Logic for handling ends part
                }

                // Logic for handling middle part can be added here
            }

            System.out.println(starts.toString() + middle.toString() + ends.toString());
        }
    }
}