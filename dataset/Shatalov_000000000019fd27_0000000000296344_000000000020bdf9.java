import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class TimeLine implements Comparable<TimeLine> {
        int start;
        int end;
        String responsible;

        TimeLine(int start, int end, String responsible) {
            this.start = start;
            this.end = end;
            this.responsible = responsible;
        }

        @Override
        public int compareTo(TimeLine other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "TimeLine{" +
                    "start=" + start +
                    ", end=" + end +
                    ", responsible='" + responsible + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        //String[] arr = {"5 9", "1 5", "3 7", "9 10"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCasesNumb = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCasesNumb; t++) {
            List<TimeLine> timeLineList = new ArrayList<>();
            Map<Integer, TimeLine> indexValueMap = new HashMap<>();

            int linesNumber = Integer.parseInt(br.readLine());
            for (int i = 0; i < linesNumber; i++) {
                String line = br.readLine();

                String[] rowArr = line.split(" ");
                int start = Integer.parseInt(rowArr[0]);
                int end = Integer.parseInt(rowArr[1]);

                TimeLine timeLine = new TimeLine(start, end, "");
                timeLineList.add(timeLine);
                indexValueMap.put(i, timeLine);
            }
            Collections.sort(timeLineList);

            try {
                int counter = 0;
                Iterator<TimeLine> iterator = timeLineList.iterator();
                TimeLine firstTimeLine = iterator.next();
                firstTimeLine.responsible = "J";
                if (!iterator.hasNext()) {
                    System.out.println("Case #" + t + ": " + "J");
                    continue;
                }
                TimeLine secondTimeLine = iterator.next();
                secondTimeLine.responsible = "C";

                while (iterator.hasNext()) {
                    TimeLine thirdTimeLine = iterator.next();
                    if (checkThreeOverlap(firstTimeLine, secondTimeLine, thirdTimeLine))
                        throw new RuntimeException("Impossible");
                    thirdTimeLine.responsible = counter % 2 == 0 ? "J" : "C";
                    firstTimeLine = secondTimeLine;
                    secondTimeLine = thirdTimeLine;
                    counter++;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < indexValueMap.size(); i++) {
                    stringBuilder.append(indexValueMap.get(i).responsible);
                }
                System.out.println("Case #" + t + ": " + stringBuilder.toString());

            } catch (RuntimeException e) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }
        br.close();
    }

    private static boolean checkThreeOverlap(TimeLine first, TimeLine second, TimeLine third) {
        return isOverlap(first, second) && isOverlap(second, third) && isOverlap(first, third);
    }

    private static boolean isOverlap(TimeLine first, TimeLine second) {
        if (first.start < second.start) {
            return second.start < first.end;
        } else return first.start < second.end;
    }
}