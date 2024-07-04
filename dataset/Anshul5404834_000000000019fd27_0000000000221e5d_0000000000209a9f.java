import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int t=0;t<testcase;t++){
            String pro=sc.next();
            String ans="";
            for(int i=0;i<pro.length();i++){
                
                    int pre=0;
                    int post=0;
                if(i!=0){
                     pre=Character.getNumericValue(pro.charAt(i-1));
                }
                if(i!=pro.length()-1){
                    post=Character.getNumericValue(pro.charAt(i+1));
                }
                int current=Character.getNumericValue(pro.charAt(i));
                ans=ans+prepos(Math.max(current-pre,0),current,Math.max(current-post,0));
            }
            System.out.print("Case #"+Integer.toString(t+1)+": ");
            System.out.println(ans);
        }
    }
    public static String prepos(int x,int y , int z){
        String ans="";
        for(int i=0;i<x;i++){
            ans=ans+"(";
        }
        ans=ans+Integer.toString(y);
        for(int i=0;i<z;i++){
            ans=ans+")";
        }
        return ans;
    }
    
}