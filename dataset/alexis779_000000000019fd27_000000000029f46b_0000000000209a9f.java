import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
   private static final char ZERO = '0';

   public static void main(String[] args) throws Exception {
      InputStream inputStream = System.in;
      //InputStream inputStream = new FileInputStream(new File("NestingDepth"));
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      String[] tokens;
      tokens = bufferedReader.readLine().split(" ");
      int T = Integer.parseInt(tokens[0]);
      for (int t = 1; t <= T; t++) {
         String S = bufferedReader.readLine();
         Solution nestingDepth = new Solution(S);
         bufferedWriter.write("Case #" + t + ": " + nestingDepth.S2);
         bufferedWriter.newLine();
      }
      bufferedWriter.flush();
   }

   /**
    * original string
    */
   String S;

   /**
    * nested string
    */
   String S2;

   public Solution(String S) {
      this.S = S;

      int level = 0;
      int digit = 0;

      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < S.length(); i++) {
         char c = S.charAt(i);
         digit = c - ZERO;
         addParenthesis(stringBuffer, digit, level);
         stringBuffer.append(c);
         level = digit;
      }
      digit = 0;
      addParenthesis(stringBuffer, digit, level);

      S2 = stringBuffer.toString();
   }

   private void addParenthesis(StringBuffer stringBuffer, int digit, int level) {
      if (digit > level) {
         int n = digit - level;
         for (int i = 0; i < n; i++) {
            stringBuffer.append('(');
         }
      } else if (digit < level) {
         int n = level - digit;
         for (int i = 0; i < n; i++) {
            stringBuffer.append(')');
         }
      }
   }


}
