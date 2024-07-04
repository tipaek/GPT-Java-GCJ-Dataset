import java.util.Scanner;
import java.util.Arrays;

public class Solution
{
    public static boolean rowRepeats(int[] a)
    {
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        for (int c = 1; c < b.length; c++)
        {
            if (b[c] == b[c-1])
            {
                return true;
            }
        }
        return false;
    }
    public static String solve(int[][] square)
    {
        int repCols = 0;
        for (int c = 0; c < square.length; c++)
        {
            int[] col = new int[square.length];
            for (int r = 0; r < square.length; r++)
            {
                col[r] = square[r][c];
            }
            if (rowRepeats(col))
            {
                repCols++;
            }
        }
        
        int repRows = 0;
        for (int r = 0; r < square.length; r++)
        {
            int[] row = square[r];
            if (rowRepeats(row))
            {
                repRows++;
            }
        }
        
        int sum = 0;
        for (int r = 0; r < square.length; r++)
        {
            sum += square[r][r];
        }
        
        return sum + " " + repRows + " " + repCols;
    }
 
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            int size = input.nextInt();
            input.nextLine();
            int[][] square = new int[size][size];
            
            for (int j = 0; j < size; j++)
            {
                String newRow = input.nextLine();
                int val = 0;
                int inRow = 0;
                int ele = size-1;
                for (int k = newRow.length()-1; k >= 0; k--)
                {
                    if (newRow.charAt(k) != ' ' && k != 0)
                    {
                        val += Character.getNumericValue(newRow.charAt(k))*Math.pow(10, inRow);
                        inRow++;
                    }
                    else
                    {
                        if (k == 0)
                        {
                            val += Character.getNumericValue(newRow.charAt(k))*Math.pow(10, inRow);
                        }
                        inRow = 0;
                        square[j][ele] = val;
                        ele--;
                        val = 0;
                    }
                }
            }
            
            System.out.println("Case #" + ks + ": " + solve(square));
        }
    }
}