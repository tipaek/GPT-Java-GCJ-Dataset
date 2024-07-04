import java.io.*;
import java.util.*;

public class Solution 
{
    public static int[] reverse(int[] s, boolean[] known)
    {
        System.out.println("reversing");
        int[] result = new int[s.length];
        
        for(int i = 0; i < s.length; i++)
        {
            if(known[i] && known[s.length - (i + 1)])
                result[i] = s[s.length - (i + 1)];
        }
        
        return result;
    }
    
    public static int[] complement(int[] s, boolean[] known)
    {
        System.out.println("complementing");
        int[] result = new int[s.length];
        
        for(int i = 0; i < s.length; i++)
        {
            if(known[i])
               result[i] = s[i] ^ 1;
        }
        
        return result;
    }
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        int B = input.nextInt();
        
        for(int currCase = 1; currCase <= T; currCase++)
        {
           int[] solution = new int[B];
           boolean[] known = new boolean[B];
           int pairA = -1;
           int difA = -1;
           int head = 1;
           int tail = B;
           //True = head, false = tail
           boolean side = true;
           
           System.out.println(1);
           System.out.flush();
           input.nextInt();
           
           for(int i = 2; i <= 150; i++)
           {   
               String sol = "";
               
               for(int j = 0; j < B; j++)
               {
                   sol += solution[j];
               }
               
               System.err.println("Current believed: " + sol);
               
               if(i % 10 == 1)
               {                    
                    if(pairA == -1 || difA == -1)
                    {         
                        int prevKnown = solution[head - 2];
                        System.out.println(head - 1);
                        System.out.flush();
                        int test = input.nextInt();
                        
                        if(test != prevKnown)
                            solution = complement(solution, known);
                    }else
                    {
                        int pairKnown = solution[pairA];
                        int difKnown = solution[difA];
                        
                        System.out.println(difA + 1);
                        System.out.flush();
                        int testDif = input.nextInt();
                        i++;
                        System.out.println(pairA + 1);
                        System.out.flush();
                        int testPair = input.nextInt();
                        
                        if(testDif != difKnown && testPair != pairKnown)
                        {                                                    
                            solution = complement(solution, known);
                        }else if(testDif != difKnown && testPair == pairKnown)
                        {
                            solution = reverse(solution, known);
                        }else if(testDif == difKnown && testPair != pairKnown)
                        {
                            solution = complement(solution, known);
                            solution = reverse(solution, known);
                        }
                    }
               }else
               {      
                   if(head > tail)
                       break;
                   
                   if(side)
                   {
                       System.out.println(head);
                       System.out.flush();
                       int response = input.nextInt();
                       known[head - 1] = true;
                       solution[head - 1] = response;
                       side = !side;
                       
                       if(head == tail)
                           break;
                   }
                   else
                   {
                       System.out.println(tail); 
                       System.out.flush();
                       int response = input.nextInt();
                       known[tail - 1] = true;
                       solution[tail - 1] = response;
                       side = !side;
                       
                       if(solution[head-1] == response)
                       {
                           pairA = head - 1;
                       }else
                       {
                           difA = head - 1;
                       }
                       
                       head++;
                       tail--;
                   }
               }
           }
           
           String sol = "";
           
           for(int i = 0; i < B; i++)
           {
               sol += solution[i];
           }
           
           System.out.println(sol);
           System.out.flush();
           String response = input.next();
           if(!response.equals("Y"))
               return;
        }
    }
}
