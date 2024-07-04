import java.util.*;
import java.io.*;

class Solution{

    public static int permut[][];
    public static int k,n;
    public static ArrayList<int[][]> list = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            n = in.nextInt();
            k = in.nextInt();
            permut = new int[n][n];
            for(int i=0;i<n;i++){
                permut[i] = getSample(n,i);
            }
            permute(getStr(n), 0, n - 1);
            if(list.size()>0){
                System.out.println("Case #"+(t+1)+": POSSIBLE");
                print(list.get(0));
            }
            else{
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }
            list.clear();
        }
    }

    public static void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String getStr(int n){
        String s = "";
        for(int i=1;i<=n;i++){
            s+=i;
        }
        return s;
    }

    public static int[] getSample(int size, int shift){
        int a[] = getSample(size);
        int b[] = new int[size];
        int index = 0;
        for(int i=size-1-shift;i<size;i++){
            b[index++] = a[i];
        }
        for(int i=0;i<size-1-shift;i++){
            b[index++] = a[i];
        }
        return b;
    }

    public static int[] getSample(int size){
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = i+1;
        }
        return a;
    }

    public static void check(String s){
        int sum = 0;
        int result[][] = new int[n][n];
        for(int i=0;i<s.length();i++){
            int I = s.charAt(i) - 48 - 1;
            sum+=permut[I][i];
            result[i] = permut[I];
        }
        if(sum == k){
            list.add(result);
        }
    }

    private static void permute(String str, int l, int r)
    {
        if (l == r) {
            check(str);
        }
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    
}
