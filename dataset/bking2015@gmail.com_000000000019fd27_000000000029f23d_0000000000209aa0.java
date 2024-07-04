/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class SolutionGCJ {
  PrintWriter out;

    public void solve(FastReader in, PrintWriter out) {
        this.out = out;
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          int N = in.nextInt();
          int trace = in.nextInt();
          if (trace > N * N || trace < N || trace == N+1 || trace == N*N-1) {
            out.println(String.format("Case #%d: IMPOSSIBLE", test_case + 1));
            continue;
          }

          int M = trace / N;
          if (M*N == trace) {
              square(M, N, test_case, standardOrder(N, M), false);
              continue;
          }

          if (trace > ((N+1) / 2)*(N)) {
            M++;
          }

          if (M*N - 1 == trace) {
            M++;
          }

          if (M*N + 1 == trace) {
            M--;
          }

          if (M > (N+1)/2) {
            square(M, N, test_case, bigOrder(N, M, trace), true);
          } else {
            square(M, N, test_case, smallOrder(N, M, trace), true);
          }
        }
    }

    public List<Integer> bigOrder(int N, int M, int trace) {
      List<Integer> order = new ArrayList<>();
      int diff = N*M - trace;
      int a = M;
      int b = M;
      int x = 0;
      while (x < diff) {
        if (a != 1) {
          a--; x++;
        } else {
          b--; x++;
        }
      }
      order = standardOrder(N, M);

      // out.println(order);
      //
      // out.println(a + " " +  b);

      int i = find(order, a); int j = find(order, b);
      swap(order, i, 1);
      swap(order, j, order.size() - 1);
      return order;
    }

    public List<Integer> smallOrder(int N, int M, int trace) {
      List<Integer> order = new ArrayList<>();
      int diff = trace - N*M;
      int a = M;
      int b = M;
      int x = 0;
      while (x < diff) {
        if (a != N) {
          a++; x++;
        } else {
          b++; x++;
        }
      }

      order = standardOrder(N, M);
      int i = find(order, a); int j = find(order, b);
      swap(order, i, 1);
      swap(order, j, order.size() - 1);
      return order;
    }

    public List<Integer> standardOrder(int N, int M) {
      List<Integer> order = new ArrayList<>();
      order.add(M);
      int i = M % N;
      while (i != (M+N-1) % N) {
        order.add(i+1);
        i = (i+1) % N;
      }
      return order;
    }

    public void square(int M, int N, int test_case, List<Integer> order, boolean swap) {

      reverse(order);

      List<List<Integer>> ret = fromList(order);

      for (List<Integer> l : ret) {
        reverse(l);
      }

      if (swap) {
        List<Integer> tmp = ret.get(0);
        ret.set(0, ret.get(1));
        ret.set(1, tmp);
      }


      out.println(String.format("Case #%d: POSSIBLE", test_case + 1));
      for (List<Integer> l : ret) {
        for (int j : l) {
          out.print(j + " ");
        }
        out.println();
      }
      out.println();
    }

    public List<List<Integer>> fromList(List<Integer> arr) {
      List<List<Integer>> output = new ArrayList<>();
      int N = arr.size();

      for (int j = 0; j < N; j++) {
        output.add(new ArrayList<>());
      }

      for (int j = 0; j < N; j++) {
        output.get(j).add(arr.get(j));
        int i = (j+1) % arr.size();
        while (i != j) {
          output.get(j).add(arr.get(i));
          i = (i + 1) % arr.size();
        }
      }

      return output;
    }

    public void reverse(List<Integer> list) {
      for (int i = 0; i < list.size() / 2; i++) {
        swap(list, i, list.size() - 1 - i);
      }
    }

    public void swap(List<Integer> list, int i, int j) {
      int tmp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, tmp);
    }

    public int find(List<Integer> list, int t) {
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == t) {
          return i;
        }
      }
      return -1;
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
