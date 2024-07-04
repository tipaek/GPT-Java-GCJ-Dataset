import java.util.*;


class Pair{
        int x;
        int y;
        public Pair(int s1,int s2)
        {
            x=s1;
            y=s2;
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
            String result="";
            int cl=0,jl=0;
            ArrayList<Pair> ls=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int x=in.nextInt(),y=in.nextInt();
                Pair p=new Pair(x,y);
                ls.add(p);
            }
             Collections.sort(ls, new SortbyStart());
            
            for(Pair p:ls)
            {
                int x=p.x,y=p.y;
                if(x>=cl)
                {
                    cl=y;
                    result+="C";
                }
                else if(x>=jl)
                {
                    jl=y;
                    result+="J";
                }
                else
                {
                    poss=false;
                    break;
                }
            }
            if(poss)
            System.out.println("Case #"+l+": "+result);
            else
            System.out.println("Case #"+l+": "+"IMPOSSIBLE");
        }
    }
}