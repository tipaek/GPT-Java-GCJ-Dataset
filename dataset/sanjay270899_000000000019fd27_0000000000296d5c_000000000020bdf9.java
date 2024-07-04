import java.util.*;
// Sanjay270899, IIITV, India
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder pc = new StringBuilder();
        int t = sc.nextInt();
        for(int x=1; x<=t; x=x+1)
        {
            int n = sc.nextInt();
            
            ArrayList<Pair> a = new ArrayList<>(n);
            char y[] = new char[n];
            for(int i=0; i<n; i=i+1)
            {
                Pair p = new Pair(sc.nextInt(), 0, i);
                a.add(p);
                p = new Pair(sc.nextInt(), 1, i);
                a.add(p);
            }
            Collections.sort(a);
            int chalu = 0;
            int c = 0;
            int j = 0;
            boolean possible = true;
            HashSet<Integer> h = new HashSet<>();
            for(int i=0; i<2*n; i=i+1)
            {
                if(chalu > 2)
                {
                    possible = false;
                    break;
                }
                int v = a.get(i).v;
                int at = a.get(i).at;
                
                if(a.get(i).t == 0)
                {
                    chalu = chalu + 1;
                    if(c == 0)
                    {
                        c = 1;
                        y[at] = 'C';
                    }
                    else
                    {
                        j = 1;
                        y[at] = 'J';
                    }
                }
                else
                {
                    chalu = chalu - 1;
                    if(y[at] == 'C')
                    {
                        c = 0;
                    }
                    else
                    {
                        j = 0;
                    }
                }
            }
            if(possible)
            {
               pc.append(new String(y) + "\n");
            }
            else
            {
                pc.append("IMPOSSIBLE\n");
            }
        }
        System.out.print(pc);
    }
}

class Pair implements Comparable<Pair>
{
    int v;
    int t;
    int at;
    
    Pair(int v, int t, int at)
    {
        this.v = v;
        this.t = t;
        this.at = at;
    }
    
    public int compareTo(Pair p)
    {
        if(v == p.v)
        {
            return p.t-t;
        }
        else
        {
            return v-p.v;
        }
    }
    
    public String toString()
    {
        return v + " " + t + " " + at;
    }
}