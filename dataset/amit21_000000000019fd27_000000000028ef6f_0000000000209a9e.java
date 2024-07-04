import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int queryIndex = 1;
    private static final int MAX_QUERY = 150;
    private static boolean judgeRejected = false;
    private static MyScanner sc;
    private static final int COMPLEMENT_AND_REVERSE = 3;
    private static final int COMPLEMENT_ONLY = 2;
    private static final int REVERSE_ONLY = 4;
    private static final int NO_OPERATION = 5;
    private static FileWriter fileWriter;
    private static boolean logEnabled = false;

    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static int findPalindromicIndex(int index, int start, int end) {
        return end - (index - start);
    }

    //case 1: If not same with judge query than array operation has complement And reverse or complement
    //case 2: If judge query same as value than array can be in reverse state or no change
    //case 3: If no index found and judge query change the value of start index than array is reversed
    public static int findIndexToCheckComplement(int start, int end, int arr[]) {
        while (start < end) {
            if (arr[start] == arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    //For above case 1: to check whether complement also involves reverse
    //check whether number changed its value from judge query if yes than no reverse else reverse + complement
    public static int findIndexToCheckComplementIfReverse(int start, int end, int arr[]) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }


    //For above case 2: to check whether no complement also involves reverse
    //check whether number changed its value from judge query if yes than no reverse else no change
    public static int findIndexToCheckReverse(int start, int end, int arr[]) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return start;
            }
            start++;
            end--;
        }
        return -1;
    }

    public static void log(String message) {
        if (fileWriter != null && logEnabled) {
            try {
                fileWriter.write(message);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int queryJudge(int index) {
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

    public static boolean giveAnswerToJudge(String output) {
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

    public static boolean runTest10() {
        int[] answer = new int[10];
        for (int i = 0; i < 10; i++) {
            answer[i] = queryJudge(i + 1);
        }
        return giveAnswerToJudge(arrToString(answer));
    }

    public static void reverseArr(int arr[]) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void complementArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
    }

    public static boolean runTest100_20(int b) {
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
                if (fluctuatingCase == 1) {
                    int index = findIndexToCheckComplementIfReverse(start, end, answer);
                    if (index >= 0) {
                        int judgeQueryResult = queryJudge(index + 1);
                        if (answer[index] != judgeQueryResult) {
                            //No reverse only complement
                            complementArr(answer);
                        } else {
                            complementArr(answer);
                            reverseArr(answer);
                        }
                    } else {
                        queryJudge(1);
                        complementArr(answer);
                    }
                } else if (fluctuatingCase == 2) {
                    int index = findIndexToCheckReverse(start, end, answer);
                    if (index >= 0) {
                        int judgeQueryResult = queryJudge(index + 1);
                        if (answer[index] != judgeQueryResult) {
                            //Yes it is reverse
                            reverseArr(answer);
                        } else {
                            //No changes
                        }
                    } else {
                        queryJudge(1);
                    }
                } else {
                    int index = start;
                    int judgeQueryResult = queryJudge(index + 1);
                    if (answer[index] != judgeQueryResult) {
                        //No reverse only complement
                        reverseArr(answer);
                    } else {
                        // No change
                    }
                }
                fluctuating = false;
            } else if (queryIndex % 10 == 1) {
                int index = findIndexToCheckComplement(start, end, answer);
                if (index >= 0) {
                    int judgeQueryResult = queryJudge(index + 1);
                    if (answer[index] != judgeQueryResult) {
                        fluctuatingCase = 1;
                    } else {
                        fluctuatingCase = 2;
                    }
                } else {
                    //Dummy query so counting does not mash up
                    queryJudge(start);
                    fluctuatingCase = 3;
                }
                fluctuating = true;
            } else {
                if ((lastUpdatedIndex == end || end + 1 == b) && start - 1 >= 0) {
                    start--;
                    answer[start] = queryJudge(start + 1);
                    lastUpdatedIndex = start;
                } else {
                    end++;
                    answer[end] = queryJudge(end + 1);
                    lastUpdatedIndex = end;
                }
                filled++;
            }
        }
        return giveAnswerToJudge(arrToString(answer));
    }

    public static void runTest(int testIndex, int b) {
        log("run test " + testIndex + "\n");
        queryIndex = 1;
        judgeRejected = false;
        if (b == 10) {
            runTest10();
        } else {
            runTest100_20(b);
        }
    }

    public static void main(String[] args) {
        sc = new MyScanner();
        fileWriter = null;
        try {
            //fileWriter = new FileWriter("debugfilelocation");
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
