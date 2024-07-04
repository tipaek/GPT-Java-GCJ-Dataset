import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Solution {
  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
    int noOfTC = in.nextInt();
    
    for(int i=1; i<=noOfTC; i++) {
        int n=in.nextInt();
        int x=in.nextInt();
        int[][] arr=new int[n][n];
        int num=1;
        int count=0;
        int temp=0;
        boolean flag=false;
        while(count<n){
        int sum=0;
        num=1+count;
        int j=0;
        for(j=0;j<n;j++){
            temp=num+j;
            if(temp>n)
            temp=1;
            int k=0;
            for(k=0;k<n;k++)
            {
                arr[j][k]=temp;
                if(j==k)
                    sum+=temp;
                if(sum==x && j+1==n)
                flag=true;

                if(sum>x)
                break;
                if(temp==n)
                    temp=1;
                else
                temp++;
            }
            // System.out.println("Debug");
            // for(int[] a:arr)
            // System.out.println(Arrays.toString(a));
            // System.out.println("Debug");
            if(k!=n)
            break;
        }
        if(flag){
            System.out.println("Case #"+i+": POSSIBLE");
            for(int[] a:arr)
            {
                String s="";
                for(int t:a)
                    s=s+t+" ";
                System.out.println(s.substring(0,(n*2)-1));
            }
            break;
        }
        else
            count++;
        }
      if(!flag)
            System.out.println("Case #"+i+": IMPOSSIBLE");
    }

  }
}
