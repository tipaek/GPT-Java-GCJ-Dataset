import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] testCases = new String[T + 1];
        String[] answers = new String[T + 1];
        for (int i = 1; i <= T; i++) {
            testCases[i] = br.readLine();
        }

        for (int i = 1; i <= T; i++) {
            String curr_case = testCases[i];
            if (Integer.parseInt(curr_case) == 0) {
                answers[i] = curr_case;
                continue;
            }
            StringBuilder str = new StringBuilder("");
            int j = 0;
            while (j < curr_case.length()) {
                if (curr_case.charAt(j) == '0') {
                    str.append('0');
                    j++;
                } else {
                    int count = 1;
                    str.append('(');
                    //count 1s
                    while (j < curr_case.length() - 1 && curr_case.charAt(j) == curr_case.charAt(j + 1)) {
                        count++;
                        j++;


                    }

                    //add 1s
                    while (count > 0) {
                        str.append('1');
                        count--;
                    }

                    str.append(')');


                    j++;
                }

            }
            answers[i] = str.toString();
        }

        for (int i = 1; i <= T; i++) {
            System.out.println("Case #"+i+": "+answers[i]);
            System.out.flush();
        }
    }
}
