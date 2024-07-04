import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new BufferedReader(new FileReader("c.in")));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();
        int numCases = Integer.parseInt(line);
        boolean[] sheduleBusyC;
        boolean[] sheduleBusyJ;
        int N;
        String result;
        String[] minutes;
        int minIni;
        int minEnd;
        boolean isBusyC;
        boolean isBusyJ;
        String[] activities;
        String[] activitiesSorted;

        for (int i = 0; i < numCases; i++) {
            line = in.nextLine();
            N = Integer.parseInt(line);
            activities = new String[N];
            activitiesSorted = new String[N];
            result = "";
            sheduleBusyC = new boolean[1440];
            sheduleBusyJ = new boolean[1440];
            for (int j = 0; j < N; j++) {
                activities[j] = in.nextLine();
                activitiesSorted[j] = activities[j];
            }
            //Sorted
            for (int j = 0; j < activitiesSorted.length - 1; j++) {
                for (int k = j + 1; k < activitiesSorted.length; k++) {
                    String[] auxJ = activitiesSorted[j].split(" ");
                    String[] auxK = activitiesSorted[k].split(" ");
                    if (Integer.parseInt(auxK[0]) < Integer.parseInt(auxJ[0])) {
                        String aux = activitiesSorted[j];
                        activitiesSorted[j] = activitiesSorted[k];
                        activitiesSorted[k] = aux;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                line = activitiesSorted[j];
                minutes = line.split(" ");
                isBusyC = false;
                minIni = Integer.parseInt(minutes[0]);
                minEnd = Integer.parseInt(minutes[1]);
                for (int k = minIni; k < minEnd && !isBusyC; k++) {
                    isBusyC = sheduleBusyC[k];
                }
                if (!isBusyC) {
                    activitiesSorted[j] += ";C";
                    for (int k = minIni; k < minEnd; k++) {
                        sheduleBusyC[k] = true;
                    }
                } else {
                    isBusyJ = false;
                    for (int k = minIni; k < minEnd && !isBusyJ; k++) {
                        isBusyJ = sheduleBusyJ[k];
                    }
                    if (!isBusyJ) {
                        activitiesSorted[j] += ";J";
                        for (int k = minIni; k < minEnd; k++) {
                            sheduleBusyJ[k] = true;
                        }
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            if (!result.equals("IMPOSSIBLE")) {
                //Sorted
                result = "";
                for (int j = 0; j < activities.length; j++) {
                    for (int k = 0; k < activitiesSorted.length; k++) {
                        String[] aux = activitiesSorted[k].split(";");
                        if (aux[0].equals(activities[j])) {
                            result += aux[1];
                        }
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}
