import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

        int cases = sc.nextInt();
        int bitcount = sc.nextInt();
x:        for (int cs = 1; cs <= cases; cs++) {
            char[] state = new char[bitcount];
            Arrays.fill(state, '.');
            for (int i = 0; i < 5; i++) {
                state[i]=get(i, sc);
                state[bitcount-i-1]=get(bitcount-i-1, sc);
            }
            int sameIndex = -1;
            int diffIndex = -1;
            for (int q = 0, p = 5; p<bitcount/2; p++, q+=2) {
                if (q%10 == 0) {
                    if (sameIndex<0) {
                        for (int i = 0; i < p; i++) if (state[i] == state[bitcount-i-1]) {
                            sameIndex = i;
                            break;
                        }
                    }
                    if (diffIndex<0) {
                        for (int i = 0; i < p; i++) if (state[i] != state[bitcount-i-1]) {
                            diffIndex = i;
                            break;
                        }
                    }
                    boolean inverse = false;
                    boolean reverse = false;
                    if (sameIndex>=0) inverse = state[sameIndex] != get(sameIndex, sc); else get(0, sc);
                    if (inverse) for (int i =0; i < bitcount; i++) if (state[i]=='1') state[i]='0'; else if (state[i]=='0') state[i]='1';
                    if (diffIndex>=0) reverse = state[diffIndex] != get(diffIndex, sc); else get(0, sc);
                    if (reverse) for (int i = 0; i < bitcount/2; i++) { char t = state[i]; state[i]=state[bitcount-1-i];state[bitcount-1-i] = t; }
                    q+=2;
                }
                state[p]=get(p, sc);
                state[bitcount-p-1]=get(bitcount-p-1, sc);
            }
            System.out.println(state);
            if (!sc.next().equals("Y")) throw new RuntimeException();
        }
    }

    private static char get(int index, Scanner sc) {
        System.out.println((index+1)); System.out.flush();
        String v = sc.next();
        if("N".equals(v)) throw new RuntimeException();
        if (v.length()>1) throw new RuntimeException();
        return v.charAt(0);
    }
}
