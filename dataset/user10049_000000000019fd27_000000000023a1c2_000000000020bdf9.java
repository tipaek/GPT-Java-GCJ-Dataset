import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int ts = sc.nextInt();
        for(int t=1;t<=ts;t++){
            int n = sc.nextInt();
            int[][] itvs = new int[n][2];//intervals
            for(int i=0;i<n;i++){
                itvs[i][0] = sc.nextInt();
                itvs[i][1] = sc.nextInt();
            }
            String out = new Solution().arrange(itvs);
            System.out.println("Case #"+t+": "+out);
        }
    }
    String arrange(int[][] itvs){
        //boundary
        //problem type: interval sorted end? sorted start points? sweep line?
        /*
        360 480
        420 540
        600 660

        2 5 C
        1 100 J
        99 150
        150 250
        100 301
         */
        I[] is = new I[itvs.length];
        for(int i=0;i<itvs.length;i++){
            is[i] = new I(itvs[i][0],itvs[i][1],i);
        }

        Arrays.sort(is,(a,b )->a.e-b.e);
        int cend = is[0].e,jend=-1; is[0].cj='C';//480 C
        for(int i=1;i<is.length;i++){//1//2//3
            I it = is[i];//420 540//600 660
            if(it.s>=cend){
                it.cj = 'C'; cend = it.e;}
            else{
                if(it.s>=jend){
                    it.cj = 'J'; jend = it.e;}
                else{
                    return "IMPOSSIBLE";}}}//0 C
        Arrays.sort(is,(a,b)->a.index-b.index);
        StringBuilder ret = new StringBuilder();
        for(I i:is){
            ret.append(i.cj);}
        return ret.toString();//CJC
    }
    class I{int s;int e;int index;char cj;public I(int s,int e,int index){this.s=s;this.e=e;this.index=index;}}
}
