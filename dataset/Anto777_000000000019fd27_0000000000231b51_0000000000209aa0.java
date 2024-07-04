//package solution;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.awt.Point;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    long mod = 1000000007L;
    void run() throws Exception {
        int t = ni();
        for(int I=1; I<=t; I++) {
            int n = ni(), k = ni();
            if(n > 5) {
                pl("-1"); return;
            } else {
                String temp = "12345";
                String s = temp.substring(0, n);
                
                String[] perms = getAllPermutations(s);
                int[][] ans = new int[n][n];
                if(n == 2) {
                    outer:
                    for(int i=0; i<perms.length; i++) {
                        for(int j=i+1; j<perms.length; j++) {
                            ans = isLatinSquare(perms[i], perms[j]);
                            if(ans == null) continue;
                            if(check(ans, k)) {
                                break outer;
                            } else {
                                ans = null;
                            }
                        }
                    }
                } else if(n == 3) {
                    outer:
                    for(int i=0; i<perms.length; i++) {
                        for(int j=i+1; j<perms.length; j++) {
                            for(int l=j+1; l<perms.length; l++) {
                                ans = isLatinSquare(perms[i], perms[j], perms[l]);
                                if(ans == null) continue;
                                if(check(ans, k)) {
                                    break outer;
                                } else {
                                    ans = null;
                                }
                            }
                        }
                    }
                } else if(n == 4) {
                    outer:
                    for(int i=0; i<perms.length; i++) {
                        for(int j=i+1; j<perms.length; j++) {
                            for(int l=j+1; l<perms.length; l++) {
                                for(int m=l+1; m<perms.length; m++) {
                                    ans = isLatinSquare(perms[i], perms[j], perms[l], perms[m]);
                                    if(ans == null) continue;
                                    if(check(ans, k)) {
                                        break outer;
                                    } else {
                                        ans = null;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    outer:
                    for(int i=0; i<perms.length; i++) {
                        for(int j=i+1; j<perms.length; j++) {
                            for(int l=j+1; l<perms.length; l++) {
                                for(int m=l+1; m<perms.length; m++) {
                                    for(int q=m+1; q<perms.length; q++) {
                                        ans = isLatinSquare(perms[i], perms[j], perms[l], perms[m], perms[q]);
                                        if(ans == null) continue;
                                        if(check(ans, k)) {
                                            break outer;
                                        } else {
                                            ans = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(ans == null) {
                    pl("Case #" + I + ": IMPOSSIBLE");
                } else {
                    StringBuilder res = new StringBuilder(10000);
                    res.append("Case #").append(I).append(": POSSIBLE\n");
                    for(int i=0; i<n; i++) {
                        for(int j=0; j<n; j++) {
                            res.append(ans[i][j]).append(" ");
                        }
                        res.deleteCharAt(res.length() - 1);
                        res.append("\n");
                    }
                    p(res);
                }
            }
        }
    }
    
    int[][] isLatinSquare(String... a) {
        int n = a.length;
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            String s = a[i];
            for(int j=0; j<n; j++)
                map[i][j] = s.charAt(j) - '0';
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int num = map[i][j];
                for(int k=0; k<n; k++) {
                    if(k == j) continue;
                    if(map[i][k] == num) return null;
                }
                for(int k=0; k<n; k++) {
                    if(k == i) continue;
                    if(map[k][j] == num) return null;
                }
            }
        }
        return map;
    }
    
    boolean check(int[][] a, int k) {
        int n = a.length, sum = 0;
        for(int i=0; i<n; i++)
            sum += a[i][i];
        return sum == k;
    }
    
    String[] getAllPermutations(String s){
        if(s.length() == 1)return new String[]{s};
        if(s.length() == 2)return new String[]{s, "" + s.charAt(1) + s.charAt(0)};
        
        Queue<String> queue = new LinkedList<>();
        queue.add("" + s.charAt(s.length() - 1) + s.charAt(s.length() - 2));
        queue.add("" + s.charAt(s.length() - 2) + s.charAt(s.length() - 1));
        while(queue.peek().length() < s.length()){
            String string = queue.peek();
            queue.remove();
            char appChar = s.charAt(s.length() - string.length() - 1);
            queue.add("" + appChar + string);
            queue.add(string + appChar);
            for(int i=1; i<string.length(); i++){
                queue.add(new StringBuilder(string.substring(0, i)).append(appChar).append(string.substring(i)).toString());
            }
        }
        
        int ans_i = 0;
        String[] ans = new String[queue.size()];
        while(!queue.isEmpty()){
            ans[ans_i++] = queue.peek();
            queue.remove();
        }
        
        return ans;
    }
    
    //Reader & Writer
    String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    String nt() throws Exception {
        return nextToken();
    }

    String ns() throws Exception {
        return br.readLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    void p(Object o) {
        System.out.print(o);
    }

    void pl(Object o) {
        System.out.println(o);
    }
}