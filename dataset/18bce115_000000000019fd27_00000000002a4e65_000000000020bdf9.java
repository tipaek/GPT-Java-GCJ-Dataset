import java.util.*;

 class Solution {
     public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int z=scan.nextInt();
        for(int t=1;t<=z;t++)
        {
           HashSet<Integer> c=new HashSet<>();
           HashSet<Integer> j=new HashSet<>();
           int flag=1;
           int n=scan.nextInt();
           int mat[][]=new int[n][2];
           int in[]=new int[n];
           char ans[]=new char[n];
           for(int i=0;i<n;i++)
           {
               mat[i][0]=scan.nextInt();
               mat[i][1]=scan.nextInt();
               in[i]=i;
           }
           
           sort(0,n-1,mat,in);
           
           for(int i=0;i<n;i++)
           {
               int a=mat[i][0];
               int b=mat[i][1];
               
               
               if(c.isEmpty() || (!c.isEmpty() && !c.contains(a) && !c.contains(b-1)))
               {
                  ans[in[i]]='C';
                  for(int k=a;k<b;k++)
                   c.add(k);
                 
               }
               else if(j.isEmpty() ||  (!j.isEmpty() && !j.contains(a) && !j.contains(b-1)) )
               {
                  ans[in[i]]='J';
                   for(int k=a;k<b;k++)
                   j.add(k);
               }
               else
               {
                   flag=-1;
                   
               }
           }
           
           if(flag==1)
           {
               StringBuilder res=new StringBuilder();
           for(int i=0;i<ans.length;i++)
           res.append(ans[i]);
           System.out.println("Case #"+t+": "+res);
           }
           else
           System.out.println("Case #"+t+": IMPOSSIBLE");
        }
    }
        static void sort(int l,int h,int arr[][],int in[])
    {
        if(l<h)
        {
           
        int pi=partition(l,h,arr,in);
        for(int i=0;i<arr.length;i++)
        sort(l,pi-1,arr,in);
       
        sort(pi+1,h,arr,in);
        }
    }
   
    static int partition(int l,int h,int arr[][],int in[])
    {
        int pivot=arr[h][0];
        int smallest=l-1;
        int temp=0;
        for(int i=l;i<h;i++)
        {
            if(arr[i][0]<pivot)
            {
                smallest++;
                temp=arr[smallest][0];
                arr[smallest][0]=arr[i][0];
                arr[i][0]=temp;
               
                int temp1=arr[smallest][1];
                arr[smallest][1]=arr[i][1];
                arr[i][1]=temp1;
               
                temp=in[smallest];
                in[smallest]=in[i];
                in[i]=temp;
            }
        }
        temp=arr[smallest+1][0];
        arr[smallest+1][0]=arr[h][0];
        arr[h][0]=temp;
       
        temp=arr[smallest+1][1];
        arr[smallest+1][1]=arr[h][1];
        arr[h][1]=temp;
       
        temp=in[smallest+1];
        in[smallest+1]=in[h];
        in[h]=temp;
        return smallest+1;
    }
}