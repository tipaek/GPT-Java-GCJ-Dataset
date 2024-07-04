import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,i,j,ind;
        boolean flag=false;
        String e="*",s="*",ans="*",curr;
        sc.nextLine();
        for(int z = 1; z<=t;z++){
            n = sc.nextInt();
            sc.nextLine();
            e="*";s="*";ans="***";flag=false;
            for(int k=0;k<n;k++){ 
                curr=sc.nextLine();
                
                if(curr.charAt(0)!='*'){
                    i=0;
                    if(s.equals("*")){
                        while(i<curr.length()&&curr.charAt(i++)!='*');
                        s=curr.substring(0,i-1);
                        ans=s+ans;
                    } else{
                        while(i<curr.length()&&curr.charAt(i)!='*'){
                            if(i>=s.length()){
                                i++;  
                                continue;
                            } 
                            if(s.charAt(i)!=curr.charAt(i)){
                                ans="*";
                                flag=true;
                            }                       
                            i++;   
                        }
                        if(i>s.length()){
                            s=curr.substring(0,i);
                            ans=s+ans;
                        }
                    }
                }
                if(curr.charAt(curr.length()-1)!='*'){
                    i=curr.length()-1;
                    if(e.equals("*")){
                        while(i>=0&&curr.charAt(i--)!='*');
                        e=curr.substring(i+2,curr.length());
                        ans=ans+e;
                    } else{
                        while(i>=0&&curr.charAt(i)!='*'){
                            if(curr.length()-1-i>=e.length()){
                                i--;  
                                continue;
                            } 
                            if(e.charAt(e.length()-1-(curr.length()-1-i))!=curr.charAt(i)){
                                ans="*";
                                flag=true;
                            }                
                            i--;           
                        }
                        if(curr.length()-1-i>e.length()){
                            e=curr.substring(i+1,curr.length());
                            ans=ans+e;
                        }
                    }
                }
                if(flag){
                    break;
                }

                // for(i=0;i<curr.length();i++){
                //     if(curr.charAt(i)=='*')
                //         ans = s+e
                // }
                ans=ans.substring(0,s.length())+curr+ans.substring(s.length()+1);
                
                // System.out.println(s+e); 
            }  
            // System.out.println("out "+ans.replace("*",""));          
            if(flag)
                System.out.println("Case #"+z+": *");
            else{
                ans = ans.replace("*","");
                if(ans=="")
                    System.out.println("Case #"+z+": a");
                else 
                    System.out.println("Case #"+z+": "+ans);
            }
        }
    }
}
