import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int T = input.nextInt();
        Integer[][] matrice = null;
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            matrice = new Integer[N][N];
            int index = 0;
            for(int i = 0;i<N;i++)
            {
                for(int j = 0; j<N;j++)
                {
                    matrice[i][j] = input.nextInt();
                }                
            }
            calculMatrice(matrice, ks);
        }

        
    }
    
    public static Integer[] getColumn(Integer[][] array, int index){
        Integer[] column = new Integer[array[0].length]; // Here I assume a rectangular 2D array! 
        for(int i=0; i<column.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }
    
    public static void calculMatrice(Integer[][] matrice, int iteration)
    {
        int trace = 0;
        int countRow = 0;
        int countColumn = 0;
        
        for(int i =0;i<matrice.length;i++)
        {
            trace += matrice[i][i];
        }
        
        //System.out.println("ligne 1= "+Arrays.toString(matrice[0]));
        for(int i =0;i<matrice.length;i++)
        {
            Set<Integer> ligne = new HashSet<Integer>(Arrays.asList(matrice[i]));
            
            if(ligne.size() < matrice[i].length)
            {
                countRow++;
            }
            
            Integer[] tabColone = getColumn(matrice, i);
            Set colone = new HashSet<>(Arrays.asList(tabColone));
            
            if(colone.size() != tabColone.length)
            {
                countColumn++;
            }
        }

        System.out.println("Case #" + iteration + ": "+trace+" "+countRow+" "+countColumn);
    }
    
}