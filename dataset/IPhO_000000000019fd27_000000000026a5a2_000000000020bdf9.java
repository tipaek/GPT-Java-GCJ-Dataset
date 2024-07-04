import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        for(int t=1; t<=T; t++) {
            int N=in.nextInt();
            Pair[] a=new Pair[N];
            for(int i=0; i<N; i++)
                a[i]=new Pair(in.nextInt(), in.nextInt(), i);
            Arrays.sort(a);
            ArrayList<Pair2> p=new ArrayList<>();
            char[] ans = new char[N];
            Boolean impossible=false;
            for(int i=0; i<N; i++) {
                Iterator it = p.iterator();
                while (it.hasNext())
                    if (((Pair2)it.next()).x<=a[i].x)
                        it.remove();
                if (p.size()>1) {
                    impossible=true;
                    break;
                }
                char c='C';
                for(Pair2 j:p)
                    if (j.c=='C')
                        c='J';
                p.add(new Pair2(a[i].y, c));
                ans[a[i].pos]=c;
            }
            StringBuilder ans_str=new StringBuilder();
            if (impossible)
                ans_str.append("IMPOSSIBLE");
            else
                for(char c:ans)
                    ans_str.append(c);
            System.out.println(String.format("Case #%d: %s", t, ans_str));

        }

    }


    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;
        public int pos;
        public Pair(int x, int y, int pos) {
            this.x = x;
            this.y = y;
            this.pos = pos;
        }

        public int compareTo(Pair p) {
            if (x != p.x)
                return x - p.x;
            else
                return y-p.y;
        }
    }

    static class Pair2 {
        public int x;
        public char c;
        public Pair2(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }

}

