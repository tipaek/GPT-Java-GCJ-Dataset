import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= numberOfTestCase; ++testCase) {
            int numberOfActivities = in.nextInt();
            List<TimeDuration> list = new ArrayList<>(numberOfActivities);
            List<Character> result = new ArrayList<>(numberOfActivities);
            Map<Character, List<TimeDuration>> checkImpossibleMap = new HashMap<>();
            for (int i = 0; i < numberOfActivities; i++) {
                int begin = in.nextInt();
                int end = in.nextInt();
                list.add(new TimeDuration(begin, end));
            }
            List<TimeDuration> oldList = new ArrayList<>(list);
            list.sort(Comparator.comparingInt(o -> o.begin));
            for (int i = 0; i < list.size(); i++) {
                TimeDuration now = list.get(i);
                Character personNow;
                if (i > 0) {
                    int index = i - 1;
                    TimeDuration before = list.get(index);
                    Character personBefore = result.get(index);
                    if (before.end > now.begin) {
                        personNow = 'C' == personBefore ? 'J' : 'C';
                    } else {
                        personNow = personBefore;
                    }
                } else personNow = 'C';
                checkImpossibleMap.computeIfAbsent(personNow, character -> new ArrayList<>()).add(now);
                result.add(personNow);
            }
            List<Character> finalResult = new ArrayList<>(numberOfActivities);
            for (TimeDuration timeDuration : oldList) {
                int i = list.indexOf(timeDuration);
                finalResult.add(oldList.indexOf(timeDuration), result.get(i));
            }

            boolean isImpossibleC = false;
            List<TimeDuration> cList = checkImpossibleMap.get('C');
            if (cList != null && cList.size() > 1) {
                for (int i = 0; i < cList.size() - 1; i++) {
                    TimeDuration now = cList.get(i);
                    TimeDuration next = cList.get(i + 1);
                    isImpossibleC = now.end > next.begin;
                    if (isImpossibleC) break;
                }
            }
            boolean isImpossibleJ = false;
            List<TimeDuration> lLists = checkImpossibleMap.get('J');
            if (lLists != null && lLists.size() > 1) {
                for (int i = 0; i < lLists.size() - 1; i++) {
                    TimeDuration now = lLists.get(i);
                    TimeDuration next = lLists.get(i + 1);
                    isImpossibleJ = now.end > next.begin;
                    if (isImpossibleJ) break;
                }
            }

            if (isImpossibleC || isImpossibleJ) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder finalResultBuilder = new StringBuilder();
                finalResult.forEach(finalResultBuilder::append);
                System.out.println("Case #" + testCase + ": " + finalResultBuilder.toString());
            }
        }
    }

    private static class TimeDuration {
        int begin;
        int end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeDuration that = (TimeDuration) o;
            return begin == that.begin &&
                    end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end);
        }

        public TimeDuration(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

}