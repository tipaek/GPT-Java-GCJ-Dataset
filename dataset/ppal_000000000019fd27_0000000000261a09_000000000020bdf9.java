import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 1;
        Map<String, List<List<Integer>>> map = new HashMap<>();
        String output = "";
        int cases = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount >= 2 && line.split(" ").length == 1) {
                if (testCount > 2) {
                    cases++;
                    System.out.println("Case #" + (cases) + ": " + output);
                    output = "";
                    map.clear();
                }
            } else if (testCount > 2) {
                String[] strArr = line.split(" ");
                int input0 = Integer.parseInt(strArr[0]);
                int input1 = Integer.parseInt(strArr[1]);
                if (map.containsKey("C")) {
                    boolean found = false;
                    for (List<Integer> l : map.get("C")) {
                        if (input0 >= l.get(0) && input1 <= l.get(1)) {
                            found = true;
                            output = output + "C";
                            List<Integer> list = new ArrayList<>();
                            String[] arr = line.split(" ");
                            map.get("C").remove(l);
                            list.add(0);
                            list.add(input0);
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(input1);
                            list1.add(l.get(1));
                            map.get("C").add(list);
                            map.get("C").add(list1);
                            break;
                        }
                    }
                    if (!found) {
                        if (map.containsKey("J")) {
                            boolean foundj = false;
                            for (List<Integer> l : map.get("J")) {
                                if (input0 >= l.get(0) && input1 <= l.get(1)) {
                                    foundj = true;
                                    output = output + "J";
                                    List<Integer> list = new ArrayList<>();
                                    String[] arr = line.split(" ");
                                    map.get("J").remove(l);
                                    list.add(0);
                                    list.add(input0);
                                    List<Integer> list1 = new ArrayList<>();
                                    list1.add(input1);
                                    list1.add(l.get(1));
                                    map.get("J").add(list);
                                    map.get("J").add(list1);
                                    break;
                                }
                            }
                            if (!foundj) {
                                output = "IMPOSSIBLE";
                            }
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(0);
                            list.add(input0);
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(input1);
                            list1.add(1440);
                            List<List<Integer>> integerList = new ArrayList<>();
                            integerList.add(list);
                            integerList.add(list1);
                            map.put("J", integerList);
                            output = output + "J";
                        }
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(0);
                    list.add(input0);
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(input1);
                    list1.add(1440);

                    List<List<Integer>> integerList = new ArrayList<>();
                    integerList.add(list);
                    integerList.add(list1);
                    map.put("C", integerList);
                    output = output + "C";
                }
            }
            testCount++;
        }
        System.out.println("Case #" + (cases + 1) + ": " + output);
    }
}
