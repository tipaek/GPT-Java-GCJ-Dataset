import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pair {
        int left;
        int right;
        int leftIndex;
        int rightIndex;

        public Pair(int left, int right, int leftIndex, int rightIndex) {
            this.left = left;
            this.right = right;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        int B = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            List<Pair> same = new ArrayList<>();
            List<Pair> diff = new ArrayList<>();
            for (int j = 0; j < B / 2; j++) {

                if (j != 0 && j % 5 ==1) {
                    if (same.isEmpty()) {
                        System.out.println(diff.get(0).leftIndex);
                        int response = scanner.nextInt();
                        if (response != diff.get(0).left)
                            for (Pair pair : diff) {
                                pair.right ^=1;
                                pair.left ^=1;
                            }
                    } else if (diff.isEmpty()) {
                        System.out.println(same.get(0).leftIndex);
                        int response = scanner.nextInt();
                        if (response != same.get(0).left)
                            for (Pair pair : same) {
                                pair.right ^=1;
                                pair.left ^=1;
                            }
                    } else {
                        System.out.println(same.get(0).leftIndex);
                        int response1 = scanner.nextInt();
                        System.out.println(diff.get(0).leftIndex);
                        int response2 = scanner.nextInt();
                        if (response2 != diff.get(0).left) {
                            for (Pair pair : diff) {
                                pair.right ^=1;
                                pair.left ^=1;
                            }
                        }
                        if (response1 != same.get(0).left) {
                            for (Pair pair : same) {
                                pair.right ^=1;
                                pair.left ^=1;
                            }
                            for (Pair pair : diff) {
                                pair.right ^=1;
                                pair.left ^=1;
                            }
                        }

                    }
                }

                System.out.println(j + 1);
                int left = scanner.nextInt();
                System.out.println(B - j);
                int right = scanner.nextInt();
                Pair pair = new Pair(left, right, j + 1, B - j);
                if (left != right)
                    diff.add(pair);
                else
                    same.add(pair);

            }
            StringBuilder builder = new StringBuilder();
            int[] arr = new int[B];
            for (Pair pair : same) {
                arr[pair.leftIndex-1]=pair.left;
                arr[pair.rightIndex-1]=pair.right;
            }
            for (Pair pair : diff) {
                arr[pair.leftIndex-1]=pair.left;
                arr[pair.rightIndex-1]=pair.right;
            }
            for(int j=0;j<B;j++)
                builder.append(arr[j]);
            System.out.println(builder.toString());

            String judge = scanner.next();
            if(judge.equalsIgnoreCase("N"))
                return;
        }


    }
}
