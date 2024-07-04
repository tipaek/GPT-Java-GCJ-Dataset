import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tcases=sc.nextInt();
        for(int t=0;t<tcases;t++)
        {   int sum=0,rowsum=0,colsum=0;
            int num=sc.nextInt();
            int arr[][]=new int[num][num];
            for(int p=0;p<num;p++)
            {
                for(int q=0;q<num;q++)
                {
                    arr[p][q]=sc.nextInt();
                    if(p==q)
                    sum+=arr[p][q];
                }
            }
            for(int i=0;i<num;i++)
            {
                HashSet<Integer> set= new HashSet<Integer>();
                for(int j=0;j<num;j++)
                {
                 if(!set.add(arr[i][j]))
                  {
                  rowsum++;
                  break;
                  }
                }
            }
            for(int a=0;a<num;a++)
            {
                HashSet<Integer> set= new HashSet<Integer>();
                for(int b=0;b<num;b++)
                {
                 if(!set.add(arr[b][a]))
                  {
                  colsum++;
                  break;
                  }
                }
            }
           
            
            System.out.println("Case #"+(t+1)+": "+sum+" "+rowsum+" "+colsum);
            
        }
    }
}