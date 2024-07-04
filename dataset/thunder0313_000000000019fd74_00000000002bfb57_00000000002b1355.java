import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));                                         
      StringTokenizer star = new StringTokenizer(bf.readLine());
      int cases = Integer.parseInt(star.nextToken());
      for(int case_num = 1; case_num <= cases; case_num++) {
         star = new StringTokenizer(bf.readLine());
         int R = Integer.parseInt(star.nextToken());
         int C = Integer.parseInt(star.nextToken());
         int[][] skill = new int[R][C];
         boolean[][] eliminated = new boolean[R][C];
         for(int i = 0; i < R; i++) {
            star = new StringTokenizer(bf.readLine());
            for(int j = 0; j < C; j++) {
               skill[i][j] = Integer.parseInt(star.nextToken());
            }
         }
         
         int total_round_skill = 0;
         boolean someone_eliminated = true;  
         while(someone_eliminated) {
            ArrayList<Integer> eliminations = new ArrayList<Integer>();
            someone_eliminated = false;
            int round_skill = 0;
            for(int i = 0; i < R; i++) {
               for(int j = 0; j < C; j++) {
                  int sum = 0;
                  int count = 0;
                  int temp_i, temp_j = 0;
                  if(eliminated[i][j]) {
                     continue;
                  } else {
                     round_skill += skill[i][j];
                  
                     temp_i = i;
                     temp_j = j;
                     while(((temp_i - 1) >= 0)) {
                        if(eliminated[temp_i - 1][temp_j]) {
                           temp_i--;
                           continue;
                        } else {
                           sum += skill[temp_i - 1][temp_j];
                           count++;
                           break;
                        }
                     }
                     
                     temp_i = i;
                     temp_j = j;
                     while(((temp_j - 1) >= 0)) {
                        if(eliminated[i][temp_j - 1]) {
                           temp_j--;
                           continue;
                        } else {
                           sum += skill[i][temp_j - 1];
                           count++;
                           break;
                        }
                     }
                  
                     temp_i = i;
                     temp_j = j;
                     while(((temp_i + 1) < R)) {
                        if(eliminated[temp_i + 1][temp_j]) {
                           temp_i++;
                           continue;
                        } else {
                           sum += skill[temp_i + 1][temp_j];
                           count++;
                           break;
                        }
                     }
                  
                     temp_i = i;
                     temp_j = j;
                     while(((temp_j + 1) < C)) {
                        if(eliminated[temp_i][temp_j + 1]) {
                           temp_j++;
                           continue;
                        } else {
                           sum += skill[temp_i][temp_j + 1];
                           count++;
                           break;
                        }
                     }
                  
                     if(count > 0) {
                        double average = (double)(sum) / (double)(count);
                        if(average > skill[i][j]) {
                           eliminations.add(i);
                           eliminations.add(j);
                           someone_eliminated = true;
                        }
                     }
                  }               
               }
            }
            
            total_round_skill += round_skill;
            for(int i = 0; i < eliminations.size(); i+=2) {
               eliminated[eliminations.get(i)][eliminations.get(i + 1)] = true;
            }
         }
         System.out.println("Case #" + case_num + ": " + total_round_skill);
      }    
   }
}