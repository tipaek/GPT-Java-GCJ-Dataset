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
class pos implements Comparator<pos>{
   int num;
   int position;
   pos(){}
   pos(int x,int y)
   {
       
       num=x;
       position=y;
   }
   public int compare(pos p1,pos p2){
       return -(p1.num-p2.num);
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
            String arr[]=new String[n];
            ArrayList<point> al=new ArrayList<>();
            LinkedHashMap<Integer,ArrayList<pos>> hm=new LinkedHashMap<>();
           for(int i=0;i<n;i++)
            {
                int a=sc.nextInt(),b=sc.nextInt();
                if(hm.containsKey(a))
                {
                    pos p=new pos(b,i);
                    ArrayList<pos> aa=hm.get(a);
                    aa.add(p);
                    hm.put(a,aa);
                }
                else
                {
                    ArrayList<pos> aa=new ArrayList<>();
                    pos p=new pos(b,i);
                    aa.add(p);
                    hm.put(a,aa);
                }
                al.add(new point(a,true));
                al.add(new point(b,false));
            }
            for(Map.Entry<Integer,ArrayList<pos>> m:hm.entrySet())
            {
                Collections.sort(m.getValue(),new pos());
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
                        ArrayList<pos> a=hm.get(p.position);
                        mat[0]=(a.get(0).num);
                        arr[a.get(0).position]="J";
                         a.remove(0);
                    }
                    else if(p.position>=mat[1])
                    {
                        ArrayList<pos> a=hm.get(p.position);
                        mat[1]=(a.get(0).num);
                        arr[a.get(0).position]="C";
                         a.remove(0);
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
            {
                System.out.print("Case #"+tt+": ");
               for(int i=0;i<n;i++)
               System.out.print(arr[i]);
               System.out.println();
            }
            tt++;
        }
    }
}