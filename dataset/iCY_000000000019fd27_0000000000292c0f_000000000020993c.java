import java.util.*;

class Vestigium {
    public static void main(String [] args) {
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        int ans[][]=new int[t][3];
        for(int i=0;i<t;i++) {
            int n=kb.nextInt();
            int k=0;
            int r=0;
            int c=0;
            int arr[][]=new int[n][n];
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    arr[a][b]=kb.nextInt();
                }
            }
            for(int a=0;a<n;a++){
                k=k+arr[a][a];
            }
            for(int a=0;a<n;a++){
                for(int b=0;b<n-1;b++){
                    int z=0;
                    for(int d=b+1;d<n;d++){
                        if(arr[a][b]==arr[a][d]){
                            r++;
                            z=1;
                            break;
                        }
                    }
                    if(z==1)
                        break;
                }
            }
            for(int a=0;a<n;a++){
                for(int b=0;b<n-1;b++){
                    int z=0;
                    for(int d=b+1;d<n;d++){
                        if(arr[b][a]==arr[d][a]){
                            c++;
                            z=1;
                            break;
                        }
                    }
                    if(z==1)
                        break;
                }
            }
            ans[i][0]=k;
            ans[i][1]=r;
            ans[i][2]=c;
        }
        for(int i=0;i<t;i++) {
            System.out.println("Case #"+(i+1)+": "+ans[i][0]+" "+ans[i][1]+" "+ans[i][2]);
        }
    }
}
