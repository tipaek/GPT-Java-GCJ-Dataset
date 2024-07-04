import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numTests = scanner.nextInt();
    for (int t = 1; t <= numTests; ++t) {
      int U = scanner.nextInt();
      Map<Character, Integer> map = new HashMap<>();
      Set<Character> nonZeroChars = new HashSet<>();
      for(int i = 0; i < 10000; i++){
        String num = scanner.next();
        String resultString = scanner.next();
        Character firstNumChar = num.charAt(0);
        Integer firstNum = Character.getNumericValue(firstNumChar);
        if(firstNum == -1){
          continue;
        }
        Character firstChar = resultString.charAt(0);
        nonZeroChars.add(firstChar);
        if(!map.containsKey(firstChar)){
          map.put(firstChar, 9);
        }
        if(firstNum < map.get(firstChar)){
          map.replace(firstChar, firstNum);
        }
      }
      char[] finalCharArray = new char[10];
      for(Map.Entry<Character, Integer> entry : map.entrySet()){
        Character key = entry.getKey();
        if(!nonZeroChars.contains(key)){
          finalCharArray[0] = key;
          continue;
        }
        finalCharArray[entry.getValue()] = key;
      }
      String answer = new String(finalCharArray);
      System.out.println("Case #" + t + ": " + answer);
    }
  }

  private static boolean mapIsReduced(Map<Character, List<Integer>> map){
    for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
      if(entry.getValue().size() > 1){
        return false;
      }
    }
    return true;
  }
  private static Set<Integer> generateNewList(){
    Set<Integer> list = new HashSet<>();
    for(int i = 0; i < 10; i++){
      list.add(i);
    }
    return list;
  }
}
