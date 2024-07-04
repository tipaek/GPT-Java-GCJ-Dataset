import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution 
{
    public static void main(String[] args) 
    {
       Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        
        for(int currCase = 1; currCase <= T; currCase++)
        {
            long X = input.nextLong();
            long Y = input.nextLong();
            ArrayList<Long> twoSums = new ArrayList<>();
            twoSums.add(1L);
            long pogoValue = 2;
            
            for(int i = 1; i < 30; i++)
            {
                twoSums.add(twoSums.get(i - 1) + pogoValue);
                pogoValue *= 2;
                //System.out.println(twoSums.get(i));
            }
                        
            //if(//!twoSums.contains(Math.abs(X) + Math.abs(Y)))
            if(Math.abs(X) % 2 == Math.abs(Y) % 2)
            {
                System.out.println("Case #" + currCase + ": IMPOSSIBLE");
                continue;
            }
            
            long lesser;
            long greater;
            char[] lesserChars = new char[2];
            char[] greaterChars = new char[2];
            
            if(Math.abs(X) > Math.abs(Y))
            {
                lesser = Y;
                greater = X;
                lesserChars = new char[] {'S', 'N'};
                greaterChars = new char[] {'W', 'E'};
                
            }else
            {
                lesser = X;
                greater = Y;
                greaterChars = new char[] {'S', 'N'};
                lesserChars = new char[] {'W', 'E'};
            }
            
            String solution = "";
            pogoValue = 1;
            
            if(Math.abs(lesser % 2) != 0)
            {
                if(lesser > 0)
                {      
                    solution += lesserChars[1];
                    lesser--;
                    pogoValue *= 2;
                }else if(lesser < 0)
                {
                    solution += lesserChars[0];
                    lesser++;
                    pogoValue *= 2;
                }
            }
            
            if(Math.abs(greater % 2) != 0)
            {
                if(greater > 0)
                {
                    if(greater == Math.abs(lesser) + 1)
                    {
                        solution += greaterChars[0];
                        greater++;
                        pogoValue *= 2;
                    }else
                    {
                        solution += greaterChars[1];
                        greater--;
                        pogoValue *= 2;
                    }
                }else if(greater < 0)
                {
                    if(Math.abs(greater) == Math.abs(lesser) + 1)
                    {
                        solution += greaterChars[1];
                        greater--;
                        pogoValue *= 2;
                    }else
                    {
                        solution += greaterChars[0];
                        greater++;
                        pogoValue *= 2;
                    }
                }
            }
            
            boolean good = true;
            
            while(lesser != 0)
            {
                if(pogoValue > Math.abs(lesser))
                {
                    System.out.println("Case #" + currCase + ": IMPOSSIBLE");
                    //System.out.println("pogo " + pogoValue + " exceeded lesser " + lesser);
                    good = false;
                    break;
                }
                
                if(lesser > 0)
                {
                    solution += lesserChars[1];
                    lesser -= pogoValue;
                    pogoValue *= 2;
                }else if(lesser < 0)
                {
                    solution += lesserChars[0];
                    lesser += pogoValue;
                    pogoValue *= 2;
                }
            }
            
            if(!good)
                continue;
            
            while(greater != 0)
            {
                if(pogoValue > Math.abs(greater))
                {
                    System.out.println("Case #" + currCase + ": IMPOSSIBLE");
                   // System.out.println("pogo " + pogoValue + " exceeded greater " + greater);
                    good = false;
                    break;
                }
                
                if(greater > 0)
                {
                    solution += greaterChars[1];
                    greater -= pogoValue;
                    pogoValue *= 2;
                }else if(greater < 0)
                {
                    solution += greaterChars[0];
                    greater += pogoValue;
                    pogoValue *= 2;
                }
            }
            
            if(!good)
                continue;
            
            System.out.println("Case #" + currCase + ": " + solution);
        }
    }
}
