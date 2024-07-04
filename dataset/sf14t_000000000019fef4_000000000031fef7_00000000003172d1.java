import java.io.*; 
import java.util.*; 
public class Solution {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int n=input.nextInt();
            int d=input.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++) {
                arr[i]=input.nextLong();
            }
            System.out.println("Case #"+t+": "+solve(n,d,arr));
        }
    }
    public static int solve(int n,int d,long arr[]) {
        Arrays.sort(arr);
        if(d==1) {
            return 0;
        }
        if(d==2) {
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    if(arr[i]==arr[j]) {
                        return 0;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    if(arr[j]>arr[i]) {
                        return 1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=j+1;k<n;k++) {
                    if(arr[i]==arr[j] && arr[j]==arr[k]) {
                        return 0;
                    }
                }
            }
        }
         for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(2*arr[i]==arr[j]) {
                    return 1;
                }
            }
        }
         return 2;
    }
}
