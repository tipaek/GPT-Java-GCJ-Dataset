import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String string = br.readLine();
            int N = string.length();
            int previous = 0;
            for (int j = 0; j < N; j++) {
                int current = Integer.parseInt(string.charAt(j) + "");
                int difference = previous - current;
                if(difference < 0) {
                    for (int k = 0; k < difference * -1; k++) {
                        System.out.print("(");
                    }
                }
                else if(difference > 0) {
                    for (int k = 0; k < difference; k++) {
                        System.out.print(")");
                    }
                }
                System.out.print(current);
                previous = current;
            }
            for (int j = 0; j < previous; j++) {
                System.out.print(")");
            }
            System.out.println();
        }

    }
}
