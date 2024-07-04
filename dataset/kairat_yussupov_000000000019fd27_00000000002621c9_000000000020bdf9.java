import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
      /*  String input = "4\n" +
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


       // BufferedReader reader = new BufferedReader(new StringReader(input));

        Scanner scanner = new Scanner(System.in);
        int test_cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < test_cases; i++) {

            Stack<Interval> stack = new Stack<>();

            boolean impossible = false;

            int size = Integer.parseInt(scanner.nextLine());
            int[][] array = new int[size][2];

            TreeSet<Interval> set = new TreeSet<Interval>(new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    if (i1.leftTime != i2.leftTime) {
                        return i1.leftTime - i2.leftTime;
                    }

                    return i2.rightTime - i1.rightTime;
                }
            });

            List<Interval> list = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                String numbersLine = scanner.nextLine();
               // System.out.println("numbersLine : " + numbersLine);
                String numbers[] = numbersLine.split(" ");
                array[j][0] = Integer.parseInt(numbers[0]);
                array[j][1] = Integer.parseInt(numbers[1]);
                Interval interval = new Interval();
                interval.leftTime = array[j][0];
                interval.rightTime = array[j][1];
                set.add(interval);
                list.add(interval);
            }

            Iterator<Interval> it = set.descendingIterator();

            Set<Integer> timeline = new TreeSet<>();
            while (it.hasNext()) {
                Interval next = it.next();
                //System.out.println(next);
                timeline.add(next.leftTime);
                timeline.add(next.rightTime);

                stack.add(next);
            }

            Map<String, Interval> map = new HashMap<>();
            Iterator<Integer> ittimeline = timeline.iterator();

            while (ittimeline.hasNext()) {



                if (stack.isEmpty()){
                   // System.out.println(" empty ");
                    break;
                }

                Integer curtime = ittimeline.next();
               // System.out.println("curtime : " + curtime);
                Interval popme = stack.pop();

                if (!map.containsKey("C") && !map.containsKey("J")) { // both C J free


                    popme.who = "C";
                    map.put("C", popme);

                   // System.out.println("1 popme: " + popme);

                } else if (!map.containsKey("C")) {  // C is free

                    if (map.get("J").rightTime == popme.rightTime) {
                        popme.who = "J";
                        map.put("J", popme);
                    } else {
                        popme.who = "C";
                        map.put("C", popme);
                    }

                  //  System.out.println(" 2 popme: " + popme);

                } else if (!map.containsKey("J")) {  // J is free

                    if (map.get("C").rightTime == popme.rightTime) {
                        popme.who = "C";
                        map.put("C", popme);
                    } else {
                        popme.who = "J";
                        map.put("J", popme);
                    }

                    //System.out.println(" 3 popme: " + popme);

                } else { //both C and J are occupied

                   // System.out.println(" 4 popme:" + popme);
                  //  System.out.println(map);

                    if (curtime <= popme.leftTime){
                        if (map.containsKey("C") || map.containsKey("J")) {
                            if (map.get("C").rightTime == curtime) {
                                popme.who = "C";
                                map.put("C", popme);
                              //  System.out.println(" 5 popme : " + popme);
                                continue;
                            } else if (map.get("J").rightTime == curtime) {
                                //System.out.println("map.get(\"J\").rightTime : "  + map.get("J").rightTime);
                                popme.who = "J";
                                map.put("J", popme);
                              //  System.out.println(" 6 popme : " + popme);
                                continue;
                            }
                        }
                    } else {
                        //System.out.println("impossible");
                        impossible = true;
                        break;
                    }



                    stack.push(popme);

                   /* System.out.println("IMPOSSIBLE");
                    break;*/
                }
            }

           // System.out.println(" stack size : " + stack.size());

            if (impossible){
                System.out.print("Case #"+(i+1)+": ");
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.print("Case #"+(i+1)+": ");
                for (int k = 0; k < list.size(); k++){
                    System.out.print(list.get(k).who);
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