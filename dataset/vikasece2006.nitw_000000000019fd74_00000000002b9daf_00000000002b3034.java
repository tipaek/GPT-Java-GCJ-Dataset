


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
            String prefix = ans.substring(0, ans.indexOf('*'));
            String suffix = ans.substring(ans.indexOf('*') + 1);
            for (int index = 1; index < noOfString; index++) {
                String s1 = br.readLine();
                String prefixS1 = s1.substring(0, s1.indexOf('*'));
                String suffixS1 = s1.substring(s1.indexOf('*') + 1);
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
