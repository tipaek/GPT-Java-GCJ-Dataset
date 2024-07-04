import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for(int i=1; i<=T; i++) {
            int N = input.nextInt();
            input.nextLine();
            String begin = "";
            String end = "";
            boolean works = true;
            for(int j=0; j<N; j++) {
                String str = "";
                String str1 = "";
                String line = input.nextLine();
                for(int k=0; k<line.length(); k++) {
                    if(line.charAt(k)=='*') break;
                    else {
                        str = str+line.charAt(k);
                    }
                }
                for(int k=line.length()-1; k>=0; k--) {
                    if(line.charAt(k)=='*') break;
                    else {
                        str1 = str1+line.charAt(k);
                    }
                }
                String copystring = "";
                for(int k=0; k<str1.length(); k++) {
                    copystring+=str1.charAt(str1.length()-k-1);
                }
                boolean istrue = true;
                if(begin.length()<str.length()&&!str.contains(begin)) {
                    istrue = false;
                }
                else if(begin.length()>=str.length()&&!begin.contains(str)) {
                    istrue = false;
                }
                else if(end.length()<copystring.length()&&!copystring.contains(end)) {
                    istrue = false;
                }
                else if(end.length()>=copystring.length()&&!end.contains(copystring)) {
                    istrue = false;
                }
                if(istrue == false) {
                    works = false;
                    break;
                }
                if(begin.length()<str.length()) {
                    begin = str;
                }
                if(end.length()<copystring.length()) {
                    end = copystring;
                }
            }
            if(works==false) System.out.println("Case #" + i + ": " + "*");
            else {
                System.out.println("Case #" + i + ": " + begin+end);
            }
        }
    }
}