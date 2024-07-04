import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution
{
    public static void main(String args[])
    {
      Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t=in.nextInt();
      for (int case_num = 1; case_num <= t; case_num ++){
          BigInteger sum=BigInteger.valueOf(0);
          int col=0,row=0,flagr=0,flagc=0;
        int n=in.nextInt();
        int arr[][] = new int[n][n];
        HashSet<Integer> setr = new HashSet<Integer>();
        HashSet<Integer> setc = new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
            {
            arr[i][j] = in.nextInt();
            if(i==j)
            sum =sum.add(BigInteger.valueOf(arr[i][j]));
        }
        }
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
        {
            if(flagr==0){
            if(setr.contains(arr[i][j]))
            {row++;flagr=1;}
            else
            setr.add(arr[i][j]);}
            if(flagc==0){
            if(setc.contains(arr[j][i]))
            {col++;flagc=1;}
            else
            setc.add(arr[j][i]);}
            if(flagc==1&&flagr==1)
            break;
        }setc.clear();
        setr.clear();
        flagc=flagr=0;
    }
        
        System.out.println("Case #"+case_num+": "+sum+" "+row+" "+col);
        }}}