import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for(int i=1;i<=t;i++)
            {
        int t2 = in.nextInt();
        int f=2*t2;
        
        
        int arr[]=new int[f];
        for(int j=0;j<f;j++)
        {
        arr[j]=in.nextInt();
        
        }
        int c=0,c2=0,k=0,k2=0;
        String s="";
        for(int j=0;j<f;j++)
        {if(j%2==0){
        if(j==0){
        c=arr[1];
        c2=arr[0];
        s=s+"C";
        continue;
        }
        if(c==0){
            c=arr[j+1];
            c2=arr[j];
            s=s+"C";
            continue;
        }
        
        if(k==0){
            k=arr[j+1];
            k2=arr[j];
            s=s+"J";
            continue;
        }
        if(arr[j]>=c||(arr[j]<c2&&arr[j+1]<c2))
        {
            c=arr[j+1];
            c2=arr[j];
            s=s+"C";
            continue;
        }
        
        if(arr[j]>=k||(arr[j]<k2&&arr[j+1]<k2))
        {
            k=arr[j+1];
            k2=arr[j];
            s=s+"J";
            continue;
        }
        
        s="IMPOSSIBLE";
        break;
        }
        
        }
        System.out.println("Case #"+i+": "+s);
            }
        }
        }