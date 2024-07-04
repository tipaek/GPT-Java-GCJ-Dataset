import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int foo = -5;
        int bar = 5;
        System.out.println(foo + " " + bar);
        String[] initial = br.readLine().split(" ");
        int testCases = Integer.parseInt(initial[0]);
        int A = Integer.parseInt(initial[1]);
        int B = Integer.parseInt(initial[2]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            int leftMax = -1000000000;
            int upMax = 1000000000;
            int rightMax = 1000000000;
            int downMax = -1000000000;

            boolean left = false;
            boolean up = false;
            boolean right = false;
            boolean down = false;

            String result = "";
            while (!result.equals("CENTER")) {
                for (int i = 0; i < 50; i++) {
                    if (!left) {
                        System.out.println(leftMax + i + " " + 0);
                        String leftResult = br.readLine();
                        if (leftResult.equals("HIT")) {
                            leftMax = leftMax + i;
                            left = true;
                        }
                    }

                    if (!up) {
                        System.out.println(upMax - i + " " + 0);
                        String upResult = br.readLine();
                        if (upResult.equals("HIT")) {
                            upMax = upMax - i;
                            up = true;
                        }
                    }

                    if (!right) {
                        System.out.println(rightMax - i + " " + 0);
                        String rightResult = br.readLine();
                        if (rightResult.equals("HIT")) {
                            rightMax = rightMax - i;
                            right = true;
                        }
                    }

                    if (!down) {
                        System.out.println(downMax + i + " " + 0);
                        String downResult = br.readLine();
                        if (downResult.equals("HIT")) {
                            downMax = downMax + i;
                            down = true;
                        }
                    }
                    if (left && right && up && down) {
                        int X = (leftMax + rightMax)/2;
                        int Y = (upMax + downMax)/2;
                        System.out.println(X + " " + Y);
                        result = br.readLine();
                    }
                }
                
            }
        }
    }

}