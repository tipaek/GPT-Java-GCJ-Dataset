
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution 
{
    static class Dancer
    {
        public Dancer left;
        public Dancer right;
        public Dancer up;
        public Dancer down;
        int skill;
        double average;
        
        public Dancer(int s)
        {
            skill = s;
            left = null;
            right = null;
            up = null;
            down = null;
        }
        
        public boolean staying()
        {
            if(skill < average)
                return false;
            
            /*
            if(left == null && right == null && up == null && down == null)
                return true;
            
            if(((left != null && left.skill > skill) || left == null) && ((right != null && right.skill > skill) || right == null) && ((up != null && up.skill > skill) || up == null) && ((down != null && down.skill > skill) || down == null))
                return false;
           
            /*
            if(left != null && left.skill > skill)
                return false;
            if(right != null && right.skill > skill)
                return false;
            if(up != null && up.skill > skill)
                return false;
            if(down != null && down.skill > skill)
                return false;
            */
            return true;
        }
        
        public void elim()
        {            
            if(left != null)
            {
                left.right = right;
                left.getNeighborAverage();
            }
            if(right != null)
            {              
                right.left = left;
                right.getNeighborAverage();
            }
            if(up != null)
            {                
                up.down = down;
                up.getNeighborAverage();
            }
            if(down != null)
            {
                down.up = up;
                down.getNeighborAverage();
            }
        }
        
        public void getNeighborAverage()
        {
            int neighbors = 0;
            int skills = 0;
            
            if(up != null)
            {
                neighbors++;
                skills += up.skill;
            }
            
            if(down != null)
            {
                neighbors++;
                skills += down.skill;
            }
            
            if(left != null)
            {
                neighbors++;
                skills += left.skill;
            }
            
            if(right != null)
            {
                neighbors++;
                skills += right.skill;
            }
            
            if(neighbors == 0)
            {
                average = 0;
                return;
            }
            average = ((double)skills) / ((double)neighbors);
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(input.readLine());
       
       for(int currCase = 1; currCase <= T; currCase++)
       {
           String[] inits = input.readLine().split(" ");
           int R = Integer.parseInt(inits[0]);
           int C = Integer.parseInt(inits[1]);
           ArrayList<ArrayList<Dancer>> dancers = new ArrayList<>();
           ArrayList<Dancer> elim = new ArrayList<>();
           ArrayList<Dancer> keep = new ArrayList<>();
           long availableSkill = 0;
           long totalInterest = 0;
           
           for(int i = 0; i < R; i++)
           {
               dancers.add(new ArrayList<>());
               ArrayList<Dancer> row = dancers.get(i);
               String[] cols = input.readLine().split(" ");
               
               for(int j = 0; j < C; j++)
               {
                   int skill = Integer.parseInt(cols[j]);
                   availableSkill += skill;
                   row.add(new Dancer(skill));
                   Dancer d = row.get(j);
                   
                   if(i != 0)
                   {
                       d.up = dancers.get(i - 1).get(j);
                       dancers.get(i - 1).get(j).down = d;
                   }
                   
                   if(j != 0)
                   {
                       d.left = row.get(j-1);
                       row.get(j-1).right = d;
                   }
               }
           }
           
           for(int i = 0; i < R; i++)
           {
               for(int j = 0; j < C; j++)
               {
                   Dancer d = dancers.get(i).get(j);
                   d.getNeighborAverage();
                   if(d.staying())
                       keep.add(d);
                   else
                   {
                       elim.add(d);
                   }
               }
           }
           
           totalInterest += availableSkill;
           
           while(!elim.isEmpty())
           {                       
               for(Dancer d : elim)
               {
                   availableSkill -= d.skill;
                   d.elim();              
               }
               
               totalInterest += availableSkill;
               
               ArrayList<Dancer> toKeep = new ArrayList<>();
               elim = new ArrayList<>();
               
               for(Dancer d : keep)
               {
                   if(d.staying())
                       toKeep.add(d);
                   else
                       elim.add(d);                 
               }
               
               keep = toKeep;
           }
           
           System.out.println("Case #" + currCase + ": " + totalInterest);
       }
    }
}
