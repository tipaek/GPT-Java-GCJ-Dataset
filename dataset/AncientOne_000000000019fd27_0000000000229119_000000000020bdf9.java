
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

 class Solution{
    static class Pair{
        int st,ed,ind;
        String str;

        public Pair(int st, int ed, int ind) {
            this.st = st;
            this.ed = ed;
            this.ind = ind;
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
                if (p1.st != p2.st)
                    return Integer.compare(p1.st, p2.st);
                return Integer.compare(p1.ed, p2.ed);
            });
            System.out.println(comp(pairs).toString());
        }
    }
    private static StringBuffer comp(Pair[] pairs){
        StringBuffer str;
        int fCam=0,fJam=0;
        boolean isImp=false;
        int n=pairs.length;
        for (int j=1;j<n;j++){
            if (pairs[j].st>=pairs[fCam].ed||pairs[j].ed<=pairs[fCam].st) {
                pairs[j].str="C";
                fCam=j;
            }
            else if (pairs[j].st>=pairs[fJam].ed||pairs[j].ed <=pairs[fJam].st){
                pairs[j].str="J";
                fJam=j;
            }
            else {
                isImp=true;
                break;
            }
        }
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
        return str;
    }
}
