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

        ArrayList<int[]> aList = new ArrayList();
        ArrayList<int[]> cameron = new ArrayList();
        ArrayList<int[]> jammie = new ArrayList();

        for (int j = 0; j < N; j++)
        {
            answer += "U";
            aList.add(new int[]
            {
                in.nextInt(), in.nextInt()
            });
        }
        StringBuilder sb = new StringBuilder(answer);

        for (int i = 0; i < N; i++)
        {
            boolean check = true;
            int[] a = aList.get(i);
            if (cameron.isEmpty())
            {
                cameron.add(a);
                sb.setCharAt(0, 'C');
            }
            else
            {
                for (int j = 0; j < cameron.size(); j++)
                {
                    if ((a[0] >= cameron.get(j)[1] || a[1] <= cameron.get(j)[0]) && check)
                    {
                    }
                    else
                    {
                        check = false;
                    }

                }
                if (check)
                {
                    cameron.add(a);
                    sb.setCharAt(i, 'C');
                }
            }

        }
        for (int i = 0; i < N; i++)
        {
            if (sb.charAt(i) == 'U')
            {
                boolean check = true;
                int[] a = aList.get(i);
                if (jammie.isEmpty())
                {
                    jammie.add(a);
                    sb.setCharAt(i, 'J');
                }
                else
                {
                    for (int j = 0; j < jammie.size(); j++)
                    {
                        if ((a[0] >= jammie.get(j)[1] || a[1] <= jammie.get(j)[0]) && check)
                        {
                        }
                        else
                        {
                            return impossible;
                            
                        }

                    }
                    if (check)
                    {
                        jammie.add(a);
                        sb.setCharAt(i, 'J');
                    }
                }
            }
        }
        answer = sb.toString();

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
