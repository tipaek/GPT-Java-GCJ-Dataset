import java.util.*;
public class Solution{
    public static void main(String...args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=1; t<=T; t++){
            int N = scan.nextInt();
            int k = 0,r=0,c=0;
            int arr[][] = new int[N][N];
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for(int i=0; i<N; i++){
                String rc = "";
                for(int j=0; j<N; j++){
                    arr[i][j] = scan.nextInt();
                    if(i == j) k += arr[i][j]; 
                    if(rc.contains(arr[i][j]+"") ){
                        row.add(i);
                    }
                    rc += arr[i][j];
                }
            }

            for(int i=0; i<N; i++){
                String cc = "";
                for(int j=0; j<N; j++){
                    if(cc.contains(arr[j][i]+"") ){
                        col.add(i);
                    }
                    cc += arr[j][i];
                }
            }
            System.out.println("Case #"+t+": "+k+" "+row.size()+" "+col.size());
        }
    }
}