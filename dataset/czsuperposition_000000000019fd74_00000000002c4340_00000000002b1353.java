import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++)
        {
            int N = scanner.nextInt();
            if(N == 1)
            {
                System.out.println("Case #" + (i+1) + ": ");
                System.out.println("1 1");
                continue;
            }
            if(N == 2)
            {
                System.out.println("Case #" + (i+1) + ": ");
                System.out.println("1 1");
                System.out.println("2 2");
                continue;
            }

            int currentotal = 2;
            int Nextnum = 2;
            ArrayList<int[]> steps = new ArrayList<>();
            int[] temp = new int[2];
            temp[0] = 1;
            temp[1] = 1;
            steps.add(temp);
            int[] tempagain = new int[2];
            tempagain[0] = 2;
            tempagain[1] = 2;
            steps.add(tempagain);
            int y = 2;
            int x = 2;

            boolean goingfor1 = false;
            while(true)
            {
                if(currentotal + Nextnum > N)
                {
                    goingfor1 = true;
                    Nextnum = 1;
                    y=1;
                    continue;
                }
                if(currentotal + Nextnum == N)
                {
                    int[] ok = new int[2];
                    x++;
                    ok[0] = x;
                    ok[1] = y;
                    steps.add(ok);
                    break;
                }
                currentotal += Nextnum;
                int[] ok = new int[2];
                x++;
                ok[0] = x;
                ok[1] = y;

                steps.add(ok);
                if(!goingfor1) {
                    Nextnum++;
                }
            }
            System.out.println("Case #" + (i+1) + ": ");
            for(int j=0;j<steps.size();j++)
                System.out.println(steps.get(j)[0] + " " + steps.get(j)[1]);
        }
    }
}
