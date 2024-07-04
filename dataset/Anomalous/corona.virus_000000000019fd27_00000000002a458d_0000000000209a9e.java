import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String WRONG_ANSWER = "WRONG_ANSWER";
    private static final String CORRECT = "CORRECT";
    private static final String TOO_SMALL = "TOO_SMALL";
    private static final String TOO_BIG = "TOO_BIG";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
        String[] in = br.readLine().split(" ");
        int T = Integer.parseInt(in[0]);
        int B = Integer.parseInt(in[1]);

        while (T-- > 0) {
            boolean ans = solve(input, B);
            if (!ans) break;
        }
    }

    private static boolean solve(Scanner input, int b) {
        int P = 0;
        int n = b;
        int[] B = new int[b];
        Arrays.fill(B, -1);
        int cnt = 1; // first trial

        int[] oneOne = {-1, -1};
        int[] zeroZero = {-1, -1};
        int[] oneZero = {-1, -1};

        boolean sameAlone = false;
        boolean notSameAlone = false;
        boolean mixed = false;

        boolean readEven = true;

        while (true) {
            int x1 = -1;
            int w = -1;

            if (sameAlone) {
                if (oneOne[0] != -1) {
                    x1 = oneOne[0];
                    w = 0;
                }
                if (w == -1) {
                    x1 = zeroZero[0];
                    w = 1;
                }
                System.out.println(x1 + 1); // one index.
                x1 = input.nextInt();
                cnt++; // read one.
                if (w == 0 && B[oneOne[0]] != x1) {
                    if (!readEven) {
                        System.out.println(n - P);
                        int _x = input.nextInt();
                        cnt++;
                        B[n - P - 1] = _x;
                        readEven = true;
                        P++;
                    }
                    complement(B, P - 1);
                } else if (w == 1 && B[zeroZero[0]] != x1) {
                    if (!readEven) {
                        System.out.println(n - P);
                        int _x = input.nextInt();
                        cnt++;
                        B[n - P - 1] = _x;
                        readEven = true;
                        P++;
                    }
                    complement(B, readEven ? P - 1 : P);
                }
                sameAlone = false;

            } else if (notSameAlone) {
                x1 = oneZero[0];
                System.out.println(x1 + 1); // 1-index
                x1 = input.nextInt();
                cnt++;
                if (B[oneZero[0]] != x1) {
                    if (!readEven) {
                        System.out.println(n - P);
                        int _x = input.nextInt();
                        cnt++;
                        B[n - P - 1] = _x;
                        readEven = true;
                        P++;
                    }
                    complement(B, P - 1);
                }
                notSameAlone = false;

            } else if (mixed) {
                if (oneOne[0] != -1) {
                    x1 = oneOne[0];
                    w = 0;
                }
                if (w == -1) {
                    x1 = zeroZero[0];
                    w = 1;
                }
                System.out.println(x1 + 1); // one index.
                x1 = input.nextInt();
                cnt++; // read one.
                if (w == 0 && B[oneOne[0]] != x1) {
                    if (!readEven) {
                        System.out.println(n - P);
                        int _x = input.nextInt();
                        cnt++;
                        B[n - P - 1] = _x;
                        readEven = true;
                        P++;
                    }
                    complement(B, P - 1);
                } else if (w == 1 && B[zeroZero[0]] != x1) {
                    if (!readEven) {
                        System.out.println(n - P);
                        int _x = input.nextInt();
                        cnt++;
                        B[n - P - 1] = _x;
                        readEven = true;
                        P++;
                    }
                    complement(B, P - 1);
                } else {
                    x1 = oneZero[0];
                    System.out.println(x1 + 1);
                    x1 = input.nextInt();
                    cnt++;
                    if (B[oneZero[0]] != x1) {
                        if (!readEven) {
                            System.out.println(n - P);
                            int _x = input.nextInt();
                            cnt++;
                            B[n - P - 1] = _x;
                            readEven = true;
                            P++;
                        }
                        reverse(B, P - 1);
                    }
                }
                mixed = false;
            }

            oneOne = new int[]{-1, -1};
            zeroZero = new int[]{-1, -1};
            oneZero = new int[]{-1, -1};

            int limit = 10 - cnt % 10 + 1;

            while (limit-- > 0) {
                if (readEven) {
                    System.out.println(P + 1);
                } else {
                    System.out.println(n - P);
                }
                int x = input.nextInt();
                cnt++;
                if (2 * P <= n - 1) {
                    if (readEven) {
                        B[P] = x;
                        readEven = false;
                    } else {
                        B[n - P - 1] = x;
                        readEven = true;
                        P++;
                    }
                }
            }

            if (2 * P > n - 1) {
                StringBuilder sb = new StringBuilder();
                for (int t : B) sb.append(t);
                System.out.println(sb.toString());
                if (input.next().equals("Y")) return true;
                return false;
            }

            if (oneOne[0] == -1) {
                oneOne = find(B, P - 1, 1, 1);
            }
            if (zeroZero[0] == -1) {
                zeroZero = find(B, P - 1, 0, 0);
            }
            if (oneZero[0] == -1) {
                oneZero = find(B, P - 1, 1, 0);
            }
            if (oneZero[0] == -1) {
                oneZero = find(B, P - 1, 0, 1);
            }

            if ((oneOne[0] != -1 || zeroZero[0] != -1) && oneZero[0] == -1) {
                sameAlone = true;
            } else if ((oneOne[0] == -1 && zeroZero[0] == -1) && oneZero[0] != -1) {
                notSameAlone = true;
            } else {
                mixed = true;
            }
        }
    }

    private static void reverse(int[] B, int p) {
        int n = B.length;
        for (int i = 0; i <= p; i++) {
            int temp = B[i];
            B[i] = B[n - i - 1];
            B[n - i - 1] = temp;
        }
    }

    private static void complement(int[] B, int p) {
        int n = B.length;
        for (int i = 0; i <= p; i++) {
            B[i] = 1 - B[i];
            if (i != n - i - 1) {
                B[n - i - 1] = 1 - B[n - i - 1];
            }
        }
    }

    private static int[] find(int[] b, int p, int x, int y) {
        int n = b.length;
        for (int i = 0; i <= p; i++) {
            if (b[i] == x && b[n - i - 1] == y) return new int[]{i, n - i - 1};
        }
        return new int[]{-1, -1};
    }
}