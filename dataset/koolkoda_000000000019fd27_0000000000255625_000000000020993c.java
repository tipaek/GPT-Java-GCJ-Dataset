import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());

        for(int i = 0; i < T; i++){

            int N = Integer.parseInt(input.nextLine());

            int trace = 0;

            Map<Integer, Integer>[] rows = new Map[N];
            Map<Integer, Integer>[] cols = new Map[N];

            for(int j = 0; j < N; j++){
                rows[j] = new HashMap<>();
                for(int k = 0; k < N; k++){
                    if(cols[k] == null){
                        cols[k] = new HashMap<>();
                    }
                    int M = Integer.parseInt(input.next());
                    if(j == k){
                        trace += M;
                    }

                    if(rows[j].containsKey(M)){
                        rows[j].put(M, rows[j].get(M) + 1);
                    } else {
                        rows[j].put(M, 1);
                    }

                    if(cols[k].containsKey(M)){
                        cols[k].put(M, cols[k].get(M) + 1);
                    } else {
                        cols[k].put(M, 1);
                    }
                }
                input.nextLine();
            }

            int r = 0;
            int c = 0;
            for(int j = 0; j < N; j++) {
                for( int count: rows[j].values()){
                    if(count > 1){
                        r++;
                        break;
                    }
                }

                for( int count: cols[j].values()){
                    if(count > 1){
                        c++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d:%d %d %d%n", i + 1, trace, r, c);

        }
    }
}
