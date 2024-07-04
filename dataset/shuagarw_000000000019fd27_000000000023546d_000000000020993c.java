import java.util.Scanner;
public class Solution{
    public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt(in.nextLine());

    for (int i = 1; i <= cases; i++) {
      int n = Integer.parseInt(in.nextLine());

      int sum = 0;
      int rSum = 0;
      int cSum = 0;

      int [][] col = new int[n][n];
      boolean[] colB = new boolean[n];


      for (int r = 0; r < n; r++) {

        String[] name = in.nextLine().split(" ");


        int[] row = new int[n];
        boolean found = false;
        for (int c = 0; c < n; c++) {

          int val = Integer.parseInt(name[c]);
          if(r == c ){
            sum+=val;
          }
          if(!found) {
            if (row[val - 1] == 1) {
              rSum++;
              row[val - 1] = 2;
              found = true;
            }
            else if (row[val - 1] == 0) {
              row[val - 1] = 1;
            }
          }
          if(!colB[c]) {
            if (col[c][val - 1] == 1) {
              cSum++;
              col[c][val - 1] = 2;
              colB[c] = true;
            }
            else if (col[c][val - 1] == 0) {
              col[c][val - 1] = 1;
            }
          }

        }

      }
      System.out.println("Case #"+i+": " + sum +" " + rSum +" " +cSum);
    }
  }
}