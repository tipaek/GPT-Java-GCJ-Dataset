import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static void print(BufferedOutputStream bufferedOutputStream, byte[] bytes) throws IOException {
        bufferedOutputStream.write(bytes);
    }

    private static void buildSDash(char[] ch, int depth, int i, int n, StringBuilder stringBuilder) {
        if(i < n) {
            int curr_num = ch[i] - 48;
            while(curr_num > depth) {
                stringBuilder.append('('); depth++;
            }
            while (curr_num < depth) {
                stringBuilder.append(')'); depth--;
            }
            stringBuilder.append(ch[i]);
            buildSDash(ch, depth, i+1, n, stringBuilder);
        } else while (depth-- > 0) stringBuilder.append(')');
    }

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            String eol = System.getProperty("line.separator");
            byte[] eolb = eol.getBytes();
            String str[] = bufferedReader.readLine().split(" ");
            int testCases = Integer.parseInt(str[0]);
            byte[] testCaseStrBytes = "Case #".getBytes();
            byte[] colSpace = ": ".getBytes();
            byte[] space = " ".getBytes();
            for (int t = 1; t<=testCases; t++) {
                str = bufferedReader.readLine().split(" ");
                char[] chars = str[0].toCharArray();
                int n = chars.length;
                StringBuilder stringBuilder = new StringBuilder();

                buildSDash(chars, 0, 0, n, stringBuilder);

                print(bufferedOutputStream, testCaseStrBytes);
                print(bufferedOutputStream, Integer.toString(t).getBytes());
                print(bufferedOutputStream, colSpace);
                print(bufferedOutputStream, stringBuilder.toString().getBytes());
                print(bufferedOutputStream, eolb);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
