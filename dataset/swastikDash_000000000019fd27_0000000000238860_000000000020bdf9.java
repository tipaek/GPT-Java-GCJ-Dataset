import java.io.*;

public class Solution {

    static int[] startTime;
    static int[] endTime;
    static int tasks;

    static String order;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int test = 1; test <= cases; test++) {

            tasks = Integer.parseInt(br.readLine());

            startTime = new int[tasks];
            endTime = new int[tasks];

            for (int i = 0; i < tasks; i++) {
                String[] input = br.readLine().trim().split(" ");
                startTime[i] = Integer.parseInt(input[0]);
                endTime[i] = Integer.parseInt(input[1]);

            }

            order = "";

            getOrder();

            //DONOT CHANGE THE LINE IF NOT NECESSARY
            System.out.print("Case #" + test + ": ");

            System.out.println(order);

        }
    }

    private static void getOrder() {
        order = "CJ";

        int cStart = startTime[0];
        int cEnd = endTime[0];
        int jStart = startTime[1]; //1
        int jEnd = endTime[1]; //3

        for (int i = 2; i < tasks; i++) {
            
            if ((startTime[i] >= cEnd) || (startTime[i] < cStart && endTime[i] < cEnd))
                order += "C";
            else if ((startTime[i] >= jEnd ) || (startTime[i] < jStart && endTime[i] < jEnd))
                order += "J";
            else {
                order = "IMPOSSIBLE";
                break;
            }

        }
    }

}