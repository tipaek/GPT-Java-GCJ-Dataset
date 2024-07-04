import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc=new Scanner(System.in);
        int z=sc.nextInt();
        for(int t=1;t<=z;t++)
        {
           HashSet<Integer> c=new HashSet<>();
           HashSet<Integer> j=new HashSet<>();
          // StringBuilder ans=new StringBuilder();
           int f=1;
           int n=sc.nextInt();
           int mat[][]=new int[n][2];
           int in[]=new int[n];
           char ans[]=new char[n];
           for(int i=0;i<n;i++)
           {
               mat[i][0]=sc.nextInt();
               mat[i][1]=sc.nextInt();
               in[i]=i;
           }
           
           sort(0,n-1,mat,in);
           
           for(int i=0;i<n;i++)
           {
               int a=mat[i][0];
               int b=mat[i][1];
               
               if(j.isEmpty() ||  (!j.isEmpty() && !j.contains(a) && !j.contains(b-1)) )
               {
                  ans[in[i]]='J';
                   for(int k=a;k<b;k++)
                   j.add(k);
               }
               else if(c.isEmpty() || (!c.isEmpty() && !c.contains(a) && !c.contains(b-1)))
               {
                  ans[in[i]]='C';
                  for(int k=a;k<b;k++)
                   c.add(k);
                  
               }
               else
               {
                   f=-1;
                   
               }
           }
           
           if(f==1)
           {
               StringBuilder res=new StringBuilder();
           for(int i=0;i<ans.length;i++)
           res.append(ans[i]);
           System.out.println("Case #"+t+": "+res);
           }
           else
           System.out.println("Case #"+t+": IMPOSSIBLE");
        }
      //  System.out.println("XXXXXXXX");
    }
    
    static void sort(int l,int h,int a[][],int in[])
    {
        if(l<h)
        {
            
        int pi=partition(l,h,a,in);
       // System.out.println(l+" "+h+" "+pi);
        for(int i=0;i<a.length;i++)
      //  System.out.print(a[i][0]+" ");
        sort(l,pi-1,a,in);
        
        sort(pi+1,h,a,in);
        }
    }
    
    static int partition(int l,int h,int a[][],int in[])
    {
        int piv=a[h][0];
        int smallest=l-1;
        int temp=0;
        for(int i=l;i<h;i++)
        {
            
            if(a[i][0]<piv)
            {
                smallest++;
                temp=a[smallest][0];
                a[smallest][0]=a[i][0];
                a[i][0]=temp;
                
                int temp1=a[smallest][1];
                a[smallest][1]=a[i][1];
                a[i][1]=temp1;
                
                temp=in[smallest];
                in[smallest]=in[i];
                in[i]=temp;
            }
        }
        temp=a[smallest+1][0];
        a[smallest+1][0]=a[h][0];
        a[h][0]=temp;
        
        temp=a[smallest+1][1];
        a[smallest+1][1]=a[h][1];
        a[h][1]=temp;
        
        temp=in[smallest+1];
        in[smallest+1]=in[h];
        in[h]=temp;
        return smallest+1;
    }
}
