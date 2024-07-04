import java.util.regex.*;
import java.io.*;

public class newfile {
   public static void main(String[] args) throws IOException {
      Pattern p1 = Pattern.compile("[A-Za-z][a-z]+");
      BufferedReader r = new BufferedReader(new FileReader("os.java"));
      String line;
      
      while ((line = r.readLine()) != null) {
         Matcher m = p1.matcher(line);
         while (m.find()) {
            System.out.println(m.group(0));
            int s1 = m.start(0);
            int e1 = m.end(0);
            System.out.println(line.substring(s1, e1));
         }
      }
   }
}