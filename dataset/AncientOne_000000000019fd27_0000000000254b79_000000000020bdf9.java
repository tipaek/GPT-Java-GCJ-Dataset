
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

 class Solution {
    static class Pair{
        int st,ed,ind;
        String str;

        Pair(int st, int ed, int ind) {
            this.st = st;
            this.ed = ed;
            this.ind = ind;
            str=null;
        }
    }
    public static  void  main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n=sc.nextInt();
            Pair[] pairs= new Pair[n+1];
            pairs[0]= new Pair(0,0,-1);
            for (int j = 1; j <= n; j++)
                pairs[j]=new Pair(sc.nextInt(),sc.nextInt(),j);
            Arrays.sort(pairs, (p1, p2) -> {
                if (p1.ed != p2.ed)
                    return Integer.compare(p1.ed, p2.ed);
                return Integer.compare(p1.st, p2.st);
            });
            System.out.println(sol(pairs));
        }
    }
    private static String sol(Pair[] pairs){
        int n= pairs.length;
        boolean isImp=false;
        int st=0,end=0;
        for (Pair dur:pairs){
            if(dur.st>=end||dur.ed<=st){
                dur.str="C";
                st=Math.min(st,dur.st);
                end=Math.max(end,dur.ed);
            }
        }
         st=0;
        end=0;
        for (Pair dur:pairs){
            if (dur.str==null) {
                if ((dur.st >= end || dur.ed <= st)) {
                    dur.str = "J";
                    st = Math.min(st, dur.st);
                    end = Math.max(end, dur.ed);
                } else {
                    isImp = true;
                    break;
                }
            }
        }
        StringBuffer str;
        if (isImp)
            str=new StringBuffer("IMPOSSIBLE");
        else {
            String[] chars=new String[n];
            chars[0]="";
            for (int i=1;i<n;i++){
                chars[pairs[i].ind]=pairs[i].str;
            }
            str=new StringBuffer();
            for (String s:chars)
                str.append(s);
        }
        return str.toString();
    }
}
