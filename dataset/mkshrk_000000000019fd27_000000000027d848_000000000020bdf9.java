import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileReader("src/task.txt"));
        int T = Integer.parseInt(sc.next());
        for(int i = 0; i< T; ++i) {
            int val = Integer.parseInt(sc.next());
            Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
            for (int v = 0; v < val; ++v) {
                linkedHashMap.put(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
            }
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(linkedHashMap);
            findTask(treeMap, linkedHashMap, val, i+1);
        }

    }

    private static void findTask(Map<Integer, Integer> treeMap, Map<Integer, Integer> linkedHashMap, int val, int test) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] list = new String[val];
        List<Integer> keys = new ArrayList<>(linkedHashMap.keySet());
        Map<String, Integer> taskMap = new HashMap<>();

        Iterator<Map.Entry<Integer, Integer>> itr = treeMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> map = itr.next();
            String taskName = "";
            if(!taskMap.containsKey("C")
            || (taskMap.containsKey("C") && taskMap.get("C") <= map.getKey())) {
                taskName = "C";
            }

            else if(!taskMap.containsKey("J")
            || (taskMap.containsKey("J") && taskMap.get("J") <= map.getKey())) {
                taskName = "J";
            }
            taskMap.put(taskName, map.getValue());
            list[keys.indexOf(map.getKey())] = taskName;
        }
        for (String s : list)
            stringBuilder.append((s));
        if(stringBuilder.toString().length() < val)
            stringBuilder = new StringBuilder("IMPOSSIBLE");

        System.out.println("Case #" + test +": " + stringBuilder.toString());
    }
}
