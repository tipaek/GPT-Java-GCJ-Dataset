import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    private static class PairInteger implements  Comparable<PairInteger> {
        Integer num;
        char c;

        public  PairInteger(int num, char c) {
            this.num = num;
            this.c = c;
        }

        @Override
        public int compareTo(PairInteger pairInteger) {
            int aux = this.num.compareTo(pairInteger.num);
            return ((aux == 0) ? this.c - pairInteger.c : aux);
        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cases; i++) {
            int todos = Integer.parseInt(scan.nextLine());
            int[][] mat = new int[todos][3];
            for (int j = 0; j < todos; j++) {
                String[] tab = scan.nextLine().split(" ");
                mat[j][0] = Integer.parseInt(tab[0]);
                mat[j][1] = Integer.parseInt(tab[1]);
                mat[j][2] = j;
            }
            printSchedule(i + 1, orderTable(mat));
        }
    }

    public static void printSchedule(int test, int[][] mat)
    {
        String res = "";
        TreeSet<PairInteger> tree = new TreeSet<>();
        for (int i = 0; i < mat.length; i++) {
            while (!tree.isEmpty() && tree.first().num <= mat[i][0])
                tree.pollFirst();
            char c = (!tree.isEmpty() && tree.last().c == 'C') ? 'J' : 'C';
            switch (tree.size()) {
                case 0:
                case 1:
                    res += c;
                    break;
                default:
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                    return;

            }
            tree.add(new PairInteger(mat[i][1], c));
        }
        System.out.print("Case #"+ test + ": ");
        transformString(res, mat);
    }

    public static void transformString(String str, int[][] mat)
    {
        char[] res = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            res[mat[i][2]] = str.charAt(i);
        }
        for (char c: res)
            System.out.print(c);
        System.out.println();
    }

    public static int[][] orderTable(int[][] tab)
    {
        int[][] res = tab.clone();
        int[] aux = new int[3];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length - i - 1; j++) {
                if (res[j][0] > res[j + 1][0])
                {
                    aux[0] = res[j][0];
                    aux[1] = res[j][1];
                    aux[2] = res[j][2];
                    res[j][0] = res[j + 1][0];
                    res[j][1] = res[j + 1][1];
                    res[j][2] = res[j + 1][2];
                    res[j + 1][0] = aux[0];
                    res[j + 1][1] = aux[1];
                    res[j + 1][2] = aux[2];
                }
            }
        }
        return (res);
    }



}