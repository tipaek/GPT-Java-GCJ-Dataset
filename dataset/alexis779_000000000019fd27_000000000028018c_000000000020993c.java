import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 class Vestigium {
   public static void main(String[] args) throws Exception {
      InputStream inputStream = System.in;
      //InputStream inputStream = new FileInputStream(new File("Vestigium"));
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      String[] tokens;
      tokens = bufferedReader.readLine().split(" ");
      int T = Integer.parseInt(tokens[0]);
      while (T > 0) {
         tokens = bufferedReader.readLine().split(" ");
         int N = Integer.parseInt(tokens[0]);
         int[][] M = new int[N][N];
         for (int i = 0; i < N; i++) {
            tokens = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
               M[i][j] = Integer.parseInt(tokens[j]);
            }
         }

         Vestigium vestigium = new Vestigium(N, M);
         bufferedWriter.write(vestigium.k + " " + vestigium.r + " " + vestigium.c);
         bufferedWriter.newLine();

         T--;
      }
      bufferedWriter.close();
      bufferedReader.close();
   }

   /**
    * Matrix size
    */
   int N;

   /**
    * Square matrix
    */
   int[][] M;

   /**
    * trace
    */
   int k;

   /**
    * Number of rows with repeats
    */
   int r;

   /**
    * Number of columns with repeats
    */
   int c;

   public Vestigium(int N, int[][] M) {
      this.N = N;
      this.M = M;
      
      trace();

      rowRepeats();
      columnRepeats();
   }

   private void trace() {
      for (int i = 0; i < N; i++) {
         k += M[i][i];
      }
   }

   private void rowRepeats() {
      for (int i = 0; i < N; i++) {
         if (rowRepeat(i)) {
            r++;
         }
      }
   }

   private void columnRepeats() {
      for (int j = 0; j < N; j++) {
         if (columnRepeat(j)) {
            c++;
         }
      }
   }

   private boolean rowRepeat(int i) {
      boolean[] visited = new boolean[N+1];
      for (int j = 0; j < N; j++) {
         if (visited[M[i][j]]) {
            return true;
         }
         visited[M[i][j]] = true;
      }
      return false;
   }

   private boolean columnRepeat(int j) {
      boolean[] visited = new boolean[N+1];
      for (int i = 0; i < N; i++) {
         if (visited[M[i][j]]) {
            return true;
         }
         visited[M[i][j]] = true;
      }
      return false;
   }

}
