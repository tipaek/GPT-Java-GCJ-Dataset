import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution  {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
            List<Set<Integer>> matrixRowCheck = new ArrayList<>();
            List<Set<Integer>> matrixColCheck = new ArrayList<>();
            int trace = 0;
            int rowDuplicates=0;
            int colDuplicates=0;
            for(int row=0;row<N;row++)
            {
                matrixRowCheck.add(new HashSet<>());
                for(int col=0;col<N;col++)
                {
                    int number = in.nextInt();
                    matrixRowCheck.get(row).add(number);
                    
                    if(row==0)
                    {
                         HashSet<Integer> colSet = new HashSet<>();
                         colSet.add(number);
                         matrixColCheck.add(colSet);
                    }
                    else
                         matrixColCheck.get(col).add(number);
                    
                    if(row==col)
                        trace+=number;
                }
                rowDuplicates+=(matrixRowCheck.get(row).size()!=N?1:0);
            }
            
            for(int col=0;col<N;col++)
            {
                colDuplicates+=(matrixColCheck.get(col).size()!=N?1:0);
            }
            
            System.out.println("Case #"+i+": "+trace+" "+rowDuplicates+" "+colDuplicates);
        }
      }
    
   
}
