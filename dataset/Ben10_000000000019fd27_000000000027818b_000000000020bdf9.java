import java.util.*;
public class Solution {
    static class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String args[]) {
     Scanner sc=new Scanner(System.in);
     int T=sc.nextInt();
     for(int t=1;t<=T;t++){
         int n=sc.nextInt();
         pair a[]=new pair[n];
         for(int i=0;i<n;i++){
             a[i]=new pair(sc.nextInt(),sc.nextInt());
         }
     
     Arrays.sort(a,new Comparator<pair>(){
         @Override
         public int compare(pair p1,pair p2){
             return p1.x-p2.x;
         }
     });
     //int j=0;k=0;
     StringBuilder sb=new StringBuilder("");
     sb.append("J");
     sb.append("C");
     pair p1=a[0];
     pair p2=a[1];
     String s="";
     boolean f=true;
     for(int i=2;i<n;i++){
         if(a[i].x>=p1.y){
             if(p1.y<p2.y){
                 p1=a[i];
                 sb.append("J");
             }else{
                 p2=a[i];
                 sb.append("C");
             }
         }else if(a[i].x>=p2.y){
            if(p2.y<p1.y){
                 p2=a[i];
                 sb.append("C");
             }else{
                 p1=a[i];
                 sb.append("J");
             } 
         }else{
           f=false;
           s="IMPOSSIBLE";
         }
     }
     if(f){
       s=sb.toString();
     }
     System.out.println("Case #"+t+": "+s);
     }
    }
}