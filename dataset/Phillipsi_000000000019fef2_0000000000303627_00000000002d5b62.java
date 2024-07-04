import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y =  Integer.parseInt(st.nextToken());
                int currentNum = 2;
                String currentSteps = "";
                boolean impossible = false;
                while(x != 0 && y != 0){
                  System.out.println(x + " " + y + " " + currentNum);  
                  if(x % currentNum != 0){
                     if(y % currentNum != 0){
                        currentSteps = "IMPOSSIBLE";
                        impossible = true;
                        break;
                     }else{
                        if((x+currentNum/2) % (currentNum * 2) != 0){
                           if(y  % (currentNum * 2) != 0){
                              x-=currentNum/2;
                              currentSteps = currentSteps + "E";
                           }else{
                              x+=currentNum/2;
                              currentSteps = currentSteps + "W";
                           }
                        }else{
                           if(y  % (currentNum * 2) != 0){
                              x+=currentNum/2;
                              currentSteps = currentSteps + "W";
                           }else{
                              x-=currentNum/2;
                              currentSteps = currentSteps + "E";
                           }
                        }
                     }
                  }else{
                     if(y % currentNum != 0){
                        if((y+currentNum/2) % (currentNum * 2) != 0){
                           if(x  % (currentNum * 2) != 0){
                              y-=currentNum/2;
                              currentSteps = currentSteps + "N";
                           }else{
                              y+=currentNum/2;
                              currentSteps = currentSteps + "S";
                           }
                        }else{
                           if(x  % (currentNum * 2) != 0){
                              y+=currentNum/2;
                              currentSteps = currentSteps + "S";
                           }else{
                              y-=currentNum/2;
                              currentSteps = currentSteps + "N";
                           }
                        }
                     }else{
                        currentSteps = "IMPOSSIBLE";
                        impossible = true;
                        break;
                     }
                  }
                  currentNum *= 2;
                }
                while(x != 0 && !impossible){
                  System.out.println(x + " " + y + " " + currentNum);  
                  if(x % currentNum == 0){
                     currentSteps = "IMPOSSIBLE";
                     impossible = true;
                     break;
                  }
                  if((x + currentNum/2) % (currentNum*2) == 0 &&  x + currentNum/2 != 0 ||  x-currentNum/2 == 0){
                     currentSteps = currentSteps + "E";
                     x -= currentNum/2;
                  }else{
                     currentSteps = currentSteps + "W";
                     x += currentNum/2;
                  }
                  currentNum *= 2;
                }
                while(y != 0 && !impossible){
                  System.out.println(x + " " + y + " " + currentNum);    
                  if(y % currentNum == 0){
                     currentSteps = "IMPOSSIBLE";
                     break;
                  }
                  if((y + currentNum/2) % (currentNum*2) == 0 && y + currentNum/2 != 0 || y-currentNum/2 == 0){
                     currentSteps = currentSteps + "N";
                     y -= currentNum/2;
                  }else{
                     currentSteps = currentSteps + "S";
                     y += currentNum/2;
                  }
                  currentNum *= 2;
                }
                System.out.println("Case #" + i + ": " + currentSteps);
            }
        }catch(IOException e){
            return;
        }
    }
    
}