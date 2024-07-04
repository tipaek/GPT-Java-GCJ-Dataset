import java.util.*; 
import java.lang.*; 
import java.io.*; 
  

public class Main
{
    static int tn;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String args[])
    {int t = scan.nextInt();
        while(t-- > 0)
        {
            solution();
        }
    }

    private static void solution()
    {
        int n = scan.nextInt();
        int[][] sorted= new int[n][2];
        int[][] matSorted = sorted.clone();
        char person = 'J';
        char[] characters = new char[n];
        Stack<int[]> stackOfJ = new Stack<>();
        Stack<int[]> stackOfC = new Stack<>();
        boolean impossible = false;

        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0;i < sorted.length;i++)
        {
            for(int j = 0;j < sorted[i].length;j++)
            {
                sorted[i][j] = scan.nextInt();
            }
            map.put(sorted[i], i);
        }
        Arrays.sort(matSorted, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });

        for(int i = 0;i < matSorted.length; i++)
        {
            characters[map.get(matSorted[i])] = person;
        
        if(i < matSorted.length - 1 && doesOverlap(matSorted[i], matSorted[i+1]))
        {
            if(person == 'J')
            {
                stackOfJ.push(matSorted[i]);
                person = getPerson(person);

                if(!stackOfC.isEmpty() && doesOverlap(stackOfC.peek(), matSorted[i+1]))
                {
                    impossible = true;
                    break;
                }
            }
            else
            {
                stackOfC.push(matSorted[i]);
                person = getPerson(person);

                if(!stackOfJ.isEmpty() && doesOverlap(stackOfJ.peek(), matSorted[i+1]))
                {
                    impossible = true;
                    break;
                }
            }
        }
        else{
            if(person == 'J')
            {
                stackOfJ.push(matSorted[i]);
            }
            else{
                stackOfC.push(matSorted[i]);
            }
        }
    }
    System.out.println("Char #" + tn++ + ": " +(impossible ? "IMPOSSIBLE"  : new String(characters)));
    }

    private static char getPerson(char p)
    {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b)
    {
        return a[1] > b[0];
    }

}
    


