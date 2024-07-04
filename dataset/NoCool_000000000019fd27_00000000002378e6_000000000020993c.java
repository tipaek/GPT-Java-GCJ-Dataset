import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int test_case = 1;
        while (t-->0)
        {
            int size = sc.nextInt();
            int k = 0 , r = 0 , c = 0;
            int[][] arr = new int[size][size];
            //taking input and finding trace of the matrix
            for(int i = 0 ; i < size ; i++)
            {
                for(int j = 0 ; j < size ; j++)
                {
                    arr[i][j] = sc.nextInt();
                    if(i==j)
                    {
                        k+=arr[i][j];
                    }
                }
            }
            //traversing from row by row and finding repeated elements
            for(int i = 0 ; i < size ; i++) {
                int[] temp = new int[size];
                System.arraycopy(arr[i], 0, temp, 0, size);
                Arrays.sort(temp);
                for(int l = 0 ; l < size-1 ; l++)
                {
                    if(temp[l]==temp[l+1])
                    {
                        ++c;
                        break;
                    }
                }
            }

            //traversing from column by column and finding repeated elements
            for(int i = 0 ; i < size ; i++) {
                int[] temp = new int[size];
                for (int j = 0; j < size; j++) {
                    temp[j] = arr[j][i];
                }
                Arrays.sort(temp);
                for(int l = 0 ; l < size-1 ; l++)
                {
                    if(temp[l]==temp[l+1])
                    {
                        ++r;
                        break;
                    }
                }
            }

            System.out.println("Case #"+test_case+": "+ k +" "+r+" "+c);

            ++test_case;
        }
    }
}
