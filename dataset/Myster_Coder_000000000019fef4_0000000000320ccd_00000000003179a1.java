import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t,u,mi, qi;
        t=Integer.parseInt(in.readLine());
        for(int a=1;a<=t;a++){
            u=Integer.parseInt(in.readLine());
            ArrayList<Character> key=new ArrayList<>();
            for(int b=0;b<10000;b++){
                String str[]=in.readLine().split(" ");
                int len=str[1].length();
                for(int c=0;c<len;c++){
                    char ch=str[1].charAt(c);
                    if(!key.contains(ch))
                        key.add(ch);
                }
            }
            String ans="";
            for(char ch: key){
                ans+=ch;
            }
            out.println("Case #"+a+": "+ans);
        }
        out.close();
    }
}
