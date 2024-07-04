import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
                    List<List<Integer>> l = map.get("C");
                    for (int i = 0; i < l.size(); i++) {
                        int inputl0 = l.get(i).get(0);
                        int inputl1 = l.get(i).get(1);
                        if (found) {
                            break;
                        }
                        if (input0 >= inputl0 && input1 <= inputl1) {
                            if ("IMPOSSIBLE".equals(output)) {
                                break;
                            }
                            found = true;
                            output = output + "C";
                            List<Integer> list = new ArrayList<>();
                            map.get("C").remove(l.get(i));
                            list.add(0);
                            list.add(input0);
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(input1);
                            list1.add(inputl1);
                            map.get("C").add(list);
                            map.get("C").add(list1);
                        }
                    }
                    if (!found) {
                        if (map.containsKey("J")) {
                            boolean foundj = false;
                            List<List<Integer>> lj = map.get("J");
                            for (int i = 0; i < lj.size(); i++) {
                                int inputl0 = lj.get(i).get(0);
                                int inputl1 = lj.get(i).get(1);
                                if (foundj) {
                                    break;
                                }
                                if (input0 >= inputl0 && input1 <= inputl1) {
                                    if ("IMPOSSIBLE".equals(output)) {
                                        break;
                                    }
                                    foundj = true;
                                    output = output + "J";
                                    List<Integer> list = new ArrayList<>();
                                    map.get("J").remove(l.get(i));
                                    list.add(0);
                                    list.add(input0);
                                    List<Integer> list1 = new ArrayList<>();
                                    list1.add(input1);
                                    list1.add(inputl1);
                                    map.get("J").add(list);
                                    map.get("J").add(list1);
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
                    map.put("C", Collections.synchronizedList(integerList));
                    output = output + "C";
                }
            }
            testCount++;
        }
        System.out.println("Case #" + (cases + 1) + ": " + output);
    }
}
