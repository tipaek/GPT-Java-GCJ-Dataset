import java.util.LinkedHashMap;
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
        Map<Integer, Integer> map;

        for (int k = 0; k < caseCount; k++) {
            size = sc.nextInt();
            map = new LinkedHashMap<>();

            for (int j = 0; j < size; j++) {
                map.put(sc.nextInt(), sc.nextInt());
            }

            value = new char[size];

            for (int i : map.keySet()) {

                if (output.equals("IMPOSSIBLE")) break;

                for (int j : map.keySet()) {
                    if ((j > i && j < map.get(i)) || (map.get(j) > i && map.get(j) < map.get(i))) {
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