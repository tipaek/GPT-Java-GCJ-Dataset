/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class SolutionGCJ {


    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          int N = in.nextInt();
          Set<String> words_ = new HashSet<>();
          for (int i = 0; i < N; i++) {
            words_.add(in.next());
          }
          List<String> words = new ArrayList<>(words_);

          List<String> prefixes = new ArrayList<>();
          List<String> suffixes = new ArrayList<>();
          for (String word : words) {
            int i = word.indexOf('*');
            int j = word.lastIndexOf('*');
            if (i != 0) prefixes.add(word.substring(0, i));
            if (j != word.length() - 1) suffixes.add(word.substring(j + 1, word.length()));
          }

          Collections.sort(prefixes, (a, b) -> b.length() - a.length());
          Collections.sort(suffixes, (a, b) -> b.length() - a.length());

          String prefix = prefixes.size() != 0 ? prefixes.get(0) : "";
          String suffix = suffixes.size() != 0 ? suffixes.get(0) : "";

          // out.println(prefix + " " + suffix);
          boolean fail = false;

          for (String p : prefixes) {
            if (!prefix.substring(0, p.length()).equals(p)) {
              fail = true;
              break;
            }
          }

          for (String s : suffixes) {
            if (!suffix.substring(suffix.length() - s.length(), suffix.length()).equals(s)) {
              fail = true;
              break;
            }
          }

          String answer = "";
          StringBuilder sb = new StringBuilder();
          if (fail) {
            answer = "*";
          } else {
            sb.append(prefix);
            for (String word : words) {
              String middle = word.substring(word.indexOf('*'), word.lastIndexOf('*'));
              if (middle.length() != 0) {
                sb.append(middle.replace("*", ""));
              }
            }
            sb.append(suffix);
            answer = sb.toString();
          }


          out.println(String.format("Case #%d: %s", test_case + 1, answer));
        }
    }
}


/*******************************************************************************
********************************************************************************
********************************************************************************/


/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		SolutionGCJ solution = new SolutionGCJ();
		solution.solve(in, out);
		out.flush();
		out.close();
	}
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException  e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace();
            System.exit(0);
        }
        return str;
    }
}
