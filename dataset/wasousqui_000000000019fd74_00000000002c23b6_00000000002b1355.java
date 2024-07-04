import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cases; i++) {
            String[] tab = scan.nextLine().split(" ");
            int maxJ = Integer.parseInt(tab[0]);
            int maxK = Integer.parseInt(tab[1]);
            int[][] table = new int[maxJ + 2][maxK + 2];
            for (int j = 1; j <= maxJ; j++) {
                String[] line = scan.nextLine().split(" ");
                for (int k = 1; k <= maxK; k++) {
                    table[j][k] = Integer.parseInt(line[k - 1]);
                }
            }
            for (int j = 0; j < maxJ; j++) {
                table[j][0] = 0;
                table[j][maxK + 1] = 0;
            }
            for (int k = 0; k < maxK; k++)
            {
                table[0][k] = 0;
                table[maxJ + 1][k] = 0;
            }
            System.out.println("Case #" + (i+1) + ": " + getInterest(table));
        }
    }

    private static int getInterest(int[][] table) {
        int sum = 0;
        int prevRes = -1;
        while (true)
        {
            int res = checkRound(table);
            if (res == prevRes)
                break;
            sum += res;
            prevRes = res;
        }
        return (sum);
    }

    private static int checkRound(int[][] table) {
        Stack<Pair> pila = new Stack<>();
        int sum = 0;
        for (int i = 1; i < table.length - 1; i++){
            for (int j = 1; j < table[i].length - 1; j++) {
                Pair res = checkPos(table, i , j);
                sum += table[i][j];
                if (res != null)
                    pila.push(res);
            }
        }
        while (!pila.isEmpty())
        {
            Pair p = pila.pop();
            table[p.y][p.x] = 0;
        }
        return (sum);
    }

    private static Pair checkPos(int[][] table, int y, int x)
    {
        int sum = 0;
        int count = 0;
        for (int i = y + 1; i < table.length; i++) {
            if (table[i][x] != 0)
            {
                sum += table[i][x];
                count++;
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (table[i][x] != 0)
            {
                sum += table[i][x];
                count++;
                break;
            }
        }
        for (int j = x + 1; j < table[0].length; j++) {
            if (table[y][j] != 0)
            {
                sum += table[y][j];
                count++;
                break;
            }
        }
        for (int j = x - 1; j >= 0; j--) {
            if (table[y][j] != 0)
            {
                sum += table[y][j];
                count++;
                break;
            }
        }
        if (count != 0 && (double)table[y][x] < ((double)sum / count))
            return (new Pair(x, y));
        return (null);
    }
}
