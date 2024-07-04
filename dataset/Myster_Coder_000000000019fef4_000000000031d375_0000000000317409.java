import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t,x,y;
        String m;
        t=Integer.parseInt(in.readLine());
        for(int a=0;a<t;a++){
            String str[]=in.readLine().split(" ");
            x=Integer.parseInt(str[0]);
            y=Integer.parseInt(str[1]);
            m=str[2];
            long time=-1;
            int cX=x, cY=y;
            int len=m.length();
            if(!(x==0 && y==0)) {
                for (int b = 0; b < len; b++) {
                    char ch = m.charAt(b);
                    if (ch == 'N')
                        cY++;
                    else if (ch == 'S')
                        cY--;
                    else if (ch == 'W')
                        cX--;
                    else
                        cX++;
                    if(Math.abs(cX)+Math.abs(cY)<=(b+1)){
                        time=b+1;
                        break;
                    }
//                    else if(cX+cY<b+1){
//                        int diff=(b+1)-(cX+cY);
//                        time=(b+1)-(diff/2);
//                        break;
//                    }
                }
            }
            else
                time=0;
            if(time!=-1)
                out.println("Case #"+(a+1)+": "+time);
            else
                out.println("Case #"+(a+1)+": IMPOSSIBLE");
        }
        out.close();
    }
}
