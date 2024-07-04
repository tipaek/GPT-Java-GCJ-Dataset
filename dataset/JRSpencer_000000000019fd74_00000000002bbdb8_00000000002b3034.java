import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];

            for (int j = 0; j < n; j++) {
                String string = in.next();
                prefixes[j] = string.split("\\*")[0];
                if (string.endsWith("*")){
                    suffixes[j]= "";
                } else {
                    suffixes[j] = string.split("\\*")[1];
                }
            }
            String prefix = prefixes[0];
            String suffix = suffixes[0];
            for (int j = 1; j < n; j++) {
                String newPrefix = prefixes[j];
                String newSuffix = suffixes[j];

                if (prefix.startsWith(newPrefix)){
                    // Do Nothing
                }
                else if(newPrefix.startsWith(prefix)){
                    prefix = newPrefix;
                }
                else{
                    prefix = "*";
                }
                if (suffix.endsWith(newSuffix)){
                    continue;
                }
                else if(newSuffix.endsWith(suffix)){
                    suffix = newSuffix;
                }
                else{
                    suffix = "*";
                }
            }

            if (prefix.endsWith(suffix)){
                suffix = "";
            }
            if( prefix.isEmpty() && suffix.isEmpty()){
                prefix = "*";
            }
            System.out.println(String.format("Case #%d: %s", i, prefix+suffix));
        }
    }
}
