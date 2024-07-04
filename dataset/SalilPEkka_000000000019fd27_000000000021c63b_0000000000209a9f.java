import java.util.*;
class Solution
{
    static class storeS implements Comparable<storeS>
    {
        int st=0,en=0,in=0;
        String ch="";
        storeS(int s,int e,int i,String c)
        {
            st=s;
            en=e;
            in=i;
            ch=c;
        }
        
        @Override
        public int compareTo(storeS s)
        {
            if(st==s.st)  
                return 0;  
            else if(st>s.st)  
                return 1;  
            else  
            return -1;  
        }
        
    }
    
   static class storeI implements Comparable<storeI>
    {
        int st=0,en=0,in=0;
        String ch="";
        storeI(int s,int e,int i,String c)
        {
            st=s;
            en=e;
            in=i;
            ch=c;
        }
        
        @Override
        public int compareTo(storeI s)
        {
            if(in==s.in)  
                return 0;  
            else if(in>s.in)  
                return 1;  
            else  
            return -1;  
        }
        
    }
    
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        for(int it=1;it<=t;it++)
        {
            int n=ob.nextInt();
            storeS stores[]=new storeS[n];
            storeI storei[]=new storeI[n];
            for(int i=0;i<n;i++)
            {
                int sta=ob.nextInt();
                int end=ob.nextInt();
                stores[i]=new storeS(sta,end,i+1,"N");
               
            }
            
            int Cs=0,Ce=0,Rs=0,Re=0,br=0;
            Arrays.sort(stores);
            for(int i=0;i<n;i++)
            {
                storei[i]=new storeI(stores[i].st,stores[i].en,stores[i].in,stores[i].ch);
            }
            
            first:
            for(int i=0;i<n;i++)
            {
                int st=stores[i].st,et=stores[i].en;
                if(i==0)
                {
                    stores[i].ch="C";
                    storei[i].ch="C";
                    Cs=st;
                    Ce=et;
                   
                    
                }
                else if(i==1)
                {
                    stores[i].ch="J";
                    storei[i].ch="J";
                    Rs=st;
                    Re=et;
                   
                }
                else
                {
                    if(st>=Ce)
                    {
                        stores[i].ch="C";
                        storei[i].ch="C";
                        Cs=st;
                        Ce=et;
                       
                    }
                    else if(st>=Re)
                    {
                        stores[i].ch="J";
                        storei[i].ch="J";
                        Rs=st;
                        Re=et; 
                      
                    }
                    else
                    {
                        System.out.println("Case #"+it+": IMPOSSIBLE");
                        br=1;
                        break first;
                    }
                }
            }
            if(br==0)
            {
            Arrays.sort(storei);
            
            System.out.print("Case #"+it+": ");
            for(int i=0;i<n;i++)
            {
                System.out.print(storei[i].ch);
            }
            System.out.println();
            }
        }
    }
            
}