import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        in.nextLine();
        String[] s;
        for(int i=0; i<t; i++){
            s=in.nextLine().split("");
            int[] arr= new int[s.length];
            int ind=0;
            for(String num:s){
                arr[ind]=Integer.parseInt(num);
                ind++;
            }
            
            System.out.println("Case #"+(i+1)+": "+solve(arr));
        }
        
    }
    
    public static String solve(int[]arr) {
        int sum=0;
        int val=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            
            val=arr[i]-sum;
            sum+=val;
             while(val<0){
                 ans.append(")");
                val++;
            }
            while(val>0){
                ans.append("(");
                val--;
            }
            ans.append(arr[i]);
        }
        while(sum>0){
            ans.append(")");
            sum--;
        }
        return ans.toString();
    }
    
    
}






