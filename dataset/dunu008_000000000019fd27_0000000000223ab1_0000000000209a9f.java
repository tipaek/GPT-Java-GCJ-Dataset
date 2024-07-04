import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String N = in.nextLine();
            solve(i, N);
        }
    }

    private static void solve(int testCase, String N) {
        StringBuilder sb = new StringBuilder();
        StringBuilder op = new StringBuilder();
        StringBuilder cl = new StringBuilder();

        for (int index = 0; index < N.toCharArray().length; index++) {
            int digit = N.toCharArray()[index] - 48;
            for (int i = 0; i < digit; i++) {
                if (index == 0) {
                    sb.append("(");
                }
                if (index>0){
                    if(N.toCharArray()[index-1] != N.toCharArray()[index]){
                        sb.append("(");
                    }
                }
            }
            sb.append(digit);
            for (int i = 0; i < digit; i++) {
                if (index + 1 < N.toCharArray().length) {
                    if (digit != N.toCharArray()[index + 1] - 48) {
                        sb.append(")");
                    }
                }
                if (index == N.toCharArray().length - 1 && digit != 0) {
                    sb.append(")");
                }
            }
        }

        System.out.print("Case #" + testCase + ": " + sb.toString());

        System.out.println();
    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }

}