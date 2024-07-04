import java.util.Scanner;

public class Solution {

    public static int query(int pos, Scanner input)
    {
        System.out.println(pos+1);
        return input.nextInt();
    }
    
    public static boolean answer(int arr[], Scanner input)
    {
        String s = "";
        for (int i = 0; i < arr.length; i++)
            s = s + arr[i];
        System.out.println(s);
        return input.next().equals("Y");
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int tt = 0; tt < T; tt++)
        {
            int[] arr = new int[B];
            int known = 0;
            while (true)
            {
                int next = known == 0 ? 5 : known+4;
                if (next > B/2) next = B/2;
                for (int i = known; i < next; i++)
                {
                    arr[i] = query(i, input);
                    arr[B-1-i] = query(B-1-i, input);
                }
                known = next;
                if (known == B/2)
                {
                    break;
                }
                int q1 = -1, q2 = -1;
                for (int i = 0; i < known; i++)
                {
                    if (arr[i] == arr[B-1-i])
                        q1 = i;
                    if (arr[i] != arr[B-1-i])
                        q2 = i;
                }
                int a1 = query(q1 == -1 ? 0 : q1, input);
                int a2 = query(q2 == -1 ? 0 : q2, input);
                if (q1 != -1)
                {
                    if (a1 != arr[q1])
                        for (int i = 0; i < B; i++)
                            arr[i] ^= 1;
                }
                if (q2 != -1)
                {
                    if (a2 != arr[q2])
                        for (int i = 0; i < B/2; i++)
                        {
                            int tmp = arr[i];
                            arr[i] = arr[B-1-i];
                            arr[B-1-i] = tmp;
                        }
                }
            }
            if (!answer(arr, input))
            {
                break;
            }
        }
    }
}
