import java.util.HashMap;
import java.util.Scanner;

class Main {
  
  static boolean hasDuplicate(HashMap<Integer, Integer> map) {
    for (int v: map.values()) {
      if (v > 1) {
        return true;
      }
    }
    return false;
  }
  
  static void trace(int m[][], int t) {
    int k = 0, r = 0, c = 0;
    int s = m.length;
    
    for (int i = 0; i < s; i++) {
      HashMap<Integer, Integer> rowMap = new HashMap<>();
      HashMap<Integer, Integer> colMap = new HashMap<>();
    
      for (int j = 0; j < s; j++) {
        int tempRow = m[i][j];
        if (i == j) k += tempRow;
      
        if (!rowMap.containsKey(tempRow)) {
          rowMap.put(tempRow, 1);
        } else {
          rowMap.put(tempRow, (rowMap.get(tempRow) + 1));
        }
  
        int tempCol = m[j][i];
        if (!colMap.containsKey(tempCol)) {
          colMap.put(tempCol, 1);
        } else {
          colMap.put(tempCol, (colMap.get(tempCol) + 1));
        }
      }
      
      if (hasDuplicate(rowMap)) r++;
      if (hasDuplicate(colMap)) c++;
    }
  
    System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int t = 1;
    while (t <= n) {
      int s = scanner.nextInt();
      
      int m[][] = new int[s][s];

      for (int i = 0; i < s; i++) {
        for (int j = 0; j < s; j++) {
          m[i][j] = scanner.nextInt();
        }
      }
      
      trace(m, t);
      t++;
    }
  }
}
