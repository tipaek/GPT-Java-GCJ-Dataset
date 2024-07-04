import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int x=1;x<=t;x++){
            int n=in.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            int k=0;
            for(int i=0;i<n;i++) {
                k+=arr[i][i];
            }
            int r=0,c=0;boolean check=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-1;j++){
                    for(int y=j+1;y<n;y++){
                        if(arr[i][j]==arr[i][y]){
                            r++;
                            check=true;
                            break;
                        }
                    }
                    if(check){
                        check=false;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n-1;j++){
                    for(int y=j+1;y<n;y++){
                        if(arr[j][i]==arr[y][i]){
                            c++;
                            check=true;
                            break;
                        }
                    }
                    if(check){
                        check=false;
                        break;
                    }
                }
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
    }
}