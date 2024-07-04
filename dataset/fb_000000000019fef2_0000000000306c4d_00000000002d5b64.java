
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int i = 0; i < T; i++) {
            solve(i+1, in);
        }

    }

    private static void solve(int cid, Scanner in) {

        int R = in.nextInt();
        int S = in.nextInt();

        int[] A = new int[R*S];
        int p = 0;
        for(int s = 0; s < S; s++) {
            for(int r = 0; r < R; r++) {
                A[p] = r;
                p++;
            }
        }

        int N = R*S;

        Queue<CardState> states = new LinkedList<CardState>();
        states.add(new CardState(A));
        while(true) {
            Queue<CardState> next = new LinkedList<CardState>();
            for(CardState s : states) {
                if(s.isDone()) {
                    System.out.println("Case #" + cid + ": " + s.history.size());
                    for(String l : s.history) {
                        System.out.println(l);
                    }
                    return;
                }
                for(int i = N-1; i > 0; i--) {
                    for(int j = N-i; j > 0; j--) {
                        next.add(s.permute(i, j));
                    }
                }
            }
            states = next;
        }


    }

    private static class CardState {

        int[] A;
        List<String> history = new LinkedList<String>();

        CardState(int[] A) {
            this.A = A;
        }

        boolean isDone() {
            for(int i = 0; i < A.length-1; i++) {
                if(A[i] > A[i+1])
                    return false;
            }
            return true;
        }

        CardState permute(int a, int b) {
            int[] B = new int[A.length];
            int p = 0;
            for(int i = a; i < a+b; i++) {
                B[p] = A[i];
                p++;
            }
            for(int i = 0; i < a; i++) {
                B[p] = A[i];
                p++;
            }
            for(int i = a+b; i < A.length; i++) {
                B[p] = A[i];
                p++;
            }
            CardState ret = new CardState(B);
            ret.history.addAll(history);
            ret.history.add(a + " " + b);
            return ret;
        }

    }

}