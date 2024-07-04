import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
      int n = scanner.nextInt();
      int d = scanner.nextInt();
      long[] numbers = new long[n];
      Set<Long> uniqueNumbers = new HashSet<>();
      
      for (int i = 0; i < n; i++) {
        numbers[i] = scanner.nextLong();
        uniqueNumbers.add(numbers[i]);
      }
      
      int cutsRequired = n - (uniqueNumbers.size() + d) + 1;
      
      if (cutsRequired != 0) {
        Arrays.sort(numbers);
        boolean found = false;
        
        for (int i = 1; i < n && !found; i++) {
          for (int j = 0; j < i; j++) {
            if (numbers[i] == 2 * numbers[j]) {
              cutsRequired = 1;
              found = true;
              break;
            }
          }
        }
        
        if (cutsRequired < 0 && d == 3) {
          cutsRequired = 2;
        } else if (d == 2) {
          cutsRequired = 1;
        }
      }
      
      System.out.println("Case #" + caseNumber + ": " + cutsRequired);
    }
  }
}