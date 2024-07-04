import java.util.HashMap;
import java.util.Scanner;

public class Vestigium
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for(int i = 1; i <= number; i++)
        {
            int index = in.nextInt();
            int arr[][] = new int[index][index];

            for(int j = 0; j < index; j++)
            {
                for(int k = 0; k < index; k++)
                    arr[j][k] = in.nextInt();
            }

            System.out.print("Case #" + i + ": " + diagonalsum(arr) + " " + rowduplicate(arr) + " " + columnduplicate(arr));
        }
    }

    private static int diagonalsum(int arr[][])
    {
        int len = arr.length;
        int sum = 0;
        for(int i = 0; i < len; i++)
            sum += arr[i][i];
        return sum;
    }

    private static int rowduplicate(int arr[][])
    {
        int len = arr.length;
        int count = 0;

        for(int i = 0; i < len; i++)
        {
            boolean found = false;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int j = 0; j < len; j++)
            {
                if(hashMap.containsKey(arr[i][j]) && found == false)
                {
                    count++;
                    found = true;
                }
                else
                    hashMap.put(arr[i][j], 1);
            }
        }
        return count;
    }

    private static int columnduplicate(int arr[][])
    {
        int len = arr.length;
        int count = 0;

        for(int i = 0; i < len; i++)
        {
            boolean found = false;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int j = 0; j < len; j++)
            {
                if(hashMap.containsKey(arr[j][i]) && found == false)
                {
                    count++;
                    found = true;
                }
                else
                    hashMap.put(arr[j][i], 1);
            }
        }
        return count;
    }
}