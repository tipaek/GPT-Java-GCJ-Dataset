import javax.swing.*;
import java.util.*;

public class Solution {
    private static class Act
    {
        int s;
        int e;
        int i;

        public Act(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.i = i;
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int c = 1; c <= t; c++)
        {
           int a = in.nextInt();
           List<Act> acts = new ArrayList<>(a);
           for (int i = 0; i < a; i++)
           {
               acts.add(new Act(in.nextInt(), in.nextInt(), i));
           }
            Collections.sort(acts, Comparator.comparingInt(s -> s.s));
           int p1 = -1, p2= -1;
           char p[] = new char[a];
           boolean possible = true;
           for (Act act: acts)
           {
               if (p1 <= act.s)
               {
                   p1 = act.e;
                   p[act.i] = 'C';
               }
               else if (p2 <= act.s)
               {
                   p2 = act.e;
                   p[act.i] = 'J';
               }
               else {
                   possible = false;
                   break;
               }
           }
            if (possible)
                System.out.printf("Case #%d: %s\n", c, new String(p));
            else
                System.out.printf("Case #%d: IMPOSSIBLE\n", c);
        }
    }
}
