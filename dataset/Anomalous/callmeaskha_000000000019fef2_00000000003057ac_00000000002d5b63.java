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
                        leftMax += i;
                        System.out.println(leftMax + " " + 0);
                        if (br.readLine().equals("HIT")) {
                            left = true;
                        } else {
                            leftMax -= i;
                        }
                    }

                    if (!up) {
                        upMax -= i;
                        System.out.println(upMax + " " + 0);
                        if (br.readLine().equals("HIT")) {
                            up = true;
                        } else {
                            upMax += i;
                        }
                    }

                    if (!right) {
                        rightMax -= i;
                        System.out.println(rightMax + " " + 0);
                        if (br.readLine().equals("HIT")) {
                            right = true;
                        } else {
                            rightMax += i;
                        }
                    }

                    if (!down) {
                        downMax += i;
                        System.out.println(downMax + " " + 0);
                        if (br.readLine().equals("HIT")) {
                            down = true;
                        } else {
                            downMax -= i;
                        }
                    }

                    if (left && right && up && down) {
                        int X = (leftMax + rightMax) / 2;
                        int Y = (upMax + downMax) / 2;
                        System.out.println(X + " " + Y);
                        result = br.readLine();
                        if (result.equals("CENTER")) break;
                    }
                }
            }
        }
    }
}