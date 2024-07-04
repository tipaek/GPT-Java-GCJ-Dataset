import java.util.*;
import java.io.*;
class Non
  {    public static void main(String args[])
    {
    Scanner k=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc,n;
    tc=k.nextInt();
   
    int arr[][];
    while(tc>0)
    {
         n=k.nextInt();
        arr =new int[n][n];
        for(int i=0;i<n;i++)
        {
        for(int j=0;j<n;j++)
        {
            arr[i][j]=k.nextInt();           
        }
      }
      cal(arr,n);
      tc--;
    }
    }
    public static void cal(int ar[][] ,int n)
    {
    int k=0,r=0,c=0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i==j)
            {
                k+=ar[i][j];
            }
                   
        }
    }
    for(int i=0;i<n;i++)
    {
        int temp[]=new int[n];
        for(int j=0;j<n;j++)
        {
            temp[j]=ar[i][j];
        }
        if (Counts(temp,temp.length)==true)
        r++;
    }
    for(int i=0;i<n;i++)
    {
        int temp[]=new int[n];
        for(int j=0;j<n;j++)
        {
            temp[j]=ar[j][i];
        }
        if (Counts(temp,temp.length)==true)
        c++;
    }
    System.out.println(k+" , "+r+"  , "+c);
}
public static boolean Counts(int arr[], int n)  
    { 
        boolean c=false;
      
        int [] fr = new int [arr.length];  
        int visited = -1;  
        
        for(int i = 0; i < arr.length; i++){  
            int count = 1;  
            for(int j = i+1; j < arr.length; j++){  
                if(arr[i] == arr[j]){  
                    count++;  
                    //To avoid counting same element again  
                    fr[j] = visited;  
                }  
            }  
            if(fr[i] != visited)  
                fr[i] = count;  
        }  
        for(int j = 0; j < n; j++) 
        {
            if(fr[j]>1)
            c=true;
        }
       return c;      
    } 
  }  