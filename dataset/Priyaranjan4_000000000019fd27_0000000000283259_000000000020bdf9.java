import java.util.*;

class Parent
{
static int tn =0;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++)
        {
            Solve();
        }
    }

    public static void Solve()
    {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt(); //no of test case
        //int tn=0;
        int mat[][] = new int[n][2];
        int[][] sotedMat = mat.clone();
        char person = 'J';
        char[] chars = new char[n];
        boolean impossible = false;
        Map<int[], Integer> map = new HashMap<>();
        Stack<int[]> Jstack = new Stack();
        Stack<int[]> Cstack = new Stack();
        

        // read the time in array
        for(int i=0; i<mat.length; i++)
        {
            for(int j=0; j<mat[i].length; j++)
            {
                mat[i][j] = sc1.nextInt();
            }
            map.put(mat[i], i);
        }
        //System.out.println(Arrays.deepToString(sotedMat));

        Arrays.sort(mat, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for(int i=0; i < sotedMat.length; i++)
        {
            chars[map.get(sotedMat[i])] = person;
            
            if(i < sotedMat.length-1 && doesOverlap(sotedMat[i], sotedMat[i+1]))
            {
                if(person == 'J')
                {
                    Jstack.push(sotedMat[i]);
                    person = getPersion(person);

                    if(!Cstack.isEmpty() && doesOverlap(Cstack.peek(),sotedMat[i+1]))
                    {
                        impossible = true;
                        break;
                    }
                }
                else
                {
                    Cstack.push(sotedMat[i]);
                    person = getPersion(person);
                    
                    if(!Jstack.isEmpty() && doesOverlap(Jstack.peek(),sotedMat[i+1]))
                    {
                        impossible = true;
                        break;
                    }
                }
            }
            else{
                if(person == 'J')
                    {
                        Jstack.push(sotedMat[i]);
                    }
                    else
                    {
                        Cstack.push(sotedMat[i]);
                    }
            }
        }
        System.out.println("Case # "+(tn++)+": "+(impossible ? "IMPOSSIBLE " : new String(chars)));
    }

    public static boolean doesOverlap(int[] a, int[] b)
    {
        return a[1] > b[0];
    }

    public static char getPersion(char p)
    {
        return p == 'J' ? 'C':'J';
    }
}