import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int T=Integer.parseInt(str[0]);
        int B=Integer.parseInt(str[1]);
        for(int t=1;t<=T;t++){
            int[] arr=new int[B];
            int i=1;
            for(int count=1;i<=B;count++){
                if(count%10==1){
                    System.out.println("1");
                    System.out.flush();
                    br.readLine();
                }
                else{
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    arr[i-1]=n;
                    i++;
                }
            }
            StringBuffer sb=new StringBuffer();
            for(i=0;i<B;i++) sb.append(arr[i]);
            System.out.println(sb);
            System.out.flush();
            char ch=br.readLine().charAt(0);
            if(ch=='N') break;
        }
    }
}