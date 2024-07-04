import java.util.*;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int counter = 0; counter < n; counter++) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] slices = new long[N];
            int result = 0;

            for (int i = 0; i < N; i++) {
                slices[i] = in.nextLong();
            }
            Arrays.sort(slices);
            if(D == 2) {
                result =1;
                for (int i = 0; i < N - 1; i++) {
                    if(slices[i] == slices[i+1]){
                        result = 0;
                        break;
                    }
                }
            }else{
                for (int i = 0; i < N - 2; i++) {
                    if(slices[i] == slices[i+1] && slices[1] == slices[2]){
                        break;
                    }
                    if(slices[i] == slices[i+1]){
                        if(i==0){
                            result = 1;
                        }

                    }
                    if(existHalf(i, slices)) result = 1;
                }
                if(result != 1) result = 2;
            }
            System.out.println("Case #" + (counter + 1) + ": " + result);
        }
    }

    private static boolean existHalf(int i, long[] slices) {
        double half = ((double)i)/2;
        for (long slice : slices) {
            if ((double)slice == half) return true;
        }
        return false;
    }
}
