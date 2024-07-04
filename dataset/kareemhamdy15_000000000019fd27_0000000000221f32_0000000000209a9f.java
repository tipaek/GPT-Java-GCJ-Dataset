import java.util.Scanner;

/**
 * Created by kareem on 3/19/2020.
 */
public class Solution {

//    static int n, row, col;
//    static int[][] arr;

    static String in;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        for (int i = 1; i <= testCases; i++) {
            in = s.next();

            testCase(i);
        }

    }


    static void testCase(int caseNum) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < in.length(); i++) {
            int currNum = in.charAt(i) - '0';
            for (int j = 0; j < currNum; j++) {
                sb.append('(');
            }
            sb.append(currNum);
            while (i < in.length() - 1 && in.charAt(i) == in.charAt(i + 1)) {
                sb.append(in.charAt(i + 1));
                i++;
            }
//            if (currNum != 0)
//                sb.append(')');

            int rem = currNum;
            while (i < in.length() - 1) {
                currNum = in.charAt(i) - '0';
                int next = in.charAt(i + 1) - '0';

                if (next == 0) {
                    for (int j = 0; j < rem; j++) {
                        sb.append(')');
                    }
                    sb.append(next);
                    rem = next;
                    i++;
                } else if (currNum > next) {
                    int irem = rem - next;
                    for (int j = 0; j < irem; j++) {
                        sb.append(')');
                    }

                    sb.append(next);
                    i++;
                    rem = rem - irem;
                } else if (currNum == next) {
                    sb.append(next);
                    i++;

                } else {

                    for (int j = 0; j < next - currNum; j++) {
                        sb.append('(');
                    }
                    sb.append(next);

                    rem = next ;
                    i++;
                }

            }

            for (int j = 0; j < rem; j++) {
                sb.append(')');
            }


        }
        System.out.println("Case #" + caseNum + ": " + sb.toString());
    }

}
