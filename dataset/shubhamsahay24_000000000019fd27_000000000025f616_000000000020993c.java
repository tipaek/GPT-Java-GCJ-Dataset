import java.util.*;
class Demo
{
    public static int checkDuplicates(int n,int arr[])
    {
        int c=0;
         for(int i = 0; i < n; i++) {  
            for(int j = i + 1; j < n; j++) {  
                if(arr[i] == arr[j])  
                 c++;
            }  
        }  
        if(c>0)
        return 1;
        else return 0;

    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
       
        
        for(int t1=1;t1<=t;t1++)
        {
            String str="Case ";
            int n=in.nextInt();
            int a[][]=new int[n][n];
            int dm[]=new int[n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                }
            }
            
            int s=0;
            for(int i=0;i<n;i++)
            {
                s+=a[i][i];
                
            }
            int r=0;
            for(int i=0;i<n;i++)
            {
                int q=0;
                for(int j=0;j<n;j++)
                {
                    dm[q]=a[i][j];
                    q++;
                }
                int count=checkDuplicates(n,dm);
                if(count==1)
                r++;
                
            }
            
             int c=0;
            for(int i=0;i<n;i++)
            {
                int q=0;
                for(int j=0;j<n;j++)
                {
                    dm[q]=a[j][i];
                    q++;
                }
                int count=checkDuplicates(n,dm);
                if(count==1)
                c++;
                
            }
            
            str+="#"+t1+": "+s+" "+r+" "+c;
            System.out.println(str);
            
            /* for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(""+a[i][j]);
                }
                System.out.println();
            }*/
            
        }
    }   
}