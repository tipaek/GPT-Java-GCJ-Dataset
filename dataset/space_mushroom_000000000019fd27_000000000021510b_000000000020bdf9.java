import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(List<List<Integer>> list){
        int n = list.size();

        Map<List<Integer>, Integer> indexMap = new HashMap<>();
        for(int i=0; i<n; i++){
            indexMap.put(list.get(i), i);
        }

        list.sort((o1, o2) -> {
            int start1 = o1.get(0);
            int start2 = o2.get(0);
            if (start1 == start2)
                return o1.get(1) - o2.get(1);
            return start1 - start2;
        });


        char[] result = new char[n];
        Set<Integer> carter = new HashSet<>();
        Set<Integer> jamie = new HashSet<>();

        for(int i=0; i<n; i++){
            List<Integer> task = list.get(i);
            int t1 = task.get(0);
            int t2 = task.get(1);

            boolean carterCan = true;
            boolean jamieCan = true;

            for(int j=t1; j<t2; j++){
                if(carter.contains(j)){
                    carterCan = false;
                    break;
                }
            }
            if(carterCan){
                for(int j=t1; j<t2; j++){
                    carter.add(j);
                }
                result[indexMap.get(task)] = 'C';
                continue;
            }

            for(int j=t1; j<t2; j++){
                if(jamie.contains(j)){
                    jamieCan = false;
                    break;
                }
            }
            if(jamieCan){
                for(int j=t1; j<t2; j++){
                    jamie.add(j);
                }
                result[indexMap.get(task)] = 'J';
                continue;
            }
            return "IMPOSSIBLE";
        }

        return String.valueOf(result);
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int n = input.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                int t1 = input.nextInt();
                int t2 = input.nextInt();
                list.add(new ArrayList<>(Arrays.asList(t1, t2)));
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(list));
        }
    }
}