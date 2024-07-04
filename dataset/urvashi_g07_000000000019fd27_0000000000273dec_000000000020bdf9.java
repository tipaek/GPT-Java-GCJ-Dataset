import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        int T = scrn.nextInt();
        int k = 1;
        while (T > 0) {
            int N = scrn.nextInt();
            ArrayList<pair> al = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                pair p = new pair(scrn.nextInt(), scrn.nextInt(), i);
                al.add(p);
            }
            Collections.sort(al);
            char []ans=new char[N];
            int JStart = -1;
            int JEnd = -1;
            int CStart = al.get(0).start;
            int CEnd = al.get(0).end;
            ans[al.get(0).index]='C';
            boolean possible = true;
            for (int i = 1; i < N; i++) {
                int s=al.get(i).start;
                int e=al.get(i).end;
                if (s >= CEnd || e<= CStart) {
                    CStart = Math.min(s, CStart);
                    CEnd = Math.max(e, CEnd);
                    ans[al.get(i).index]='C';
                } else if (JStart == -1 && JEnd == -1) {
                    JStart =s;
                    JEnd = e;
                    ans[al.get(i).index]='J';
                } else if (s >= JEnd || e <= JStart) {
                    JStart = Math.min(s, JStart);
                    JEnd = Math.max(e, JEnd);
                    ans[al.get(i).index]='J';
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + new String(ans));
            }
            k++;
            T--;
        }
    }

    static class pair implements Comparable<pair> {
        int start;
        int end;
        int index;

        public pair(int s, int e, int i) {
            this.start = s;
            this.end = e;
            this.index = i;

        }

        @Override
        public int compareTo(pair pair) {
            return this.start-pair.start;
        }
    }
}
