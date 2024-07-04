import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


//********************************************************************************************************
//********************************************************************************************************
public class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;
  
  static int u;
  static char[] line;
  
  static int board[][];
  
  public static void main(String[] args) {
    t = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  // ***************************************************************************
  // INPUT
  // ***************************************************************************
  static String[] text = new String[10000];
  static int[] r = new int[10000];
  
  static int[] id = new int[10000];
  
  static char[] answer = new char[10];
  
  static void prb() {
    read();
    
    HashSet<Character> set = new HashSet();

    for(int i = 0; i != 10; i++) {
      for(int j = 0; j != 10000; j++) {
        int idx = id[j];
        int h = r[idx];
        String nbr = text[idx];
        int sz = nbr.length() - 1;
        
        int log = log(h);
        if (h % 10 == i && sz == log && !set.contains(nbr.charAt(log))) {
          set.add(nbr.charAt(log));
          answer[i] = nbr.charAt(log);
          break;
        }
      }
    }
    
    System.out.printf("Case #%d: ", num);
    for(int i = 0; i != 10; i++) {
      System.out.print(answer[i]);
    }
    System.out.printf("\n");
  }
  
  static int log(int x) {
    int i = 0;
    while(x != 0) {
      x /= 10;
      i++;
    }
    return i;
  }
  
  static void read() {
    u = scanner.nextInt();
    
    for (int i = 0; i != 10000; i++) {
      id[i] = i;
      r[i] = scanner.nextInt();
      text[i]  = scanner.nextLine();
    }
    
    sort(id, 0, 10000, Solution::less);
  }
  
  static boolean less(int[] t, int x, int y) {
    int idx = id[x];
    int jdx = id[y];
    return r[idx] < r[jdx];
  }
  
  // *************************************************************
  // SORT
  // *************************************************************
  static int[] index1 = new int[10000];
  static int[] index2 = new int[10000];

  static void sort(int[] t, int idx, int jdx, Cmp c) {
    if (jdx - idx > 1) {
      int m = idx + (jdx - idx) / 2;
      sort(t, idx, m, c);
      sort(t, m, jdx, c);
      merge(t, idx, m, jdx, c);
      copy(t, idx, jdx);
    }
  }

  static void merge(int[] t, int idx, int m, int jdx, Cmp c) {
    int i = idx;
    int j = m;
    int k = idx;

    while (i != m && j != jdx) {
      boolean cnd = c.less(t, i, j);
      if (cnd) {
        index1[k] = t[i];
        i++;
      } else {
        index1[k] = t[j];
        j++;
      }
      k++;
    }

    while (i != m) {
      index1[k] = t[i];
      i++;
      k++;
    }

    while (j != jdx) {
      index1[k] = t[j];
      j++;
      k++;
    }
  }

  static void copy(int t[], int idx, int jdx) {
    while (idx != jdx) {
      t[idx] = index1[idx];
      index2[t[idx]] = idx;
      idx++;
    }
  }

  @FunctionalInterface
  interface Cmp {
    boolean less(int[] t, int x, int y);
  }
}