import java.io.*;
import java.util.*;

class Solution {

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void schedulingTasks(ArrayList<Integer> start, ArrayList<Integer> end, int testNo, int n) {
        char[] assignTask = new char[start.size()];
        int[] s = new int[start.size()];
        int[] mark = new int[n];
        ArrayList<Integer> remaining = new ArrayList<>();
        int eTime;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < start.size(); i++) {
            s[i] = start.get(i);
        }

        sort(s, 0, s.length - 1);

        eTime = end.get(start.indexOf(s[0]));
        mark[0] = 1;
        assignTask[start.indexOf(s[0])] = 'C';
        for (int j = 1; j < s.length; j++) {
            if (eTime <= s[j]) {
                eTime = end.get(start.indexOf(s[j]));
                assignTask[start.indexOf(s[j])] = 'C';
                mark[j] = 1;
            } else {
                remaining.add(s[j]);
                mark[j] = 0;
            }
        }

        if (!remaining.isEmpty()) {
            for (int p = 0; p < s.length; p++) {
                if (mark[p] == 0) {
                    eTime = end.get(start.lastIndexOf(s[p]));
                    assignTask[start.lastIndexOf(s[p])] = 'J';
                    break;
                }
            }
            for (int j = 1; j < remaining.size(); j++) {
                if (eTime <= remaining.get(j)) {
                    eTime = end.get(start.indexOf(remaining.get(j)));
                    assignTask[start.indexOf(remaining.get(j))] = 'J';
                } else {
                    assignTask[start.indexOf(remaining.get(j))] = 'I';
                }
            }
        }

        for (char c : assignTask) {
            if (c == 'C' || c == 'J') {
                ans.append(c);
            }
        }

        PrintWriter writer = new PrintWriter(System.out);
        if (ans.length() < n) {
            writer.write("Case #" + testNo + ": IMPOSSIBLE\n");
        } else if (ans.length() == n) {
            writer.write("Case #" + testNo + ": " + ans + "\n");
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> startTime = new ArrayList<>(n);
            ArrayList<Integer> endTime = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String[] taskTimes = br.readLine().split(" ");
                startTime.add(Integer.parseInt(taskTimes[0]));
                endTime.add(Integer.parseInt(taskTimes[1]));
            }
            schedulingTasks(startTime, endTime, k, n);
        }
    }
}