import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

  private static Scanner scanner;

  private static void process(int tid) {
    int n = scanner.nextInt();
    BitSet[] bsr = new BitSet[n];
    BitSet[] bsc = new BitSet[n];
    int sm = 0, rc = 0, cc = 0;
    for(int i=0; i<n; i++) {
      bsc[i] = new BitSet(n);
      bsr[i] = new BitSet(n);
    }
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        int cv = scanner.nextInt();
        if(bsr[i] != null) {
          if(bsr[i].get(cv-1)) {
            bsr[i] = null;
            rc++;
          } else {
            bsr[i].set(cv-1);
          }
        }
        if(bsc[j] != null) {
          if(bsc[j].get(cv-1)) {
            bsc[j] = null;
            cc++;
          } else {
            bsc[j].set(cv-1);
          }
        }
        if(i == j) sm += cv;
      }
    }

    System.out.printf("Case #%d: %d %d %d\n", tid, sm, rc, cc);
  }

  public static void main(String[] args) {
    scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scanner.nextInt();
    for(int i=1; i<=t; i++) {
      process(i);
    }
  }

}
