import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static StringBuffer rev(StringBuffer str){
        StringBuffer ans=new StringBuffer();
        int len=str.length();
        for(int i=len-1;i>=0;i--) ans.append(str.charAt(i));
        return ans;
    }
    public static StringBuffer com(StringBuffer str){
        StringBuffer ans=new StringBuffer();
        int len=str.length();
        for(int i=0;i<len;i++) ans.append(1-str.charAt(i)+'0');
        return ans;
    }
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
            if(B==20){
                StringBuffer a=new StringBuffer();
                StringBuffer b=new StringBuffer();
                StringBuffer c=new StringBuffer();
                for(int i=1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    a.append(n);
                }
                for(int i=16;i<=20;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    b.append(n);
                }
                for(int i=6;i<=15;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    c.append(n);
                }
                String[] ans=new String[4];
                ans[0]=new String(a+""+c+""+b);
                ans[1]=new String(com(a)+""+c+""+com(b));
                ans[2]=new String(rev(b)+""+c+""+rev(a));
                ans[3]=new String(rev(com(b))+""+c+""+rev(com(a)));
                int i=0;
                char r;
                do{
                    System.out.println(ans[i]);
                    System.out.flush();
                    i++;
                    r=br.readLine().charAt(0);
                }while(r=='N' && i<=3);
            }
        }
    }
}