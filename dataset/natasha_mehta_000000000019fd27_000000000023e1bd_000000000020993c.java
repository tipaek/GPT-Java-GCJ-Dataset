/*nclude<iostream>
using namespace std;
int i,j,t,n;
cin>>t;
cin>>n;
void findTrace(int a[],int n){
    int trace=0;
    for(i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==j)
                trace=trace+a[i][j];
        }
    }
    cout<<trace;
}
void nrows(int a[],int n){
int count=0,nr=0;
for(int i=0;i<t;i++){
    for(int j=0;j<n;i++){
        if(a[i][j]==a[i][j+1]){
            count++;
        }
    }
    if(count>0)
        nr++;
}
cout<<nr;
}
void ncol(int a[],int n){
    int count=0,nc=0;
for(int i=0;i<t;i++){
    for(int j=0;j<n;i++){
        if(a[i][j]==a[i][j+1]){
            count++;
        }
    }
    if(count>0)
        nr++;
}
cout<<nr;
}*/

import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k = 0; k<t; k++){
            int n=sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int rCount=0;int flag=0;
            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    if(arr[i][0]==arr[i][j]){
                        flag=1;
                    }
                }
                if(flag==1){
                    rCount++;
                }
            }
            flag=0;int cCount=0;
            for(int i=0;i<n;i++){
                int f=0;
                for(int j=1;j<n;j++){
                    if(arr[0][i]==arr[j][i] || arr[f][i]==arr[j][i]){

                        flag=1;
                        break;
                    }
                    f++;
                }
                if(flag==1){
                    cCount++;
                    
                }
                flag=0;
            }
            int sum=0;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            System.out.println("Case#"+(k+1) +": " + (sum)+ " " + (rCount) + " "+ (cCount));
        }
    }
}