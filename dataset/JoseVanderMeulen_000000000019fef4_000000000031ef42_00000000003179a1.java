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
    
    HashSet<Character> set  = new HashSet();
    int max = -1;
    for(int i = 0; i != 10000; i++) {
      int idx = id[i];
      int h = r[idx];
      String t = text[idx];
      
      char c = t.charAt(1);
      if (h < 10 && h > max && !set.contains(c)) {
        max = h;
        answer[max] = c;
        set.add(c);
        continue;
      }
      
      if (t.length() < 3) {
        continue;
      }
      
      c = t.charAt(2);
      if (h == 10 && h > max && !set.contains(c)) {
        max = h;
        answer[0] = c;
        set.add(c);
        continue;
      }
    }
    
    System.out.printf("Case #%d: ", num);
    for(int i = 0; i != 10; i++) {
      System.out.print(answer[i]);
    }
    System.out.printf("\n");
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