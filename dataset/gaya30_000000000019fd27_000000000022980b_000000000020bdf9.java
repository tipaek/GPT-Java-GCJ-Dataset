import java.util.*;
class point{
    int position;
    boolean start;
    point(int x,boolean y)
    {
        position=x;
        start=y;
    }
}
public class Solution implements Comparator<point>{
    public int compare(point p1,point p2)
    {
        if(p1.position<p2.position)
        return -1;
        else if(p1.position==p2.position)
        {
            if(p1.start && !p2.start)
            return 1;
            else if(!p1.start && p2.start)
            return -1;
            else return 0;
        }
        else return 1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt(),tt=1;
        while(tt<=test)
        {
            int n=sc.nextInt(),flag=0;
            ArrayList<point> al=new ArrayList<>();
            HashMap<Integer,Integer> hm=new HashMap<>();
            while(n-->0)
            {
                int a=sc.nextInt(),b=sc.nextInt();
                hm.put(a,b);
                al.add(new point(a,true));
                al.add(new point(b,false));
            }
            Collections.sort(al,new Solution());
            int mat[]=new int[2];
            String res="";
            for(int i=0;i<al.size();i++)
            {
                point p=al.get(i);
                if(p.start)
                {
                    int count=0;
                for(int j=i+1;j<=i+2 && j<al.size();j++)
                {
                   if(al.get(j).start)
                   count++;
                }
                if(count==2)
                {
                    flag=1;break;
                }
                else 
                {
                    if(p.position>=mat[0]){
                        mat[0]=hm.get(p.position);
                        res+="J";
                    }
                    else if(p.position>=mat[1])
                    {
                      mat[1]=hm.get(p.position);
                      res+="C";
                    }
                    else{
                        flag=1;break;
                    }
                }
                }
            }
            if(flag==1)
            System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+tt+": "+res);
            tt++;
        }
    }
}