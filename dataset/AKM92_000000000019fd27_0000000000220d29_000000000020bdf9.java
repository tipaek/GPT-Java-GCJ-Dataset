import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    class cust
    {
        int start;
        int end;
        cust(int s,int e)
        {
            start = s;
            end = e;
        }
    }
    
    private void check(Scanner sc, Comparator<cust> cusSort, int i)
    {
        boolean flag = true;
        PriorityQueue<cust> pq = new PriorityQueue(cusSort);
        Map<cust,Integer> mp = new HashMap();
        int N = sc.nextInt();
        int canE = 0, jamE = 0;
        for(int j = 0; j < N; j++)
        {
            int start = sc.nextInt();
            int end = sc.nextInt();
            cust newC = new cust(start, end);
            mp.put(newC, j);
            pq.add(newC);
        }
        StringBuilder sb = new StringBuilder();
        
        for(int j = 0; j<N; j++)
        {
            sb.append("C");
        }
        
        while(!pq.isEmpty())            
        {
            cust obj = pq.poll();
            int j = mp.get(obj);
            if(obj.start >= canE)
            {
                canE = obj.end;
                sb.replace(j, j+1, "C");
            }
            else if(obj.start >= jamE)
            {
                jamE = obj.end;
                sb.replace(j, j+1, "J");
            }
            else
            {
                flag = false;
                break;
            }
        }
        if(!flag)
            System.out.println("Case #" + (i) + ": IMPOSSIBLE");
        else
            System.out.println("Case #" + (i) + ": " + sb.toString());
            
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<cust> cusSort = new Comparator<cust>(){
                @Override
                public int compare(cust c1, cust c2)
                {
                    return c1.start - c2.start;
                }
            };
        int T = sc.nextInt();
        for(int i = 0; i<T; i++)
        {
            
            
            Solution s1 = new Solution();
            s1.check(sc, cusSort, i+1);
            
            
        }
    }
    
}
