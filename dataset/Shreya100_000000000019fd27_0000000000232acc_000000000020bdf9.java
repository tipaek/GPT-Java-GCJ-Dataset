import java.util.*;

public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            int i, j;
            int b[] = new int[n*2];
            int k=0;
            HashMap<Integer, Character> h = 
            new HashMap<Integer, Character>();
            for(i=0;i<n;i++)
            {
                for(j=0;j<2;j++)
                {
                    a[i][j] = sc.nextInt();
                    b[k++] = a[i][j];
                }
                if(!h.containsKey(a[i][0]))
                {
                    h.put(a[i][0], 'a');
                }
                else
                {
                    if(h.get(a[i][0]) == 'd')
                    {
                        h.put(a[i][0], '0');
                    }
                }
                if(!h.containsKey(a[i][1]))
                {
                    h.put(a[i][1], 'd');
                }
                else
                {
                    if(h.get(a[i][1]) == 'a')
                    {
                        h.put(a[i][1], '0');
                    }
                }
                
               // h.put(a[i][1], 'd');
            }
            
            Arrays.sort(b);
            int count=0;
            int max=0;
            int res=1;
            for(i=0;i<b.length;i++)
            {
              if(h.get(b[i]) == 'a')
              {
                  count++;
              }
              else if(h.get(b[i]) == 'd')
              {
                  count--;
              }
              max = Math.max(count, max);
              if(max>2)
              {
                  if(b[i] != b[i+1] )
                  {
                      res=0;
                      break;
                  }
                  else if(h.get(b[i]) == h.get(b[i+1]))
                  {
                      res=0;
                      break;
                  }
              }
            }
            
            String ans = "";
            if(res==0)
            {
                ans = "IMPOSSIBLE";
            }
            else
            {
              ans = ans+'C';
              char z = 'C';
              for(i=1;i<n;i++)
              {
                  if(a[i][0] < a[i-1][1])
                  {
                      z = swap(z);
                  }
                  ans = ans+z;
              }
            }
            System.out.println("Case #"+t+": "+ans);
            h.clear();
        }
    }
    
    static char swap(char a)
    {
        if(a == 'C')
        {
            return 'J';
        }
        else
        return 'C';
    }
}