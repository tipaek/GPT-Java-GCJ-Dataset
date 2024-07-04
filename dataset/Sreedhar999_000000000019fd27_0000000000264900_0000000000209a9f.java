import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String str1=br.readLine();
            Queue<String> q=new LinkedList<String>();
            char[] ar=str1.toCharArray();
            int n=ar.length;
            int[] arr=new int[n];
            
            int i=0;
            
            while(i<n){
                char y=ar[i];
                i++;
                String str2="";
                str2+=String.valueOf(y);
                while(i<n && y==ar[i]){
                    str2+=String.valueOf(y);
                    i++;   
                }
                q.add(str2);
            }
            String str="";
            while(!q.isEmpty()){
                String x=q.poll();
                int x1=(Integer.parseInt(x))%10;
                for(int j=0;j<x1;j++){
                    str+="(";
                }
                str+=x;
                for(int j=0;j<x1;j++){
                    str+=")";
                }
            }
           System.out.println(str); 
        }
    }
}