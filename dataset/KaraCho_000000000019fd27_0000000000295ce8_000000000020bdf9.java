import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for(int t = 1; t <= T; t++) {
            ////////////////////////
            
            int n = in.nextInt();
            String[] schedule = new String[n];
            ArrayList<Integer> c = new ArrayList<>();
            ArrayList<Integer> j = new ArrayList<>();
            schedule[0] = "C";
            c.add(in.nextInt());
            c.add(in.nextInt());
            boolean possible = true;
            for ( int i = 1; i < n; i++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                int ind = 0;
                boolean working = false;
                
                if (schedule[i-1].equals("C"))
                {
                    while (ind < c.size()-1)
                    {
                        if ((start > c.get(ind) && start < c.get(ind+1)) || (end > c.get(ind) && end < c.get(ind+1)))
                        {
                            working = true;
                            break;
                        }
                        ind+=2;
                    }
                }
                
                else 
                {
                    while (ind < j.size()-1)
                    {
                        if ((start > j.get(ind) && start < j.get(ind+1)) || (end > j.get(ind) && end < j.get(ind+1)))
                        {
                            working = true;
                            break;
                        }
                        ind+=2;
                    }
                }
                
                
                if (working == false && schedule[i-1].equals("C"))schedule[i] = "C";
                else if (working == false && schedule[i-1].equals("J"))schedule[i] = "J";
                else if (working == true && schedule[i-1].equals("C")) schedule[i] = "J";
                else schedule[i] = "C";
                int k = 0;
                if (schedule[i].equals("C"))
                {
                    c.add(start);
                    c.add(end);
                    
                    while (k < c.size()-1)
                    {
                        if ((start > c.get(k) && start < c.get(k+1)) || (end > c.get(k) && end < c.get(k+1)))
                        {
                            possible = false;
                            break;
                        }
                        k+=2;
                     }
                }
                else {
                    
                    j.add(start);
                    j.add(end);
                    while (k < j.size()-1)
                    {
                        if ((start > j.get(k) && start < j.get(k+1)) || (end > j.get(k) && end < j.get(k+1)))
                        {
                            possible = false;
                            break;
                        }
                        k+=2;
                     }
                }
                
                
            
            
            
                
            
        }
                if (possible )
                {
                    System.out.print("Case #" + t + ": ");
                    for (String s : schedule)
                    {
                        System.out.print(s);
                    }
                    System.out.println();
                }
                else
                {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
    }
}
}