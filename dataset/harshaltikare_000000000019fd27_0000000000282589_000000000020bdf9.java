import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        if(t<1 && t>100){
            System.exit(0);
        }
        for(int z=1;z<=t;z++){
            //main code starts
            int n=sc.nextInt();

            int [][] arr=new int[n][2];
            for(int i=0;i<n;i++){
                for(int j=0;j<2;j++){
                    arr[i][j]=sc.nextInt();
                    if(arr[i][j]<0 && arr[i][j]>1440){
                        System.exit(0);
                    }
                }
            }//input taken
            for(int i=0;i<n;i++){
                if(arr[i][1]<arr[i][0]){
                    System.exit(0);
                }
            }

            //impossible condition
            int flag=0;
            for(int i=0;i<n;i++){
                for(int k=i;k<n;k++){
                    if(k==i){
                        continue;
                    }
                    if((arr[k][0]<arr[i][1] && arr[k][0]>arr[i][0]) || (arr[k][1]<arr[i][1] && arr[k][1]>arr[i][0]) || (arr[k][0]==arr[i][0] && arr[k][1]==arr[i][1])){
                        for(int l=k;l<n;l++){
                            if(l==k || l==i){
                                continue;
                            }
                            if((arr[l][0]>arr[k][0] && arr[l][0]<arr[k][1] && arr[l][0]>arr[i][0] && arr[l][0]<arr[i][1]) || (arr[l][1]>arr[k][0] && arr[l][1]<arr[k][1] && arr[l][1]>arr[i][0] && arr[l][1]<arr[i][1])){
                                flag=1;
                            }
                            if((arr[l][0]==arr[k][0] && arr[l][1]==arr[k][1]) || (arr[l][0]==arr[i][0] && arr[l][1]==arr[i][1]) || (arr[l][0]==arr[i][0] && arr[l][1]==arr[k][1]) || (arr[l][0]==arr[k][0] && arr[l][1]==arr[i][1]) ){
                                flag=1;
                            }
                        }
                    }


                }
            }
            for(int i=n-1;i>=0;i--){
                if(flag==1){
                    break;
                }
                for(int k=i;k>=0;k--){
                    if(k==i){
                        continue;
                    }
                    if((arr[k][0]<arr[i][1] && arr[k][0]>arr[i][0]) || (arr[k][1]<arr[i][1] && arr[k][1]>arr[i][0]) || (arr[k][0]==arr[i][0] && arr[k][1]==arr[i][1])){
                        for(int l=k;l>=0;l--){
                            if(l==k || l==i){
                                continue;
                            }
                            if((arr[l][0]>arr[k][0] && arr[l][0]<arr[k][1] && arr[l][0]>arr[i][0] && arr[l][0]<arr[i][1]) || (arr[l][1]>arr[k][0] && arr[l][1]<arr[k][1] && arr[l][1]>arr[i][0] && arr[l][1]<arr[i][1])){
                                flag=1;
                            }
                            if((arr[l][0]==arr[k][0] && arr[l][1]==arr[k][1]) || (arr[l][0]==arr[i][0] && arr[l][1]==arr[i][1]) || (arr[l][0]==arr[i][0] && arr[l][1]==arr[k][1]) || (arr[l][0]==arr[k][0] && arr[l][1]==arr[i][1]) ){
                                flag=1;
                            }
                        }
                    }


                }
            }
            if(flag==1){
                System.out.println("Case #"+z+": IMPOSSIBLE");
                continue;
            }

            int[] sol=new int[n];
            flag=1;
            sol[0]=1;
            
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if((arr[j][0]<arr[i][0] && arr[j][1]>arr[i][0]) || (arr[j][0]<arr[i][1] && arr[j][1]>arr[i][1]) || (arr[j][0]==arr[i][0] && arr[j][1]==arr[i][1])){
                        if(sol[j]==1){
                            flag=2;
                        }
                        else{
                            flag=1;
                        }
                    }
                }
                sol[i]=flag;
            }


            System.out.print("Case #"+z+": ");
            for(int i=0;i<n;i++){
                if(sol[i]==1){
                    System.out.print("C");
                }
                else{
                    System.out.print("J");
                }
            }
            System.out.print("\n");
        }
    }
}