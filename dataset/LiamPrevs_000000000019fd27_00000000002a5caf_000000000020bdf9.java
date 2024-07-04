import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numCases; i++){
            Integer[] timeSlotsCam = new Integer[1441];
            Integer[] timeSlotsJamie = new Integer[1441];
            String returnString = "";

            int numActivities = sc.nextInt();
            sc.nextLine();

            for(int n = 0; n < numActivities; n++){
                String[] currActivity = sc.nextLine().split(" ");

                boolean camOpen = true;
                boolean jamieOpen = true;

                int c = Integer.parseInt(currActivity[0]);
                Integer[] potTimeSlotsCam = timeSlotsCam.clone();
                Integer[] potTimeSlotsJamie = timeSlotsJamie.clone();
                
                while(c < Integer.parseInt(currActivity[1])){
                    if(camOpen && potTimeSlotsCam[c] == null){
                        potTimeSlotsCam[c] = 0;
                    }
                    else if(potTimeSlotsCam[c] != null){
                        camOpen = false;
                    }
                    if(jamieOpen && potTimeSlotsJamie[c] == null){
                        potTimeSlotsJamie[c] = 0;
                    }
                    else if(potTimeSlotsJamie[c] != null){
                        jamieOpen = false;
                    }
                    if(!(camOpen||jamieOpen)) break;

                    c+=1;
                }

                if(camOpen && !returnString.equals("IMPOSSIBLE")){
                    returnString += "C";
                    timeSlotsCam = potTimeSlotsCam.clone();

                }
                else if(jamieOpen && !returnString.equals("IMPOSSIBLE")){
                    returnString += "J";
                    timeSlotsJamie = potTimeSlotsJamie.clone();
                }
                else{
                    returnString = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + (i+1) + ": " + returnString);
        }
        sc.close();
    }
}
