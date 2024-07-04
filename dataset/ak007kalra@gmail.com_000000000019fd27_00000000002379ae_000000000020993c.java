import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++){
            int n=input.nextInt();
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[j][k]=input.nextInt();
                }
            }
            HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
            int count=0;
            int count1=0;
            int p=0;
            int q=0;
            int sum=0;
            while (p<n){
                sum+=a[p][q];
                p++;q++;
            }
           A: for(int j=0;j<n;j++){
                hashMap=new HashMap<Integer, Integer>();
                hashMap.put(a[j][0],1);
               // System.out.println(a[j][0]);
                //count=0;
                for(int k=1;k<n;k++){
                    if (hashMap.containsKey(a[j][k])) {
                    count++;
                     //   System.out.println(a[j][k]);
                    continue A;
                    }
                    else {
                        hashMap.put(a[j][k],1);
                        //System.out.println(a[j][k]);
                    }
                    }
                }
           B: for(int j=0;j<n;j++){
                hashMap=new HashMap<Integer,Integer>();
                hashMap.put(a[0][j],1);
               //System.out.println(a[0][j]);
                for(int k=1;k<n;k++){
                    if(hashMap.containsKey(a[k][j])){
                        count1++;
                      //  System.out.println(a[k][j]);
                        continue B;
                    }
                    else {
                        hashMap.put(a[k][j],1);
                        //System.out.println(a[j][0]);
                    }
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+count+" "+count1);

            }

        }
    }
