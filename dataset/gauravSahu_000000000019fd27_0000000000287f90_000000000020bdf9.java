import java.io.*;
import java.util.*;
class Solution {

    public static class node implements Comparable<node> {
        int st;
        int et;
        int idx;
        node(int s, int e, int i) {
            this.st = s;
            this.et = e;
            this.idx = i;
        }

        public int compareTo(node n1) {
            return this.st - n1.st;
        }
    }

    public static void getAnswer(node[] arr, int ct) {
        int c = 0;
        int j = -1;
        char[] ans = new char[arr.length];
        StringBuilder str = new StringBuilder();
        // str.append("C");
        
        ans[arr[0].idx] = 'C';

        for(int i = 1; i < arr.length; i++) {
            if(arr[i].st >= arr[c].et ) {
                c = i;
                ans[arr[i].idx] = 'C';
            }
            else if(j == -1 || arr[i].st >= arr[j].et) {
                j = i;
                ans[arr[i].idx] = 'J';
            }
            else {
                str.append("IMPOSSIBLE");
                break;
            }
        }

        if(str.length() == 0) {
            for(int i = 0; i < ans.length; i++) {
                str.append(ans[i]);
            }
        }

        System.out.println("Case #" + ct + ": " + str);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scn.nextInt();

        int ct = 1;
        while(ct <= t) {
            int n = scn.nextInt();

            node[] arr = new node[n];

            for(int i = 0; i < n; i++) {
                int s = scn.nextInt();
                int e = scn.nextInt();
                arr[i] = new node(s, e, i);
            }

            Arrays.sort(arr);

            getAnswer(arr, ct);
            ct++;
        }
    }
}