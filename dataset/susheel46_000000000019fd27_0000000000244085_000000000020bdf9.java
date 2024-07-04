
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int[][] times = new int[N][2];


            for (int j = 0; j < N; j++) {
                times[j][0] = sc.nextInt();
                times[j][1] = sc.nextInt();

            }
            solutions[i] = parenting(N, times);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String parenting(int N, int[][] times) {

        Map<int[], Integer> indexMap = new HashMap<>();
        char[] res = new char[N];
        for(int i=0;i<N;i++){
            indexMap.put(times[i],i);
        }
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        StringBuilder sb = new StringBuilder();
        boolean[] isBusy = new boolean[2];
        Map<Integer, Integer> jobAlloc = new ConcurrentHashMap<>();

        for (int i = 0; i < N ; i++) {
            if (i == 0) {
//                sb.append('C');
                res [indexMap.get(times[i])]='C';

                jobAlloc.put(0, times[i][1]);
//                isBusy[0] = true;
//                count++;
            } else {
                //Check if any existing jobs have finished by now (start of current job)
                for(Map.Entry<Integer,Integer> e : jobAlloc.entrySet()){
                    if(e.getValue() <= times[i][0])jobAlloc.remove(e.getKey());
                }

//                if (times[i - 1][1] < times[i][0]) {
//                    isBusy[jobAlloc.getOrDefault(i - 1,0)] = false;
//                    count--;
//                }
                //Take current job if there is capacity else return impossible
                if (times[i][0] < times[i - 1][1] && jobAlloc.size()==2) return "IMPOSSIBLE";
                if(jobAlloc.get(0)!=null){
                    jobAlloc.put(1,times[i][1]);
                    res [indexMap.get(times[i])]='J';
//                    sb.append('J');
                }
                else {
                    jobAlloc.put(0,times[i][1]);
                    res [indexMap.get(times[i])]='C';

//                    sb.append('C');
                }
//                count++;
//                char next = isBusy[0] ?'J':'C';
//                sb.append(next);
            }
        }
//        char next = isBusy[0] ?'J':'C';
//        sb.append(next);
        for(int i=0;i<N;i++)sb.append(res[i]);

        return sb.toString();

    }


}
