import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 1;
        int numofSchedule = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        String output = "";
        int cases = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount >= 2 && line.split(" ").length == 1) {
                numofSchedule = Integer.parseInt(line);
                if (testCount > 2) {
                    cases++;
                    System.out.println("Case #" + (cases) + ": " + output);
                    output = "";
                    map.clear();
                }
            } else if (testCount > 2) {
                String[] strArr = line.split(" ");
                if (map.containsKey("C")) {
                    map.get("C").add(Integer.parseInt(strArr[0]));
                    map.get("C").add(Integer.parseInt(strArr[1]));
                    Collections.sort(map.get("C"));
                    int index1 = map.get("C").indexOf(Integer.parseInt(strArr[1]));
                    int index0 = map.get("C").lastIndexOf(Integer.parseInt(strArr[0]));
                    if (index1 - index0 > 1) {
                        map.get("C").remove(index1);
                        map.get("C").remove(index0);
                        if (map.containsKey("J")) {
                            map.get("J").add(Integer.parseInt(strArr[0]));
                            map.get("J").add(Integer.parseInt(strArr[1]));
                            Collections.sort(map.get("J"));
                            int indexj1 = map.get("J").indexOf(Integer.parseInt(strArr[1]));
                            int indexj0 = map.get("J").lastIndexOf(Integer.parseInt(strArr[0]));
                            if (indexj1 - indexj0 > 1) {
                                output = "IMPOSSIBLE";
                            } else {
                                output = output + "J";
                            }
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(Integer.parseInt(strArr[0]));
                            list.add(Integer.parseInt(strArr[1]));
                            map.put("J", list);
                            output = output + "J";
                        }
                    } else {
                        output = output + "C";
                    }

                } else {
                    List<Integer> list = new ArrayList<>();
                    String[] arr = line.split(" ");
                    list.add(Integer.parseInt(arr[0]));
                    list.add(Integer.parseInt(arr[1]));
                    map.put("C", list);
                    output = output + "C";
                }
            }
            if (testCount - 2 == numofSchedule) {

            }
            testCount++;
        }
        System.out.println("Case #" + (cases + 1) + ": " + output);
    }
}
