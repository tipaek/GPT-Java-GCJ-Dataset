import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
    public static long mod(long a,long b){
        long ans=a%b;
        if(ans<0) ans+=b;
        return ans;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int mm=1;mm<=T;mm++){
            String str[] =br.readLine().split(" ");
            long X=Long.parseLong(str[0]);
            long Y=Long.parseLong(str[1]);
            StringBuffer s=new StringBuffer();
            long p=1;
            for(int i=1;X!=0 || Y!=0;i++){
                p=p+p;
                long j=p/2;
                if(mod(X,p)==mod(Y,p)){
                    s=new StringBuffer();
                    s.append("IMPOSSIBLE");
                    break;
                }
                else{
                    if(mod(X,p)==j){
                        if(Y==0 && X==j){
                            s.append('E');
                            break;
                        }
                        else if(Y==0 && X+j==0){
                            s.append('W');
                            break;
                        }
                        if(mod(X-j,2*p)!=mod(Y,2*p)){
                            s.append('E');
                            X-=j;
                        }
                        else {
                            s.append('W');
                            X+=j;
                        }
                    }
                    else{
                        if(X==0 && Y==j){
                            s.append('N');
                            break;
                        }
                        else if(X==0 && Y+j==0){
                            s.append('S');
                            break;
                        }
                        if(mod(X,2*p)!=mod(Y-j,2*p)){
                            s.append('N');
                            Y-=j;
                        }
                        else {
                            s.append('S');
                            Y+=j;
                        }
                    }
                }
            }
            sb.append("Case #"+mm+": ");
            sb.append(s);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
            