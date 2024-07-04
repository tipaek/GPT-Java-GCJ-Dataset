import java.util.Scanner;

//********************************************************************************************
//Parenting Partnering Returns
//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
//********************************************************************************************
public class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;

  static int n;
  static int[] a = new int[2000];
  static int[] b = new int[2000];
  static int[] c = new int[2000];

  static int sz;
  static int[] d = new int[2000];
  
  static char[] fnames = new char[3];
  
  static char[] planning = new char[1000];

  public static void main(String[] args) {
    t = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    fnames[0] = 'X';
    fnames[1] = 'J';
    fnames[2] = 'C';
    
    read();
    init(d, sz);
    sort(d, 0, sz, Solution::cmp);
    
    int cpt = 0;
    int i = 0;
    while(i != sz && cpt <= 2) {
      int idx = d[i];
      
      if (b[idx] == 1) {
        cpt++;
        planning[c[idx]] = fnames[3 - cpt];
      } else {
        fnames[3 - cpt] = planning[c[idx]];
        cpt--;
      }
      i++;
    }

    System.out.printf("Case #%d: ", num);
    if (i != sz) {
      System.out.printf("IMPOSSIBLE");
    } else {
      for(int k = 0; k != n; k++) {
        System.out.print(planning[k]);
      }
    }
    System.out.printf("\n");
  }
  
  static void read() {
    n = scanner.nextInt();
    sz = 2 * n;

    for(int i = 0; i != n; i++) {
      a[2 * i] = scanner.nextInt();
      a[2 * i + 1] = scanner.nextInt();
      
      b[2 * i] = 1;
      b[2 * i + 1] = 0;
      
      c[2 * i] = i;
      c[2 * i + 1] = i;
    }
  }

  static boolean cmp(int[] t, int x, int y) {
    int idx = t[x];
    int jdx = t[y];
    return a[idx] < a[jdx] || a[idx] == a[jdx] && b[idx] < b[jdx];
  }
  
  static void init(int[] t, int sz) {
    for(int i = 0; i != sz; i++) {
      t[i] = i;
    }
  }

  // *************************************************************
  // SORT
  // *************************************************************
  static int[] index1 = new int[2000];
  static int[] index2 = new int[2000];

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