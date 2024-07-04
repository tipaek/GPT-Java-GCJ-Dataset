import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int MAX_QUERY = 150;
    private static final int COMPLEMENT_AND_REVERSE = 3;
    private static final int COMPLEMENT_ONLY = 2;
    private static final int REVERSE_ONLY = 4;
    private static final int NO_OPERATION = 5;
    private static MyScanner sc;
    private static FileWriter fileWriter;
    private static boolean logEnabled = false;
    private static int queryIndex = 1;
    private static boolean judgeRejected = false;

    public static void main(String[] args) {
        sc = new MyScanner();
        try {
            // fileWriter = new FileWriter("debugfilelocation");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] command = sc.nextLine().split(" ");
        int t = Integer.parseInt(command[0]);
        int b = Integer.parseInt(command[1]);
        for (int i = 1; i <= t; i++) {
            runTest(i, b);
        }

        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runTest(int testIndex, int b) {
        log("run test " + testIndex + "\n");
        queryIndex = 1;
        judgeRejected = false;
        if (b == 10) {
            runTest10();
        } else {
            runTest100_20(b);
        }
    }

    private static boolean runTest10() {
        int[] answer = new int[10];
        for (int i = 0; i < 10; i++) {
            answer[i] = queryJudge(i + 1);
        }
        return giveAnswerToJudge(arrToString(answer));
    }

    private static boolean runTest100_20(int b) {
        int[] answer = new int[b];
        int start = (b - 1) / 2;
        int end = start + 1;
        int filled = 2;
        boolean fluctuating = false;
        int fluctuatingCase = -1;
        answer[start] = queryJudge(start + 1);
        answer[end] = queryJudge(end + 1);
        int lastUpdatedIndex = end;

        while (filled < b || fluctuating) {
            if (fluctuating) {
                handleFluctuatingCase(answer, start, end, fluctuatingCase);
                fluctuating = false;
            } else if (queryIndex % 10 == 1) {
                fluctuatingCase = determineFluctuatingCase(answer, start, end);
                fluctuating = true;
            } else {
                lastUpdatedIndex = updateAnswerArray(answer, start, end, lastUpdatedIndex);
                filled++;
            }
        }

        return giveAnswerToJudge(arrToString(answer));
    }

    private static void handleFluctuatingCase(int[] answer, int start, int end, int fluctuatingCase) {
        int index;
        int judgeQueryResult;
        switch (fluctuatingCase) {
            case 1:
                index = findIndexToCheckComplementIfReverse(start, end, answer);
                if (index >= 0) {
                    judgeQueryResult = queryJudge(index + 1);
                    if (answer[index] != judgeQueryResult) {
                        complementArr(answer);
                    } else {
                        complementArr(answer);
                        reverseArr(answer);
                    }
                } else {
                    queryJudge(1);
                    complementArr(answer);
                }
                break;
            case 2:
                index = findIndexToCheckReverse(start, end, answer);
                if (index >= 0) {
                    judgeQueryResult = queryJudge(index + 1);
                    if (answer[index] != judgeQueryResult) {
                        reverseArr(answer);
                    }
                } else {
                    queryJudge(1);
                }
                break;
            case 3:
                index = start;
                judgeQueryResult = queryJudge(index + 1);
                if (answer[index] != judgeQueryResult) {
                    reverseArr(answer);
                }
                break;
        }
    }

    private static int determineFluctuatingCase(int[] answer, int start, int end) {
        int index = findIndexToCheckComplement(start, end, answer);
        if (index >= 0) {
            int judgeQueryResult = queryJudge(index + 1);
            return answer[index] != judgeQueryResult ? 1 : 2;
        } else {
            queryJudge(start);
            return 3;
        }
    }

    private static int updateAnswerArray(int[] answer, int start, int end, int lastUpdatedIndex) {
        if ((lastUpdatedIndex == end || end + 1 == answer.length) && start - 1 >= 0) {
            start--;
            answer[start] = queryJudge(start + 1);
            return start;
        } else {
            end++;
            answer[end] = queryJudge(end + 1);
            return end;
        }
    }

    private static int queryJudge(int index) {
        if (queryIndex > MAX_QUERY) {
            System.exit(-1);
        }
        if (judgeRejected) {
            System.exit(-2);
        }
        System.out.println(index);
        log("query = " + index + "\n");
        System.out.flush();
        queryIndex++;
        int returnValue = Integer.parseInt(sc.nextLine());
        log("Judge return " + returnValue + "\n");
        return returnValue;
    }

    private static boolean giveAnswerToJudge(String output) {
        if (judgeRejected) {
            System.exit(-2);
        }
        System.out.println(output);
        System.out.flush();
        boolean passed = sc.nextLine().equals("Y");
        if (!passed) {
            judgeRejected = true;
        }
        return passed;
    }

    private static int findIndexToCheckComplement(int start, int end, int[] arr) {
        while (start < end) {
            if (arr[start] == arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    private static int findIndexToCheckComplementIfReverse(int start, int end, int[] arr) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    private static int findIndexToCheckReverse(int start, int end, int[] arr) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    private static void reverseArr(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void complementArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
    }

    private static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value);
        }
        return sb.toString();
    }

    private static void log(String message) {
        if (fileWriter != null && logEnabled) {
            try {
                fileWriter.write(message);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}