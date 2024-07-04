import java.util.*;
import java.io.*;
import java.lang.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        //ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        int x=1;      
       while(x<=test){
           int j=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
           int je=Integer.MIN_VALUE,ce=Integer.MIN_VALUE;
           String ans="";
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int start=sc.nextInt();
                int end=sc.nextInt();
                if(start>=je || end<=j){
                    j=start;
                    je=end;
                    ans+="J";
                }
                else if(start>=ce || end<=c){
                    c=start;
                    ce=end;
                    ans+="C";
                }
                else{
                    //System.out.println(ans);
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+x+":"+ans);
            x++;
       }
    }
}