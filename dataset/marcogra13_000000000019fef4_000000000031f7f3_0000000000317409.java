import java.util.*;
import java.io.*;

public class Solution {

    static void print(int caso, boolean poss, int minute) {
        if (poss) {
            System.out.println("Case #" + (caso + 1) + ": " + minute);
        } else {
            System.out.println("Case #" + (caso + 1) + ": IMPOSSIBLE");
        }
    }

    static int[] move(int[] pos, char mossa) {
        int[] risultato = { pos[0], pos[1] };
        switch (mossa) {
            case 'N':
                risultato[1]++;
                break;
            case 'S':
                risultato[1]--;
                break;
            case 'E':
                risultato[0]++;
                break;
            case 'W':
                risultato[0]--;
                break;
            case 'F':
                break;
        }
        return risultato;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            int X = input.nextInt();
            int Y = input.nextInt();
            String path = input.next();
            int[] target = { X, Y };
            boolean trovato = false;

            int[] me = { 0, 0 };
            int contatore = 0;
            char[] mosse = { 'N', 'S', 'E', 'W', 'F' };
            Queue<int[]> coda = new LinkedList<>();
            coda.add(me);

            for (int j = 0; j < path.length(); j++) {
                target = Solution.move(target, path.charAt(j));
                contatore++;
                int[] t = coda.remove();
                int[] t2 = { 0, 0 };
                if (target[0] > t[0]) {
                    t2 = Solution.move(t, 'E');
                } else if (target[0] < t[0]) {
                    t2 = Solution.move(t, 'W');
                } else {
                    if (target[1] > t[1]) {
                        t2 = Solution.move(t, 'N');
                    } else if (target[1] < t[1]) {
                        t2 = Solution.move(t, 'S');
                    } else {
                        trovato = true;
                        break;
                    }
                }
                coda.add(t2);
                if (target[0] == t2[0] && target[1] == t2[1]) {
                    trovato = true;
                    break;
                }

            }
            Solution.print(i, trovato, contatore);
        }
    }
}
