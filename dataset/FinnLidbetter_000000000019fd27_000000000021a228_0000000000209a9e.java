/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    String[] s = br.readLine().split(" ");
    int nTests = Integer.parseInt(s[0]);
    int n = Integer.parseInt(s[1]);
    for (int test=0; test<nTests; test++) {
      int[] arr = new int[n];
      Arrays.fill(arr, -1);
      int numC = 0;
      int numR = 0;
      int cIndex = -1;
      int rIndex = -1;
      int known = 0;
      int qIndex = 0;
      while (known<n) {
        if (qIndex>1 && qIndex%10==0) {
          if (cIndex>=0) {
            //System.err.printf("Checking for complement\n");
            //System.err.printf("\tReading from position %d\n", cIndex+1);
            System.out.println(cIndex+1);
            System.out.flush();
            int read = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n", read);
            int expect = arr[cIndex];
            if (numR%2==1) 
              expect = arr[n-cIndex-1];
            if (numC%2==1) 
              expect = 1-expect;
            if (read!=expect) {
              numC++;
              //System.err.printf("\tThere was a complement operation, incrementing numC to %d\n", numC);
            }
            /*
            else {
              System.err.printf("\tNo complement detected. numC is %d\n", numC);
            }
            */
          } else {
            // Throw away query for simplicity.
            //System.err.printf("Not enough data to determine if a complement occurred\n");
            //System.err.println("\tReading from position 1\n");
            System.out.println(1);
            System.out.flush();
            int val = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n",val);
          }
        } else if (qIndex>1 && qIndex%10==1) {
          if (rIndex>=0) {
            //System.err.printf("Checking for reversal\n");
            //System.err.printf("\tReading from position %d\n", rIndex+1);
            System.out.println(rIndex+1);
            System.out.flush();
            int read = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n", read);
            int expect = arr[rIndex];
            if (numR%2==1)
              expect = arr[n-rIndex-1];
            if (numC%2==1)
              expect = 1-expect;
            if (read!=expect) {
              numR++;
              //System.err.printf("\tThere was a reversal operation, incrementing numR to %d\n", numR);
            } 
            /*
            else {
              System.err.printf("\tNo reversal detected. numR is %d\n", numR);
            }
            */
          } else {
            // Throw away query for simplicity.
            //System.err.printf("Not enough data to determine if a reversal occurred\n");
            //System.err.println("\tReading from position 1\n");
            System.out.println(1);
            System.out.flush();
            int val = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n",val);
          }
        } else {
          if (qIndex%2==0) {
            //System.err.printf("Reading from position %d\n", (known/2)+1);
            System.out.println((known/2)+1);
            System.out.flush();
            int val = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n", val);
            if (numC%2==1) {
              val = 1-val;
              //System.err.printf("\tComplementing\n");
            }
            if (numR%2==0) {
              //System.err.printf("\tStoring at position %d\n", known/2 + 1);
              arr[known/2] = val;
            } else {
              //System.err.printf("\tStoring at position %d\n", n-(known/2));
              arr[n-(known/2)-1] = val;
            }
          } else {
            //System.err.printf("Reading from position %d\n", n-(known/2));
            System.out.println(n-(known/2));
            System.out.flush();
            int val = Integer.parseInt(br.readLine());
            //System.err.printf("\tGot %d\n", val);
            if (numC%2==1) {
              val = 1-val;
              //System.err.printf("\tComplementing\n");
            }
            if (numR%2==0) {
              arr[n-(known/2)-1] = val;
              //System.err.printf("\tStoring at position %d\n", n-(known/2));
            } else {
              arr[known/2] = val;
              //System.err.printf("\tStoring at position %d\n", known/2 + 1);
            }
            if (cIndex==-1 && arr[n-(known/2)-1]==arr[known/2]) {
              //System.err.printf("\tSetting cIndex to %d\n", known/2);
              cIndex = known/2;
            }
            if (rIndex==-1 && arr[n-(known/2)-1]!=arr[known/2]) {
              //System.err.printf("\tSetting rIndex to %d\n", known/2);
              rIndex = known/2;
            }
          }
          known++;
        }
        qIndex++;
      }
      sb = new StringBuilder();
      for (int i=0; i<n; i++) {
        int index = i;
        if (numR%2==1) {
          index = n-i-1;
        }
        int val = arr[index];
        if (numC%2==1)
          val = 1-val;
        sb.append(val);
      }
      //System.err.printf("Guessing %s\n", sb.toString());
      System.out.println(sb.toString());
      System.out.flush();
      String response = br.readLine();
      //System.err.printf("Got response %s\n",response);
      //System.err.println();
      //System.err.println();
      //System.err.println();
    }
  }
}
