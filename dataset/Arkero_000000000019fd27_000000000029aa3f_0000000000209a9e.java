import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = in.nextInt();
        int bitSize = in.nextInt();

        for (int test = 1; test <= T; ++test) {
            if (bitSize == 10) {
                makeNQueries(30);
                System.out.println(getTrueValues(1));
                String verdict = in.nextLine();
                if ("N".equals(verdict.trim())) {
                    break;
                }
            }

            if (bitSize == 20) {
                makeNQueries(30);
                String firstValues =  getTrueValues(1);
                makeNQueries(30);
                String secondValues =  getTrueValues(11);
                System.out.println(firstValues + secondValues);
                String verdict = in.nextLine();
                if ("N".equals(verdict.trim())) {
                    break;
                }
            }
        }
    }

    static void makeNQueries(int N) {
        for (int i=0; i< N; i++) {
            System.out.println(1);
            in.nextInt();

        }
    }

    static String getTrueValues(int iniIndex) {
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<= 10; i++) {
            System.out.println(iniIndex);
            builder.append(in.nextInt());
            iniIndex++;
        }
        return builder.toString();
    }

}
