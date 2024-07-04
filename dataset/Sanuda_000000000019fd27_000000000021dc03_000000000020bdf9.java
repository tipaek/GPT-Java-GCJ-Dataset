import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static String solve(Scanner in)
    {
        String answer = "";
        String impossible = "IMPOSSIBLE";
        int N = in.nextInt();
        int arr[][] = new int[N][2];
        char carr[] = new char[N];
        main:for (int j = 0; j < N; j++)
        {
            int start = in.nextInt();
            int end = in.nextInt();
            arr[j][0] = start;
            arr[j][1] = end;
            int count = 0;
            char tAnswer = 'C';
            for (int i = 0; i < j; i++)
            {
                if (!(end <= arr[i][0] || start >= arr[i][1]))
                {
                    count++;
                    if (count == 1)
                    {
                        if (carr[i] == 'C')
                        {
                            tAnswer = 'J';
                        }
                        else
                        {
                            tAnswer = 'C';
                        }
                    }
                    else
                    {
                        answer = impossible;
                        break main;
                    }
                }
                if (count == 0)
                {
                    tAnswer = 'C';
                }
            }
            answer += tAnswer;
            carr[j] = tAnswer;
        }
        //stop writing from here
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int rep = 0; rep < T; rep++)
        {
            String answer = solve(in);
            System.out.println("Case #" + (rep + 1) + ": " + answer);

        }
    }
}
