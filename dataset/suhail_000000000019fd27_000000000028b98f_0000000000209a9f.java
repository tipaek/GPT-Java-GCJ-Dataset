import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[]  arr = new String[t];
        HashMap<Integer, String> bracket = new HashMap<>();
        bracket.put(0,"");
        bracket.put(1,"(");
        bracket.put(2,"((");
        bracket.put(3,"(((");
        bracket.put(4,"((((");
        bracket.put(5,"(((((");
        bracket.put(6,"((((((");
        bracket.put(7,"(((((((");
        bracket.put(8,"((((((((");
        bracket.put(9,"(((((((((");
        HashMap<Integer, String> reverse = new HashMap<>();
        reverse.put(0,"");
        reverse.put(1,")");
        reverse.put(2,"))");
        reverse.put(3,")))");
        reverse.put(4,"))))");
        reverse.put(5,")))))");
        reverse.put(6,"))))))");
        reverse.put(7,")))))))");
        reverse.put(8,"))))))))");
        reverse.put(9,")))))))))");
        for (int i = 0; i < t; ++i) {
            arr[i] = in.next();
        }
        int j=1;StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            char[] ch = str.toCharArray();

            sb.append("Case #"+j+": ");
            sb.append(bracket.get(Integer.parseInt(""+ch[0])));
            sb.append(""+ch[0]);
            for(int i = 1; i<ch.length; i++) {
                int diff = (int)ch[i] - (int)ch[i-1];
                System.out.println("diff    "+diff);
                if(diff > 0) {
                    sb.append(bracket.get(diff));
                    sb.append(""+ch[i]);
                }else if(diff < 0) {

                    sb.append(reverse.get(-1*diff));
                    sb.append(""+ch[i]);
                } else{
                    sb.append(""+ch[i]);
                }
            }
            sb.append(reverse.get(Integer.parseInt(""+ch[ch.length-1])));
            sb.append("\n");
            j++;
        }
        System.out.println(sb.toString());
    }
}