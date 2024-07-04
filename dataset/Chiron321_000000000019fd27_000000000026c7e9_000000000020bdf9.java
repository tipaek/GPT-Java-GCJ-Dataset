import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static Map<String, String> hashMap;
    static String[] taskDivision;
    static int i;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int caseNo = 1;
        int test = sc.nextInt();
        while (test-- > 0) {
            i =0;
            int noOfTasks = sc.nextInt();
            hashMap= new HashMap<String, String>(noOfTasks);
            taskDivision = new String[noOfTasks];
            sc.nextLine();
            hashMap.put("J",sc.nextLine());
            taskDivision[0] = "J";

            putTasksInMap(noOfTasks);

            System.out.print("Case #"+caseNo +": ");
            for (int k =0;k<taskDivision.length;k++){
                if(Arrays.asList(taskDivision).contains("IMPOSSIBLE")){
                    System.out.print("IMPOSSIBLE");
                    break;
                }
                System.out.print(taskDivision[k]);
            }
            
            System.out.println();
            caseNo++;
        }
        sc.close();
    }

    public static void putTasksInMap(int noOfTasks) {
        while (++i < noOfTasks) {
            int lowLimit = 0;
            int highLimit = 0;
            int ansJ = 0;
            int perfectC = 0;
            int perfectJ = 0;
            int ansC = 0;
            int lowEntry = 0;
            int highEntry = 0;
            String s = sc.nextLine();

            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                lowLimit = Integer.parseInt(String.valueOf(entry.getValue().split(" ")[0]));
                highLimit = Integer.parseInt(String.valueOf(entry.getValue().split(" ")[1]));
                lowEntry = Integer.parseInt(String.valueOf(s.split(" ")[1]));
                highEntry = Integer.parseInt(String.valueOf(s.split(" ")[0]));

                if (entry.getKey().contains("J")) {
                    perfectJ++;
                    if (( lowEntry <= lowLimit) || (highEntry >= highLimit)) {
                        ansJ++;
                    }
                }

                else if (entry.getKey().contains("C")) {
                    perfectC++;
                    if (( lowEntry <= lowLimit) || (highEntry >= highLimit)) {
                        ansC++;
                    }
                }
            }
            if (perfectC == ansC) {
                taskDivision[i] = "C";
                hashMap.put("C" + i, s);
            } else if (perfectJ == ansJ) {
                taskDivision[i] = "J";
                hashMap.put("J" + i, s);
            } else {
                taskDivision[i] = "IMPOSSIBLE";
                break;
            }
        }
    }
}