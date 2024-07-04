import java.util.*;
import java.io.*;

public class Solution {

    static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    static String compl(String s) {
        String st=s.replace('0','2');
        st=st.replace('1','0');
        return st.replace('2','1');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        int B=in.nextInt();
        for (int t=1; t<=T; t++) {            
            if (B==100) {
                continue;
            }
            if (B==10) {
                String tmp="";
                for (int i=1; i<11; i++) {                
                    System.out.println(i);
                    tmp+=(char)(in.nextInt() + '0');
                }
                System.out.println(tmp); // base case
                in.next();
            } else {
                String ver="N";
                String prev=null;
                while (!ver.equals("Y")) {
                    String tmp="";
                    for (int i=1; i<11; i++) {
                        System.out.println(i);
                        tmp+=(char)(in.nextInt() + '0');
                    }
                    if (prev!=null) {
                        System.out.println(tmp+prev); // not sure
                        ver = in.next();
                        if (ver.equals("N")) {
                            System.out.println(tmp+rev(prev)); // r
                            ver = in.next();
                            if (ver.equals("N")) {
                                System.out.println(tmp+compl(prev)); // c
                                ver = in.next();
                                if (ver.equals("N")) {
                                    System.out.println(tmp+rev(compl(prev))); // r, rc
                                    ver = in.next();
                                }
                            }
                        }
                    }
                    prev=tmp;
                }
            }
        }
    }
}