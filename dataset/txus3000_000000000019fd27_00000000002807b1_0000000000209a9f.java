
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            String origin = in.nextLine();
            String out = origin.chars()
                    .mapToObj(Solution::addpar)
                    .collect(Collectors.joining());
            while(out.indexOf(")(") != -1)
                out = out.replace(")(", "");
            System.out.println("Case #" + i + ": " + out);
        }
    }

    private static String addpar(int c){
        Integer value = Integer.valueOf("" + (char)c);
        String open = "";
        String close = "";
        for(int i=0; i<value; i++) {
            open = open.concat("(");
            close = close.concat(")");
        }
        StringBuilder stringBuilder = new StringBuilder()
                .append(open)
                .append(value)
                .append(close);
        return stringBuilder.toString();
    }
}
