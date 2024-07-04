import java.util.*;

public class Solution {

    public static int n;
    public static int[][] info;

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int nC = stdin.nextInt();
        n = stdin.nextInt();

        for (int loop = 0; loop < nC; loop++) {

            info = new int[15][n];
            for (int i = 0; i < 15; i++) {
                Arrays.fill(info[i], -1);
            }

            for (int rnd = 0; rnd < n / 10; rnd++) {

                for (int i = 0; i < 5; i++) {
                    System.out.println(5 * rnd + i + 1);
                    System.out.flush();
                    info[rnd][5 * rnd + i] = stdin.nextInt();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(n - (5 * rnd + i));
                    System.out.flush();
                    info[rnd][n - (5 * rnd + i) - 1] = stdin.nextInt();
                }
            }

            if (n <= 20) {
                int[] result = new int[n];

                for (int rnd = 0; rnd < n / 10; rnd++) {

                    ArrayList<Integer> sample = getSample(5 * rnd, rnd);
                    int[] ans = new int[sample.size()];
                    for (int i = 0; i < ans.length; i++) {
                        System.out.println(sample.get(i) + 1);
                        System.out.flush();
                        ans[i] = stdin.nextInt();
                    }

                    int xor = (ans[0] == info[rnd][sample.get(0)]) ? 0 : 1;
                    int flip = 0;

                    if (sample.size() > 1) {
                        flip = (ans[1] == info[rnd][sample.get(1)]) ? 0 : 1;
                        flip ^= xor;
                    }

                    for (int i = 5 * rnd; i < 5 * rnd + 5; i++) {
                        int loc = (flip == 0) ? i : n - 1 - i;
                        result[loc] = xor ^ info[rnd][i];
                    }
                    for (int i = n - (5 * rnd + 5); i < n - (5 * rnd); i++) {
                        int loc = (flip == 0) ? i : n - 1 - i;
                        result[loc] = xor ^ info[rnd][i];
                    }
                }

                for (int i = 0; i < n; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
                System.out.flush();
                String response = stdin.next();
                if (response.equals("N")) break;
            } else {
                for (int i = 0; i < 100; i++) {
                    System.out.print(0);
                }
                System.out.println();
                System.out.flush();
                String response = stdin.next();
                if (response.equals("N")) break;
            }
        }
    }

    public static ArrayList<Integer> getSample(int start, int rnd) {

        ArrayList<Integer> sample = new ArrayList<>();
        sample.add(start);
        boolean state = (info[rnd][start] == info[rnd][n - 1 - start]);

        for (int i = start + 1; i < start + 5; i++) {
            boolean currentState = (info[rnd][i] == info[rnd][n - 1 - i]);
            if (currentState != state) {
                sample.add(i);
                break;
            }
        }

        if (!state && sample.size() == 2) {
            Collections.swap(sample, 0, 1);
        }

        return sample;
    }
}