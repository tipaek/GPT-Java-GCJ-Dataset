import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initial = br.readLine().split(" ");
        int testCases = Integer.parseInt(initial[0]);
        int A = Integer.parseInt(initial[1]);
        int B = Integer.parseInt(initial[2]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            outerloop:
            for (int i = -5; i < 5; i ++) {
                for (int j = -5; j < 5; j ++) {
                    System.out.println(i + " " + j);
                    String str = br.readLine();
                    if (str.equals("CENTER")) {
                        break outerloop;
                    }
                }
            }
        }
    }

}