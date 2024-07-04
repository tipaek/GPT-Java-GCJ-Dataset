import java.util.*;


class Pair{
        int x;
        int y;
        int ind;
        public Pair(int s1,int s2,int index)
        {
            x=s1;
            y=s2;
            ind=index;
        }
}
class SortbyStart implements Comparator<Pair> 
{ 
    public int compare(Pair a, Pair b) 
    { 
        return a.x - b.x; 
    } 
} 

public class Solution{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++)
        {
            int n =in.nextInt();
            boolean poss=true;
            int cl=0,jl=0;
            ArrayList<Pair> ls=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int x=in.nextInt(),y=in.nextInt();
                Pair p=new Pair(x,y,i);
                ls.add(p);
            }
             Collections.sort(ls, new SortbyStart());
            char arr[]=new char[n];
            for(Pair p:ls)
            {
                int x=p.x,y=p.y,i=p.ind;
                if(x>=cl)
                {
                    cl=y;
                    // result+="C";
                    arr[i]='C';
                }
                else if(x>=jl)
                {
                    jl=y;
                    // result+="J";
                    arr[i]='J';
                }
                else
                {
                    poss=false;
                    break;
                }
            }
            String result=new String(arr);
            if(poss)
            System.out.println("Case #"+l+": "+result);
            else
            System.out.println("Case #"+l+": "+"IMPOSSIBLE");
        }
    }
}