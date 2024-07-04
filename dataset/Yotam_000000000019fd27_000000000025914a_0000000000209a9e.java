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
        List<Pair> same = new ArrayList<>();
        List<Pair> diff = new ArrayList<>();
        for (int i = 0; i < tests; i++) {
            for (int j = 0; j < B / 2; j++) {

                if (j != 0 && j % 5 != 0) {
                    if (same.isEmpty()) {
                        System.out.println(diff.get(0).left);
                        int response = scanner.nextInt();
                        if (response != diff.get(0).left)
                            for (Pair pair : diff) {
                                pair.right = ~pair.right;
                                pair.left = ~pair.left;
                            }
                    } else if (diff.isEmpty()) {
                        System.out.println(same.get(0).left);
                        int response = scanner.nextInt();
                        if (response != same.get(0).left)
                            for (Pair pair : same) {
                                pair.right = ~pair.right;
                                pair.left = ~pair.left;
                            }
                    } else {
                        System.out.println(same.get(0).left);
                        int response1 = scanner.nextInt();
                        System.out.println(diff.get(0).left);
                        int response2 = scanner.nextInt();
                        if (response2 != diff.get(0).left) {
                            for (Pair pair : diff) {
                                pair.right = ~pair.right;
                                pair.left = ~pair.left;
                            }
                        }
                        if (response1 != same.get(0).left) {
                            for (Pair pair : same) {
                                pair.right = ~pair.right;
                                pair.left = ~pair.left;
                            }
                            for (Pair pair : diff) {
                                pair.right = ~pair.right;
                                pair.left = ~pair.left;
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
                arr[pair.leftIndex]=pair.left;
                arr[pair.rightIndex]=pair.right;
            }
            for (Pair pair : diff) {
                arr[pair.leftIndex]=pair.left;
                arr[pair.rightIndex]=pair.right;
            }
            for(int j=0;j<B;j++)
                builder.append(arr[j]);
            System.out.println(builder.toString());
        }


    }
}
