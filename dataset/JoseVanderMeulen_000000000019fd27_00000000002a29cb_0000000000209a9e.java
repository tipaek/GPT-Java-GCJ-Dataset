import java.util.Scanner;

//********************************************************************************************
//ESAb ATAd
//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
//********************************************************************************************
class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;
  
  static int B;
  static int sz;
  static int[] line = new int[100];
  
  public static void main(String[] args) {
    t = scanner.nextInt();
    B = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    query(0, 5);
    query(B - 5, B);
    sz = 5;
    while(2 * sz < B) {
      int same = existsSame();
      int diff = existsDiff();
            
      if (same == sz) {
        query(0);
        
        int x = query(diff);
        if (x != line[diff]) {
          compl(line, sz, B);
        }
      } else if (diff == sz) {
        query(0);
        
        int x = query(same);
        if (x != line[same]) {
          compl(line, sz, B);
        }
      } else {
        int x = query(same);
        int y = query(diff);
        
        if (x != line[same] && y != line[diff]) {
          compl(line, sz, B);
        } else if (x == line[same] && y != line[diff]) {
          reverse(line, sz, B);
        } else if (x != line[same] && y == line[diff]) {
          compl(line, sz, B);
          reverse(line, sz, B);
        }
      }
      
      if (2 * sz + 8 > B) {
        query(sz, B - sz);
        sz = B / 2;
      } else {
        query(sz, sz + 4);
        query(B - sz - 4, B - sz);
        sz += 4;
      }
    }

    print(line);
    scanner.nextLine();
  }
  
  static void query(int min, int max) {
    for(int i = min; i != max; i++) {
      line[i] = query(i);
    }
  }

  static int query(int idx) {
    System.out.println(idx + 1);
    System.out.flush();
    
    int res = scanner.nextInt();
    scanner.nextLine();
    return res;
  }
  
  static void reverse(int[] line, int sz, int B) {
    for(int i = 0; i != sz; i++) {
      int tmp = line[i];
      line[i] = line[B - i - 1];
      line[B - i - 1] = tmp;
    }
  }
  
  static void compl(int[] line, int sz, int B) {
    for(int i = 0; i != sz; i++) {
      line[i] = 1 - line[i]; 
      line[B - i - 1] = 1 - line[B - i - 1];
    }    
  }
  
  static int existsSame() {
    int i = 0;
    while(i != sz && line[i] != line[B - i - 1]) {
      i++;
    }
    return i;
  }
  
  static int existsDiff() {
    int i = 0;
    while(i != sz && line[i] == line[B - i - 1]) {
      i++;
    }
    return i;
  } 
  
  static void print(int[] line) {
    for(int i = 0; i != B; i++) {
      System.out.print(line[i]);
    }
    System.out.println();
    System.out.flush();
  }
}