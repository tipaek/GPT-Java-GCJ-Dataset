import java.util.*;

public class Solution{

  int[][] arr;
  int n;
  int m;
  int sum;

  public Solution(int i, int j, Scanner sc){
    arr = new int[i][j];
    n = i;
    m = j;
    sum = 0;
    for (int a = 0; a < n; a ++){
      for (int b = 0; b < m; b ++){
        arr[a][b] = sc.nextInt();
        sum += arr[a][b];
      }
    }
  }

  public boolean isEliminated(int x, int y){
    int sum = 0;
    int count = 0;
    for (int i = x-1; i >= 0; i --){
      if (arr[i][y] != -1){
        sum += arr[i][y];
        count ++;
        break;
      }
    }
    for (int i = x+1; i < n; i ++){
      if (arr[i][y] != -1){
        sum += arr[i][y];
        count ++;
        break;
      }
    }
    for (int i = y-1; i >= 0; i --){
      if (arr[x][i] != -1){
        sum += arr[x][i];
        count ++;
        break;
      }
    }
    for (int i = y+1; i < m; i ++){
      if (arr[x][i] != -1){
        sum += arr[x][i];
        count ++;
        break;
      }
    }
    if (count == 0) return false;
    return (float)sum/count > arr[x][y];
  }

  public int calculate(){
    boolean eliminated = true;
    int totalElim = 0;
    int interest = 0;
    while (eliminated){
      interest += sum - totalElim;
      Vector<Integer> vec = new Vector<Integer>();
      eliminated = false;
      for (int i = 0; i < n; i ++){
        for (int j = 0; j < m; j ++){
          if (arr[i][j] != -1 && isEliminated(i,j)){
            eliminated = true;
            totalElim += arr[i][j];
            vec.add(i);
            vec.add(j);
          }
        }
      }
      int i = 0;
      while (i < vec.size()){
        int x = vec.get(i);
        int y = vec.get(i+1);
        arr[x][y] = -1;
        i += 2;
      }
    }
    return interest;
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int n = sc1.nextInt();
      int m = sc1.nextInt();
      Solution b = new Solution(n,m,sc1);
      System.out.println("Case #" + c + ": " + b.calculate());
    }
  }
}
