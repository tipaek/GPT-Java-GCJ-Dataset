public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        // Testcases loop
        for(int i = 0; i < testcases; i++){
            int testcase = i + 1;
            String output = "";

            // get schedule
            int n = sc.nextInt();
            int[][] schedule = new int[n][2];
            for(int k = 0; k < n; k++){
                schedule[k][0] = sc.nextInt();
                schedule[k][1] = sc.nextInt();
            }

            int c = 0;
            int j = 0;

            for(int k = 0; k < n; k++){
                if(schedule[k][0] >= c){
                    c = schedule[k][1];
                    output += "C";
                } else if(schedule[k][0] >= j) {
                    c = schedule[k][1];
                    output += "J";
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }

            // output the line
            System.out.println("Case #" + testcase + ": " + output);

        }



    }
}