import java.util.*;
    import java.io.*;
    public class Solution {
        public static void main (String[]args)
    {
        Scanner in = new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        int test = in.nextInt ();
        in.nextLine ();
        for(int t = 1; t <= test; t++){
            String s = in.nextLine ();
            String op= "";
            String cp= "";
            for(int i = 1; i<10; i++){
                op += "(";
                cp += ")";
                s = s.replace(""+i,op+i+cp);
                s = s.replace(")(","");
            }
            System.out.println ("Case #"+t + ": " + s);
        }
    }
        }