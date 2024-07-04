import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;

public class Solution {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    /*
    List<Future<Integer>> result = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    for (int i=0; i<T; i++) {
      R1A_A solver = new R1A_A();
      solver.read(in, i+1);
      result.add(executorService.submit(solver));
    }
    for (int i=1; i<=T; i++) {
      System.out.println("Case #" + i + ": " + result.get(i-1).get());
    }
    executorService.shutdown();

     */
    int B = in.nextInt();
    for (int i=0; i<T; i++) {
      Q4 solver = new Q4();
      solver.read(in, B);
      //System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class Q4 implements Callable<String> {
  int B;
  String result;

  void read(Scanner in, int B) {
    this.B = B;
    interactive(in);
  }

  void interactive(Scanner in) {
    List<List<Integer>> bits = new ArrayList<>();
    bits.add(new ArrayList<>());
    bits.add(new ArrayList<>());
    BitSet cur = new BitSet(B);

    for (int i=0, l=0; l<B/2; i+=2) {
      if (i%10 == 0 && i>0) {
        for (int j=0; j<2; j++) {
          if (!bits.get(j).isEmpty()) {
            boolean val = getBit(in, bits.get(j).get(0)+1);
            if (val != cur.get(bits.get(j).get(0))) {
              for (Integer index : bits.get(j)) {
                cur.flip(index);
              }
            }
          } else {
            getBit(in, 1);
          }
        }
      } else {
        boolean val1 = getBit(in, l+1);
        boolean val2 = getBit(in, B-l);
        cur.set(l, val1);
        cur.set(B-l-1, val2);
        if (val1 == val2) {
          bits.get(0).add(l);
          bits.get(0).add(B-l-1);
        } else {
          bits.get(1).add(l);
          bits.get(1).add(B-l-1);
        }
        l++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<B; i++) {
      sb.append(cur.get(i) ? '1' : '0');
    }
    System.out.println(sb.toString());
    System.out.flush();
    String result = in.next();
    if (!result.equalsIgnoreCase("Y")) {
      throw new RuntimeException();
    }
  }

  boolean getBit(Scanner in, int position) {
    System.out.println(position);
    System.out.flush();
    int val = in.nextInt();
//    in.nextLine();
    if (val > 1) {
      throw new RuntimeException();
    }
    return val == 1;
  }

  @Override
  public String call() throws Exception {
    return result;
  }
}