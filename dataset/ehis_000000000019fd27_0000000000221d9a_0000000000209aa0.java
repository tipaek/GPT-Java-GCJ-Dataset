import java.util.Scanner;


public class Solution
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();

            System.out.println(calculMatrice(N, K, ks));
        }

    }
    
    static String calculMatrice(int n, int trace, int iteration) {
        
        
        if(trace % n != 0)
        {
            return "Case #" + iteration + ": "+"IMPOSSIBLE";
        }

        int coef = trace/n;
        
        String resultat = "";
        
        int[][] matrice = new int[n][n];
        int[][] matriceResultat = new int[n][n];
        int indexX = 0;
        int indexY = 0;

        for (int line = 0; line < n; line++) {
            for (int col = 0; col < n; col++) {
                int o = n - line;
                int v = (o + col) % n + 1;
                matrice[indexX][indexY] = v;
                indexY++;
                if (indexY == n) {
                    indexX++;
                    indexY = 0;
                }
            }
        }

        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrice[i][j] == coef)
                {
                    matriceResultat[j] = matrice[i];
                    
                }
            }
        }
        
        System.out.println("Case #" + iteration + ": " + "POSSIBLE");
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n-1)
                {
                    System.out.print(matriceResultat[i][j] + " ");
                }
                else
                {
                    System.out.print(matriceResultat[i][j]);
                }
            }
            if(i < n-1)
            {
                System.out.println("");
            }
        }
        
        return "";
    }
    
}