import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution implements CJSolution {

  public static void main(String[] args) {
    new Solution().run();
  }

  Scanner in = null;
  private InputStream inStream;
  private PrintStream outStream;
  private HashMap<String, Long> map;
  private HashMap<Long, String> map2;

  public Solution(InputStream stream) {
    inStream = stream;
    outStream = System.out;
  }

  public Solution() {
    this(System.in);
  }

  @Override
  public void setInput(InputStream inputStream) {
    this.inStream = inputStream;
  }

  @Override
  public void setOutput(PrintStream outputStream) {
    this.outStream = outputStream;
  }

  public void run() {
    Scanner in = null;
    try {
      in = new Scanner(new BufferedReader(new InputStreamReader(inStream)));
      long t = in.nextLong();
      Set<Character> letters = new HashSet<Character>();
      for (int tCase = 1; tCase <= t; ++tCase) {
        long u = in.nextLong();
        in.nextLine();
        String[] qs = new String[10000];
        long[] q = new long[10000];
        String[] r = new String[10000];
        for (int i = 0; i < 10000; ++i) {
          String line = in.nextLine();
          qs[i] = line.split(" ")[0];
          q[i] = Long.valueOf(qs[i]);
          r[i] = line.split(" ")[1];
          for (int j = 0; j < r[i].length(); ++j) {
            letters.add(r[i].charAt(j));
          }
        }

        map = new HashMap<String, Long>();
        map2 = new HashMap<Long, String>();

        long dig = 0;
        char digc = '0';
        for (; dig <= 9; ++dig, ++digc) {
          for (int i = 0; i < 10000; ++i) {
            if (qs[i].charAt(0) == digc) {
              if (r[i].length() == qs[i].length()) {
                if (!contains(r[i], 0))
                  put(r[i], 0, dig);
              }
            }
            if (qs[i].charAt(qs[i].length() - 1) == digc) {
              if (qs[i].length() == 1) {
                if (!contains(r[i], r[i].length() - 1))
                  put(r[i], r[i].length() - 1, dig);
              }
            }
          }
        }
        StringBuilder answer = new StringBuilder("0123456789");
        for (int i = 0; i < 10; ++i) {
          String cs = map2.get(Long.valueOf(answer.substring(i, i + 1)));
          if (cs != null) {
            Character c = cs.charAt(0);
            answer.setCharAt(i, c);
            letters.remove(c);
          }
        }
        for (int i = 0; i < 10; ++i) {
          try {
            Long.valueOf(answer.substring(i, i + 1));
            Iterator<Character> it = letters.iterator();
            Character ch = it.next();
            it.remove();
            answer.setCharAt(i, ch);
          } catch (NumberFormatException e) {
          }
        }

        outStream.println("Case #" + tCase + ": " + answer.toString());
      }

    } finally {
      if (in != null)
        in.close();
    }
  }

  private boolean contains(String string, int i) {
    return map.containsKey(string.substring(i, i + 1));
  }

  private void put(String substring, int pos, long dig2) {
    String key = substring.substring(pos, pos + 1);
    if (map.containsKey(key)) {
      long i = map.get(key);
      if (i != dig2)
        i = 0;
    } else {
      map.put(key, dig2);
      map2.put(dig2, key);
    }
  }

}

interface CJSolution {

  void setInput(InputStream inputStream);

  void setOutput(PrintStream outStream);

  void run();

}
