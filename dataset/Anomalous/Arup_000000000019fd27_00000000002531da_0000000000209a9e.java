import java.util.*;

public class Solution {

    public static int n;
    public static int[][] info;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        n = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println(1);
            System.out.flush();
            int response = scanner.nextInt();

            info = new int[15][n];
            for (int i = 0; i < 15; i++) {
                Arrays.fill(info[i], -1);
            }

            for (int round = 0; round < n / 10; round++) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(10 * round + i + 1);
                    System.out.flush();
                    info[round][10 * round + i] = scanner.nextInt();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(n - (10 * round + i));
                    System.out.flush();
                    info[round][n - (10 * round + i) - 1] = scanner.nextInt();
                }
            }

            if (n <= 20) {
                int[] result = new int[n];

                for (int round = 0; round < n / 10; round++) {
                    ArrayList<Integer> sample = getSample(5 * round, round);
                    int[] answers = new int[sample.size()];

                    for (int i = 0; i < answers.length; i++) {
                        System.out.println(sample.get(i) + 1);
                        System.out.flush();
                        answers[i] = scanner.nextInt();
                    }

                    int xor = answers[0] == info[0][sample.get(0)] ? 0 : 1;
                    int flip = 0;

                    if (sample.size() > 1) {
                        flip = answers[1] == info[0][sample.get(1)] ? 0 : 1;
                        flip ^= xor;
                    }

                    for (int i = 10 * round; i < 10 * round + 10; i++) {
                        int index = flip == 0 ? i : n - 1 - i;
                        result[index] = xor ^ info[round][i];
                    }
                }

                for (int i : result) {
                    System.out.print(i);
                }
                System.out.println();
                System.out.flush();
                String verdict = scanner.next();
                if (verdict.equals("N")) break;
            } else {
                for (int i = 0; i < 100; i++) {
                    System.out.print(0);
                }
                System.out.println();
                System.out.flush();
                String verdict = scanner.next();
                if (verdict.equals("N")) break;
            }
        }
    }

    public static ArrayList<Integer> getSample(int start, int round) {
        ArrayList<Integer> sample = new ArrayList<>();
        sample.add(start);
        boolean initialState = info[round][start] == info[round][n - 1 - start];

        for (int i = start + 1; i < start + 5; i++) {
            boolean currentState = info[round][i] == info[round][n - 1 - i];
            if (currentState != initialState) {
                sample.add(i);
                break;
            }
        }

        if (!initialState && sample.size() == 2) {
            Collections.swap(sample, 0, 1);
        }

        return sample;
    }
}