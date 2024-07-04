import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String cases = in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String caseses = in.nextLine();
            String solutions = helper(caseses);
            System.out.println("Case #" + i + ": "+ solutions);
        }
    }

    private static String helper(String cases) {
        String result = "";
        int count = 0;
        for(int i = 0;i < cases.length();i++){
            if(cases.charAt(i) == '1'){
                count++;
            }else{
                if(count != 0){
                    result = result + "(";
                    for(int a =0;a<count;a++){
                        result = result + "1";
                    }
                    result = result + ")";
                    count = 0;
                    result = result + "0";
                }else{
                    result = result + "0";
                }
            }
        }
        if(count != 0){
            result = result + "(";
            for(int a =0;a<count;a++){
                result = result + "1";
            }
            result = result + ")";
        }
        return result;
    }
}