

import java.util.*;

public class Solution {
    public static int[] rotate(int[] a){
        int[] temp=new int[a.length];
        temp[0]=a[a.length-1];
        for (int i=1; i<a.length; i++){
            temp[i]=a[i-1];
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int b=1; b<=t; b++){
            int n=s.nextInt(), k=s.nextInt();
            int[][] a=new int[n][n];
            int[] temp=new int[n];
            for(int i=0; i<n; i++)
                temp[i]=i+1;
            boolean flag=false;
            int sum=0;
            for(int i=1; i<=n; i++){
                sum= n*i;
                if(sum==k) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("Case #"+b+": IMPOSSIBLE");
            else {
                sum=sum/n;
                while(sum!=temp[0])
                    temp=rotate(temp);
                for(int i=0; i<n; i++){
                    a[i]=temp;
                    temp=rotate(temp);
                }
                System.out.println("Case #"+b+": POSSIBLE");
                for(int i=0; i<n;i++){
                    for(int j=0; j<n; j++){
                        System.out.print(a[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }

        }
    }
}
