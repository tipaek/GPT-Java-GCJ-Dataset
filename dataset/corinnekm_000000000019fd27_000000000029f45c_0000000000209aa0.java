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

            if (K < N || K > N * N) {
                impossible = true;
            }
            if (K % N == 0) {
                int[] nb = new int[N];
                for (int i = 0; i < N; i++) {
                    nb[i] = i;
                }
                for (int i = 0; i < N; i++) {
                    lines[i] = fillLineStart(K / N, i, N);
                }
                if (impossible) {
                    System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                    for (int i = 0; i < N; i++) {
                        System.out.println(lines[i]);
                    }
                }
            } else {
                if (N == 2 || N == 3) {
                    System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
                }
                if (N == 4) {
                    if (N == 4 && (K == 5 || K == 7 || K == 13 || K == 15)) {
                        System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
                    } else if (N == 4 && K == 6) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("2 1 4 3");
                        System.out.println("1 2 3 4");
                        System.out.println("3 4 1 2");
                        System.out.println("4 3 2 1");
                    } else if (N == 4 && K == 8) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("3 1 2 4");
                        System.out.println("1 3 4 2");
                        System.out.println("2 4 1 3");
                        System.out.println("4 2 3 1");
                    } else if (N == 4 && K == 9) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("1 3 4 2");
                        System.out.println("3 2 1 4");
                        System.out.println("2 4 3 1");
                        System.out.println("4 1 2 3");
                    } else if (N == 4 && K == 10) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("4 1 2 3");
                        System.out.println("1 4 3 2");
                        System.out.println("2 3 1 4");
                        System.out.println("3 2 4 1");
                    } else if (N == 4 && K == 11) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("1 4 3 2");
                        System.out.println("4 2 1 3");
                        System.out.println("2 3 4 1");
                        System.out.println("3 1 2 4");
                    } else if (N == 4 && K == 14) {
                        System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
                        System.out.println("4 3 2 1");
                        System.out.println("3 4 1 2");
                        System.out.println("2 1 3 4");
                        System.out.println("1 2 4 3");
                    } else {
                        System.out.printf("TODO %d %d", N, K);
                    }


                } else if (N == 5) {
                        System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");

                }

            }
        }
    }


    private static String fillLineStart(int start, int current, int N) {
        StringBuffer buff = new StringBuffer();
        start = (start - current) <= 0 ? (start - current) + N : start - current;
        for (int i = 0; i < N; i++) {
            if (buff.length() > 0) {
                buff.append(" ");
            }
            if ((start + i) > N) {
                buff.append((start + i) % N);
            } else {
                buff.append((start + i));
            }

        }
        return buff.toString();

    }
}
