
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(input.readLine());
       
       for(int currCase = 1; currCase <= t; currCase++)
       {
           String[] params = input.readLine().split(" ");
           int east = Integer.parseInt(params[0]);
           int north = Integer.parseInt(params[1]);
           String path = params[2];
           
           if(east == 0 && north == 0)
           {
               System.out.println("Case #" + currCase + ": 0");
               continue;
           }
           
           int best = -1;
           int time = 0;
           
           for(int i = 0; i < path.length(); i++)
           {
               //System.out.println("Current time: " + time);
               switch(path.charAt(i))
               {
                   case 'N':
                       north++;
                       break;
                   case 'S':
                       north--;
                       break;
                   case 'E':
                       east++;
                       break;
                   case 'W':
                       east--;
                       break;
               }
               
               int distance = Math.abs(east) + Math.abs(north);
               
               if(distance <= ++time)
               {
                   //System.out.println("updating at " + east + ", " + north + " with time " + time + " and distance " + distance);
                   distance += (time - distance);
                   
                   if(distance < best || best == -1)
                       best = distance;
               }
           }
           
           if(best == -1)
           {
               System.out.println("Case #" + currCase + ": IMPOSSIBLE");
           }else
           {
               System.out.println("Case #" + currCase + ": " + best);
           }
       }
    }
}
