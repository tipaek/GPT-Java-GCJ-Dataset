import java.util.*;
import java.util.stream.*;
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
                int rc[] = new int[N];
                for(int j=0; j<N; j++){
                    arr[i][j] = scan.nextInt();
                    if(i == j) k += arr[i][j];
                    int temp = arr[i][j]; 
                    if(IntStream.of(rc).anyMatch(x -> x == temp)){
                        row.add(i);
                    }
                    rc[j] = arr[i][j];
                }
            }

            for(int i=0; i<N; i++){
                int cc[] = new int[N];
                for(int j=0; j<N; j++){
                    int temp = arr[j][i];
                    if(IntStream.of(cc).anyMatch(x -> x ==temp) ){
                        col.add(i);
                    }
                    cc[j] = arr[j][i];
                }
            }
            System.out.println("Case #"+t+": "+k+" "+row.size()+" "+col.size());
        }
    }
}