import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.readLine());

        for (int i = 1; i <= t; i++) {
            String answer = "*";
            Set<String> string = new HashSet();
            boolean flag =false;

            int number = Integer.parseInt(in.readLine());
           for(int j=0;j<number;j++) {
               String line = in.readLine();

               flag = flag || checkIfFileHasExtension(line, string);
               string.add(line.substring(1));
           }
            if(flag)
                answer = getLongestString(string);
            System.out.println("Case #"+i+": "+ answer);
        }

    }
    public static String getLongestString(Set<String> array) {
        int maxLength = 0;
        String longestString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }
    public static boolean checkIfFileHasExtension(String s, Set<String> extn) {
        return extn.stream().allMatch(entry -> s.endsWith(entry));
    }
}
