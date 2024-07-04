import java.util.*;

public class Solution{

  private static ArrayList<String[]> matrix = new ArrayList<>();
  private static int N = 0;

  public static void main(String[] args){

    args = new String[]{"1","3","1 2 3","3 2 1","2 1 3"};
    int testCaseNo = Integer.parseInt(args[0]);

    int index = 1;
    for(int i = 1; i <= testCaseNo; i++){
      System.out.print("Case #"+i+":");

      N = Integer.parseInt(args[index]);
      int trace = 0;
      for(int j = 0 ; j < N; j++){
        String[] row = args[index+j+1].split(" ");
        trace += Integer.parseInt(row[j]);
        matrix.add(row);
      }

      int horizon = checkHorizon(0);
      int vertical = checkVertical(0);
      System.out.println(" "+trace+" "+horizon+" "+vertical);
      index+=N+1;
    }
  }

  private static int checkHorizon(int index){
    if(index >= N) return 0;
    ArrayList<Integer> array = new ArrayList<>();
    for(int i = 0 ; i < N ; i++){
      int number = Integer.parseInt((matrix.get(index))[i]);
      if(isArray(array, number))
        return 1 + checkHorizon(index+1);
      array.add(number);
    }
    return checkHorizon(index+1);
  }

  private static int checkVertical(int index){
      if(index >= N) return 0;
      ArrayList<Integer> array = new ArrayList<>();
      for(int i = 0 ; i < N ; i++){
        int number = Integer.parseInt((matrix.get(i))[index]);
        if(isArray(array,number))
          return 1 + checkVertical(index+1);
        array.add(number);
      }
      return checkVertical(index+1);
  }

  private static Boolean isArray(ArrayList<Integer> array, int number){
    for(int i = 0 ; i < array.size() ; i++){
      if(array.get(i) == number)
        return true;
    }
    return false;
  }
}
