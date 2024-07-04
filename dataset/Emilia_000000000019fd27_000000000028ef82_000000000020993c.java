import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution{

    public static String checkMatrix(Integer[][] matrixArray, int n)
    {

        Integer rowDuplicate = 0;
        Integer colDuplicate = 0;
        Integer trace = 0;

        for(int i=0;i<n;i++)
        {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2= new HashSet<>();

            for (int j=0;j<n;j++) {
                set1.add(matrixArray[i][j]);
                set2.add(matrixArray[j][i]);

                if(i==j)
                    trace=trace+matrixArray[i][j];
            }
            if (set1.size() < n) {
                rowDuplicate++;
            }
            if (set2.size() < n) {
                colDuplicate++;
            }
        }

        return trace.toString()+" "+rowDuplicate.toString()+" "+colDuplicate.toString();

    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = in.nextInt();

        for (int k = 1; k <= testCase; ++k) {
            Integer n = in.nextInt();
            in.nextLine();
            Integer[][] matrixArray = new Integer[n][n];

            for(int i=0;i<n;++i)
            {
                String rowString = in.nextLine();
                String[] row= rowString.split(" ");
                for (int j=0;j<n;j++)
                {
                    matrixArray[i][j] = Integer.valueOf(row[j]);
                }


            }
            System.out.println("Case #"+k+": "+checkMatrix(matrixArray, n));
        }
    }


}

