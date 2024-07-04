import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        public final int row;
        public final int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ":");
            switch (n) {
                case 1:
                    System.out.println("1 1");
                    break;
                case 2:
                    System.out.println("1 1");
                    System.out.println("2 1");
                    break;
                case 3:
                    System.out.println("1 1");
                    System.out.println("2 1");
                    System.out.println("2 2");
                    break;
                case 4:
                    System.out.println("1 1");
                    System.out.println("2 1");
                    System.out.println("3 2");
                    break;
                default:
                    ArrayList<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(1, 1));
                    pairs.add(new Pair(2, 1));

                    int sum = 2;
                    int nextNum = 2;
                    int nextRow = 3;

                    while (sum + nextNum < n) {
                        pairs.add(new Pair(nextRow, 2));
                        sum += nextNum;
                        nextNum++;
                        nextRow++;
                    }
                    nextRow--;
                    while (sum < n) {
                        pairs.add(new Pair(nextRow, 1));
                        nextRow++;
                        sum++;
                    }

                    for (Pair pair : pairs) {
                        System.out.println(pair.row + " " + pair.col);
                    }
                    break;
            }
        }
    }
}