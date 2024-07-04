import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Solution {
	void solveCase(int caseNr) {
		String result = "";
		int[] x = Matrix.parseArray();
		
		for  (int i=-10; i< 11; i++) {
			for  (int j=-10; j< 11; j++) { 
				if (query(i+" "+j).equals("CENTER")){
					j=11;
					i=1;
				}
			}
		}
		
		
		System.out.println("Case #"+caseNr+": "+result);

	}
	
	
	


	void solve() {
		int nrCases = readInt();
		for (int i=0; i<nrCases;i++)
			solveCase(i+1);		
	}
	
	class ProblemState implements CPSState {
		public boolean isSolved() {
			// TODO Auto-generated method stub
			return false;
		}
		public List<CPSState> nextStates() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public int hashCode() {
			return super.hashCode();
		}
		public boolean equalsSub(ProblemState other) {
			return super.equals(other);
		}
		public boolean equals(Object o) {if (!(o instanceof ProblemState)) {return false;}ProblemState other = (ProblemState) o;return equalsSub(other);}
	}
	
	/* ******************************************************************************************************************* */
	/* UTILITY SECTION */
	/* ******************************************************************************************************************* */
	static boolean DEBUG_MODE = false;
	static Scanner input;

	static int readInt() {
		return Integer.parseInt(input.nextLine());
	}
	static int queryInt(int i) {
		return Integer.parseInt(query(""+(i+1)));
	}	
	static String query(String msg) {		
		System.out.println(msg);
		String result =  input.next();
		debugWrite("IN: "+msg +"\tOUT: "+result);
		return result;
	}	
	static void debug(String msg){if (DEBUG_MODE)System.out.println("DBG: "+msg);}
	static void debugWrite(String msg){if (DEBUG_MODE){try {OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Brigitte\\log.txt", true));bw.write(msg+"\n");bw.flush();bw.close();} catch (IOException e) {e.printStackTrace();}}}
	
	// runnable interface
	public static void main(String[] args) {
		if (DEBUG_MODE){try {OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Brigitte\\log.txt", false));bw.write("");bw.flush();bw.close();} catch (IOException e) {e.printStackTrace();}}
		input = new Scanner(System.in);
		(new Solution()).solve();
		input.close();
	}	
	
	/* ******************************************************************************************************************* */
	/* matrix functions */
	/* ******************************************************************************************************************* */
	static class Matrix{
		static String toString(int [][] matrix) {
			String result = "";
			for (int i=0; i<matrix.length; i++) {
				String line = "";
				for (int j=0; j<matrix[i].length; j++) 
					line = line + matrix[i][j] + " ";
				result = result + line +"\n";
			}
			return result;
		}
		static void print(int [][] matrix) {System.out.print(toString(matrix));}		
		static int[] parseArray() {return parseArray(" ");}
		static int[] parseArray(String separator) {
			String line = input.nextLine();
			if (!separator.equals("")) {
				String [] tokens = line.split(separator);
				int[] result = new int[tokens.length];	
				for (int i= 0; i<result.length; i++) 
					result[i] = Integer.parseInt(tokens[i]);
				return result;
				}
			int[] result = new int[line.length()];	
			for (int i= 0; i<result.length; i++) 
				result[i] = Integer.parseInt(""+line.charAt(i));
			return result;
		}
		static int[][] parse(){
			return parse(readInt());		
		}
		static int[][] parse(int lines){
			int[][] result = new int[lines][];
			for (int i= 0; i<lines; i++) {
				result[i] = parseArray(" ");
			}
			return result;		
		}
		static int[][] transpose(int[][] in){
			int[][]result = new int[in[0].length][in.length];
			for (int i= 0; i<in[0].length; i++) 
				for (int j= 0; j<in.length; j++)
					result[i][j]=in[j][i];
			return result;
		}
		static int[][] copy(int [][] in){
			int[][]result = new int[in.length][in[0].length];
			for (int i=0; i< result.length; i++)
				for (int j=0; j< result[i].length; j++)
					result[i][j] = in[i][j];
			return result;			
		}		
		static int[][] add(int [][] in1, int[][] in2){return add(in1,in2,false);}
		static int[][] add(int [][] in1, int[][] in2, boolean minus){
			int[][]result = new int[in1.length][];
			for (int i=0; i< result.length; i++) {
				result[i] = add(in1[i], in2[i], minus);
			}
			return result;
		}
		static int[] add(int [] in1, int[] in2){return add(in1,in2,false);}
		static int[] add(int [] in1, int[] in2, boolean minus){
			int[]result = new int[in1.length];
			for (int i=0; i< result.length; i++) {
				result[i] = in1[i] + (minus ? -1:1) * in2[i];
			}
			return result;
		}
		static int[][] signs(int [][] in){
			int[][]result = new int[in.length][in[0].length];
			for (int i=0; i< result.length; i++)
				for (int j=0; j< result[i].length; j++)
					result[i][j] = in[i][j] ==0 ? 0 : (in[i][j] <0?-1:1);
			return result;			
		}
		static int[][] multiply(int [][] in1, int [][] in2){
			int[][]result = new int[in1.length][in2[0].length];
			for (int i=0; i< result.length; i++)
				for (int j=0; j< result[i].length; j++) {
					result[i][j] = 0;
					for (int k=0; k< in1[i].length; k++)
						result[i][j] += in1[i][k] *in2[k][j];
				}
			return result;			
		}

	}
	
	/* ******************************************************************************************************************* */
	/* collection classes */
	/* ******************************************************************************************************************* */
	class IntSet extends HashSet<Integer>{IntSet(int [] array){super(); for (int i:array) {add(i);}}int[] toIntArray() {int[] result = new int[this.size()];int i=0;for (int k : this)result[i++] = k;return result;}}
	class IntList extends ArrayList<Integer>{IntList(int [] array){super(); for (int i:array) {add(i);}}int[] toIntArray() {int[] result = new int[this.size()];int i=0;for (int k : this)result[i++] = k;return result;}}
	class StringSet extends HashSet<String>{}
	class IntMultiMap extends MultiMap<Integer,Integer>{IntMultiMap(){super();}IntMultiMap(boolean asMultiSet){super(asMultiSet);}}
	class StringMultiMap extends MultiMap<String,String>{StringMultiMap(){super();}StringMultiMap(boolean asMultiSet){super(asMultiSet);}}
	class MultiMap<K,V> extends HashMap<K,List<V>>{
		private boolean      isSetBacked;
		private HashMap<K, HashSet<V>> multiSetAdmin;
		
		MultiMap (){
			this(false);
		}
		MultiMap (boolean asMultiSet){
			isSetBacked = asMultiSet;
			if(isSetBacked)
				multiSetAdmin = new HashMap<K, HashSet<V>>();			
		}
		int fullSize() {
			int result=0;
			for(List<V> values : this.values())
				result+=values.size();
			return result;
		}
		Collection<V> fullValues(){
			ArrayList<V> result = new ArrayList<V>();
			for (List<V> subValues: values())
				result.addAll(subValues);
			return result;
		}
		Collection<Entry<K,V>> fullEntrees(){
			ArrayList<Entry<K,V>> result = new ArrayList<Entry<K,V>>();
			for (Entry<K, List<V>> subEntree: entrySet()) {
				K key = subEntree.getKey();
				for (V value : subEntree.getValue()){
					result.add(new AbstractMap.SimpleEntry<K, V>(key, value));
				}
			}				
			return result;
		}		
		void add(K key, V value){putSingle(key,value);}
		void putSingle(K key, V value) {
			List<V> list = this.get(key);
			if (list == null) {
				list = new ArrayList<V>();
				this.put(key,  list);
				if (isSetBacked) {
					HashSet<V> set = new HashSet<V>();
					multiSetAdmin.put(key, set);
				}
			}
			if (isSetBacked) {
				Set<V> testSet = multiSetAdmin.get(key);
				if (!testSet.contains(value)) {
					list.add(value);
					testSet.add(value);
				}
			} else {
				list.add(value);
			}
		}
		public List<V> put(K key, List<V> values) {
			if (!isSetBacked) {
				return super.put(key, values);
			}
			HashSet<V> valuesAsSet = new HashSet<V>(values);
			ArrayList<V> uniqueValues = new ArrayList<V>(valuesAsSet);
			multiSetAdmin.put(key, valuesAsSet);
			return super.put(key, uniqueValues);
		}
		void merge(K key, List<V> values) {
			List<V> list = this.get(key);
			if (list == null) {
				put(key,values);
			} else  if (!isSetBacked) {
				list.addAll(values);
			} else {
				multiSetAdmin.get(key).addAll(values);
				this.put(key, new ArrayList<V>(multiSetAdmin.get(key)));
			}
		}
		void merge(MultiMap<K,V> other) {
			for (Entry<K, List<V>> subEntree: other.entrySet())
				merge(subEntree.getKey(), subEntree.getValue());
		}
		List<V> safeGet (K key){
			List<V> list = this.get(key);
			if (list == null) {
				return  new ArrayList<V>();
			}
			return list;
		}
		
	}
	
	/* ******************************************************************************************************************* */
	/* CP solver */
	/* ******************************************************************************************************************* */
	interface CPSState{
		boolean isSolved();
		List<CPSState> nextStates();
	}
	static class CPSSolver{
		static CPSState solve(CPSState startState) {
			if (startState.isSolved()){
				return startState;
			}			
			Stack<CPSState>  solveableStack = new Stack<CPSState>();			
			solveableStack.add(startState);			
			while (!solveableStack.isEmpty()) {
				CPSState checkState = solveableStack.pop();
				List<CPSState> nextStates =  checkState.nextStates();
				if (nextStates!= null)
					for (CPSState nextState : nextStates) {
						if (nextState.isSolved())
							return nextState;
						solveableStack.add(nextState);
					}
			}
			return null;			
		}
		static Set<CPSState> solveAll(CPSState startState) {
			Set<CPSState> results = new HashSet<CPSState>();
			if (startState.isSolved()){
				results.add( startState);
			}			
			Stack<CPSState>  solveableStack = new Stack<CPSState>();			
			solveableStack.add(startState);			
			while (!solveableStack.isEmpty()) {
				CPSState checkState = solveableStack.pop();
				List<CPSState> nextStates =  checkState.nextStates();
				if (nextStates!= null)				
					for (CPSState nextState : nextStates) {
						if (nextState.isSolved())
							results.add(nextState);
						solveableStack.add(nextState);
					}
			}
			return results;			
		}		
	}
}
