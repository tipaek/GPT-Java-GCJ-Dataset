import java.io.*;
import java.util.*;
class Solution {

    public static class node implements Comparable<node> {
        int s;
        int e;
        int ix;
        node(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.ix = i;
        }

        public int compareTo(node n1) {
            return this.s - n1.s;
        }
    }

    public static void getAnswer(node[] ary, int b) {
        int c = 0;
        int j = -1;
        char[] answ = new char[ary.length];
        StringBuilder str = new StringBuilder();
        // str.append("C");
        
        answ[ary[0].ix] = 'C';

        for(int i = 1; i < ary.length; i++) {
            if(ary[i].s >= ary[c].e ) {
                c = i;
                answ[ary[i].ix] = 'C';
            }
            else if(j == -1 || ary[i].s >= ary[j].e) {
                j = i;
                answ[ary[i].ix] = 'J';
            }
            else {
                str.append("IMPOSSIBLE");
                break;
            }
        }

        if(str.length() == 0) {
            for(int i = 0; i < answ.length; i++) {
                str.append(answ[i]);
            }
        }

        System.out.println("Case #" + b + ": " + str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        int i = 1;
        while(i<=t) {
            int n = sc.nextInt();

            node[] ary = new node[n];

            for(int j = 0; j < n; j++) {
                int ss = sc.nextInt();
                int ea = sc.nextInt();
                ary[j] = new node(ss, ea, j);
            }

            Arrays.sort(ary);

            getAnswer(ary, i);
            i++;
        }
    }
}