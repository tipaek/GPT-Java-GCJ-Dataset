import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static void solve(Scanner input, int b)
    {
        String answer = "";
        if (b == 10)
        {
            for (int i = 1; i <= b; i++)
            {
                if ((i) % 10 == 1)
                {
                }

                System.out.println(i);
                int k = input.nextInt();
                answer += k;

            }
        }
        else if (b == 20)
        {
            boolean[] arr = new boolean[10];
            boolean[] arr2 = new boolean[10];
            boolean[] arr3 = new boolean[10];
            boolean[] finalAr = new boolean[20];
            for (int i = 1; i <= 10; i++)
            {
                if (i <= 5)
                {
                    System.out.println(i);
                }
                else
                {
                    System.out.println(10 + i);
                }
                int k = input.nextInt();
                arr[i - 1] = k == 1;
            }
            for (int i = 1; i <= 10; i++)
            {
                System.out.println(5 + i);
                int k = input.nextInt();
                arr2[i - 1] = k == 1;
            }
            for (int i = 1; i <= 10; i++)
            {
                System.out.println(i);
                int k = input.nextInt();
                arr3[i - 1] = k == 1;
                finalAr[i - 1] = k == 1;
            }

            if (finalAr[0] == arr[0] && finalAr[1] == arr[1] && finalAr[2] == arr[2] && finalAr[3] == arr[3] && finalAr[4] == arr[4])
            {
                finalAr[15] = arr[5];
                finalAr[16] = arr[6];
                finalAr[17] = arr[7];
                finalAr[18] = arr[8];
                finalAr[19] = arr[9];
            }
            else if (finalAr[0] == !arr[0] && finalAr[1] == !arr[1] && finalAr[2] == !arr[2] && finalAr[3] == !arr[3] && finalAr[4] == !arr[4])
            {
                finalAr[15] = !arr[5];
                finalAr[16] = !arr[6];
                finalAr[17] = !arr[7];
                finalAr[18] = !arr[8];
                finalAr[19] = !arr[9];
            }
            else if (finalAr[0] == arr[9] && finalAr[1] == arr[8] && finalAr[2] == arr[7] && finalAr[3] == arr[6] && finalAr[4] == arr[5])
            {
                finalAr[15] = arr[4];
                finalAr[16] = arr[3];
                finalAr[17] = arr[2];
                finalAr[18] = arr[1];
                finalAr[19] = arr[0];
            }
            else
            {
                finalAr[15] = !arr[4];
                finalAr[16] = !arr[3];
                finalAr[17] = !arr[2];
                finalAr[18] = !arr[1];
                finalAr[19] = !arr[0];
            }
            /////////////////////////////////////////////////////////
            if (finalAr[5] == arr2[0] && finalAr[6] == arr2[1] && finalAr[7] == arr2[2] && finalAr[8] == arr2[3] && finalAr[9] == arr2[4])
            {
                finalAr[10] = arr2[5];
                finalAr[11] = arr2[6];
                finalAr[12] = arr2[7];
                finalAr[13] = arr2[8];
                finalAr[14] = arr2[9];
            }
            else if (finalAr[5] == !arr2[0] && finalAr[6] == !arr2[1] && finalAr[7] == !arr2[2] && finalAr[8] == !arr2[3] && finalAr[9] == !arr2[4])
            {
                finalAr[10] = !arr2[5];
                finalAr[11] = !arr2[6];
                finalAr[12] = !arr2[7];
                finalAr[13] = !arr2[8];
                finalAr[14] = !arr2[9];
            }
            else if (finalAr[5] == arr2[9] && finalAr[6] == arr2[8] && finalAr[7] == arr2[7] && finalAr[8] == arr2[6] && finalAr[9] == arr2[5])
            {
                finalAr[10] = arr2[4];
                finalAr[11] = arr2[3];
                finalAr[12] = arr2[2];
                finalAr[13] = arr2[1];
                finalAr[14] = arr2[0];
            }
            else 
            {
                finalAr[10] = !arr2[4];
                finalAr[11] = !arr2[3];
                finalAr[12] = !arr2[2];
                finalAr[13] = !arr2[1];
                finalAr[14] = !arr2[0];
            }

            for (int i = 0; i < 20; i++)
            {
                answer += (finalAr[i]) ? "1" : "0";
            }
        }

        System.out.println(answer);
        String s = input.next();
        if (s.equals("Y"))
        {
            return;
        }
        else if (s.equals("N"))
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++)
        {
            solve(input, B);
        }
    }
}
