import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            boolean impossible = false;
            String[] lines = new String[N];

            if (K < N || K > N * N || K % N > 0) {
                impossible = true;
            } else {
                switch (N) {
                    case 2:
                        if (K == 3) {
                            impossible = true;
                        } else if (K == 2) {
                            lines[0] = "1 2";
                            lines[1] = "2 1";
                        } else if (K == 4) {
                            lines[0] = "2 1";
                            lines[1] = "1 2";
                        }
                        break;
                    case 3:
                        if (K == 3) {
                            lines[0] = "1 2 3";
                            lines[1] = "3 1 2";
                            lines[2] = "2 3 1";
                        } else if (K == 6) {
                            lines[0] = "2 3 1";
                            lines[1] = "1 2 3";
                            lines[2] = "3 1 2";
                        } else if (K == 9) {
                            lines[0] = "3 1 2";
                            lines[1] = "2 3 1";
                            lines[2] = "1 2 3";
                        }
                        break;
                    case 4:
                        if (K == 4) {
                            lines[0] = "1 2 3 4";
                            lines[1] = "4 1 2 3";
                            lines[2] = "3 4 1 2";
                            lines[3] = "2 3 4 1";
                        } else if (K == 8) {
                            lines[0] = "2 3 4 1";
                            lines[1] = "1 2 3 4";
                            lines[2] = "4 1 2 3";
                            lines[3] = "1 4 1 2";
                        } else if (K == 12) {
                            lines[0] = "3 4 1 2";
                            lines[1] = "2 3 4 1";
                            lines[2] = "1 2 3 4";
                            lines[3] = "4 1 2 3";
                        } else if (K == 16) {
                            lines[0] = "4 3 2 1";
                            lines[1] = "1 4 3 2";
                            lines[2] = "2 1 4 3";
                            lines[3] = "3 2 1 4";
                        }
                        break;
                    case 5:
                        if (K == 5) {
                            lines[0] = "1 2 3 4 5";
                            lines[1] = "5 1 2 3 4";
                            lines[2] = "4 5 1 2 3";
                            lines[3] = "3 4 5 1 2";
                            lines[4] = "2 3 4 5 1";
                        } else if (K == 10) {
                            lines[0] = "2 3 4 5 1";
                            lines[1] = "1 2 3 4 5";
                            lines[2] = "5 1 2 3 4";
                            lines[3] = "4 5 1 2 3";
                            lines[4] = "3 4 5 1 2";
                        } else if (K == 15) {
                            lines[0] = "3 4 5 1 2";
                            lines[1] = "2 3 4 5 1";
                            lines[2] = "1 2 3 4 5";
                            lines[3] = "5 1 2 3 4";
                            lines[4] = "4 5 1 2 3";
                        } else if (K == 20) {
                            lines[0] = "4 5 1 2 3";
                            lines[1] = "3 4 5 1 2";
                            lines[2] = "2 3 4 5 1";
                            lines[3] = "1 2 3 4 5";
                            lines[4] = "5 1 2 3 4";
                        } else if (K == 25) {
                            lines[0] = "5 1 2 3 4";
                            lines[1] = "4 5 1 2 3";
                            lines[2] = "3 4 5 1 2";
                            lines[3] = "2 3 4 5 1";
                            lines[4] = "1 2 3 4 5";
                        }
                        break;
                    default:
                        impossible = true;
                        break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        }
    }
}