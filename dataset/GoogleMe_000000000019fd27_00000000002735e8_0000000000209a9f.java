import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tN = in.nextInt();
        for (int t = 1;t<=tN;t++) {
            String s  =  in.next();
            StringBuilder build = new StringBuilder();
boolean isOpen = false;
            for(int i = 0;i<s.length();i++) {
                if(s.charAt(i)=='0') {
                    if(isOpen) {
                        build.append(")0");
                        isOpen = false;
                    } else {
                        build.append('0');
                    }
                } else {
                    if(isOpen) {
                        build.append('1');
                    } else {
                        build.append("(1");
                        isOpen = true;
                    }
                }
            }

            if(isOpen) {
                build.append(")");
            }

            System.out.println("Case #" + t + ": " + build.toString());

        }
    }
}

