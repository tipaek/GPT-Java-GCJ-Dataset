import java.util.*;

public class Lunch

{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        for(int t = 0;t < T;t++)
        {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int r = 0,c = 0;
            HashSet<Integer> mapr[] = new HashSet[n];
            HashSet<Integer> mapc[] = new HashSet[n];
            for(int i = 0;i < n;i++)
            {
                mapr[i] = new HashSet<>();
                mapc[i] = new HashSet<>();
            }
            boolean row[] = new boolean[n];
            boolean col[] = new boolean[n];
            Arrays.fill(row,false);
            Arrays.fill(col,false);
            int ans = 0;
            for(int i = 0; i < n;i++)
            {
                for(int j = 0;j < n;j++)
                {
                    a[i][j] = in.nextInt();
                    
                    if(mapr[i].contains(a[i][j]))
                        row[i] = true;
                    
                    if(mapc[j].contains(a[i][j]))
                        col[j] = true;  
                    mapr[i].add(a[i][j]);
                    mapc[j].add(a[i][j]);    
                    if(i == j)
                        ans += a[i][j];
                }
            }
            
            for(int i = 0;i < n;i++)
                if(row[i])
                    r++;
                    
            
            for(int i = 0;i < n;i++)
                if(col[i])
                    c++;
                    
            System.out.println("Case #"+(t+1)+": "+ans+" "+r+" "+c);
        }
    }
}