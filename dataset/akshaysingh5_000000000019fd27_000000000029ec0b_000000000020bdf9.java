import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class Solution
{
    private static Scanner sc;
    static int jaat =1;
    public static void main(String args[])
    {
        sc = new Scanner(System.in);
        int pep= sc.nextInt();
        sc.nextLine();

        while(pep-- >0)
        {
            solve();
        }
    }
    public static void solve()
    {
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] nakli = mat.clone();
        char person = 'J';
        char[] chars= new char[n];
        Stack<int[]> Jandu = new Stack<>();
        Stack<int[]> Chomu = new Stack<>(); 
        Map<int[],Integer> map = new HashMap<>();

        boolean andychorre = false;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                mat[i][j]= sc.nextInt();
            }
            map.put(mat[i], i);
        }

        Arrays.sort(nakli,new Comparator<int[]>() {
        @Override
        public int Compare(int[] a,int[] b)
        {
            return a[0]- b[0];
        }
        });

        for(int i=0;i<nakli.length;i++)
        {
            chars[map.get(nakli[i])] = person;
            if(i<nakli.length-1 && HogaKOverlap(nakli[i],nakli[i+1]))
            {
                if(person == 'J')
                {
                    Jandu.push(nakli[i]);
                    person = getPerson(person);

                    if(!Chomu.isEmpty() && HogaKOverlap(Chomu.peek(), nakli[i+1]))
                    {
                        andychorre = true;
                        break;
                    }
                }
                else
                {
                    Chomu.push(nakli[i]);
                    person = getPerson(person);

                    if(!Jandu.isEmpty() && HogaKOverlap(Jandu.peek(), nakli[i+1]))
                    {
                        andychorre = true;
                        break;
                    }
                }
            }
            else
            {
                if(person == 'J')
                {
                    Jandu.push(nakli[i]);
                }    
                else
                {
                    Chomu.push(nakli[i]);
                }
            }
        }
        System.out.println("Case #"+(jaat++)+": "+ (andychorre ? "IMPOSSIBLE" : new String(chars)));

    }

    private static char getPerson(char p)
    {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean HogaKOverlap(int[] a, int[] b)
    {
        return a[1] > b[0];
    }
}
