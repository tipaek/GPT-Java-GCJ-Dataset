import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ParentingPartneringReturns
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("parent.in"));
        int testCases = Integer.parseInt(sc.nextLine());

        for(int o = 1; o<=testCases; o++)
        {
            int numTasks = Integer.parseInt(sc.nextLine());
            int[] starts = new int[numTasks];
            int[] ends = new int[numTasks];
            String[] tasks = new String[numTasks];
            ArrayList<int[]> J = new ArrayList<>();
            ArrayList<int[]> C = new ArrayList<>();

            String[] split;
            for(int i = 0; i<numTasks; i++)
            {
                split = sc.nextLine().split(" ");
                starts[i] = Integer.parseInt(split[0]);
                ends[i] = Integer.parseInt(split[1]);
            }

            boolean impossible = false;
            boolean j = true;
            boolean c = true;
            for(int i = 0; i<numTasks; i++)
            {
                c = j = true;
                for(int x = 0; x < J.size(); x++)
                {
                    if(J.get(x)[0] > starts[i] && J.get(x)[0] < ends[i])
                    {
                        j = false;
                    }
                    else if(J.get(x)[1] > starts[i] && J.get(x)[1] < ends[i])
                    {
                        j = false;
                    }
                    else if(J.get(x)[0] < starts[i] && J.get(x)[1] > ends[i])
                    {
                        j = false;
                    }
                }
                for (int x = 0; x < C.size(); x++)
                {
                    if(C.get(x)[0] > starts[i] && C.get(x)[0] < ends[i])
                    {
                        c = false;
                    }
                    else if(C.get(x)[1] > starts[i] && C.get(x)[1] < ends[i])
                    {
                        c = false;
                    }
                    else if(C.get(x)[0] < starts[i] && C.get(x)[1] > ends[i])
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
                else
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
                System.out.print("\n");
            }
        }
    }
}
