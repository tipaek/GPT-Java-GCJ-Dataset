
import java.util.*;
import java.lang.*;
import java.io.*;
class Chart{
    int start;
    int end;
    int order;
    String assigned;
    Chart(int start,int end,int order)
    {
        this.start=start;
        this.end=end;
        this.order=order;
        this.assigned=null;
    }
 
}
class Solution
{
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tt=1;
        Comparator<Chart> c=(o1,o2)->{
            if (o1.start==o2.start)
            {
                return Integer.compare(o1.end, o2.end);
            }
            return Integer.compare(o1.start, o2.start);
        };
        Comparator<Chart> ord=(o1,o2)->{
         
            return Integer.compare(o1.order, o2.order);
        };
        while(tt<=t){
           int n=sc.nextInt();
           ArrayList<Chart> a=new ArrayList<Chart>();
           for(int i=0;i<n;i++)
           {
            a.add(new Chart(sc.nextInt(),sc.nextInt(),i));
           }
           Collections.sort(a,c);
           int flag=0;
           int x1=-1,y1=-1,x2=-1,y2=-1;
           for(int i=0;i<n;i++){
          
                if(y1<=a.get(i).start)
                {
                    x1=a.get(i).start;
                    y1=a.get(i).end;
                    a.get(i).assigned="C";

                }
                else if(y2<=a.get(i).start)
                {
                    x2=a.get(i).start;
                    y2=a.get(i).end;
                    a.get(i).assigned="J";
                }
                else{
                    flag=1;
                }
            }
            if(flag==1){
                System.out.println("Case #"+tt+": IMPOSSIBLE");
            }
            else{
                Collections.sort(a,ord);
                String ans="";
                 for(int i=0;i<n;i++){
                    ans+=a.get(i).assigned;
                }
                 System.out.println("Case #"+tt+": "+ans);
            }
          
            tt++;
        }
      sc.close();
    }


}