import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++){
            //main code starts here
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(k<n && k>n*n){
                System.exit(0);
            }

            //matrix
            int[][] arr=new int[n][n];
            int y=0;
            int x=0;
            while(x!=n){
                arr[x][x]=1;
                //System.out.println(x);
                x++;  
            }

            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=0;j<n;j++){
                    sum=sum+arr[j][j];
                }
                if(sum==k){
                    break;
                }
                arr[i][i]=arr[i][i]+1;
                if(i==4){
                    i=0;
                    continue;
                }
            }



            //row and coloumn
            int operate=1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        continue;
                    }

                    //selection
                    int a=1,flag = 0;
                    if(operate==1){
                        for(a=1;a<=n;a++){
                            flag=0;
                            for(int r=0;r<n;r++){
                                if(a==arr[i][r] || a==arr[r][j]){
                                    flag=1;
                                }
                            }

                            //System.out.println(a);
                            if(flag==0){
                                break;
                            }
                            if(flag==1 && a==n-1){
                                operate=2;
                            }
                        }
                    }
                    if(operate==2){
                        for(a=n;a>=1;a--){
                            flag=0;
                            for(int r=0;r<n;r++){
                                if(a==arr[i][r] || a==arr[r][j]){
                                    flag=1;
                                }
                            }

                            //System.out.println(a);
                            if(flag==0){
                                break;
                            }
                            if(flag==1 && a==n-1){
                                operate=2;
                            }
                        }
                    }

                    //System.out.println(flag);
                    arr[i][j]=a;
                }
            }
            int imp=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]==0){
                        System.out.println("Case #"+z+": IMPOSSIBLE");
                        imp=1;
                        break;
                    }
                }
                if(imp==1){
                    break;
                }
            }
            if(imp==1){
                continue;
            }
            System.out.println("Case #"+z+": POSSIBLE");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    }
}