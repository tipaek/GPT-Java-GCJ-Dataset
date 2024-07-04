import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine());
        int caseCounter = 0;

        while (caseCounter++ < testCases) {
            int n = sc.nextInt();


            int[] day = new int[24 * 60 + 1];
            int[] starts = new int[n];
            int[] ends = new int[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                starts[i] = sc.nextInt();
                ends[i] = sc.nextInt();
                if(!impossible) {
                    for (int j = starts[i]; j < ends[i]; j++) {
                        day[j]++;
                        if(day[j] > 2) {
                            impossible = true;
                            break;
                        }
                    }
                }
            }

            String result;
            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                char[] who = new char[n];
                for (int i = 0; i < n; i++) {
                    boolean isC = true;

                    // check for negatives
                    for (int j = starts[i]; j < ends[i]; j++) {
                        if(day[j] < 0) {
                            isC = false;
                            break;
                        }
                    }

                    // if C will do it, set negatives
                    if (isC) {
                        for (int j = starts[i]; j < ends[i]; j++) {
                            day[j] *= -1;
                        }
                    }

                    // construct answer
                    who[i] = isC ? 'C' : 'J';
                }
                result = new String(who);
            }

            System.out.printf("Case #%d: %s\n", caseCounter, result);
        }
    }
}
