import java.util.Scanner;

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
                for(int b=0;b<n;b++){
                    for(int c=b+1;c<(n-b-1);c++){
                        if(arr[a][b]==arr[a][c]){
                            r++;
                            break;
                        }
                    }
                }
            }
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    for(int c=b+1;c<(n-b-1);c++){
                        if(arr[b][a]==arr[c][a]){
                            c++;
                            break;
                        }
                    }
                }
            }
            ans[i][1]=k;
            ans[i][2]=r;
            ans[i][3]=c;
        }
        for(int i=0;i<t;i++) {
            System.out.print("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
    }
}