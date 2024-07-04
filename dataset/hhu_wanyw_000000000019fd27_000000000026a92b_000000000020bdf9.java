   /**
 * @author Stephen
 * @date 2020-01-27
 * @time 14:32
 */

import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.util.*;

public class Solution {
    private Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    void solve(){
        int T=in.nextInt();
        for(int t=1;t<=T;t++){
            ArrayList<Pair> C=new ArrayList<>();
            ArrayList<Pair> J=new ArrayList<>();
            int n=in.nextInt();
            Pair[] act=new Pair[n];
            char[] c=new char[n];
            for(int i=0;i<n;i++){
                int s=in.nextInt();
                int e=in.nextInt();
                act[i]=new Pair(i,s,e);
            }
            Arrays.sort(act);
            boolean flag=false,r=false;
            repeat:for(int i=0;i<n;i++){

                if(i==0) {
                C.add(act[i]);
                c[act[i].i]='C';
                }
                else {
                    if(act[i].s<act[i-1].e) {
                        flag=!flag;
                        if(flag){
                            for(int j=0;j<J.size();j++){
                                if(act[i].s<J.get(j).e) {
                                    r=true;
                                    break repeat;
                                }
                            }
                            c[act[i].i]='J';

                        }
                        else {
                            for(int j=0;j<C.size();j++){
                                if(act[i].s<C.get(j).e) {
                                    r=true;
                                    break repeat;
                                }
                            }
                            c[act[i].i]='C';
                        }

                    }
                    else {
                        if(flag) c[act[i].i]='J';
                        else c[act[i].i]='C';
                    }
                }
            }
            if(r) System.out.println("Case #"+t+": IMPOSSIBLE");
            else System.out.println("Case #"+t+": "+new String(c).trim());
        }
    }
    class Pair implements Comparable<Pair>{
        int i,s,e;

        public Pair(int i,int s, int e) {
            this.s = s;
            this.e = e;
            this.i=i;
        }

        @Override
        public int compareTo(Pair o) {
            return e==o.e?s-o.s:e-o.e;
        }
    }
    public static void main(String[] args){
        new Solution().solve();

    }
}