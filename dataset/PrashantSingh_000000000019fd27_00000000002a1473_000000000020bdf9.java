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
    	int[][] arrSorted = arr.clone();
    	char[] chars = new char[n];
//     	StringBuilder sb = new StringBuilder();
    	Stack<int[]> Js = new Stack<>();
    	Stack<int[]> Cs = new Stack<>();
    	boolean impossible =false;
    	Map<int[], Integer> map = new HashMap<>();
    	char person='J';
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<arr[i].length;j++) {
    			arr[i][j]=sc.nextInt();
    		}
    		map.put(arr[i],i);
    	}
    	Arrays.sort(arrSorted,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
    			return a[0]-b[0];
    		}
    	});
//    	System.out.println(Arrays.deepToString(arr));
    	for(int i=0;i<arrSorted.length;i++) {
    		chars[map.get(arrSorted[i])]=person;
    		if(i<arrSorted.length-1 && doesOverlap(arrSorted[i],arrSorted[i+1])) {
    			if(person == 'J') {
    				Js.push(arrSorted[i]);
    				person=getPerson(person);
    				if(!Cs.isEmpty() && doesOverlap(Cs.peek(),arrSorted[i+1])) {
    					impossible = true;
    					break;
    				}
    			}
    			else {
    				Cs.push(arrSorted[i]);
    				person=getPerson(person);
    				if(!Js.isEmpty() && doesOverlap(Js.peek(),arrSorted[i+1])) {
    					impossible = true;
    					break;
    				}
//    			sb.append(person);
//    			person=getPerson(person);
    			}
    		}
    		else {
//    			if(!Cs.isEmpty() && doesOverlap(arrSorted[i+1],Cs.peek()) || !Js.isEmpty() && doesOverlap(arrSorted[i+1],Js.peek())) {
//					impossible = true;
//					break;
//				} 
    			if(person=='J') {
    				Js.push(arrSorted[i]);
    			}
    			else {
    				Cs.push(arrSorted[i]);
    			}
    		}
    	}
//    		else {
////    			sb.append(person);
////    			person=getPerson(person);
//    		}
//    		chars[map.get(arrSorted[i])]=person;
    	
    	System.out.println("Case #"+(tn++)+": "+(impossible?"IMPOSSIBLE" : new String(chars) ));
    }
    public static boolean doesOverlap(int[] a, int[] b) {
    	return a[1]>b[0];
    }
    private static char getPerson(char p) {
    	return p=='J'?'C':'J';
    }
}
//class pair{
//	int first;
//	int second;
//	public pair(int first, int second) {
//		this.first=first;
//		this.second=second;
//	}
//}