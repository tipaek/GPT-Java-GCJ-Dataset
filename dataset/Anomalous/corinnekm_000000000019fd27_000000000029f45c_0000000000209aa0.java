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

            if (K < N || K > N * N) {
                impossible = true;
            }

            if (K % N == 0) {
                String[] lines = new String[N];
                for (int i = 0; i < N; i++) {
                    lines[i] = fillLineStart(K / N, i, N);
                }
                printResult(t, impossible, lines);
            } else {
                handleSpecialCases(t, N, K);
            }
        }
    }

    private static void printResult(int t, boolean impossible, String[] lines) {
        if (impossible) {
            System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + (t + 1) + ": POSSIBLE");
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }

    private static void handleSpecialCases(int t, int N, int K) {
        if (N == 2 || N == 3) {
            System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        } else if (N == 4) {
            handle4x4Cases(t, K);
        } else if (N == 5) {
            System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        }
    }

    private static void handle4x4Cases(int t, int K) {
        switch (K) {
            case 5:
            case 7:
            case 13:
            case 15:
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                break;
            case 6:
                print4x4Case(t, new String[]{
                        "2 1 4 3",
                        "1 2 3 4",
                        "3 4 1 2",
                        "4 3 2 1"
                });
                break;
            case 8:
                print4x4Case(t, new String[]{
                        "3 1 2 4",
                        "1 3 4 2",
                        "2 4 1 3",
                        "4 2 3 1"
                });
                break;
            case 9:
                print4x4Case(t, new String[]{
                        "1 3 4 2",
                        "3 2 1 4",
                        "2 4 3 1",
                        "4 1 2 3"
                });
                break;
            case 10:
                print4x4Case(t, new String[]{
                        "4 1 2 3",
                        "1 4 3 2",
                        "2 3 1 4",
                        "3 2 4 1"
                });
                break;
            case 11:
                print4x4Case(t, new String[]{
                        "1 4 3 2",
                        "4 2 1 3",
                        "2 3 4 1",
                        "3 1 2 4"
                });
                break;
            case 14:
                print4x4Case(t, new String[]{
                        "4 3 2 1",
                        "3 4 1 2",
                        "2 1 3 4",
                        "1 2 4 3"
                });
                break;
            default:
                System.out.printf("TODO %d %d%n", 4, K);
                break;
        }
    }

    private static void print4x4Case(int t, String[] lines) {
        System.out.println("Case #" + (t + 1) + ": POSSIBLE");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static String fillLineStart(int start, int current, int N) {
        StringBuilder buff = new StringBuilder();
        start = (start - current) <= 0 ? (start - current) + N : start - current;
        for (int i = 0; i < N; i++) {
            if (buff.length() > 0) {
                buff.append(" ");
            }
            buff.append((start + i) > N ? (start + i) % N : (start + i));
        }
        return buff.toString();
    }
}