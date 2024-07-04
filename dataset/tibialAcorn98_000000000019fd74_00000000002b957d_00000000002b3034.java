import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int j=0; j<t; j++){
            int n=in.nextInt();
           String pat;
            String[][] split= new String[n][2];
            String[] arr= new String[2];
            int maxp=-1;
            int maxe=-1;
            String prefix="";
            String postfix="";
           for(int i=0;i<n;i++){
               pat=in.next();
               for(int k=0;k<pat.length();k++){
                   if(pat.charAt(k)=='*'){
                       arr[0]=pat.substring(0,k);
                       if(k<pat.length()-1){
                           arr[1]=pat.substring(k+1,pat.length());
                       }
                   }
               }
               split[i][0]=arr[0];
               if(arr.length>=1)
               split[i][1]=arr[1];
               if(arr[0].length()>maxp){
                   maxp=arr[0].length();
                   prefix=arr[0];
               }
               
                if(arr[1]!=null&&arr[1].length()>maxe){
                   maxe=arr[1].length();
                   postfix=arr[1];
               }
               
           }
            // System.out.println("prefix :"+ prefix);
           //  System.out.println("postfix :"+ postfix);
            System.out.println("Case #"+(j+1)+": "+solve(split,prefix,postfix));
        }
        
    }
    
    public static String solve(String[][] split,String pre, String post) {
        int n=split.length;
        String ans=pre+post;
        boolean solve=false;
        for( int i=0;i<n;i++){
            if(solve)
            break;
            for(int j=0;j<split[i][0].length();j++){
                if(pre.charAt(j)!=split[i][0].charAt(j)){
                    ans="*";
                    solve =true;
                    break;
                }
                
                
            }
            int k=0;
            if(split[i][1]!=null){
             for(int j=split[i][1].length()-1;j>-1;j--){
                 if(post.charAt(post.length()-k-1)!=split[i][1].charAt(j)){
                     
                    ans="*";
                    solve =true;
                    break;
                }
                k++;
            }
            }
            
        }
      return ans; 
    }
    
    
}






