import java.util.HashMap;
import java.util.Scanner;

public class Main {
  
  static boolean hasDuplicate(HashMap<Byte, Byte> map) {
    for (byte v: map.values()) {
      if (v > 1) {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    byte n = scanner.nextByte();
    
    if (n >= 1 && n <= 100) {
      byte t = 0;
      while (t < n) {
        byte s = scanner.nextByte();
        
        if (s >= 2 && s <= 100) {
          byte k = 0, r = 0, c = 0;
          byte m[][] = new byte[s][s];
  
          for (int i = 0; i < s; i++) {
            HashMap<Byte, Byte> rowMap = new HashMap<>();
            HashMap<Byte, Byte> colMap = new HashMap<>();
    
            for (int j = 0; j < s; j++) {
              byte temp = scanner.nextByte();
              if (temp >= 1 && temp <= s) {
                m[i][j] = temp;
        
                if (i == j) k += temp;
        
                if (!rowMap.containsKey(temp)) {
                  rowMap.put(temp, (byte) 1);
                } else {
                  rowMap.put(temp, (byte) (colMap.get(temp) + 1));
                }
        
                if (i == s) {
                  for (int l = 0; l < s; l++) {
                    byte tempC = m[l][j];
                    if (!colMap.containsKey(tempC)) {
                      colMap.put(tempC, (byte) 1);
                    } else {
                      colMap.put(tempC, (byte) (colMap.get(temp) + 1));
                    }
                  }
                }
              } else {
                throw new Exception("Invalid value");
              }
            }
            if (hasDuplicate(rowMap)) r++;
            if (hasDuplicate(colMap)) c++;
          }
  
          System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        } else {
          System.exit(0);
        }
        t++;
      }
    }
    System.exit(0);
  }
}
