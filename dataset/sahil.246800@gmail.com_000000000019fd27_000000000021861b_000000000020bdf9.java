import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++){
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int[][] a = new int[n][2];
            int[] arr = new int[1441];
            int[] brr = new int[1441];
            int[] b = new int[1441];
            for(int j=0; j<n; j++){
                a[j][0] = sc.nextInt();
                a[j][1] = sc.nextInt();
                arr[a[j][0]]++;
                brr[a[j][1]-1]--;
            }
            int count = 0;
            boolean flag = false;
            for(int j=0; j<1441; j++){
                count+=arr[j];
                if(count>=3){
                    flag = true;
                    break;
                }
                count+=brr[j];
            }
            if(flag){
                str.append("IMPOSSIBLE");
            }
            else{
                for(int j=0; j<n; j++){
                    int counter = 1;
                    for(int k=a[j][0];k<a[j][1];k++){
                        if(b[k]!=0){
                            counter = (b[k]==1)?2:1;
                        }
                    }
                    for(int k=a[j][0];k<a[j][1];k++){
                        b[k]=counter;
                    }
                    str.append((counter==1)?"C":"J");
                }
            }
            System.out.println("Case #"+i+": "+str);
        }
    }
}