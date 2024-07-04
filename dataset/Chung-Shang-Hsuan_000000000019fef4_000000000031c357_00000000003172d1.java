import java.util.*;

public class Solution{

  Long[] arr;
  int diners;
  int length;

  public Solution(int length, int num, Scanner sc){
    this.length = length;
    diners = num;
    arr = new Long[length];
    for (int i = 0; i < length; i ++){
      arr[i] = sc.nextLong();
    }
  }

  public int calculate(){
    if (diners == 2){
      for (int i = 0; i < length; i ++){
        for (int j = i+1; j < length; j ++){
          if (arr[i] == arr[j]) return 0;
        }
      }
      return 1;
    }else{
      for (int i = 0; i < length; i ++){
        for (int j = i+1; j < length; j ++){
          for (int k = j+1; k < length; k ++){
            if (arr[i] == arr[j] && arr[j] == arr[k]) return 0;
          }
        }
      }
      for (int i = 0; i < length; i ++){
        for (int j = i+1; j < length; j ++){
          if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j] || arr[i] == arr[j]) return 1;
        }
      }
      return 2;
    }
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int numHouses = sc1.nextInt();
      int money = sc1.nextInt();
      Solution b = new Solution(numHouses,money,sc1);
      System.out.println("Case #" + c + ": " + b.calculate());
    }
  }
}
