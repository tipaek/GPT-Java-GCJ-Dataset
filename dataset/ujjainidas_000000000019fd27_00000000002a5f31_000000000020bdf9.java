import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(sc.nextLine());

        for(int o = 1; o<=testCases; o++)
        {
            int numTasks = Integer.parseInt(sc.nextLine());
            int[] starts = new int[numTasks];
            int[] ends = new int[numTasks];
            String[] tasks = new String[numTasks];
            ArrayList<int[]> J = new ArrayList<>();
            ArrayList<int[]> C = new ArrayList<>();

            for(int i = 0; i<numTasks; i++)
            {
                String[] split = sc.nextLine().split(" ");
                starts[i] = Integer.parseInt(split[0]);
                ends[i] = Integer.parseInt(split[1]);
            }

            boolean impossible = false;
            for(int i = 0; i<numTasks; i++)
            {
                boolean j = true;
                boolean c = true;
                for(int x = 0; x < J.size(); x++)
                {
                    if(J.get(x)[0] >= starts[i] && J.get(x)[0] < ends[i])
                    {
                        j = false;
                    }
                    if(ends[i] > J.get(x)[0] && ends[i] <= J.get(x)[1])
                    {
                        j = false;
                    }
                    if(J.get(x)[1] > starts[i] && J.get(x)[1] <= ends[i])
                    {
                        j = false;
                    }
                    if(starts[i] >= J.get(x)[0] && starts[i] < J.get(x)[1])
                    {
                        j = false;
                    }
                    if(J.get(x)[0] <= starts[i] && J.get(x)[1] >= ends[i])
                    {
                        j = false;
                    }
                    if(starts[i] <= J.get(x)[0] && ends[i] >= J.get(x)[1])
                    {
                        j = false;
                    }
                }
                for (int x = 0; x < C.size(); x++)
                {
                    if(C.get(x)[0] >= starts[i] && C.get(x)[0] < ends[i])
                    {
                        c = false;
                    }
                    if(ends[i] > C.get(x)[0] && ends[i] <= C.get(x)[1])
                    {
                        c = false;
                    }
                    if(C.get(x)[1] > starts[i] && C.get(x)[1] <= ends[i])
                    {
                        c = false;
                    }
                    if(starts[i] >= C.get(x)[0] && starts[i] < C.get(x)[1])
                    {
                        c = false;
                    }
                    if(C.get(x)[0] <= starts[i] && C.get(x)[1] >= ends[i])
                    {
                        c = false;
                    }
                    if(starts[i] <= C.get(x)[0] && ends[i] >= C.get(x)[1])
                    {
                        c = false;
                    }
                }
                if(!c && !j)
                {
                    impossible = true;
                    break;
                }
                else if(c && !j)
                {
                    tasks[i] = "C";
                    int[] arr = {starts[i], ends[i]};
                    C.add(arr);
                }
                else if(!c && j)
                {
                    tasks[i] = "J";
                    int[] arr = {starts[i], ends[i]};
                    J.add(arr);
                }
                else if(c && j)
                {
                    tasks[i] = "C";
                    int[] arr = {starts[i], ends[i]};
                    C.add(arr);
                }
            }

            System.out.print("Case #" + o + ": ");
            if(impossible)
            {
                System.out.print("IMPOSSIBLE\n");
            }
            else
            {
                for(int i = 0; i<tasks.length; i++)
                {
                    System.out.print(tasks[i]);
                }
                // System.out.print("\n");
            }
        }
    }
}
