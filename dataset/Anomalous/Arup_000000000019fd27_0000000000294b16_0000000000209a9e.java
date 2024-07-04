import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int n;
    private static int[][] info;

    private static final int[][] QUERIES = {
        {0, 1, 2, 3},
        {0, 4, 5, 6},
        {0, 7, 8, 9}
    };

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
                int[] res = new int[n];

                for (int rnd = 0; rnd < n / 10; rnd++) {
                    ArrayList<Integer> sample = getSample(5 * rnd, rnd);
                    int[] ans = new int[sample.size()];
                    for (int i = 0; i < ans.length; i++) {
                        System.out.println(sample.get(i) + 1);
                        System.out.flush();
                        ans[i] = stdin.nextInt();
                    }

                    int xor = ans[0] == info[rnd][sample.get(0)] ? 0 : 1;
                    int flip = 0;
                    if (sample.size() > 1) {
                        flip = ans[1] == info[rnd][sample.get(1)] ? 0 : 1;
                        flip ^= xor;
                    }

                    for (int i = 5 * rnd; i < 5 * rnd + 5; i++) {
                        int loc = flip == 0 ? i : n - 1 - i;
                        res[loc] = xor ^ info[rnd][i];
                    }
                    for (int i = n - (5 * rnd + 5); i < n - (5 * rnd); i++) {
                        int loc = flip == 0 ? i : n - 1 - i;
                        res[loc] = xor ^ info[rnd][i];
                    }
                }

                for (int i = 0; i < n; i++) {
                    System.out.print(res[i]);
                }
                System.out.println();
                System.out.flush();
                String j = stdin.next();
                if (j.equals("N")) break;
            } else {
                for (int[] query : QUERIES) {
                    int[] flip = new int[query.length];
                    int[] xor = new int[query.length];

                    int ask = 0;
                    for (int j = 0; j < query.length; j++) {
                        int rnd = query[j];
                        ArrayList<Integer> sample = getSample(5 * rnd, rnd);
                        ask += sample.size();
                        int[] ans = new int[sample.size()];
                        for (int z = 0; z < ans.length; z++) {
                            System.out.println(sample.get(z) + 1);
                            System.out.flush();
                            ans[z] = stdin.nextInt();
                        }

                        xor[j] = ans[0] == info[rnd][sample.get(0)] ? 0 : 1;
                        flip[j] = 0;
                        if (sample.size() > 1) {
                            flip[j] = ans[1] == info[rnd][sample.get(1)] ? 0 : 1;
                        }
                    }

                    int askMore = 10 - ask;
                    for (int j = 0; j < askMore; j++) {
                        System.out.println(1);
                        System.out.flush();
                        stdin.nextInt();
                    }

                    for (int j = 1; j < query.length; j++) {
                        flip[j] ^= flip[0];
                        xor[j] ^= xor[0];
                        apply(flip[j], xor[j], query[j]);
                    }
                }

                ArrayList<Integer> sample = getSample(0, 0);
                int[] ans = new int[sample.size()];
                for (int i = 0; i < ans.length; i++) {
                    System.out.println(sample.get(i) + 1);
                    System.out.flush();
                    ans[i] = stdin.nextInt();
                }

                int finalxor = ans[0] == info[0][sample.get(0)] ? 0 : 1;
                int finalflip = 0;
                if (sample.size() > 1) {
                    finalflip = ans[1] == info[0][sample.get(1)] ? 0 : 1;
                    finalflip ^= finalxor;
                }

                int[] fAns = apply(finalflip, finalxor);
                for (int i = 0; i < n; i++) {
                    System.out.print(fAns[i]);
                }
                System.out.println();
                System.out.flush();
                String jAns = stdin.next();
                if (jAns.equals("N")) break;
            }
        }
    }

    private static int[] apply(int flip, int xor) {
        int[] res = new int[n];
        if (flip == 0 && xor == 0) {
            System.arraycopy(info[0], 0, res, 0, n);
        } else if (flip == 0 && xor == 1) {
            for (int i = 0; i < n; i++) {
                res[i] = info[0][i] ^ 1;
            }
        } else if (flip == 1 && xor == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = info[0][n - 1 - i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                res[i] = info[0][n - 1 - i] ^ 1;
            }
        }
        return res;
    }

    private static void apply(int flip, int xor, int idx) {
        int[] bounds = {5 * idx, 5 * idx + 5, n - 5 * idx - 5, n - 5 * idx};

        for (int i = 0; i < 2; i++) {
            for (int j = bounds[2 * i]; j < bounds[2 * i + 1]; j++) {
                if (flip == 1 && xor == 0) {
                    info[0][j] = info[idx][n - 1 - j];
                } else if (flip == 1 && xor == 1) {
                    info[0][j] = info[idx][n - 1 - j] ^ 1;
                } else if (flip == 0 && xor == 1) {
                    info[0][j] = info[idx][j] ^ 1;
                } else {
                    info[0][j] = info[idx][j];
                }
            }
        }
    }

    private static ArrayList<Integer> getSample(int s, int rnd) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(s);
        boolean state = info[rnd][s] == info[rnd][n - 1 - s];

        for (int i = s + 1; i < s + 5; i++) {
            boolean curState = info[rnd][i] == info[rnd][n - 1 - i];
            if (curState != state) {
                res.add(i);
                break;
            }
        }

        if (!state && res.size() == 2) {
            int tmp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, tmp);
        }

        return res;
    }
}