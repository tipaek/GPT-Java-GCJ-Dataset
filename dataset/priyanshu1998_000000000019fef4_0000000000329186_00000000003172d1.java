import java.util.*;

public class Solution{
    
    static class node{
        long a;
        int f;
        node(long a,int f)
        {
            this.a=a;
            this.f=f;
        }
    }
    static int solve(ArrayList<node> arr,int d,HashMap<Long,Integer> map)
    {
        
        if(d==2)
        {
            int max=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i).f>=d)
                {
                    return 0;
                }
            }
            return max;
        }
        else if(d==3)
        {
            int max=2;
            for(int i=arr.size()-1;i>=0;i--)
            {
                if(arr.get(i).f>=d)
                {
                    return 0;
                }
                if(map.containsKey(arr.get(i).a/2))
                {
                    max=1;
                }
            }
            return max;
        }
        else
        {
            return 0;
        }
        // int max=Integer.MAX_VALUE;
        // for(int i=arr.size()-2;i>=0;i--)
        // {
        //     for(int j=arr.size()-1;j>i;j--)
        //     {
        //         long temp=arr.get(j).a/arr.get(i).a;
        //         long num=temp*arr.get(j).f;
        //         max=Math.min(max,(d-arr.get(i).f)/temp);
        //     }
        // }
        // return max;
    }
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int k=1;
        while(k<=t)
        {
            int n=s.nextInt();
            int d=s.nextInt();
            long arr[]=new long[n];
            HashMap<Long,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                arr[i]=s.nextLong();
                if(!map.containsKey(arr[i]))
                {
                    map.put(arr[i],1);
                }
                else
                {
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }
            
            ArrayList<node> temp=new ArrayList<node>();
            for(long a:map.keySet())
            {
                node newnode=new node(a,map.get(a));
                temp.add(newnode);
            }
            // for(int i=0;i<temp.size();i++)
            // {
            //     System.out.println(temp.get(i).a+" "+temp.get(i).f);
            // }
            System.out.println("Case #"+k+": "+solve(temp,d,map));
            k++;
        }
    }
}