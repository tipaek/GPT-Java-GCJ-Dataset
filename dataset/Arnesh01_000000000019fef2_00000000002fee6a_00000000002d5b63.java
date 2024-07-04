import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[] =br.readLine().split(" ");
        int T=Integer.parseInt(str[0]);
        StringBuffer sb=new StringBuffer();
        for(int mm=1;mm<=T;mm++){
            boolean found=false;
            for(int i=-5;!found && i<=5;i++){
                for(int j=-5;!found && j<=5;j++){
                    System.out.println(i+" "+j);
                    System.out.flush();
                    String s=br.readLine();
                    if(s.length()==6) found=true;
                }
            }
        }
    }
}
            