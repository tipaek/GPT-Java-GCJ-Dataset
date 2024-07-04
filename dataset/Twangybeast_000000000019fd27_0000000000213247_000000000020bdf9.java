import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new FileReader("in.txt"));

        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++)
        {
            int N = in.nextInt();

            int[] starts = new int[N];
            int[] ends = new int[N];
            ArrayList<Integer> events = new ArrayList<>();
            for (int i = 0; i < N; i++)
            {
                starts[i] = in.nextInt();
                ends[i] = in.nextInt();
                events.add(i);
            }

            String result = "";
            int C = -1;
            int J = -1;
            Collections.sort(events, Comparator.comparingInt(o -> starts[o]));
            for (int event : events) {
                int time = starts[event];
                if (C != -1) {
                    if (ends[C] <= time) {
                        C = -1;
                    }
                }
                if (J != -1) {
                    if (ends[J] <= time) {
                        J = -1;
                    }
                }
                if (C == -1) {
                    C = event;
                    result += "C";
                } else if (J == -1) {
                    J = event;
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", t + 1, result);
        }
        in.close();
    }
}
