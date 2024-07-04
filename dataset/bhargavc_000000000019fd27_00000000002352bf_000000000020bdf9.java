import java.util.Scanner;

class Solution{
    public static void main(String[] args){

        Scanner stdScanner = new Scanner(System.in);
        String stream = "";
        int testCases = Integer.parseInt(stdScanner.nextLine().trim());
        int id = 0;
        while(id < testCases){

            int tasks = Integer.parseInt(stdScanner.nextLine().trim());
            int n = 0;
            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];
            while(n < tasks){

                stream = stdScanner.nextLine().trim();
                //System.out.println(stream);
                String[] line = stream.split(" ");

                startTimes[n] = Integer.parseInt(line[0]);
                endTimes[n] = Integer.parseInt(line[1]);
                n++;
            }
            ParentingPartnering parentingPartnering = new ParentingPartnering(id, startTimes, endTimes);
            String out = parentingPartnering.compute();
            System.out.println(out);
            id++;
        }
        stdScanner.close();
    }
}

class ParentingPartnering{

    int[] startTimes;
    int[] endTimes;
    int testId;
    public ParentingPartnering(int testId, int[] startTimes, int[] endTimes){

        this.testId = testId;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
    }

    public String compute(){

        int[][] endHash = new int[1441][2];
        for(int i = 0 ; i < 1441 ; i++){

            endHash[i][0] = -1;
            endHash[i][1] = -1;
        }
        char[] assignment = new char[endTimes.length];

        for(int i = 0 ; i < endTimes.length ; i++){

            if(endHash[endTimes[i]][0] == -1) {
                endHash[endTimes[i]][0] = i;
            }
            else if(endHash[endTimes[i]][1] == -1) {
                endHash[endTimes[i]][1] = i;
            }
            else{
                return formatOutput("IMPOSSIBLE");
            }
        }
        int cameronFreeFrom = 0;
        int jamieFreeFrom = 0;

        for(int i = 0 ; i < 1441 ; i++){

            for(int j = 0 ; j < 2 ; j++){

                if(endHash[i][j] != -1){

                    int index = endHash[i][j];
                    if(jamieFreeFrom <= startTimes[index]){

                        assignment[index] = 'J';
                        jamieFreeFrom = endTimes[index];
                    }
                    else if(cameronFreeFrom <= startTimes[index]){

                        assignment[index] = 'C';
                        cameronFreeFrom = endTimes[index];
                    }
                    else{
                        return formatOutput("IMPOSSIBLE");
                    }
                }
            }
        }

        return formatOutput(String.valueOf(assignment));
    }

    public String formatOutput(String schedule){

        String ret = "";
        ret += "Case #" + String.valueOf(testId+1) + ": ";
        ret += schedule;
        return ret;
    }
}