import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int real=1;
    while(t-->0){
        String s=sc.next();
        StringBuffer ans=new StringBuffer("");
        int o=0,c=0;
        for(int i=0;i<s.length();i++){
            int lo=o;
            int num=Integer.parseInt(String.valueOf(s.charAt(i)));
            if(lo>num){
                for(int j=0;j<(lo-num);j++){
                    ans.append(')');
                    o--;
                }
            }
            else{
                for(int j=0;j<(num-lo);j++){
                    ans.append('(');
                    o++;
                }
            }
            ans.append(num);

        }
        for(int i=0;i<o;i++) ans.append(')');
        System.out.println("Case #"+real+": "+ans);
        real++;
    }
  }
}