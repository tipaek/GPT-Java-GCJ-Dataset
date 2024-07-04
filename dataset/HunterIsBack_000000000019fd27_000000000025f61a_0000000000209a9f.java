

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

class Solution     {

    Scanner             sc;
    static final String FILENAME = "A-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;


    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));

        int[][] matrix ;
        sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            String input =  sc.nextLine();
            String result = solve(input);
            System.out.println("Case #" + i + ": "+result);
        }
        sc.close();
        out.close();
    }

    private String solve(String input) {
        char[] ip = input.toCharArray();
        StringBuilder stb = new StringBuilder();
        int first= Character. getNumericValue(ip[0]);
        if(first>0) {
            build(first, stb, false);
            stb.append(first);
        }else {
            stb.append(first);
        }
        for(int i=1;i<input.length();i++){
            int temp = Character. getNumericValue(ip[i]);
            int prev =Character. getNumericValue(ip[i-1]);
            if(temp>0 && ip[i-1]!=ip[i]){
                build(temp,stb,false);
                stb.append(temp);
            }else if(ip[i]=='0' && ip[i-1]!='0'){
                build(prev,stb,true);
                stb.append(ip[i]);
            }else {
                build(prev-1,stb,true);
                stb.append(ip[i]);
                build(prev-1,stb,false);
            }
        }
        int last= Character. getNumericValue(ip[ip.length-1]);

        if(last>1 && ip.length!=1) {
            build(last-1,stb,true);
        }else{
            build(last,stb,true);
        }
        return stb.toString();

    }

    private void build(Integer valueOf, StringBuilder stb,boolean flag) {

        if(flag){
            for (int i = 0; i < valueOf; i++) {
                stb.append(")");
            }
        }
        else {
            for (int i = 0; i < valueOf; i++) {
                stb.append("(");
            }
        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}