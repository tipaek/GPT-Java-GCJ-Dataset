import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int count = in.nextInt();
    int caseID = 1;
    for(int e=0;e<count;e++) {
        String S = in.nextLine();
        String finalString = "";
        
        int countOfOpenPar = 0;
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            int nbr = c - '0';
            while(countOfOpenPar < nbr) {
                finalString = finalString + "(";
                countOfOpenPar++;
            }
            while(countOfOpenPar > nbr) {
                finalString = finalString + ")";
                countOfOpenPar--;
            }
            if(countOfOpenPar == nbr) {
                finalString = finalString + c;
            }
        }
        while(countOfOpenPar > 0) {
            finalString = finalString + ")";
            countOfOpenPar--;
        }
        System.out.println("Case #" + caseID + ": " + finalString);
        caseID += 1;
    }
  }
}