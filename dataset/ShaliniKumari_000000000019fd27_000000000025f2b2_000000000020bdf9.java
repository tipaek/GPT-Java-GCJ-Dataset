import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int testCase = 1;
        while (t > 0) {
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }
            String str = "";
            int[] C = new int[24 * 60 ];
            int[] J = new int[24 * 60 ];
            boolean flagC = false;
            boolean flagJ = false;
            for (int i = 0; i < n; i++) {
                int begin = start[i];
                int stop = end[i];
                if (C[begin] == 0 && C[stop-1] == 0 && C[(begin + stop) / 2] == 0) {
                    flagC = true;
                }else{
                    flagC = false;
                }
                if (J[begin] == 0 && J[stop-1] == 0 && J[(begin + stop) / 2] == 0) {
                    flagJ = true;
                }else{
                    flagJ = false;
                }

                int[] backUpC = Arrays.copyOf(C, C.length);
                int[] backUpJ = Arrays.copyOf(J, J.length);

                for (int j = begin; j < stop; j++) {

                    if (flagC) {
                        if (C[j] == 1) {
                            flagC = false;
                            C = backUpC;
                            j = begin;
                            continue;
                        }
                        C[j] = 1;
                    } else if (flagJ) {
                        if (J[j] == 1) {
                            flagJ = false;
                            J = backUpJ;
                            j = begin;
                            continue;
                        }
                        J[j] = 1;

                    } else {
                        break;
                    }
                }
                if (flagC) {
                    str += "C";
                } else if (flagJ) {
                    str += "J";
                } else {
                    str = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + testCase
                    + ": " + str);
            testCase++;
            t--;
        }

    }
}
