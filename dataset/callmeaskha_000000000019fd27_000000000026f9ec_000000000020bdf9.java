import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        Scanner reader = new Scanner(System.in);
        int test_cases = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < test_cases; i++) {

            Stack<Interval> stack = new Stack<>();

            boolean impossible = false;

            int size = Integer.parseInt(reader.nextLine());
            int[][] array = new int[size][2];

            List<Interval> set = new ArrayList<Interval>();

            List<Interval> list = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                String numbersLine = reader.nextLine();
                String numbers[] = numbersLine.split(" ");
                array[j][0] = Integer.parseInt(numbers[0]);
                array[j][1] = Integer.parseInt(numbers[1]);
                Interval interval = new Interval();
                interval.leftTime = array[j][0];
                interval.rightTime = array[j][1];
                set.add(interval);
                list.add(interval);
            }

            set.sort(new IntervalComparator());

            for (int k = (set.size() - 1); k >= 0; k--) {
                stack.add(set.get(k));
            }

            Map<String, Interval> map = new HashMap<>();

            while (true) {
                if (stack.isEmpty()) {
                    break;
                }

                Interval popme = stack.pop();

                if (!map.containsKey("C")) {  
                    popme.who = "C";
                    map.put("C", popme);
                } else if (!map.containsKey("J")) { 
                    popme.who = "J";
                    map.put("J", popme);
                } else { 
                    Interval C = map.get("C");
                    Interval J = map.get("J");

                    if (C.rightTime > popme.leftTime && J.rightTime > popme.leftTime) {
                        impossible = true;
                        break;
                    } else {

                        if (C.rightTime <= popme.leftTime) {
                            popme.who = "C";
                            map.put("C", popme);
                        } else if (J.rightTime <= popme.leftTime) {
                            popme.who = "J";
                            map.put("J", popme);
                        }
                    }

                }
            }

            if (impossible) {
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i+1) + ": ");
                for (Interval val : list) {
                    System.out.print(val.who);
                }
                System.out.println();
            }

        }
    }
}


class Interval {

    public int leftTime;
    public int rightTime;
    public String who;

    @Override
    public String toString() {
        return "Interval{" +
                "leftTime=" + leftTime +
                ", rightTime=" + rightTime +
                ", who='" + who + '\'' +
                '}';
    }
}


class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.leftTime != i2.leftTime) {
            return i1.leftTime - i2.leftTime;
        }

        return i1.rightTime - i2.rightTime;
    }
}