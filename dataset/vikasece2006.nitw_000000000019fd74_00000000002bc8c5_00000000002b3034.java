
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        outer:
        for (int t = 1; t <= test; t++) {
            int noOfString = Integer.parseInt(br.readLine());
            String ans = br.readLine();
            int endIndex = ans.indexOf('*');
            String prefix = null, suffix = null;
            if (endIndex != -1) {
                prefix = ans.substring(0, endIndex);
                suffix = ans.substring(endIndex + 1);
            } else {
                prefix = ans;
                suffix = "";
            }
            for (int index = 1; index < noOfString; index++) {
                String s1 = br.readLine();
                int endIndex1 = s1.indexOf('*');
                String prefixS1 = null;
                String suffixS1 = null;
                if(endIndex1!=-1) {
                     prefixS1 = s1.substring(0, endIndex1);
                     suffixS1 = s1.substring(endIndex1 + 1);
                }else{
                    prefixS1 = s1;
                    suffixS1 ="";
                }
                if (prefixS1.length() > prefix.length()) {
                    if (prefixS1.startsWith(prefix)) {
                        prefix = prefixS1;
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Case #");
                        builder.append(t);
                        builder.append(": ");
                        builder.append("*");
                        System.out.println(builder.toString());
                        continue outer;
                    }
                } else {
                    if (!prefix.startsWith(prefixS1)) {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Case #");
                        builder.append(t);
                        builder.append(": ");
                        builder.append("*");
                        System.out.println(builder.toString());
                        continue outer;
                    }
                }
                if (suffixS1.length() > suffix.length()) {
                    if (suffixS1.endsWith(suffix)) {
                        suffix = suffixS1;
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Case #");
                        builder.append(t);
                        builder.append(": ");
                        builder.append("*");
                        System.out.println(builder.toString());
                        continue outer;
                    }
                } else {
                    if (!suffix.endsWith(suffixS1)) {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Case #");
                        builder.append(t);
                        builder.append(": ");
                        builder.append("*");
                        System.out.println(builder.toString());
                        continue outer;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("Case #");
            builder.append(t);
            builder.append(": ");
            builder.append(prefix);
            builder.append(suffix);
            System.out.println(builder.toString());
        }
    }

    private static int[] getArray(String line) {
        String[] s = line.split(" ");
        int[] array = new int[s.length];
        int index = 0;
        for (String temp : s) {
            array[index++] = Integer.parseInt(temp);
        }
        return array;
    }
}
