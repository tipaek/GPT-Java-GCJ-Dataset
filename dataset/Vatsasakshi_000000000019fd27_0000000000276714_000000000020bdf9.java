import java.io.*; 
import java.util.*; 
class pair
{
    int s=0;
    int e=0;
}
public class Solution { 
    public static void main(String[] args) throws IOException 
    { 
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tst=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            pair arr[]=new pair[n];
            pair store[]=new pair[n];
            for(int i=0;i<n;i++)
            {
                pair pr=new pair();
                pr.s=sc.nextInt();
                pr.e=sc.nextInt();
                arr[i]=pr;
                store[i]=pr;
            }
            Arrays.sort(store,new Comparator<pair>(){
            public int compare(pair p1,pair p2)
            {
                if(p1.s!=p2.s)
                {
                    return p1.s-p2.s;
                }
                else
                {
                    return p1.e-p2.e;
                }
            }
            }); 
            HashMap<pair,Character> h=new HashMap<>();
            pair j=null;
            pair c=store[0];
            h.put(store[0],'C');
            boolean flag=false;
            for(int i=1;i<n;i++)
            {
                if(c.e<=store[i].s)
                {
                    c=store[i];
                    h.put(store[i],'C');
                }
                else if(j==null || j.e<=store[i].s)
                {
                    j=store[i];
                    h.put(store[i],'J');
                }
                else
                {
                    flag=true;
                    break;
                }
            }
            String ans="";
            if(flag)
            {
                System.out.println("Case #"+tst+": "+"IMPOSSIBLE");
            }
            else
            {
                for(int i=0;i<n;i++)
                {
                    ans+=h.get(arr[i]);
                }
                System.out.println("Case #"+tst+": "+ans);
            }
            tst++;
        }
    } 
}
