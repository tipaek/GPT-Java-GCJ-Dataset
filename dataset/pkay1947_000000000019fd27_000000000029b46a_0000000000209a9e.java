import java.util.*;
import java.io.*;

public class Solution {

    static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    static String compl(String s) {
        String st=s.replace('0','2');
        s=st.replace('1','0');
        return s.replace('2','1');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        int B=in.nextInt();
        for (int t=1; t<=T; t++) { 
            if (B==100) {
                return;
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
                Set<String> set=new HashSet<>();
                while (!ver.equals("Y")) {
                    String tmp="";
                    for (int i=1; i<11; i++) {
                        System.out.println(i);
                        tmp+=(char)(in.nextInt() + '0');
                    }
                    for (String s : set) {
                        System.out.println(tmp+s);
                        ver = in.next();
                        if (ver.equals("Y")) break;
                    }
                    set.add(tmp);
                    set.add(rev(tmp));
                    set.add(compl(tmp));
                    set.add(compl(rev(tmp)));                    
                }
            }
        }
    }
}