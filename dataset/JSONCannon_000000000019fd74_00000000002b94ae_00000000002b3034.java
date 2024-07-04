import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = scanner.nextInt();
    for(int t = 1; t <= numTests; t++){  //Each test
      int N = scanner.nextInt();
      List<String> beginSet = new ArrayList<>();
      List<String> endSet = new ArrayList<>();
      for(int i = 0; i < N; i++){
        String word = scanner.next();
        String[] parts = word.split("\\*");
        if(!parts[0].equals("")){
          beginSet.add(parts[0]);
        }
        if(parts.length == 2){
          endSet.add(parts[1]);
        }
      }
      boolean works = true;
      String bigBegin = "";
      String bigEnd = "";
      if(beginSet.size() > 0) {
        beginSet.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        bigBegin = beginSet.get(0);
        for(int i = 1; i < beginSet.size(); i++){
          if(!bigBegin.startsWith(beginSet.get(i))){
            works = false;
            break;
          }
        }
      }
      if(works && endSet.size() > 0) {
        endSet.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        bigEnd = endSet.get(0);
        for(int i = 1; i < endSet.size(); i++){
          if(!bigEnd.endsWith(endSet.get(i))){
            works = false;
            break;
          }
        }
      }
      if(works) {
        System.out.println("Case #" + t + ": " + bigBegin.concat(bigEnd));
      }else{
        System.out.println("Case #" + t + ": *");
      }
    }
  }
}
