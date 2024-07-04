import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),x=1;
        while(t-->0)
        {
            int n=sc.nextInt(),i,j;
            int a[][] = new int[n][n];
            long k=0,r=0,c=0;
            Map<Integer,Integer> hm = new HashMap<>();
            for(i=0;i<n;i++)
            {
                for (j=0;j<n;j++)
                {
                    a[i][j] = sc.nextInt();
                    if(i==j)
                        k+=a[i][j];
                }
            }
            for(i=0;i<n;i++)
            {
                hm.clear();
                for(j=0;j<n;j++)
                {
                    if(hm.get(a[i][j])!=null)
                    {
                        r++;
                        break;
                    }
                    else hm.put(a[i][j],1);
                }
            }
            for(i=0;i<n;i++)
            {
                hm.clear();
                for(j=0;j<n;j++)
                {
                    if(hm.get(a[j][i])!=null)
                    {
                        c++;
                        break;
                    }
                    else hm.put(a[j][i],1);
                }
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            x++;
        }
    }
}
