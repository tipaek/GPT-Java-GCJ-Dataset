import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int c=1;c<=t;c++)
        {
            int r=sc.nextInt();
            int s=sc.nextInt();
            ArrayList<ArrayList<Integer>> list=new ArrayList<>();
            find(r,s,list);
            System.out.println("Case #"+c+": "+list.size());
            for(ArrayList<Integer> temp:list)
                System.out.println(temp.get(0)+" "+temp.get(1));
        }
    }
    public static void find(int r,int s,ArrayList<ArrayList<Integer>> list)
    {
        if(r<=1 || s<=1)
            return;
        for(int sc=1;sc<s;sc++)
        {
            int x=r*(s-1)-sc+1;
            int y=r-1;
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(x);temp.add(y);
            list.add(temp);
        }
        find(r-1,s,list);
    }
}