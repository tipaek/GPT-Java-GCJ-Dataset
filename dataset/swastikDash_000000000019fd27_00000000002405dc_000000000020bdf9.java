import java.io.*;

public class Solution {

    static int[] startTime;
    static int[] endTime;
    static int[] sequence;
    static int tasks;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int test = 1; test <= cases; test++) {

            tasks = Integer.parseInt(br.readLine());

            startTime = new int[tasks];
            endTime = new int[tasks];
            sequence = new int[tasks];

            for (int i = 0; i < tasks; i++) {
                String[] input = br.readLine().trim().split(" ");
                startTime[i] = Integer.parseInt(input[0]);
                endTime[i] = Integer.parseInt(input[1]);

            }

            sort();

            //DONOT CHANGE THE LINE IF NOT NECESSARY
            System.out.print("Case #" + test + ": ");

            System.out.println(getOrder());

        }
    }

    private static void sort(){

        for (int i = 0; i < tasks; i++) {
            for (int j = i+1; j < tasks; j++) {
                if(startTime[i] > startTime[j]){
                    int tempStart = startTime[i];
                    startTime[i] = startTime[j];
                    startTime[j] = tempStart;

                    int tempEnd = endTime[i];
                    endTime[i] = endTime[j];
                    endTime[j] = tempEnd;

                    int temp = sequence[i];
                    sequence[i] = sequence[j];
                    sequence[i] = temp;
                }
            }
        }

    }

    private static String getOrder() {
        char[] order = new char[tasks];
        String result = "";
        int cStart=0, cEnd=0, jStart=0, jEnd=0;

        for (int i = 0; i < tasks; i++) {

            if(i==0){
                order[i]='C';
                cStart = startTime[i];
                cEnd = endTime[i];
            }
            else if(i==1){
                if(startTime[i]>=cEnd) {
                    order[i] = 'C';
                    cStart = startTime[i];
                    cEnd = endTime[i];
                }
                else{
                        order[i] = 'J';
                        jStart = startTime[i];
                        jEnd = endTime[i];
                }
            }
            else{
                if(startTime[i]>=cEnd) {
                    order[i] = 'C';
                    cStart = startTime[i];
                    cEnd = endTime[i];
                }
                else if(startTime[i]>=jEnd){
                    order[i] = 'J';
                    jStart = startTime[i];
                    jEnd = endTime[i];
                }
                else
                    return "IMPOSSIBLE";
            }
        }


        for (char c: order) {
            result += c;
        }
        return result;
    }
}