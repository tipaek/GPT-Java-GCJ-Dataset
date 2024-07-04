import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /*String input = "4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440";*/


      //  BufferedReader reader = new BufferedReader(new StringReader(input));

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

               // System.out.println("popme : " + popme);

                if (!map.containsKey("C")) {  // C is free
                    popme.who = "C";
                    map.put("C", popme);
                   // System.out.println(" 2 popme: " + popme);
                } else if (!map.containsKey("J")) {  // J is free
                    popme.who = "J";
                    map.put("J", popme);
                  //  System.out.println(" 3 popme: " + popme);
                } else { //both C and J are occupied
                    Interval C = map.get("C");
                    Interval J = map.get("J");

                   /* System.out.println("C.rightTime: " + C.rightTime);
                    System.out.println("J.rightTime: " + J.rightTime);
                    System.out.println("popme.leftTime: " + popme.leftTime);*/

                    if (C.rightTime > popme.leftTime && J.rightTime > popme.leftTime) {
                       // System.out.println("IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {

                        if (C.rightTime <= popme.leftTime) {
                            popme.who = "C";
                            map.put("C", popme);
                           // System.out.println(" 4 popme: " + popme);
                        } else if (J.rightTime <= popme.leftTime) {
                            popme.who = "J";
                            map.put("J", popme);
                           // System.out.println(" 5 popme: " + popme);
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