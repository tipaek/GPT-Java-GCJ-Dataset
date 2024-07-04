import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int positionSame = -1;
            int positionFlip = -1;
            BitSet bs = new BitSet();
            int countQueries = 0;

            // assumes B is even (as specified in limits)
            for (int positionRead = 0; positionRead < B / 2; positionRead++) {
                if (countQueries > 0 && countQueries % 10 == 0) {
                    // recognize fluctuation and adjust
//                    System.out.println("recognize fluctuation and adjust");
                    final boolean complemented;
                    final boolean reversed;

                    if (positionSame < 0 || positionFlip < 0) {
                        // all flip or all same. detect whether to complemented
                        int anyPosition = 0;
                        read(anyPosition);
                        countQueries++;
                        complemented = scanner.nextInt() == 1 != bs.get(anyPosition);
                        reversed = false;
                        // read again to alias to even number
                        read(anyPosition);
                        scanner.nextInt();
                    } else {
                        // recognize fluctuation
                        read(positionSame);
                        countQueries++;
                        boolean vSame = scanner.nextInt() == 1;
                        boolean sameSame = vSame == bs.get(positionSame);

                        read(positionFlip);
                        countQueries++;
                        boolean vFlip = scanner.nextInt() == 1;
                        boolean flipSame = vFlip == bs.get(positionFlip);

                        complemented = !sameSame;
                        reversed = sameSame != flipSame;
                    }

                    // apply adjustment
                    if (complemented) {
                        bs.flip(0, B);
                    }

                    if (reversed) {
                        // could have done a soft reversed flag, but it's messy
                        for (int i = 0; i < B / 2; i++) {
                            boolean tmp = bs.get(i);
                            bs.set(i, bs.get(B - i - 1));
                            bs.set(B - i - 1, tmp);
                        }
                    }

//                    System.out.println("complemented = " + complemented);
//                    System.out.println("reversed = " + reversed);
                }

                read(positionRead);
                countQueries++;
                boolean v1 = scanner.nextInt() == 1;
                bs.set(positionRead, v1);
                read(B - positionRead - 1);
                countQueries++;
                boolean v2 = scanner.nextInt() == 1;
                bs.set(B - positionRead - 1, v2);

                // always overwrite, for simplicity
                if (v1 == v2) {
                    positionSame = positionRead;
                } else {
                    positionFlip = positionRead;
                }
            }

            for (int i = 0; i < B; i++) {
                System.out.print(bs.get(i) ? '1' : '0');
            }
            System.out.println();

            String result = scanner.next();
            if (!result.equals("Y")) {
                System.out.println("I failed. Bye!");
                return;
            }
        }
    }

    private static void read(int pos) {
        System.out.printf("%d\n", pos + 1);
        System.out.flush();
    }
}
