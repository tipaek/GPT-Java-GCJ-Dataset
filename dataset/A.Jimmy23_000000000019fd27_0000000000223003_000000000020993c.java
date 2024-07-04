package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
	int t,n;
	int cas=1;
	t=scan.nextInt();
	while(cas<=t){
	    n=scan.nextInt();
	    int[][] arr= new int[n][n];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            arr[i][j]=scan.nextInt();
            }
        }
        int  diag = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (i == j)
                    diag += arr[i][j];
            }
        }
        int rep1=0,rep2=0,k=0;
        int flag=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                while (k<n-1) {
                    if ((j!=(n-k-1))&& (arr[i][j] == arr[i][n - k - 1])) {
                        rep1++;
                        flag=1;
                        break;
                    } else {
                        k++;
                    }
                }
                k=0;
                if(flag==1)
                    break;
            }

        }
        int flag2=0,p=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                while (p<n-1) {
                    if ((j!=(n-p-1)) && (arr[j][i] == arr[n - p - 1][i])) {
                        rep2++;
                        flag2 = 1;
                        break;
                    } else {
                        p++;
                    }
                }
                    p=0;
                if(flag2==1)
                    break;
            }

        }

        System.out.println("Case #"+cas+": "+diag+" "+rep1+" "+rep2);

	    cas++;
    }
    }
}