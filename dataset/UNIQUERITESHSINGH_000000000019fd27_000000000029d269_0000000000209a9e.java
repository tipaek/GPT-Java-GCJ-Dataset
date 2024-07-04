
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static List<Integer> array = new ArrayList<>(Arrays.asList(1, 21, 31, 41, 51, 61,71,81,91,101,111,121,131,141));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int B = scanner.nextInt();

        for (int tc = 1; tc <= T; ++tc)
        {
            int[] arr = new int[B];
            String[] t = (scanner.next().trim()).split("");
            for (int i = 0; i < t.length; i++)
            {
                arr[i] = Integer.parseInt(t[i].trim());
            }
            for(int i=1 ; i<=150 ; i++)
            {
                int [] compliment = complimentArray(arr);
                int [] reverse = reverse(arr);
                int [] both = reverse(compliment);
                int [] copy = copy(compliment);
                System.out.println(1);
                int value = scanner.nextInt();
                if(array.contains(i))
                {

                }
                else
                {

                }
            }
            print(arr);
            String status = scanner.next();
            if("N".equals(status))
            {
                break;
            }

        }
        scanner.close();
    }

    private static int [] complimentArray(int[] arr)
    {
        int size = arr.length;
        int [] compliment = new int[size];
        for(int i=0; i< arr.length ; i++)
        {
            if(arr[i] == 0)
                compliment[i] = 1;
            else
                compliment[i] =0;
        }
        return compliment;
    }

    private static int [] reverse(int[] arr)
    {
        int size = arr.length;
        int [] reverse = new int[size];
        for(int i=0,j=size-1; i< arr.length ; i++,j--)
        {
            if(arr[i] == 0)
                reverse[j] = 0;
            else
                reverse[j] =1;
        }
        return reverse;
    }

    private static int [] copy(int[] arr)
    {
        int size = arr.length;
        int [] copy = new int[size];
        for(int i=0; i< arr.length ; i++)
        {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static void print(int[] arr)
    {
        StringBuilder output= new StringBuilder();
        for (int i1 : arr) {
            output.append(i1);
        }
        System.out.println(output);
    }

}
