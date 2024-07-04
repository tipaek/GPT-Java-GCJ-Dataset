
import java.util.*;
public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 1;
        while(count<=t){

            int n = sc.nextInt();
            int arr[][] = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for(int i=0; i<n; i++){
                trace += arr[i][i];
            }

            //similar eles in rows
            int t_r = 0;
            int num = 0;
            for(int row=0; row<n; row++){
                Set<Integer> s = new HashSet<Integer>();
                int r = 0;
                for(int col=0; col<n; col++){
                    num = arr[row][col];
                    if(s.contains(num) && r==0){
                        r++;
                    }else{
                        s.add(num);
                    }
                }
                t_r+=r;
            }

            //check for col
            int t_c = 0;
            for(int col = 0; col<n; col++){
                Set<Integer> s = new HashSet<Integer>();
                int c = 0;
                for(int row=0; row<n; row++){
                    num = arr[row][col];
                    if(s.contains(num) && c==0){
                        c++;
                    }else{
                        s.add(num);
                    }
                }
                t_c += c;
            }

            System.out.println("Case #"+(count)+": "+trace+" "+t_r+" "+t_c);

            count++;
        }
    }
}
