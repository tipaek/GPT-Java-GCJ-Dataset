import java.util.*;
class vestigium{
    public static int main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int p = 0;
        while(t-->0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int k = 0;
            int r = 0;
            int c = 0;
            for(int i = 0; i<n; i++){
                k+=arr[i][i];
            }
            
            
            for(int i = 0; i<n; i++){
                int[] temp = new int[n];
                for(int j = 0; j<n; j++){
                    temp[j] = arr[i][j];
                }
                Arrays.sort(temp);
                for(int k1 = 0; k1<n; k1++){
                    if(temp[k1]!=k1+1){
                        r++;
                        break;
                    }
                }
            }
            
            for(int j = 0; j<n; j++){
                int[] temp = new int[n];
                for(int i = 0; i<n; i++){
                    temp[i] = arr[i][j];
                }
                Arrays.sort(temp);
                for(int k2 = 0; k2<n; k2++){
                    if(temp[k2]!=k2+1){
                        c++;
                        break;
                    }
                }
            }
            p = p+1;
            System.out.println("Case #"+p+": "+k+" "+r+" "+c);
        }
        return 0;
    }
}