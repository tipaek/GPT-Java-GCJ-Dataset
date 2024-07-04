

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

     String paren(String ip){
        char[] str = ip.toCharArray();
        StringBuilder s =new StringBuilder();
        int count=0;
        for(int i=0;i<ip.length();i++){
            char c=str[i];
            int k=c-'0';
            if(i==0){
                for(int j=0;j<k;j++){
                    s.append('(');
                    count++;
                }
                s.append(c);
            }else{
                int p=str[i-1]-'0';
                int diff=k-p;
                if(diff>=0){
                    for(int j=0;j<diff;j++){
                        s.append('(');
                        count++;
                    }
                    s.append(c);
                }else{
                    diff=Math.abs(diff);
                    for(int j=0;j<diff;j++){
                        s.append(')');
                        count--;
                    }
                    s.append(c);
                }
            }
        }
        for(int i=0;i<count;i++)
            s.append(')');
        return s.toString();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}