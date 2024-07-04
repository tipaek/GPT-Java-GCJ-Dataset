import java.util.*;
class node{
    int st;
    int et;
    node(int a,int b)
    {
        this.st=a;
        this.et=b;
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int k=1;
        while(k<=t)
        {
            int n=s.nextInt();
            ArrayList<node> arr=new ArrayList<node>();
            for(int i=0;i<n;i++)
            {
                int st=s.nextInt();
                int et=s.nextInt();
                node newnode=new node(st,et);
                arr.add(newnode);
            }
            Collections.sort(arr,new Comparator<node>(){
                public int compare(node a,node b)
                {
                    if(a.st==b.st)
                    {
                        return a.et-b.et;
                    }
                    else
                    {
                        return a.st-b.st;
                    }
                }
            });
            int c=Integer.MIN_VALUE;;int j=Integer.MIN_VALUE;
            int i=0;
            String ans="Case #"+k+": ";
            while(i<n)
            {
                boolean done=false;
                if(c<=arr.get(i).st)
                {
                    ans=ans+"C";
                    c=arr.get(i).et;
                    done=true;
                    if(j<=arr.get(i).et)
                    {
                        j=Integer.MIN_VALUE;
                    }
                }
                else if(j<=arr.get(i).st)
                {
                    ans=ans+"J";
                    j=arr.get(i).et;
                    done=true;
                    if(c<=arr.get(i).et)
                    {
                        c=Integer.MIN_VALUE;
                    }
                }
                
                if(!done)
                {
                    ans=ans+"IMPOSSIBLE";
                    break;
                }
                i++;
            }
            System.out.println(ans);
            k++;
        }
    }
}