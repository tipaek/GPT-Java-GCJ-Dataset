import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int testCase = 1; testCase <= t; ++testCase) {
      
      int n = in.nextInt();
      
      int[] c = new int[1440], j = new int[1440], actStart = new int[n], actEnd = new int[n], actOGSort = new int[n];
      String[] parentRole = new String[n]; 
      String order = "";
      
      for(int i=0; i<n; i++){
        actStart[i] = in.nextInt();
        actEnd[i] = in.nextInt();
        actOGSort[i] = i;
      }
        
      boolean isImpossible = false;
      int[] fullSchedule = new int[1440];
      for(int i=0; i<n; i++){
        for(int k = actStart[i]; !isImpossible && k<actEnd[i]; k++){
          fullSchedule[k]++;
          if(fullSchedule[k]>=3){
              isImpossible = true;
              order = "IMPOSSIBLE";
            }
          }
      }

      if(!isImpossible){ 
        sort(actStart,actEnd,actOGSort,parentRole);
        for(int i=0; i<n; i++){
          if(isValid(c, actStart[i], actEnd[i])){
            for(int k=actStart[i]; k<actEnd[i]; k++){
              c[k]++;
            }
            parentRole[i]="C";
          } else {
            for(int k=actStart[i]; k<actEnd[i]; k++){
              j[k]++;
            }
            parentRole[i]="J";
          }
        }

        sort(actOGSort,actStart,actEnd,parentRole);
        for(int i=0; i<n; i++){
          order+=parentRole[i];
        }
      }

      System.out.println("Case #"+ testCase +": "+order);
    }
    
  }

  public static void sort(int[] arr1, int[] arr2, int[] arr3, String[] arr4) { 
      int n = arr1.length;
      for (int i = 1; i < n; ++i) { 
          int key1 = arr1[i];
          int key2 = arr2[i];
          int key3 = arr3[i];
          String key4 = arr4[i];
          int j = i - 1; 

          while (j >= 0 && arr1[j] > key1) { 
              arr1[j + 1] = arr1[j];
              arr2[j + 1] = arr2[j];
              arr3[j + 1] = arr3[j];
              arr4[j + 1] = arr4[j];
              j = j - 1; 
          }

          arr1[j + 1] = key1;
          arr2[j + 1] = key2; 
          arr3[j + 1] = key3;
          arr4[j + 1] = key4;  
      } 
  } 

  public static boolean isValid (int[] schedule, int activityStart, int activityEnd){
    for(int k = activityStart; k<activityEnd; k++){
      if(schedule[k]==1){
          return false;
        }
    }
    return true;
  }
}