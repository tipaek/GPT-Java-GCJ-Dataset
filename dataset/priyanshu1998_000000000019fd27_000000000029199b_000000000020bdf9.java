import java.util.*;
class node{
    int st;
    int et;
    char ch;
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
            ArrayList<node> store=new ArrayList<node>();
            for(int i=0;i<n;i++)
            {
                int st=s.nextInt();
                int et=s.nextInt();
                node newnode=new node(st,et);
                arr.add(newnode);
                store.add(newnode);
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
            int c=Integer.MIN_VALUE;int j=Integer.MIN_VALUE;
            int i=0;boolean vis=true;
            String ans="Case #"+k+": ";
            while(i<n)
            {
                if(c<=arr.get(i).st)
                {
                    c=Integer.MIN_VALUE;
                }
                if(j<=arr.get(i).st)
                {
                    j=Integer.MIN_VALUE;
                }
                boolean done=false;
                if(c<=arr.get(i).st)
                {
                    c=arr.get(i).et;
                    done=true;
                    arr.get(i).ch='C';
                }
                else if(j<=arr.get(i).st)
                {
                    j=arr.get(i).et;
                    done=true;
                    arr.get(i).ch='J';
                }
                if(!done)
                {
                    ans="Case #"+k+": "+"IMPOSSIBLE";
                    vis=false;
                    break;
                }
                i++;
            }
            if(vis)
            {
                for(int p=0;p<n;p++)
                {
                    ans=ans+store.get(p).ch;
                }
                System.out.println(ans);
            }
            else
            {
                System.out.println(ans);
            }
            k++;
        }
    }
}