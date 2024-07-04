import java.util.Scanner;
import java.util.ArrayList;

public class Solution
{
    public static int getTriSize(int sum)
    {
        int triSum = 1;
        int toAdd = 2;
        int triSize = 0;
        
        for (int i = 0; i < 501; i++)
        {
            triSize++;
            triSum += toAdd;
            toAdd += 2;
            if (triSum >= sum)
            {
                return triSize + 1;
            }
        }
       
        return triSize;
    }
    
    public static boolean travel(int currentSum, int sum, ArrayList<Integer>[] tri, int x, int y, ArrayList<Integer> track, ArrayList<String> msgArr)
    {
        if (x >= 0 && x < tri.length && y >= 0 && y < tri[x].size())
        {
            int idLoc = -1;
            currentSum += tri[x].get(y);
            for (int i = 0; i < track.size(); i+=2)
            {
                if (track.get(i) == x && track.get(i+1) == y)
                {
                    return false;
                }
            }
            idLoc = track.size();
            track.add(x);
            track.add(y);
            if (currentSum == sum)
            {
                msgArr.add((x+1) + " " + (y+1) + " ");
                return true;
            }
            if (travel(currentSum, sum, tri, x-1, y-1, track, msgArr) || travel(currentSum, sum, tri, x, y-1, track, msgArr)
            || travel(currentSum, sum, tri, x-1, y, track, msgArr)|| travel(currentSum, sum, tri, x, y+1, track, msgArr) || travel(currentSum, sum, tri, x+1, y, track, msgArr)
                   || travel(currentSum, sum, tri, x+1, y+1, track, msgArr))
            {
                msgArr.add((x+1) + " " + (y+1) + " ");
                return true;
            }
            track.remove(idLoc);
            track.remove(idLoc);
        }
        return false;
    }
    public static int solve(int sum, int triSize)
    {
        // VARIABLES
        ArrayList<Integer>[] tri = new ArrayList[triSize]; 
  
        // SOLVE THE TRIANGLE
        for (int i = 0; i < tri.length; i++) { 
            tri[i] = new ArrayList<Integer>(); 
        } 
        
        tri[0].add(1);
        for (int i = 1; i < tri.length; i++)
        {
            tri[i].add(1);
            for (int j = 1; j < (tri[i-1].size()+1)-1; j++)
            {
                //tri[i].add(1, 0);
                tri[i].add(1, tri[i-1].get(j)+tri[i-1].get(j-1));
                //System.out.println(">>>"+tri[i-1].get(j));
            }
            tri[i].add(1);
            /*for (int j = 0; j < tri[i].size(); j++)
            {
                System.out.print(tri[i].get(j) + ",");
            }
            System.out.println();*/
        }
        ArrayList<String> msgArr = new ArrayList<String>();
        travel(0, sum, tri, 0, 0, new ArrayList<Integer>(), msgArr);
        for (int i = msgArr.size()-1; i >= 0; i--)
        {
            System.out.println(msgArr.get(i));
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int sum = input.nextInt();
            int triSize = getTriSize(sum);
            System.out.println("Case #"+ks+": ");
            int result = solve(sum, triSize);
        }
    }
}