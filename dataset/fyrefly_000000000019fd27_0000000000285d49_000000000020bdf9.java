import java.util.Scanner;
public class Solution {
   public static void main (String[]args) {
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int tn = 1; tn <= t; tn++) {
         int n = scan.nextInt();
         int[][] times = new int[n][2], sortedTimes = new int[n][2];
         String output = "";
         for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
               times[i][j] = scan.nextInt();
               
         //Assignment and Sorting
         for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
               sortedTimes[i][j] = times[i][j];
               
         for (int i = 0; i < n - 1; i++) {
            if (sortedTimes[i][0] > sortedTimes[i+1][0]) {
               int tempo = sortedTimes[i][0], tempt = sortedTimes[i][1];
               sortedTimes[i][0] = sortedTimes[i+1][0]; sortedTimes[i][1] = sortedTimes[i+1][1];
               sortedTimes[i+1][0] = tempo; sortedTimes[i+1][1] = tempt;
               i = 0;
            }
         }
         
         //"Impossible" method
         boolean possible = true;
         for (int j = 0; j < n - 1; j++) {
            int count = 0;
            int timeo = sortedTimes[j][0], timet = sortedTimes[j][1];
            
            for (int k = j + 1; k < n; k++) {
               if (timeo < sortedTimes[k][0] && timet > sortedTimes[k][1]) count++;
               if (count == 2) possible = false;
            }
            
         }
         
         String[] choices = new String[n - 1];
         if (!possible) System.out.println("Case #" + tn + ": IMPOSSIBLE");
         else {
            int index = 0;
            for (int i = 0; i < n - 1; i++) {
               if (times[i][0] < times[i+1][0] && times[i][1] > times[i + 1][0]) {
                  choices[index] = "different";
                  index++;
               } else if (times[i + 1][0] < times[i][1] && times[i + 1][1] > times[i][1]) {
                  choices[index] = "different";
                  index++;
               } else if (times[i][0] < times[i+1][1] && times[i][1] > times[i + 1][1]) {
                  choices[index] = "different";
                  index++;
               }
               else if (times[i][1] > times[i+1][1] && times[i][0] > times[i+1][1]) {
                  choices[index] = "different";
                  index++;
               }
               else if (times[i][1] == times[i + 1][0] || times[i][1] < times[i + 1][0]) {
                  choices[index] = "same";
                  index++;
               }
            }
            output = output +"C";
            for(int i = 0; i < choices.length; i++) {
               if(choices[i].equals("different")) {
                  if(output.substring(output.length() - 1).equals("C")) {
                     output = output + "J";
                  } else if(output.substring(output.length() - 1).equals("J")) {
                     output = output + "C";
                  }
               } else if (choices[i].equals("same")){
                  if(output.substring(output.length() - 1).equals("C")) {
                     output = output + "C";
                  } else if(output.substring(output.length() - 1).equals("J")) {
                     output = output + "J";
                  }

               }
            }
            
            System.out.println("Case #" + tn + ": " + output);
            
         }
      }
   }
}