import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        int temp=1;
        while(T-->0){
            String stri=br.readLine();
            int[] arr=new int[stri.length()];
            for(int i=0;i<arr.length;i++){
                arr[i]=Character.getNumericValue(stri.charAt(i));
            }
            String ans=new String("");
            int b=arr[0];
            int prev=arr[0];
            int z=arr[0];
            while(z-->0)
                ans+="(";
            ans+=arr[0];
            for(int i=1;i<arr.length;i++){
                int k=Math.abs(arr[i]-b);
                if(prev<arr[i]){
                    b+=k;
                    while(k-->0)
                        ans+="(";
                }
                else{
                    b-=k;
                    while(k-->0)
                        ans+=")";
                }
                ans+=arr[i];
                prev=arr[i];
            }
            while(b-->0)
                ans+=")";
            bw.write("Case #"+(temp++)+":"+" "+ans+"\n");
        }
        bw.flush();
    }
}