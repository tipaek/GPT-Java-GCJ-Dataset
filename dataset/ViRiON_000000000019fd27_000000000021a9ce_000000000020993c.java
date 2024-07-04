import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i = 1; i<=t;i++){
            int n = in.nextInt();
            int k=0,r=0,c=0;

            Map<Integer, Set<Integer>> col = new HashMap<>();

            for(int j = 0; j<n;j++){
                Set<Integer> row = new HashSet<>();
                for(int l=0;l<n;l++){
                    int input = in.nextInt();
                    row.add(input);

                    Set<Integer> temp = col.get(l);
                    if( temp == null) temp = new HashSet<>();

                    temp.add(input);
                    col.put(l,temp);
                    if(j==l) k+=input;
                }
                if(row.size() != n) r++;
            }
            for(int m=0;m<n;m++){
                Set<Integer> colSet = col.get(m);
                if(colSet.size() != n) c++;
            }

            System.out.printf("Case #%d: %d %d %d\n", i,k,r,c);
        }

    }
}
