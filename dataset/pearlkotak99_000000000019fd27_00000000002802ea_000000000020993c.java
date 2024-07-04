import java.util.*;

class Main{
  public static void main(String[] args){
    int t, n;
    int temp;
    boolean flag = false;
    int rows_repeat = 0, sum = 0;
    int columns_repeat = 0;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    int[][] result = new int[t][3];
    for(int i = 0; i < t; i++){
      rows_repeat = 0;
      columns_repeat = 0;
      sum = 0;
      flag = false;
      n = sc.nextInt();
      int[][] ar  = new int[n][n];
      for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
          temp = sc.nextInt();
          if(temp >= 1 && temp <= n){
            ar[j][k] = temp;
            if(j == k){
              sum += ar[j][k];
            }
          }else{
            System.out.println("error.");
            flag = true;
          }
        }
      }
      if(flag){
        continue;
      }
      boolean[] check = new boolean[n];
      for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
          temp = ar[j][k];
          if(check[temp -1]){
            rows_repeat++;
            break;
          }
          check[temp - 1] = true;
        }
        for(int k = 0; k < n; k++){
          check[k] = false;
        }
      }

      for(int k = 0; k < n; k++){
        check[k] = false;
      }

      for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
          temp = ar[k][j];
          if(check[temp - 1]){
            columns_repeat++;
            break;
          }
          check[temp - 1] = true;
        }
        for(int k = 0; k < n; k++){
          check[k] = false;
        }
      }
      result[i][0] = sum;
      result[i][1] = rows_repeat;
      result[i][2] = columns_repeat;
    }
    for(int i = 0; i < t; i++){
      System.out.println("Case #" + (i + 1) + ": " + result[i][0] +" " + result[i][1] + " " + result[i][2]);
    }
  }
}