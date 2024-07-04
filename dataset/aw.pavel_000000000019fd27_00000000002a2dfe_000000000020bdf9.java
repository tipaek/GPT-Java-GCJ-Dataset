import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    byte n = in.nextByte(); 
    
    short job[][][] = new short[n][][];
    short activity[] = new short[n];
    
    
    byte index1;
    short index2, index3;
    
    byte scheduleJ[] = new byte[1441];
    byte scheduleC[] = new byte[1441];
    boolean foundJ, foundC;
    
    for (index1 = 0; index1 < n; ++index1) {
      short actQty = in.nextShort();
      
      activity[index1] = actQty;
      
      job[index1] = new short[actQty][3];

      
      for(index2 = 0; index2 < actQty; index2++) {
        job[index1][index2][0] = in.nextShort();
        job[index1][index2][1] = in.nextShort();
        job[index1][index2][2] = index2;
      }
      
      Arrays.sort(job[index1], (a, b) -> Short.compare(a[0], b[0]));
    }
    
    for(index1 = 0; index1 < n; index1++) {
        System.out.print("Case #"+(index1+1)+": ");
        
        for(index2 = 0; index2<1441; index2++) {
            scheduleJ[index2] = 0;
            scheduleC[index2] = 0;
        }
        
        char [] result = new char[activity[index1]];
        boolean error = false;
        for(index2 = 0; index2 < activity[index1]; index2++) {
            foundJ = true;
            foundC = true;
            for(index3 = job[index1][index2][0]; 
                index3<=job[index1][index2][1];index3++){
                if (scheduleJ[index3] != 0) {
                    if (index3 != job[index1][index2][1] &&
                        index3 != job[index1][index2][0]) 
                    {
                        foundJ = false;
                    }
                    
                    if (index3 == job[index1][index2][1]) {
                        if (index3==0 || scheduleJ[index3-1] == 1)
                            foundJ = false;
                    } 

                    if (index3 == job[index1][index2][0]) {
                        if (index3==1440 || scheduleJ[index3+1] == 1)
                            foundJ = false;
                    } 
                }
                if (scheduleC[index3] != 0) {
                    if (index3 != job[index1][index2][1] && 
                        index3 != job[index1][index2][0]) 
                    {
                        foundC = false;
                    } 
                    
                    if (index3 == job[index1][index2][1]) {
                        if (index3==0 || scheduleC[index3-1] == 1)
                            foundC = false;
                    } 
                    if (index3 == job[index1][index2][0]) {
                        if (index3==1440 || scheduleC[index3+1] == 1)
                            foundC = false;
                    } 
                }
            }
            
            if (foundJ) {
                for(index3 = job[index1][index2][0]; 
                    index3<=job[index1][index2][1];index3++){
                    scheduleJ[index3] = 1;
                }
                foundC = false;
                result[job[index1][index2][2]] = 'J';
            }

            if (foundC) {
                for(index3 = job[index1][index2][0]; 
                    index3<=job[index1][index2][1];index3++){
                    scheduleC[index3] = 1;
                }
                //result.append("C");
                result[job[index1][index2][2]] = 'C';
            }
            
            if (!foundC && !foundJ) {
                error = true;
                break;
            }
        }
        if (error) System.out.println("IMPOSSIBLE");
        else System.out.println(new String(result));
    }
  }
} 