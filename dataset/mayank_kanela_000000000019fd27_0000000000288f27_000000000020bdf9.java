import java.util.*;



public class Solution {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while(i < t)
        {           
            int tok = 1;
            i++;
            int n = sc.nextInt();
            ArrayList<Activities> activities = new ArrayList<>();
            for(int j = 0; j < n; j++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int pos = j;
                activities.add(new Activities(s, e, pos));
            }
            Collections.sort(activities);
            
            int c = activities.get(0).e;
            int jo = Integer.MIN_VALUE; 
            char[] sol = new char[n];
            sol[activities.get(0).pos] = 'C';
            for(int j = 1; j < n; j++)
            {
                if(activities.get(j).s >= activities.get(j - 1).e)
                {   
                    sol[activities.get(j).pos] = 'C';  
                    c = activities.get(j).e;

                } 
                else
                {
                    if(c < activities.get(j).s)
                    {
                        sol[activities.get(j).pos] = 'C';  
                        c = activities.get(j).e;
                    }
                    else 
                        if(jo < activities.get(j).s)
                        {
                            sol[activities.get(j).pos] = 'J';  
                            jo = activities.get(j).e;

                        }
                    else 
                    {
                        tok = 0;
                        break;
                    }
                    
                }
                 
            }
            if(tok == 1)
            System.out.println("Case #" + i + ": " + new String(sol));
            else 
            System.out.println("Case #" + i + ": " +"IMPOSSIBLE");
        
        }
        sc.close();

    }

}

class Activities implements Comparable<Activities> {
    public int s;
    public int e;
    public int pos;
    public char sol;
    Activities(int s, int e, int pos)
    {
        this.s = s;
        this.e = e;
        this.pos = pos;
    }


    @Override
    public int compareTo(Activities o) {
        if(e == o.e)
        return 0;
        else if(e > o.e)
        return 1;
        else
        return -1;
    }
}