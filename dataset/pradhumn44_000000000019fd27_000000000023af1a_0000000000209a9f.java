import java.util.*;
import java.io.*;
class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        int arr[][] = new int[101][101];
       for(int p = 1 ; p <= t ; p++){
            int n = s.nextInt();
            int r = 0, c = 0, k = 0;

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = s.nextInt();
                    if(i == j)
                    k += arr[i][j];
                }
            }
            
            //find r
            for(int i = 0 ; i < n ; i++){
                int count[] = new int[n+1];
                for(int j = 0 ; j < n ; j++){
                    count[arr[i][j]]++;
                    if(count[arr[i][j]] > 1){
                    r++;
                    break;
                    }
                }
            }
            //find c
            for(int i = 0 ; i < n ; i++){
                int count[] = new int[n+1];
                for(int j = 0 ; j < n ; j++){
                    count[arr[j][i]]++;
                    if(count[arr[j][i]] > 1){
                    c++;
                    break;
                    }
                }
            }

            System.out.println("Case #"+p+":"+" "+k+" "+r+" "+c);

        }
    }
}