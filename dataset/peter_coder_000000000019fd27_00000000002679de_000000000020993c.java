import java.util.Scanner; 
  
class Vestigium
{ 
    public static void main(String args[]) 
    { 
        Scanner in = new Scanner(System.in); 
        int N = in.nextInt();
        for (int x=0; x<N; ++x)
        {
            int m = in.nextInt();
            int k = 0, r = 0, c = 0;

            int[][] mm = new int[m][m];
            for (int i=0; i<m; ++i) {
                for (int j=0; j<m; ++j) {
                    int a = in.nextInt();
                    mm[i][j] = a;
                    if (i == j) {
                        k += a;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d%n", x+1, k, r, c);
        }
    }
}