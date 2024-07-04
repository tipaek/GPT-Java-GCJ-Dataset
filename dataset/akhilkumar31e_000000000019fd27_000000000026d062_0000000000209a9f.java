import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int t=1;t<=test;t++){
            String s=br.readLine();
            int curr=0;
            int arr[]=new int[s.length()];
            for(int i=0;i<s.length();i++){
                arr[i]=Character.getNumericValue(s.charAt(i));
            }
            StringBuffer ans=new StringBuffer("");
            int prev=arr[0];
            int depth=arr[0];
            while(prev-->0) ans.append('(');
            ans.append(arr[0]);
            prev=arr[0];
            for(int i=1;i<s.length();i++){
                int temp=Math.abs(arr[i]-depth);
                if(prev<arr[i]){
                    depth+=temp;
                    while(temp-->0) ans.append('(');
                }
                else if(prev>arr[i]){
                    depth-=temp;
                    while(temp-->0) ans.append(')');
                }
                ans.append(arr[i]);
                prev=arr[i];
            }
            while(depth-->0) ans.append(')');
            System.out.println("Case #"+t+":"+" "+ans.toString());
        }
    }
}