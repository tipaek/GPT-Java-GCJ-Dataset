import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class DepthValue implements Comparable<DepthValue> {
        public int index;
        public int value;
        String result;

        public DepthValue(int index, int value, String result) {
            this.index = index;
            this.value = value;
            this.result = result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof DepthValue))
                return false;
            DepthValue other = (DepthValue) o;
            return this.value == other.value;
        }

        @Override
        public int compareTo(DepthValue other) {
            return Integer.compare(this.value, other.value);
        }

        @Override
        public String toString() {
            return "Value{" +
                    "index=" + index +
                    ", value=" + value +
                    ", result='" + result + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCasesNumb = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCasesNumb; t++) {

            String line = br.readLine();
            Map<Integer, DepthValue> indexValueMap = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                String c = String.valueOf(line.charAt(i));
                DepthValue value = new DepthValue(i, Integer.parseInt(c), c);
                indexValueMap.put(i, value);
            }
            DepthValue maxValue = Collections.max(indexValueMap.values());

            //until all values processed
            while (maxValue.value > 0) {
                //go to left
                DepthValue curValue = maxValue;
                int curMaxValue = maxValue.value;
                for (int curIndex = maxValue.index; curIndex >= 0 && indexValueMap.get(curIndex).value == curMaxValue; curIndex--) {
                    curValue = indexValueMap.get(curIndex);
                    curValue.value--;
                }
                curValue.result = "(" + curValue.result;

                //go to right
                curValue = maxValue;
                for (int curIndex = maxValue.index + 1; curIndex < line.length() && indexValueMap.get(curIndex).value == curMaxValue; curIndex++) {
                    curValue = indexValueMap.get(curIndex);
                    curValue.value--;
                }
                curValue.result += ")";

                maxValue = findFirstMax(indexValueMap.values(), curMaxValue);
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                stringBuilder.append(indexValueMap.get(i).result);
            }

            System.out.println("Case #" + t + ": " + stringBuilder.toString());
        }
    }

    private static DepthValue findFirstMax(Collection<DepthValue> list, int maxValue) {
        DepthValue curMaxValue = list.iterator().next();
        for (DepthValue value : list) {
            if (value.value == maxValue) {
                return value;
            } else if (value.compareTo(curMaxValue) > 0) {
                curMaxValue = value;
            }
        }
        return curMaxValue;
    }
}