import java.util.*;
public class Solution{
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-- > 0)
        {
            int n=sc.nextInt();
            int mat[][]=new int[n][n];int s=0;
            int r=0,c=0;
            List<Set<Integer>> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                Set<Integer> st=new HashSet<>();
                int fl=1;
                for(int j=0;j<n;j++)
                {
                    int k=sc.nextInt();
                    if(i==j )
                    s+=k;
                    mat[i][j]=k;
                    if(!st.add(k)) fl=0;
                    if(i==0) {
                        Set<Integer> temp=new HashSet<>(); temp.add(k);
                        list.add(temp);
                    }
                    list.get(j).add(k);
                }
                if(fl==0) r++;
            }
         
            for(Set k:list)
            if(k.size()!=n) c++;
            
            System.out.println("Case #1: "+s+" "+r+" "+c);
            
        }
        
    }
}