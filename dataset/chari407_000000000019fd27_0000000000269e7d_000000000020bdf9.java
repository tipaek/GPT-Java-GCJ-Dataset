import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= t; test++) {

            int n = sc.nextInt();
            StringBuilder answer = new StringBuilder();

            boolean[] cameron = new boolean[1441];
            boolean[] jamie = new boolean[1441];
            Arrays.fill(cameron, false);
            Arrays.fill(jamie, false);
            boolean impossible = false;

            while (n-- > 0) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if(checkCalendar(cameron, start, end))
                {
                    blockCalendar(cameron, start, end);
                    answer.append('C');
                }
                else if(checkCalendar(jamie, start, end))
                {
                    blockCalendar(jamie, start, end);
                    answer.append('J');
                }
                else
                {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
            } else {
                System.out.printf("Case #%d: %s\n", test, answer.toString());
            }
        }
    }

    private static void blockCalendar(boolean[] parent, int start, int end) {

        for(int i=start;i<=end;i++)
        {
            parent[i] = true;
        }
    }

    private static boolean checkCalendar(boolean[] parent, int start, int end) {
        boolean isFree = true;

        for(int i=start;i<=end;i++)
        {
            if(i == start && parent[i] == true)
            {
                continue;
            }
            if(parent[i] == true)
            {
                isFree = false;
            }
        }
        return isFree;
    }
}
