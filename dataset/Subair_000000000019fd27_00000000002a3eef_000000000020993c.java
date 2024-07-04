 import java.util.*;
public class Solution{
    public static void main(String args[]){
    Scanner scan =new Scanner(System.in);
    int t=scan.nextInt();
        for(int testNo=1;testNo<=t;testNo++){
            int size=scan.nextInt();
            int metrix[][]=new int[size][size];
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    metrix[i][j]=scan.nextInt();
                }
            }
			check(metrix,testNo,size);
		}
	}
			
	public static void check(int[][] metrix, int t, int n){
		int trace=0;
		int rowDuplCount=0;
		int colDuplCount=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j){
					trace=trace+metrix[i][j];
					
				}
			}
		}
		
		HashMap<Integer,Integer> h=new HashMap<>();
		for(int i=0;i<n;i++)
        {
            int row[]=metrix[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    rowDuplCount++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
		
		
		 for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ele=metrix[j][i];
                if(h.containsKey(ele))
                {
                    colDuplCount++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
		
	System.out.println("Case #" +t+ ":"+" " +trace+ " " +rowDuplCount+ " " +colDuplCount);	
	}
}
		
		
		