import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            String cases = in.nextLine();
            String solutions = helper(cases);
            System.out.println("Case #" + i + ": "+ solutions);
        }
    }

    private static String helper(String cases) {
        String result = "";
        int count;
        boolean first = false;
        int previous = 0;
        int diff;
        for(int i = 0;i < cases.length();i++){
            char temp = cases.charAt(i);
            count = temp - '0';
            if(!first) {
                previous = count;
                for (int a = 0; a < count; a++) {
                    result = result + "(";
                }
                result = result + count;
                first = true;
            }
            if(i > 0){
                if(count > previous){
                    diff = count - previous;
                    for(int b = 0;b<diff;b++){
                        result = result + "(";
                    }
                    result = result + count;
                    previous = count;
                }else{
                    diff = previous - count;
                    for(int c = 0;c<diff;c++){
                        result = result + ")";
                    }
                    result = result + count;
                    previous = count;
                }
            }
        }
        if(previous != 0){
            for(int d = 0;d<previous;d++){
                result = result + ")";
            }
        }
        return result;
    }
}


