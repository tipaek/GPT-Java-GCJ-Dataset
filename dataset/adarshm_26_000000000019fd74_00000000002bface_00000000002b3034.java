import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
  public static void main(String[] args) throws IOException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    ArrayList<String> mids = new ArrayList<>();
    int t, n;
    boolean fnd;
    String[] ptr;
    StringBuffer strbuf, tbuf, strbufend;
    t = in.nextInt();
    for (int x = 1; x <= t; x++) {
      n = in.nextInt();
      ptr = new String[n];
      fnd = false;
      strbuf = new StringBuffer();
      strbufend = new StringBuffer();
      for (int i = 0; i < n; i++) ptr[i] = in.next();
      for (int i = 0; i < n; i++) {
        if(fnd) break;
        int fst = 0, lst = 0;
        for (int j = 0; j < ptr[i].length(); j++) {
          if(ptr[i].charAt(j) == '*') {
            fst = j;
            break;
          }
        }
        for (int j = ptr[i].length() - 1; j >= 0; j--) {
          if(ptr[i].charAt(j) == '*') {
            lst = j;
            break;
          }
        }
        tbuf = new StringBuffer();
        int tmp = 0;
        while(tmp < fst) tbuf.append(ptr[i].charAt(tmp++));
        for (int j = 0; j < Math.min(strbuf.length(), tbuf.length()); j++) {
          if(strbuf.charAt(j) != tbuf.charAt(j)) {
            fnd = true;
            break;
          }
        }
        if(strbuf.length() < tbuf.length()) strbuf = tbuf;
        tbuf = new StringBuffer();
        tmp = ptr[i].length() - 1;
        while(tmp > lst) tbuf.append(ptr[i].charAt(tmp--));
        for (int j = 0; j < Math.min(strbufend.length(), tbuf.length()); j++) {
          if(strbufend.charAt(j) != tbuf.charAt(j)) {
            fnd = true;
            break;
          }
        }
        if(strbufend.length() < tbuf.length()) strbufend = tbuf;
        tmp = fst;
        tbuf = new StringBuffer();
        while(tmp < lst) {
          if(ptr[i].charAt(tmp) != '*') tbuf.append(ptr[i].charAt(tmp));
          tmp++;
        }
        mids.add(tbuf.toString());
      }
      if(fnd) pw.println("Case #" + x + ": *");
      else {
        tbuf = new StringBuffer();
        tbuf.append(strbuf);
        for (String a : mids) {
          if(tbuf.length() + strbufend.length() > 10000) break;
          tbuf.append(a);
        }
        tbuf.append(strbufend.reverse().toString());
        pw.println("Case #" + x + ": " + tbuf.toString());
      }
    }
    pw.close();
  }

  static class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader(InputStream inputStream) {
      br = new BufferedReader(new InputStreamReader(inputStream));
      st = null;
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
