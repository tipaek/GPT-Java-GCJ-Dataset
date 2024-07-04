import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution {
    
    
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine()); 
        
        try {
            for (int i = 1; i <= T; i++) {
                int N = in.nextInt();
                int D = in.nextInt();
                float[] crepes = new float[N];
                
                for(int j = 0; j < N;j++)
                {
                    crepes[j] = in.nextFloat();
                }
                calculSlices(i, crepes, D);
            }
       } catch (Exception ex) {
            System.out.println("ex: " + ex);
        }
    }
    
    public static void calculSlices(int iteration, float[] crepes, int clients)
    {
        Arrays.sort(crepes);

        Map<Float, Float> map = new HashMap<Float, Float>();
        int maxCount = 1;
        int positionMax = 0;
        float valeurMax = crepes[0];
        int nbrSlices;
        
	for(int i =0;i <crepes.length;i++)
        {
            if (map.containsKey(crepes[i])) {
                int value = map.get(crepes[i]).intValue() + 1;
                if(value > maxCount)
                {
                    maxCount = value;
                    positionMax = i;
                    valeurMax = crepes[i];
                }
                map.put(crepes[i], (float)value);
            } else {
                map.put(crepes[i], (float)1);
               
            }
        }
        
        if(maxCount >= clients)
        {
            System.out.println("Case #" + iteration + ": 0");
        }
        
        else
        {
            int nbrRestant = clients - maxCount;
            int nbrSlicesTemp = 0;
            boolean tourPossible = true; 
            boolean essaiOptimal = true;
            boolean neverIter = true;
            int iter = 0;
            
            while(tourPossible)
            {
                if(essaiOptimal == false)
                {
                    maxCount = map.get(crepes[iter]).intValue();
                    positionMax = iter;
                    valeurMax = crepes[iter];
                }
                nbrSlices = 0;
                
                if(crepes.length == 1)
                {
                    System.out.println("Case #" + iteration + ": "+ (clients-1));
                   
                    return;
                }
                
                for(int i = positionMax+1; i < crepes.length;i++)
                {
                    nbrSlicesTemp = (int)(crepes[i]/valeurMax);
                    maxCount+=nbrSlicesTemp;
                   
                    if(crepes[i]%valeurMax == 0)
                    {
                        nbrSlicesTemp--;
                    }
                    
                    if(maxCount < clients)
                    {
                        nbrSlices += nbrSlicesTemp;
                    }

                    else if(maxCount == clients)
                    {
                        nbrSlices += nbrSlicesTemp;
                        System.out.println("Case #" + iteration + ": "+nbrSlices);
                        return;
                    }
                    
                    else if(maxCount > clients)
                    {
                        nbrSlices = nbrRestant;
                        System.out.println("Case #" + iteration + ": "+nbrSlices);
                        return;
                    }
                    
                }
                
                if(neverIter == false)
                {
                    if(iter < crepes.length-1)
                    {
                        iter++;
                    }
                    else
                    {
                        return;
                    }
                }
                
                essaiOptimal = false;
                neverIter = false;
            }
            
            
        }
        
        
    }
}
