import java.io.*;
import java.util.*;
public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner r = new Scanner(System.in);
        int cases = Integer.parseInt(r.nextLine());
        StringTokenizer st;
        int[][] matrix;
        int side;
        for(int i = 1; i <= cases; i++)
        {
            side = Integer.parseInt(r.nextLine());
            matrix = new int[side][side];
            for(int j = 0; j < side; j++){
                st = new StringTokenizer(r.nextLine());
                for(int k = 0; k < side; k++)
                {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
                
            }
            int trace = 0;
            for(int j = 0; j < side; j++)
            {
                trace += matrix[j][j];
            }
            Set<Integer> dupes = new HashSet<Integer>();
            boolean duped = false;
            int rowsd = 0;
            for(int[] j : matrix)
            {
                duped = false;
                for(int k : j)
                {
                    if(dupes.contains(k)) duped = true;
                    else dupes.add(k);
                }
                if(duped) rowsd++;
            }
            duped = false;
            int colsd = 0;
            for(int j = 0; j < side; j++)
            {
                duped = false;
                for(int k = 0; k < side; k++)
                {
                    if(dupes.contains(matrix[k][j])) duped = true;
                    else dupes.add(matrix[k][j]);
                }
                if(duped) colsd++;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowsd + " " + colsd);
        }
    }
    
