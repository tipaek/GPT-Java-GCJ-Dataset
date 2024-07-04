import java.util.Scanner;
class Solution{
  public static void main(String[] arg){
    Scanner in = new Scanner(System.in);
    int testCase = in.nextInt();
    int u = 0;
    int m;
    String s;
    int[][] arr = new int[26][2];
    String sol;
    int[] temp = new int[2];
    for(int i = 0; i < testCase;i++){
      u = in.nextInt();
      sol = new String(""); 
      temp[0] = 0;
      temp[1] = 0;
      for(int p = 0;p < 26;p++){
      arr[p][0] = 0;
      arr[p][1] = p;
    }
      for(int j = 0;j < 10000;j++){
        m = in.nextInt();
        s = in.next();
        for(int k = 0;k < s.length();k++){
          arr[((int)s.charAt(k)) - 65][0]++;
        }
      }
      for(int n = 0;n < 26;n++){
        temp = new int[2];
        temp[0] = arr[n][0];
        temp[1] = n;
        for(int l = n;l < 26;l++){
          if(temp[0] < arr[l][0]){
            temp = arr[l];
          }
        }
        arr[temp[0]] = arr[n];
        arr[n] = temp;
      }
      sol = sol + Character.toString((char) (arr[10][1] + 65));
      for(int j = 0;j < 9;j++){
        sol = sol + Character.toString((char) (arr[j][1] + 65));
      }
      System.out.println("Case #" + (i + 1) + ": " + sol);
    }
  
  
  in.close();
  }

}