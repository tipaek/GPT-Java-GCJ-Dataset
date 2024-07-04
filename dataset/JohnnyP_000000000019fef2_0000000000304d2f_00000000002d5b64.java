
import java.util.*;

public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int test =0; test< t;test++)
        {
            int r= in.nextInt();
            int s = in.nextInt();

           if(s==0)
           {
               System.out.println("CASE #" + (test +1) + ": 0");
           }else
            {
                int n = r * s;
                int placed =1;

                int count=0;
                ArrayList<Integer> m1 = new ArrayList<>();
                ArrayList<Integer> m2 = new ArrayList<>();
                while(n - placed -s > 0)
                {
                    count++;
                    int t2 = (r - placed / s - 1);
                    int t1 = (n - placed - (r - placed / s -1));
                    m1.add(t1);
                    m2.add(t2);

                    placed++;
                    if(placed % s == 0)
                        n--;
                }

                System.out.println("CASE #" + (test +1) + ": "+count);
                for(int i=0;i<m1.size();i++)
                {
                    System.out.println(m1.get(i) + " " + m2.get(i));
                }
            }

        }
    }

}