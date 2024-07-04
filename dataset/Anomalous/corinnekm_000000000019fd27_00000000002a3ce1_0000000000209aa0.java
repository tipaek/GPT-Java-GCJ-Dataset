import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            if (K < N || K > N * N || (N == 2 || N == 3) && K % N != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                continue;
            }

            if (K % N == 0) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                for (int i = 0; i < N; i++) {
                    System.out.println(generateLine(K / N, i, N));
                }
            } else {
                handleSpecialCases(t, N, K);
            }
        }
    }

    private static String generateLine(int start, int current, int N) {
        StringBuilder builder = new StringBuilder();
        start = (start - current) <= 0 ? (start - current) + N : (start - current);
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                builder.append(" ");
            }
            builder.append((start + i) > N ? (start + i) % N : (start + i));
        }
        return builder.toString();
    }

    private static void handleSpecialCases(int t, int N, int K) {
        System.out.print("Case #" + (t + 1) + ": ");
        switch (N) {
            case 4:
                handleCaseForN4(K);
                break;
            case 5:
                handleCaseForN5(K);
                break;
            default:
                System.out.println("IMPOSSIBLE");
        }
    }

    private static void handleCaseForN4(int K) {
        switch (K) {
            case 4:
                printPossibleSolution(new String[]{
                        "1 2 4 3", "2 1 3 4", "3 4 1 2", "4 3 2 1"});
                break;
            case 5:
                System.out.println("IMPOSSIBLE");
                break;
            case 6:
                printPossibleSolution(new String[]{
                        "2 1 4 3", "1 2 3 4", "3 4 1 2", "4 3 2 1"});
                break;
            case 7:
                printPossibleSolution(new String[]{
                        "1 2 3 4", "3 1 4 2", "4 3 2 1", "2 4 1 3"});
                break;
            case 8:
                printPossibleSolution(new String[]{
                        "3 1 2 4", "1 3 4 2", "2 4 1 3", "4 2 3 1"});
                break;
            case 9:
                printPossibleSolution(new String[]{
                        "1 3 4 2", "3 2 1 4", "2 4 3 1", "4 1 2 3"});
                break;
            case 10:
                printPossibleSolution(new String[]{
                        "4 1 2 3", "1 4 3 2", "2 3 1 4", "3 2 4 1"});
                break;
            case 11:
                printPossibleSolution(new String[]{
                        "1 4 3 2", "4 2 1 3", "2 3 4 1", "3 1 2 4"});
                break;
            case 13:
                printPossibleSolution(new String[]{
                        "2 1 3 4", "3 4 2 1", "1 3 4 2", "4 2 1 3"});
                break;
            case 14:
                printPossibleSolution(new String[]{
                        "4 3 2 1", "3 4 1 2", "2 1 3 4", "1 2 4 3"});
                break;
            case 15:
                System.out.println("IMPOSSIBLE");
                break;
            default:
                System.out.println("IMPOSSIBLE");
        }
    }

    private static void handleCaseForN5(int K) {
        switch (K) {
            case 6:
                System.out.println("IMPOSSIBLE");
                break;
            case 7:
                printPossibleSolution(new String[]{
                        "2 4 3 5 1", "4 1 5 2 3", "3 2 1 4 5", "5 3 2 1 4", "1 5 4 3 2"});
                break;
            case 8:
                printPossibleSolution(new String[]{
                        "3 5 4 2 1", "4 1 2 3 5", "5 2 1 4 3", "2 3 5 1 4", "1 4 3 5 2"});
                break;
            case 9:
                printPossibleSolution(new String[]{
                        "2 5 3 1 4", "1 3 4 5 2", "3 2 1 4 5", "4 1 5 2 3", "5 4 2 3 1"});
                break;
            case 11:
                printPossibleSolution(new String[]{
                        "3 4 2 1 5", "1 3 5 2 4", "2 5 1 4 3", "5 1 4 3 2", "4 2 3 5 1"});
                break;
            case 12:
                printPossibleSolution(new String[]{
                        "1 3 5 4 2", "5 4 2 3 1", "3 2 1 5 4", "2 5 4 1 3", "4 1 3 2 5"});
                break;
            case 13:
                printPossibleSolution(new String[]{
                        "3 5 4 2 1", "2 1 5 4 3", "4 3 2 1 5", "5 4 1 3 2", "1 2 3 5 4"});
                break;
            case 14:
                printPossibleSolution(new String[]{
                        "4 5 1 3 2", "1 2 5 4 3", "3 4 2 1 5", "2 1 3 5 4", "5 3 4 2 1"});
                break;
            case 16:
                printPossibleSolution(new String[]{
                        "3 2 4 5 1", "5 4 1 2 3", "2 5 3 1 4", "1 3 2 4 5", "4 1 5 3 2"});
                break;
            case 17:
                printPossibleSolution(new String[]{
                        "4 5 2 3 1", "5 2 4 1 3", "1 3 5 4 2", "3 4 1 2 5", "2 1 3 5 4"});
                break;
            case 18:
                printPossibleSolution(new String[]{
                        "3 4 5 2 1", "4 5 1 3 2", "2 1 4 5 3", "5 3 2 1 4", "1 2 3 4 5"});
                break;
            case 19:
                printPossibleSolution(new String[]{
                        "5 4 2 3 1", "4 2 5 1 3", "3 1 4 2 5", "1 5 3 4 2", "2 3 1 5 4"});
                break;
            case 21:
                printPossibleSolution(new String[]{
                        "4 5 2 3 1", "2 3 5 1 4", "5 1 4 2 3", "1 4 3 5 2", "3 2 1 4 5"});
                break;
            case 22:
                printPossibleSolution(new String[]{
                        "3 2 4 5 1", "4 5 2 1 3", "2 1 5 3 4", "5 3 1 4 2", "1 4 3 2 5"});
                break;
            case 23:
                printPossibleSolution(new String[]{
                        "4 3 5 1 2", "2 5 3 4 1", "5 1 4 2 3", "3 2 1 5 4", "1 4 2 3 5"});
                break;
            case 24:
                System.out.println("IMPOSSIBLE");
                break;
            default:
                System.out.println("IMPOSSIBLE");
        }
    }

    private static void printPossibleSolution(String[] lines) {
        System.out.println("POSSIBLE");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}