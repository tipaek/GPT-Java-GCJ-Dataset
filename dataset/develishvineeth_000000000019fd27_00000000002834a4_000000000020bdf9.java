import java.util.*;


class pairs
{
    int start ;
    int end;
    int no;
    pairs(int start,int end,int no)
    {
        this.start=start;
        this.end=end;
        this.no=no;
    }
}
class sortcomparator implements Comparator<pairs> 
{ 
   
    public int compare(pairs a, pairs b) 
    { 
        return a.start - b.start; 
    } 
} 
public class Solution
{
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int t=s.nextInt();
        int Case=1;
        while(t-->0)
        {
            int n=s.nextInt();
            pairs[] arr=new pairs[n];
            for(int i=0;i<n;i++)
                arr[i]=new pairs(s.nextInt(), s.nextInt(), i);
            Arrays.sort(arr,new sortcomparator() );
            String task="J";
            String[] ch=new String[n];
            Arrays.fill(ch,"0");
            pairs j=null;
            pairs c=null;
            boolean flag=false;
            for(int i=0;i<n;i++)
            {
                
                ch[arr[i].no]=task;
                if(i<n-1 && arr[i].end>arr[i+1].start)
                {
                    if(task.equals("J"))
                    {
                        j=arr[i];
                        task="C";
                        if(c!=null && c.end>arr[i+1].start)
                        {
                            flag=true;
                            break;
                        }
                    }
                    else
                    {
                        c=arr[i];
                         task="J";
                         if(j!=null && j.end>arr[i+1].start)
                         {
                             flag=true;
                             break;
                         }
                    }

                    
                }
                else
                {
                    if(task.equals("J"))
                    j=arr[i];
                    else
                    c=arr[i];
                }


            }
            System.out.print("Case #"+Case+": ");
            Case++;
            if(flag)
            System.out.println("IMPOSSIBLE");
            else
            {
                for (String i : ch) {
                    System.out.print(i);
                }
                System.out.println();
            }

        }
    }

}