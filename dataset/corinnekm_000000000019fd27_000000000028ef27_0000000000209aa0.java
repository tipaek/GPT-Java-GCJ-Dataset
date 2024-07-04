import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());


        for (int t = 0; t < T; t++) {
            String input = sc.nextLine();
            int N = Integer.parseInt(input.split(" ")[0]);
            int K = Integer.parseInt(input.split(" ")[1]);
            boolean impossible = false;

            String[] lines = new String[N];

            if (K < N || K > N * N || K % N > 0) {
                impossible = true;
            }
            if (N == 2) {
                if (K == 3) {
                    impossible = true;
                } else {
                    if (K == 2) {
                        lines[0] = "1 2";
                        lines[1] = "2 1";
                    }
                    if (K == 4) {
                        lines[0] = "2 1";
                        lines[1] = "1 2";
                    }
                }
            }
            if (N == 3) {
                {
                    if (K == 3) {
                        lines[0] = "1 2 3";
                        lines[1] = "3 1 2";
                        lines[2] = "2 3 1";
                    }
                    if (K == 6) {
                        lines[0] = "2 3 1";
                        lines[1] = "1 2 3";
                        lines[2] = "3 1 2";
                    }
                    if (K == 9) {
                        lines[0] = "3 1 2";
                        lines[1] = "2 3 1";
                        lines[2] = "1 2 3";
                    }
                }
            }
            if (N == 4) {
                {
                    if (K == 4) {
                        lines[0] = "1 2 3 4";
                        lines[1] = "4 1 2 3";
                        lines[2] = "3 4 1 2";
                        lines[3] = "2 3 4 1";
                    }
                    if (K == 8) {
                        lines[0] = "2 3 4 1";
                        lines[1] = "1 2 3 4";
                        lines[2] = "4 1 2 3";
                        lines[3] = "1 4 1 2";
                    }
                    if (K == 12) {
                        lines[0] = "3 4 1 2";
                        lines[1] = "2 3 4 1";
                        lines[2] = "1 2 3 4";
                        lines[3] = "4 1 2 3";
                    }
                    if (K == 16) {
                        lines[0] = "4 3 2 1";
                        lines[1] = "1 4 3 2";
                        lines[2] = "2 1 4 3";
                        lines[3] = "3 2 1 4";
                    }
                }
            }
            if (N == 5) {
                {
                    if (K == 5) {
                        lines[0] = "1 2 3 4 5";
                        lines[1] = "5 1 2 3 4";
                        lines[2] = "4 5 1 2 3";
                        lines[3] = "3 4 5 1 2";
                        lines[4] = "2 3 4 5 1";
                    }
                    if (K == 10) {
                        lines[0] = "2 3 4 5 1";
                        lines[1] = "1 2 3 4 5";
                        lines[2] = "5 1 2 3 4";
                        lines[3] = "4 5 1 2 3";
                        lines[4] = "3 4 5 1 2";
                    }
                    if (K == 15) {
                        lines[0] = "3 4 5 1 2";
                        lines[1] = "2 3 4 5 1";
                        lines[2] = "1 2 3 4 5";
                        lines[3] = "5 1 2 3 4";
                        lines[4] = "4 5 1 2 3";
                    }
                    if (K == 20) {
                        lines[0] = "4 5 1 2 3";
                        lines[1] = "3 4 5 1 2";
                        lines[2] = "2 3 4 5 1";
                        lines[3] = "1 2 3 4 5";
                        lines[4] = "5 1 2 3 4";
                    }
                    if (K == 25) {
                        lines[0] = "5 1 2 3 4";
                        lines[1] = "4 5 1 2 3";
                        lines[2] = "3 4 5 1 2";
                        lines[3] = "2 3 4 5 1";
                        lines[4] = "1 2 3 4 5";
                    }
                }
            }
            if(impossible) {
                System.out.println("Case #" + (t+1) + ": " + "IMPOSSIBLE");
            } else{
                System.out.println("Case #" + (t+1) + ": " + "POSSIBLE");
                for (int i = 0; i < N; i++) {
                    System.out.println(lines[i]);
                }
            }
        }
    }
}
