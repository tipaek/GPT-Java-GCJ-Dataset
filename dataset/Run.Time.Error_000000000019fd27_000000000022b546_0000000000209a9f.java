
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
static void add(StringBuilder stt, int a, char ch) {
    for(int i=0;i<a;i++) {
        stt.append(ch);
    }
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int k=0; k<T; k++) {
            String N = in.nextLine();
            StringBuilder stt = new StringBuilder();
            int a = N.charAt(0) - '0';
            add(stt, a, '(');
            stt.append(a);
            for(int i=1; i<N.length();i++) 
            {
                int b = N.charAt(i)-'0';
                if (b<a) 
                    add(stt, a-b, ')'); 
                else if (b>a) 
                    add(stt, b-a, '(');
                stt.append(b);
                a=b;
            }
            add(stt, a, ')');
            System.out.println("Case #"+(k+1)+": "+stt.toString());
        }
    }
}