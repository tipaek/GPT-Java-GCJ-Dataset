import java.util.*;
import java.io.*;
class vestigium
{
    public static void main(String args[])throws IOException
    {
      Scanner sc =new Scanner(System.in);
      int c =1;
      int t=sc.nextInt();
      while(t-->0){
          int sum=0,col=0,row=0,flagr=0,flagc=0;
        int n=sc.nextInt();
        int arr[][] = new int[n][n];
        HashSet<Integer> setr = new HashSet<Integer>();
        HashSet<Integer> setc = new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
            {
            arr[i][j] = sc.nextInt();
            if(i==j)
            sum += arr[i][j];
            if(flagr==0){
            if(setr.contains(arr[i][j]))
            {row++;flagr=1;}
            else
            setr.add(arr[i][j]);}
        }
        setr.clear();
        flagr=0;
        }
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
        {
            if(setc.contains(arr[j][i]))
            {col++; break;}
            else
            setc.add(arr[j][i]);
        }setc.clear();
    }
        
        System.out.println("Case #"+c+": "+sum+" "+row+" "+col);
        c++;
        }}}