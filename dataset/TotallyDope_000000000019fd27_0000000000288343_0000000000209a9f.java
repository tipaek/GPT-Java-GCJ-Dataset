import java.util.*;
public class Solution {
  private static  Scanner sc;

    public static void main(String args[]){
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
    while(t-->0){
        solve();
    }
}
public static int t=1;
private static void solve(){

        String S=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        char [] arr =S.toCharArray();
       int num=0;
       int count=0;
       int first=Character.getNumericValue(arr[0]);
       num=first;
       count=first;
       for(int i=0;i<first;i++){
           sb.append('(');
       }
        sb.append(first);
       for(int i=1;i<arr.length;i++){
           int d=Character.getNumericValue(arr[i]);
           if(d==num){
               sb.append(d);
           }else if(d>num){
               int diff=d-num;
               for(int j=0;j<diff;j++){
                   sb.append('(');
                   count++;
               }
               sb.append(d);
           }else{
               int diff=num-d;
               for(int j=0;j<diff;j++){
                   sb.append(')');
                   count--;
               }
               sb.append(d);
           }
           num=Character.getNumericValue(arr[i]);
       }
       while(count-->0){
sb.append(')');
       }
    System.out.println("Case #"+(t++) + ": "+sb.toString());
     }
}