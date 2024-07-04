import java.util.HashMap;
import java.util.Scanner;

class Vestigium
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for(int i = 1; i <= number; i++)
        {
            int index = in.nextInt();
            int arr[][] = new int[index][index];
            int rowduplicatecount = 0;
            int diagonalsum = 0;

            for (int j = 0; j < index; j++)
            {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                boolean found = false;
                for (int k = 0; k < index; k++)
                {
                    arr[j][k] = in.nextInt();
                    if(hashMap.containsKey(arr[j][k]) && found == false)
                    {
                        rowduplicatecount++;
                        found = true;
                    }

                    if(j == k)
                        diagonalsum += arr[j][k];
                }
            }
            System.out.println("Case #" + i + ": " + diagonalsum + " " + rowduplicatecount + " " + columnduplicate(arr));
        }
        System.exit(0);
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