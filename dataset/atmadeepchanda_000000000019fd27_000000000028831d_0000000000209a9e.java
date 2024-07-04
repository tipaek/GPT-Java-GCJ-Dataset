import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    
    
    
    public static boolean e(StringBuffer a,StringBuffer b){
        for(int i=0;i<5;i++)
            if(a.charAt(i)!=b.charAt(i)) return false;
        return true;
    }
    
    
    public static StringBuffer com(StringBuffer str){
        StringBuffer answer=new StringBuffer();
        int len=str.length();
        for(int i=0;i<len;i++) answer.append(1-str.charAt(i)+'0');
        return answer;
    }
    public static StringBuffer rev(StringBuffer str){
        StringBuffer answer=new StringBuffer();
        int len=str.length();
        for(int i=len-1;i>=0;i--) answer.append(str.charAt(i));
        return answer;
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
                StringBuffer d=new StringBuffer();
                StringBuffer e=new StringBuffer();
                StringBuffer f=new StringBuffer();
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
                for(int i=6;i<=10;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    c.append(n);
                }
                for(int i=11;i<=15;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    d.append(n);
                }
                for(int i=1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    e.append(n);
                }
                for(int i=6;i<=10;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    f.append(n);
                }
                
                StringBuffer c1=com(c);
                
                StringBuffer c2=rev(d);
                
                StringBuffer c3=com(c2);
                
                StringBuffer a1=com(a);
                
                StringBuffer a2=rev(b);
                
                StringBuffer a3=com(a2);
                
                StringBuffer answer=new StringBuffer();
                
                if(e(c,f)) answer.append(c+""+d);
                
                else if(e(c1,f)) answer.append(c1+""+com(d));
                
                else if(e(c2,f)) answer.append(c2+""+rev(c));
                
                else answer.append(c3+""+com(rev(c)));
                
                if(e(a,e)) System.out.println(a+""+answer+""+b);
                
                else if(e(a1,e)) System.out.println(a1+""+answer+""+com(b));
                
                else if(e(a2,e)) System.out.println(a2+""+answer+""+rev(a));
                
                else System.out.println(a3+""+answer+""+com(rev(a)));
                
                br.readLine();
            }
        }
    }
}