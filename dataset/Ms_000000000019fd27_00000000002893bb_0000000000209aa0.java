import java.util.*;
public class Solution{
public static int gcd(int n, int k){
            int num=1;
            for(int i=1;i<=n/2;i++){
                if(n%i==0 && k%i==0)
                    num=i;
            }
            return num;
        }
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int m=1;m<=t;m++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int max = n*n;
            if(k>max || k<n){
                System.out.println("Case #"+m+": "+"IMPOSSIBLE");
                continue;
            }
            else if(k%n==0){
                System.out.println("Case #"+m+": "+"POSSIBLE");
                divide(n,k/n);
                continue;
            }
            else if(gcd(k,n)>1){
                System.out.println("Case #"+m+": "+"POSSIBLE");
                print(k);
                continue;
            }
            else
                System.out.println("Case #"+m+": "+"IMPOSSIBLE");
        }
    }     
    public static void divide(int n,int k){
        int arr[] = new int[n];
        int ar[][] = new int[n][n];
        HashMap<Integer,Integer> map = new HashMap<>();
        arr[0]=k;
        map.put(k,1);
        int s=1,b=1;
        while(b<n){
            if(!map.containsKey(s)){
                arr[b]=s;
                map.put(s,1);
                b++;
            }
            s++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ar[i][j] = arr[j];
            }
            int t = arr[arr.length-1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0]=t;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void print(int s){
        int arr2[][] = {{2,3,1,4},{3,2,4,1},{1,4,3,2},{4,1,3,2}};
        int arr3[][] = {{3,1,4,2},{1,4,2,3},{4,2,3,1},{2,3,1,4}};
        int arr1[][] = {{1,3,2,4},{4,2,3,1},{2,4,1,3},{3,1,4,2}};
        if(s==6){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
        }
        if(s==10){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
        }
        if(s==14){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        }
    }
}