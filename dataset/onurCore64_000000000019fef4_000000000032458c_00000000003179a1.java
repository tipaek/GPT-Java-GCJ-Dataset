import java.util.Scanner;
class Solution{
  public static void main(String[] arg){
    Scanner in = new Scanner(System.in);
    int testCase = in.nextInt();
    int u = 0;
    String m;
    String s;
    int op;
    int op2;
    int[][] arr = new int[26][2];
    int[] sol1 = new int[10];
    String sol;
    int[] temp = new int[2];
    for(int i = 0; i < testCase;i++){
      u = in.nextInt();
      sol = new String(""); 
      temp[0] = 0;
      temp[1] = 0;
      for(int h = 0;h < 10;h++){
        sol1[h] = 0;
      }
      for(int p = 0;p < 26;p++){
      arr[p][0] = 0;
      arr[p][1] = p;
    }
      for(int j = 0;j < 10000;j++){
        m = in.next();
        s = in.next();
        for(int k = 0;k < s.length();k++){
          arr[((int)s.charAt(k)) - 65][0]++;
        }
      }
      for(int l = 0;l < 10;l++){
        op = arr[0][0];
        op2 = 0;
        for(int p = 0;p < 26;p++){
          if(op < arr[p][0]){
            op = arr[p][0];
            op2 = p;
          }
        }
        sol1[l] = arr[op2][1];
        arr[op2][0] = 0;
      }
        sol = sol + Character.toString((char) (sol1[9] + 65));
        for(int r = 0;r < 9;r++){
        sol = sol + Character.toString((char) (sol1[r] + 65));
        }
      System.out.println("Case #" + (i + 1) + ": " + sol);
      
    }
  
  
  in.close();
  }

}
