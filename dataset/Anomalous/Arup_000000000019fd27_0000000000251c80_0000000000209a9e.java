import java.util.*;

public class Main {

    public static int n;
    public static int[][] info;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();
        n = stdin.nextInt();

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            System.out.println(1);
            System.out.flush();
            int initialResponse = stdin.nextInt();

            info = new int[15][n];
            for (int i = 0; i < 15; i++) {
                Arrays.fill(info[i], -1);
            }

            for (int round = 0; round < n / 10; round++) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(10 * round + i + 1);
                    System.out.flush();
                    info[round][10 * round + i] = stdin.nextInt();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(n - (10 * round + i));
                    System.out.flush();
                    info[round][n - (10 * round + i) - 1] = stdin.nextInt();
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
                        answers[i] = stdin.nextInt();
                    }

                    int xor = answers[0] == info[0][sample.get(0)] ? 0 : 1;
                    int flip = 0;
                    if (sample.size() > 1) {
                        flip = answers[1] == info[0][sample.get(1)] ? 0 : 1;
                    }

                    for (int i = 0; i < 10; i++) {
                        int loc = flip == 0 ? i : n - 1 - i;
                        result[loc] = xor ^ info[round][loc];
                    }
                }

                for (int i = 0; i < n; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
                System.out.flush();
                String response = stdin.next();
                if (response.equals("N")) {
                    break;
                }
            } else {
                for (int i = 0; i < 100; i++) {
                    System.out.print(0);
                }
                System.out.println();
                System.out.flush();
                String response = stdin.next();
                if (response.equals("N")) {
                    break;
                }
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