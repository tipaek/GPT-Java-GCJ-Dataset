import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 1;
        int numofSchedule = 0;
        Map<String, String> map = new HashMap<>();
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
                    if (Integer.parseInt(strArr[0]) >= Integer.parseInt(map.get("C").split(" ")[1])) {
                        map.put("C", map.get("C").split(" ")[0] + " " + strArr[1]);
                        output = output + "C";
                    } else if (Integer.parseInt(strArr[1]) <= Integer.parseInt(map.get("C").split(" ")[0])) {
                        map.put("C", strArr[0] + " " + map.get("C").split(" ")[1]);
                        output = output + "C";
                    } else {
                        if (map.containsKey("J")) {
                            if (Integer.parseInt(strArr[0]) >= Integer.parseInt(map.get("J").split(" ")[1])) {
                                map.put("J", map.get("J").split(" ")[0] + " " + strArr[1]);
                                output = output + "J";
                            } else if (Integer.parseInt(strArr[1]) <= Integer.parseInt(map.get("J").split(" ")[0])) {
                                map.put("J", strArr[0] + " " + map.get("J").split(" ")[1]);
                                output = output + "C";
                            } else {
                                output = "IMPOSSIBLE";
                            }
                        } else {
                            map.put("J", line);
                            output = output + "J";
                        }
                    }
                } else {
                    map.put("C", line);
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
