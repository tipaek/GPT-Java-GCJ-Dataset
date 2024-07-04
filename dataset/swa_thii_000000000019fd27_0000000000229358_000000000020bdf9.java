import java.util.*;
public class Solution{
    int start;
    int end;
    int index;
    Solution(int a,int b,int c)
    {
        start=a;
        end=b;
        index=c;
    }
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            PriorityQueue<Solution> pq=new PriorityQueue<>((lhs,rhs)->(lhs.start-rhs.start));
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            pq.add(new Solution(sc.nextInt(),sc.nextInt(),i));
            int a[]=new int[2];
            char res[]=new char[n];
            int flag=0;
            while(!pq.isEmpty())
            {
                Solution s=pq.poll();
                if(a[0]<=s.start)
                {
                    res[s.index]='J';
                    a[0]=s.end;
                }
                else if(a[1]<=s.start)
                {
                    res[s.index]='C';
                    a[1]=s.end;
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+k+": "+String.valueOf(res));
        }
    }
        
    
}