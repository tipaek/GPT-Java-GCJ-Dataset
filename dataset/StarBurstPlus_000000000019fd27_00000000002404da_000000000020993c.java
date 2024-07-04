import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
    int tc = 0, n = 0;
    int r = 0, c = 0, trace = 0;

    Scanner scan = new Scanner(System.in);
    tc = scan.nextInt();
    int[][] matrix = new int[100][100];

    for(int i = 0; i < tc; i++){
      n = scan.nextInt();

      for(int j = 0; j < n; j++){
        
        for(int k = 0; k < n; k++){
          matrix[j][k] = scan.nextInt();

          if(k == j){
            trace += matrix[j][k];
          }

        }
      }
      int countBack = 0;
      int temp = 0;
      int l = 0;
      for(int j = 0; j < n; j++){
        l = 0;
        while(countBack != n){
          temp = matrix[j][l];
          for(int k = j+1; k < n; k++){
            // System.out.println(temp + " " + matrix[j][k]);
            if(temp == matrix[j][k]){
            System.out.println(temp + " " + j + " " + l );System.out.println(matrix[j][k] + " " + j + " " + k);

                r++;
                break;
            }
          }

          // if(temp == matrix[j][countBack+1]){
          //   r++;
          //   break;
          // }
          l++;
          countBack++;
        }
      }

      for(int j = 0; j < n; j++){

        
      }
      System.out.println("Case #" + (i+1) + ": " + trace + " " + r + " " + c);
    }
  }
}