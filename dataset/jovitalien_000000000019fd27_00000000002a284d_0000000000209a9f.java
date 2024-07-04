import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        List<String> output = new ArrayList<String>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= tests; ++i) {
            String line = in.nextLine();
            int[] digits = new int[line.length()];
            digits = lineToIntArray(line);
            int opened = 0;
            StringBuffer newLine = new StringBuffer();
            newLine.append("Case #");
            newLine.append(i);
            newLine.append(": ");
            for (int index = 0; index < digits.length; index++) {
                int num = digits[index];
                if (opened == num) {
                    newLine.append(num);
                }
                else if (opened > num) {
                    int limit = opened - num;
                    for (int j = 0; j < limit; j++) {
                        newLine.append(")");
                        opened--;
                    }
                    newLine.append(num);
                }
                else {
                    int limit = num - opened;
                    for (int j = 0; j < limit; j++) {
                        newLine.append("(");
                        opened++;
                    }
                    newLine.append(num);
                }
            }
            for (int j = 0; j < opened; j++) {
                newLine.append(")");
            }
            output.add(newLine.toString());
        }
        for(String s : output)
            System.out.println(s);
    }
    
    private static int[] lineToIntArray(String line) {
        return Arrays.asList(line.split("")).stream().mapToInt(Integer::parseInt).toArray();
    }
}