import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int t=1;t<=T;t++){
            String s=br.readLine();
            int len=s.length();
            int depth=0;
            StringBuffer sbs=new StringBuffer();
            for(int i=0;i<len;i++){
                int a=s.charAt(i)-'0';
                if(a>depth){
                    for(int j=1;j<=a-depth;j++) sbs.append("(");
                    depth=a;
                }
                else{
                    for(int j=1;j<=depth-a;j++) sbs.append(")");
                    depth=a;
                }
                sbs.append(a);
            }
            for(int i=1;i<=depth;i++) sbs.append(")");
            sb.append("Case #"+t+": "+sbs+"\n");
        }
        System.out.print(sb);
    }
}