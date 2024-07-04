import java.util.Scanner;
import java.util.*; 
public class Solution {
    private static Scanner sc;
    static int tn=1;
    public static void main(String args[]) {
        sc= new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        while(t-->0){
            solve();
        }
    }
    private static void solve(){
    	int n= sc.nextInt();
    	int[][] arr = new int[n][2];
    	StringBuilder sb = new StringBuilder();
    	Stack<int[]> Js = new Stack<>();
    	Stack<int[]> Cs = new Stack<>();
    	char person='J';
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<arr[i].length;j++) {
    			arr[i][j]=sc.nextInt();
    		}
    	}
    	Arrays.sort(arr,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			return a[0]-b[0];
    		}
    	});
//    	System.out.println(Arrays.deepToString(arr));
    	for(int i=0;i<arr.length;i++) {
    		if(i<arr.length-1 && doesOverlap(arr[i],arr[i+1])) {
    			if(person=='J') {
    				 Js.push(arr[i]);
//    				 person='C';
    				 sb.append(person);
    			}
    			else {
    				Cs.push(arr[i]);
    				sb.append(person);
    			}
    			person = getPerson(person);
    		}
    		else {
    			if(person =='j') {
    				Js.push(arr[i]);
    				sb.append(person);
    			}
    			else {
    				Cs.push(arr[i]);
    				sb.append(person);
    			}
    		}
    		 System.out.println("Case #"+(tn++)+": "+sb.toString());
    	}
    }
    public static boolean doesOverlap(int[] a, int[] b) {
    	return a[1]>b[0];
    }
    private static char getPerson(char p) {
    	return p=='J'?'C':'J';
    }
}