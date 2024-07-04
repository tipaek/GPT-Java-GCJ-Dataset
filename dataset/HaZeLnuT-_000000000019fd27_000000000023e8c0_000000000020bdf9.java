import java.util.*;

public class Solution{
    private static Scanner sc;
	static int tn = 1;

	public static void main(String[] args){
	    sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();

		while(t-- > 0){
			solve();
		}
	}
	private static void solve(){
	    int n = sc.nextInt();
	    int[][] row = new int[n][2];
	    int[][] rowSorted = row.clone();
	    char person = 'J';
	    char[] chars = new char[n];
	    Stack<int[]> JStack = new Stack<>();
	    Stack<int[]> CStack = new Stack<>();
	    boolean impossible = false;
	    Map<int[], Integer> map = new HashMap<>();
	    
	    for(int i=0;i<row.length;i++){
	    	for(int j=0;j<row[i].length;j++){
	    		row[i][j] = sc.nextInt();
			}
			map.put(row[i],i);
		}
		Arrays.sort(rowSorted, new Comparator<int[]>(){
			@Override
			public int compare(int[] a,int[] b){
				return a[0] - b[0];
			}
		});
		
		for(int i=0;i<rowSorted.length;i++){
			chars[map.get(rowSorted[i])] = person;
			if(i<rowSorted.length-1 && isOverlap(rowSorted[i],rowSorted[i+1])){
				if(person =='J'){
					JStack.push(rowSorted[i]);
					person = getPerson(person);
					if(!CStack.isEmpty() && isOverlap(CStack.peek(), rowSorted[i+1])){
						impossible = true;
						break;
					}
				}
				else{
					CStack.push(rowSorted[i]);
					person = getPerson(person);
					
					if(!JStack.isEmpty() && isOverlap(JStack.peek(), rowSorted[i+1])){
						impossible = true;
						break;
					}
						
				}
			}else{
				if(person =='J'){
					JStack.push(rowSorted[i]);
				}else{
					CStack.push(rowSorted[i]);
				}
			}
		}
		System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
		
	}
	private static char getPerson(char p){
		return p == 'J' ? 'C' : 'J';
	}
	private static boolean isOverlap(int[] a,int[] b){
		return a[1] > b[0];
	}
	
}
	    

