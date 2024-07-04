import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int noOfScenarios = Integer.parseInt(reader.readLine());
        String[] output = new String[noOfScenarios];

        for (int i = 0; i < noOfScenarios; i++) {
            int noOfActivities = Integer.parseInt(reader.readLine());

            String[][] times = parseToArray(noOfActivities);

            times = orderTimes(times);

            output[i] = getOrder(times);
        }

        for (int i=0; i<output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static String[][] orderTimes(String[][] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String[] key = arr[i];
            int j = i - 1;

            while (j >= 0 && Integer.valueOf(arr[j][0]) > Integer.valueOf(key[0])) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public static String[][] parseToArray(int noOfActivities) throws IOException {
        String[][] array = new String[noOfActivities][2];

        for (int i=0; i<noOfActivities; i++) {
            array[i] = stringIntoArray(reader.readLine());
        }

        return array;
    }

    private static String[] stringIntoArray(String line) {
        return line.split(" ");
    }

    private static String getOrder(String[][] times) {
        String finalOrder = "";

        String[] cameron = times[0];
        finalOrder += "C";
        String[] jamie = null;

        for (int i=1; i<times.length; i++) {
            //if the start time is before the previous one's end time
            if (Integer.valueOf(times[i][0]) < Integer.valueOf(cameron[1])) {
                //if jamie has had an activity and the start time is before the end of jamie's last activity
                if (jamie != null && Integer.valueOf(times[i][0]) < Integer.valueOf(jamie[1])) {
                    return "IMPOSSIBLE";
                }
                jamie = times[i];
                finalOrder += "J";
            } else {
                cameron = times[i];
                finalOrder += "C";
            }
        }

        return finalOrder;
    }
}