import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {
    static Scanner in;
    static {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    public static void main(String[] args) {
        
        int t=in.nextInt();
        int ind=0;
        while(ind<t){
    int n=in.nextInt();
    int d=in.nextInt();
    long a[]=new long[n];
    for(int i=0;i<n;i++)
    {
        a[i]=in.nextLong();
    }
    if(d==1)
    {
        System.out.println("Case #"+(ind+1)+": "+"0");
        ind++;
        continue;
    }
    else
    { int flag=0;
        HashMap<Long,Integer> h=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(!h.containsKey(a[i]))
            h.put(a[i],1);
            else
           {
               if(d==2)
               {
                   flag=1;
                   System.out.println("Case #"+(ind+1)+": "+"0");
                   break;
               }
                h.put(a[i],h.get(a[i])+1);
                if(h.get(a[i])==3)
                {
                    flag=1;
                     System.out.println("Case #"+(ind+1)+": "+"0");
                   break;
                }
           }
           
        }
        if(flag==1)
        {
            ind++;
             continue;
        }
       
         if(d==2)
        {
             System.out.println("Case #"+(ind+1)+": "+"1");
             ind++;
                   continue;
        }
        
        for(Long l : h.keySet())
        {
            if(h.get(l)==2)
            {
                for(Long in : h.keySet())
            {
                
               
                    if(in>l)
                    {
                        flag=1;
                        System.out.println("Case #"+(ind+1)+": "+"1");
                  break;
                    }
                
               
            }
             if(flag==1)
                break;
            }
        }
         if(flag==1)
         {
             ind++;
              continue;
         }
              
                for(Long l : h.keySet())
        {
            if(h.containsKey(l/2))
            {
                flag=1;
                System.out.println("Case #"+(ind+1)+": "+"1");
                  break;
            }
        }
        if(flag==0)
        {
             System.out.println("Case #"+(ind+1)+": "+"2");
        }
        
        
        
       
    }
    ind++;
        }
    }
    private static void EXTRACTED() {
        
    }
}