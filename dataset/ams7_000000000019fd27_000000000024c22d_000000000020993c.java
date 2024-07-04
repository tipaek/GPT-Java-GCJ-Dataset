import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=sc.nextInt();
            Integer m[][]=new Integer[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                }
            }

            int trace=0;
            int row=0;
            int col=0;
            for(int i=0;i<n;i++)
            {
//                trace=trace+m[i][i];
//                Set<Integer> sr=new HashSet<>(Arrays.asList(m[i]));
//                if(sr.size()!=n)
//                {
//                    row++;
//                }
                Set<Integer> sr=new HashSet<>();
                Set<Integer> sl=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    {
                        trace=trace+m[i][j];
                    }
                    sr.add(m[i][j]);
                    sl.add(m[j][i]);
                }
                if(sr.size()!=n)
                {
                    row++;
                }
                if(sl.size()!=n)
                {
                    col++;
                }
                sr.clear();
                sl.clear();
            }

            System.out.println(trace+" "+row+" "+col);
        }
    }
}
