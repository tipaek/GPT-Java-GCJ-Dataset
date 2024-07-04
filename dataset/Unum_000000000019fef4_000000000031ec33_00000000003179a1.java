import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static class Nice69 {
        char c;
        long x;

        public Nice69(char c, long x) {
            this.c = c;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        //R in = new R();
        Scanner in = new Scanner(System.in);
        int TESTCASES = in.nextInt();
        StringBuilder out = new StringBuilder();
        // use longs
        for (int TC = 0; TC < TESTCASES; TC++) {
            in.nextInt();

            long[] occ = new long[26];
            for (int i = 0; i < 10000; i++) {
                in.nextLong();
                String Ri = in.next();
                char c = Ri.charAt(0);
                if (c<'A' || c>'Z') continue;
                occ[c-'A']+=69420;
                for (int j = 1; j < Ri.length(); j++) {
                    c=Ri.charAt(j);
                    occ[c-'A']+=1;// hack for 0
                }
            }
            Nice69[] arr = new Nice69[26];
            for (int i = 0; i < 26; i++) {
                arr[i] = new Nice69((char) ('A'+i), occ[i]);
            }
            Arrays.sort(arr, (a,b)-> (b.x-a.x)==0?0:(b.x-a.x<0?-1:1));
            char[] blah = new char[10];
            for (int i = 0; i < 9; i++) {
                blah[i+1]=arr[i].c;
            }
            blah[0] = arr[9].c;
            out.append("Case #").append(TC+1).append(": ").append(new String(blah)).append('\n');
        }
        System.out.print(out);
        System.out.flush();
    }
}


//bruteforce all string tingys
// or benfords law ezzzzzz
/*
                if (Qi==1) {
                    //theNumberOne = Ri.charAt(0);
                    //assert (Ri.length()==1);
                    //foundTheNumberOne=true;
                }
*/