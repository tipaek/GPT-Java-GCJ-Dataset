import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();
        for(int i = 0; i < n; i++)
        {
            key.nextLine();
            int num = key.nextInt();
            Integer[][] arr = new Integer[num][num];
            Integer[][] arr2 = new Integer[num][num];
            int total = 0;
            for(int r = 0; r < num; r++)
            {
                key.nextLine();
                for(int c = 0; c < num; c++)
                {
                	int numb = key.nextInt();
                    arr[r][c] = numb;
                    if(r==c)
                        total += arr[r][c];
                    arr2[c][r] = arr[r][c];
                    
                }
            }
            Integer[] array = new Integer[num];
            for(int j = 0; j < num; j++)
            {
                array[j] = j+1;
            }
            int row = 0;
            int col = 0;
            for(int j = 0; j < num; j++)
            {
            	Integer[] copied = arr[j];
            	List<Integer> list = Arrays.asList(copied);
            	if(!list.containsAll(Arrays.asList(array)))
            		row++;
            	copied = arr2[j];
            	list = Arrays.asList(copied);
            	if(!list.containsAll(Arrays.asList(array)))
            		col++;
            }
            System.out.println("Case #" + (i+1) + ": " + total + " " + row + " " + col);
            
        }
       
    }
}