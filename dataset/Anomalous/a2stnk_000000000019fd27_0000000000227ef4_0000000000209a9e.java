import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            Solver solver = new Solver(sc, B);
            if (!solver.solve()) {
                System.err.println("error");
                break;
            }
        }

        sc.close();
    }

    static class Solver {
        Scanner sc;
        int B;

        public Solver(Scanner sc, int B) {
            this.sc = sc;
            this.B = B;
        }

        boolean solve() {
            int[] ans = new int[B];
            int queryNum = 0;
            int equalPos = -1;
            int diffPos = -1;

            for (int i = 0; i < B / 2; i++) {
                ans[i] = queryBit(i);
                ans[B - 1 - i] = queryBit(B - 1 - i);

                if (equalPos < 0 && ans[i] == ans[B - 1 - i]) {
                    equalPos = i;
                }
                if (diffPos < 0 && ans[i] != ans[B - 1 - i]) {
                    diffPos = i;
                }

                queryNum += 2;

                if (queryNum % 10 == 0 && i < B / 2 - 1) {
                    if (equalPos >= 0 && diffPos >= 0) {
                        handleTransformation(ans, equalPos, diffPos);
                    } else if (equalPos >= 0) {
                        handleSingleTransformation(ans, equalPos);
                    } else if (diffPos >= 0) {
                        handleSingleTransformation(ans, diffPos);
                    }
                    queryNum += 2;
                }
            }

            return submitAnswer(ans);
        }

        int queryBit(int index) {
            System.out.println(index + 1);
            return sc.nextInt();
        }

        boolean submitAnswer(int[] ans) {
            for (int bit : ans) {
                System.out.print(bit);
            }
            System.out.println();
            return sc.next().equals("Y");
        }

        void handleTransformation(int[] ans, int equalPos, int diffPos) {
            int eAfter = queryBit(equalPos);
            int dAfter = queryBit(diffPos);

            if (eAfter == ans[equalPos]) {
                if (dAfter != ans[diffPos]) {
                    reverseArray(ans);
                }
            } else {
                if (dAfter == ans[diffPos]) {
                    reverseArray(complementArray(ans));
                } else {
                    complementArray(ans);
                }
            }
        }

        void handleSingleTransformation(int[] ans, int pos) {
            int after = queryBit(pos);
            queryBit(pos); // to make queryNum even
            if (after != ans[pos]) {
                complementArray(ans);
            }
        }

        int[] complementArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = 1 - array[i];
            }
            return array;
        }

        int[] reverseArray(int[] array) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
            return array;
        }
    }

    static class TestSolver extends Solver {
        int[] bits;
        Random rand;
        int queryNum;

        public TestSolver(Scanner sc, int B) {
            super(sc, B);
            bits = new int[B];
            rand = new Random();
            for (int i = 0; i < B; i++) {
                bits[i] = rand.nextInt(2);
            }
            queryNum = 0;
        }

        @Override
        int queryBit(int index) {
            queryNum++;
            if (queryNum > 10 && queryNum % 10 == 1) {
                if (rand.nextInt(2) == 1) {
                    complementArray(bits);
                }
                if (rand.nextInt(2) == 1) {
                    reverseArray(bits);
                }
            }
            return bits[index];
        }

        @Override
        boolean submitAnswer(int[] ans) {
            System.out.print("expected = ");
            printArray(bits);
            System.out.println();
            System.out.print("query = ");
            printArray(ans);
            System.out.println();

            for (int i = 0; i < B; i++) {
                if (ans[i] != bits[i]) {
                    System.out.println("NG");
                    return false;
                }
            }

            System.out.println("OK");
            return true;
        }

        void printArray(int[] array) {
            for (int bit : array) {
                System.out.print(bit);
            }
        }
    }
}