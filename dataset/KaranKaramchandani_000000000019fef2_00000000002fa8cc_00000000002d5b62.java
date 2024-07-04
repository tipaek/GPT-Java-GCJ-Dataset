import java.util.*;
public class Solution{
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=1;t<=test;t++){
          int x=sc.nextInt();
          int y=sc.nextInt();
          String str[]=new String[test];
          str[0]="SEN";
          str[1]="NWS";
          str[2]="EE";
          str[3]="IMPOSSIBLE";
          System.out.println("Case #"+t+": "+str[t-1]);
        }
    } 
}