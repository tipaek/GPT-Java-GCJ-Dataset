import java.io.*;
import java.util.*;
public class Solution{
    static String open(int n){
        String ans="";
        for(int i=0;i<n;i++){
            ans+="(";
        }
        return ans;
    }
    static String  close(int n){
        String ans="";
        for(int i=0;i<n;i++)
        ans+=")";
        return ans;
    }
    
    
    public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
for(int k=0;k<t;k++){
    String inp=sc.next();
    int arr[]=new int[inp.length()];
    for(int i=0;i<inp.length();i++){
        arr[i]=Integer.parseInt(Character.toString(inp.charAt(i)));
        
    }
    int d=0;
    String ans="";
    int start=arr[0];
      ans=ans+open(start);
       ans+=String.valueOf(arr[0]);
       boolean inside=true;
    for(int i=1;i<arr.length;i++){
        inside=false;
        if(arr[i]>start){
            int diff=arr[i]-start;
            ans+=open(diff);
             ans+=String.valueOf(arr[i]);
            d=arr[i];
            start=arr[i];
            
        }
        else if(arr[i]<start){
            
            int diff=start-arr[i];
            ans+=close(diff);
             ans+=String.valueOf(arr[i]);
             d=arr[i];
             start=arr[i];
        }
        else if(arr[i]==start){
             ans+=String.valueOf(arr[i]);
           
            d=arr[i];
            start=arr[i];
        }
      
        
    }
    if(inside==true){
        ans+=close(start);
    }
    ans+=close(d);
    
    int temp=k+1;
    System.out.println("Case #"+temp+": "+ans);


}

}
}
