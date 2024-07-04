import java.util.*;


public class Solution {



   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        double epsilon = Math.pow(10,-9);

        for(int t = 1; t <= T; t++) {


            int N = sc.nextInt();
            int D = sc.nextInt();





            double[] A = new double[N];

            Map<Double,Integer> map = new HashMap<>();

            int cut = D-1;

            int max = 0;
            double maxVal = 0;

            for(int i = 0; i < N; i++) {

                A[i] = sc.nextDouble();

                int tmp = map.getOrDefault(A[i], 0) + 1;

                map.put(A[i], tmp);

                if(tmp > cut) {
                    cut = 0;
                }

                max = Math.max(max,tmp);
                maxVal = Math.max(A[i], maxVal);
            }

            if(D > 3) continue;

            if(cut == 0) {
                System.out.println("Case #"+t+": "+0);
                continue;
            }
            if(D == 2) {
                System.out.println("Case #"+t+": "+1);
                continue;
            }



            for( double d : map.keySet()) {
                if(map.containsKey(2*d)) {
                    cut = 1;
                    break;
                } else if(map.get(d) == 2 && maxVal > d) {
                    cut = 1;
                    break;
                }
            }


            System.out.println("Case #"+t+": "+cut);


        }

    }

}