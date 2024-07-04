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
            if(B==10){
                StringBuffer sb=new StringBuffer();
                for(int i=1;i<=B;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                char ch=br.readLine().charAt(0);
            }
        }
    }
}