import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        outerloop:
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            int mat[][]=new int[n][2];
            String ans="";
            int minC=Integer.MAX_VALUE,minJ=Integer.MAX_VALUE;
            int maxC=Integer.MIN_VALUE,maxJ=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int x1=sc.nextInt();
                int y1=sc.nextInt();
                //System.out.println(x1+" "+y1);
                if(Math.max(minC,x1)>=Math.min(maxC,y1)){
                    minC=Math.min(minC,x1);
                    maxC=Math.max(maxC,y1);
                    ans+="C";
                }else if(Math.max(minJ,x1)>=Math.min(maxJ,y1)){
                    minJ=Math.min(minJ,x1);
                    maxJ=Math.max(maxJ,y1);
                    ans+="J";
                }else{
                    System.out.println("Case #"+k+": IMPOSSIBLE");
                    continue outerloop;
                }
            }
            System.out.println("Case #"+k+": "+ans);
        }
    }
}