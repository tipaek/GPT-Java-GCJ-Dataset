
import java.util.*;

class Solution {
	
	public static int findDuplicate(ArrayList<Integer> row)
	{
            int dr = 0;
            Set<Integer> s = new HashSet<>();
            for(int n : row)
            {
                if(s.add(n) == false)
                {
                    dr++;
                    break;
                }
            }
            return dr;
	}
	
	public static int matTrace(int mat[][])
	{
		int tr=0;
		int len = mat.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++) {
                if (i == j) {
                    tr += mat[i][j];
                }
            }
		}
		return tr;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTimes = sc.nextInt();
		
		int a1=0,b1=0,c1=0;
		int dur[] = new int[noOfTimes];
		int duc[] = new int[noOfTimes];
		int trace[] = new int[noOfTimes];
		
		for(int p=0; p<noOfTimes; p++){
                    int n = sc.nextInt();
                    int a[][] = new int[n][n];
		
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            a[i][j] = sc.nextInt();
                        }
                     }
// find no.of Duplicate Rows
                    ArrayList<Integer> rows = new ArrayList<>();
                    int Dr = 0;
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            rows.add(a[i][j]);
                        }
                        Dr += findDuplicate(rows);
                        rows.clear();
                    }
                    dur[a1] = Dr;
                    a1+=1;
// find no.of Duplicate Columns
		ArrayList<Integer> cols = new ArrayList<>();
                int Dc = 0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        cols.add(a[j][i]);
                    }
                    Dc += findDuplicate(cols);
                    cols.clear();
                }
		duc[b1] = Dc;
		b1+=1;
// find trace of matrix
		trace[c1] = matTrace(a);
		c1+=1;
	}
// print output
	for(int t=0; t<noOfTimes; t++)
	{
            System.out.println("Case #"+(t+1)+": "+trace[t]+" "+dur[t]+" "+duc[t]);
	}
    }
}
