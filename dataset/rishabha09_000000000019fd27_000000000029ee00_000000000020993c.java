import java.util.*;
import java.io.*;
import java.lang.*;
class Vestigium {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int z = t + 1;
        while(t-->0){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            String s = sc.nextLine();
            for(int i=0; i<n; i++) {
                s = sc.nextLine();
                String sa[] = s.split(" ");
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.valueOf(sa[j]);
                }
            }
            int ans[] = fun(arr);
            System.out.println("Case #" +(z-t)+": " +ans[0]+" "+ans[1]+" "+ans[2]);
        }
        
    }
    
    public static int[] fun(int arr[][]){
        int n = arr.length;
        int res[] = new int[]{0,0,0};
        for(int i=0; i<n; i++) {
            res[0] += arr[i][i];
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(al.contains(arr[i][j])){
                    res[1]++;
                    al.clear();
                    break;
                }else{
                    al.add(arr[i][j]);
                }
            }
            al.clear();
        }
        al.clear();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(al.contains(arr[j][i])){
                    res[2]++;
                    al.clear();
                    break;
                }else{
                    al.add(arr[j][i]);
                }
            }
            al.clear();
        }
        return res;
    }
}