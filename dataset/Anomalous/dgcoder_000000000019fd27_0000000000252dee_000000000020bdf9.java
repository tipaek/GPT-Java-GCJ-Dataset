import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            Integer[][] arr = new Integer[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                arr[i][1] = Integer.parseInt(temp[1]);
            }

            String result = getResult(arr, new ArrayList<>(), new ArrayList<>(), 0, "");
            if (result.length() != arr.length) {
                result = "IMPOSSIBLE";
            }
            System.out.format("Case #%d: %s%n", t, result);
        }
        br.close();
    }

    public static String getResult(Integer[][] arr, ArrayList<Integer[]> c, ArrayList<Integer[]> j, int index, String result) {
        if (index == arr.length) {
            return result;
        }

        if (isCompatible(c, arr[index])) {
            ArrayList<Integer[]> tempC = new ArrayList<>(c);
            tempC.add(arr[index]);
            String resC = getResult(arr, tempC, j, index + 1, result + 'C');
            if (resC.length() == arr.length) {
                return resC;
            }
        }

        if (isCompatible(j, arr[index])) {
            ArrayList<Integer[]> tempJ = new ArrayList<>(j);
            tempJ.add(arr[index]);
            String resJ = getResult(arr, c, tempJ, index + 1, result + 'J');
            if (resJ.length() == arr.length) {
                return resJ;
            }
        }

        return "";
    }

    public static boolean isCompatible(ArrayList<Integer[]> list, Integer[] interval) {
        int start = interval[0];
        int end = interval[1];

        for (Integer[] temp : list) {
            if (!(end <= temp[0] || start >= temp[1])) {
                return false;
            }
        }
        return true;
    }
}