import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= t; test++) {

            int n = sc.nextInt();
            StringBuilder answer = new StringBuilder();
            int []cameron = {0,0};
            int []jamie = {0,0};

            boolean impossible = false;

            while(n-- > 0)
            {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if(cameron[0] >= end || cameron[1] <= start)
                {
                    cameron[0] = start;
                    cameron[1] = end;
                    answer.append('C');
                }
                else if(jamie[0] >= end || jamie[1] <= start)
                {
                    jamie[0] = start;
                    jamie[1] = end;
                    answer.append('J');
                }
                else
                {
                    impossible = true;
                }
            }

            if(impossible)
            {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
            }
            else
            {
                System.out.printf("Case #%d: %s\n", test, answer.toString());
            }
        }
    }
}
