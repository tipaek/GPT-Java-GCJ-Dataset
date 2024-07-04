import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        int size;
        char[] value;
        int count = 0;
        String output = "";
        int count1 = 0;
        List<Map<Integer, Integer>> list;
        Map<Integer, Integer> map;

        for (int k = 0; k < caseCount; k++) {
            size = sc.nextInt();
           list = new LinkedList<>();

            for (int j = 0; j < size; j++) {
                map = new HashMap<>();
                map.put(sc.nextInt(), sc.nextInt());
                list.add(map);
            }

            value = new char[size];

            for (Map<Integer,Integer> map1 : list) {

                if (output.equals("IMPOSSIBLE")) break;
                for (Map<Integer,Integer> map2 : list) {

                    Map.Entry<Integer, Integer> i = map1.entrySet().iterator().next();
                    Map.Entry<Integer, Integer> j = map2.entrySet().iterator().next();
                    if ((j.getKey() > i.getKey() && j.getKey() < i.getValue()) || (j.getValue() > i.getKey() && j.getValue() < i.getValue())
                            || (count!=count1 && i.getKey().equals(j.getKey()) && i.getValue().equals(j.getValue()))) {
                        if (count == 0) {
                            value[count1] = 'J';
                        } else if (value[count1] == value[count]) {
                            output = "IMPOSSIBLE";
                            break;
                        }


                    } else if (count == 0) {
                        value[count1] = 'C';
                    }
                    count1++;
                }
                count++;
                count1 = 0;

            }
            count = 0;
            if (!output.equals("IMPOSSIBLE")) output = new String(value);
            System.out.println("Case #" + (k + 1) + ": " + output);
            output="";


        }

    }

}

