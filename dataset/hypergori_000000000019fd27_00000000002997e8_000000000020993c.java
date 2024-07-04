import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            int[][] m = new int[N][N];


            int dupr = 0;
            int sum = 0 ;
            for (int j = 0; j < N ; j++) {
                Set<Integer> s = new HashSet<>();
                boolean dup = false;
                for (int k = 0; k <N ; k++) {
                    m[j][k] = sc.nextInt();
                    if(s.contains(m[j][k])){
                        dup =true;
                    }else{
                        s.add(m[j][k]);
                    }
                    if(j==k){
                        sum += m[j][k];
                    }
                }
                if(dup) dupr++;
            }

            int dupc = 0;
            for (int j = 0; j < N ; j++) {
                Set<Integer> s = new HashSet<>();
                boolean dup = false;
                for (int k = 0; k < N; k++) {
                    if(s.contains(m[k][j])){
                        dup =true;
                    }else{
                        s.add(m[k][j]);
                    }
                }
                if(dup) dupc++;
            }


            System.out.println("Case #"+(i+1)+" " + sum +" "+dupr +" "+dupc  );


        }
    }



}
