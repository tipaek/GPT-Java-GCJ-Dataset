import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {
            String qItems = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.print("Case #"+(i+1)+": ");
            int arr_length = qItems.length();
            int[] q = new int[arr_length];
            int temp1 = 0;
            int temp2 = 0;
            String[] qItems_arr = qItems.split("");
            for (int j = 0; j < arr_length; j++){
                int qItem = Integer.parseInt(qItems_arr[j]);
                q[j] = qItem;
            }
            for (int j = 0; j < arr_length; j++){
                if(j==0){
                    for(int k=0; k<q[j];k++){
                        System.out.print("(");
                    }
                    System.out.print(q[j]);
                    if(arr_length==1){
                        for(int k=0; k<q[j];k++){
                            System.out.print(")");
                        }
                        break;
                    }
                    continue;   
                }
                temp1 = q[j-1];
                temp2 =q[j];
                int diff = temp2 - temp1;
                if(diff>0){
                    for(int k=0; k<diff;k++){
                        System.out.print("(");
                    }
                    System.out.print(q[j]);
                }
                if(diff<0){
                    if(temp2==0){
                        System.out.print(")");
                        System.out.print(q[j]);
                        continue;
                    }
                    int diff_mod = diff*(-1);
                    for(int k=0; k<diff_mod;k++){
                        System.out.print(")");
                    }
                    System.out.print(q[j]);
                }
                if(diff==0){
                    System.out.print(q[j]);
                }
                if(j==arr_length-1){
                    for(int k=0; k<q[j];k++){
                        System.out.print(")");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
