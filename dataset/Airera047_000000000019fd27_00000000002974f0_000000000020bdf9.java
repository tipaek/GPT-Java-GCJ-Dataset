import java.util.*;
import java.io.*;
import java.util.stream.IntStream; 
import java.util.stream.Collectors;

public class Solution{
  
  public static void main(String[] args) throws IOException {
    Solution fd = new Solution();
    Scanner input= new Scanner(System.in);
    int testN = input.nextInt();
    for(int i = 0; i < testN; i++){
      int intervalN = input.nextInt();
      int[][] interval = new int[intervalN][2];
      for(int j = 0; j < intervalN; j++){
        interval[j][0] = input.nextInt();
        interval[j][1] = input.nextInt();
      }
      String output = "";
      Boolean check = false;
      StringBuilder str = new StringBuilder();
      List<Integer> J = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
      List<Integer> C = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
      for(int k = 0; k < intervalN; k++){
        if(check(J,interval[k][0],interval[k][1])){
          str.append("J");
          int s = J.indexOf(interval[k][0]);
          int e = J.indexOf(interval[k][1]);     
          for(int l = s; l < e; l++){  
            J.remove(s);
          }
          continue;
        }
        else if(check(C,interval[k][0],interval[k][1])){
          str.append("C");  
          int s = C.indexOf(interval[k][0]);
          int e = C.indexOf(interval[k][1]);     
          for(int l = s; l < e; l++){  
            C.remove(s);
          }
          continue;
        }
        else{
          output = "IMPOSSIBLE";
          check = true;
          break;        
        }
        
      }
      int test = i + 1;
      if(check == true){
        System.out.println("Case #" + test + ": "  + output);
      }
      else{
        output = str.toString();
        System.out.println("Case #" + test + ": "  + output);
      }
    }
  }
  
  
  public static boolean check(List<Integer> arr, int start, int end){
    if(!arr.contains(start)){
      return false;
    }
    if(!arr.contains(end)){
      return false;
    }
    if(arr.indexOf(end) - arr.indexOf(start) == end - start){
      return true;
    }
    else{
      return false;
    }
  }
}
