import java.io.*;
import java.util.*;
import java.util.Map.*;


public class Solution {
	void solveCase(int caseNr) {
		long  []z = Matrix.parseArray();
		long slices = z[0];
		long diners = z[1];
		
		long  []cuts = Matrix.parseArray();
		long[][] cuts2 = new long[cuts.length][1]; 
		Map<Long, Long> m = new HashMap<Long,Long>();
		int j=0;
		for (long c: cuts) {
			cuts2[j++][0]=c;
			if (m.containsKey(c)) {
				m.put(c,m.get(c)+1);
			} else {
				m.put(c,1L);
			}
			
		}
		
		long[][] arr = new long[m.size()][2];
		
		j =0;
		for (Entry<Long, Long> e : m.entrySet()) {
			arr[j][0] = e.getKey();
			arr[j][1] = e.getValue();
			j++;
		}
		// sort highest freq, lowest number
		Arrays.sort(arr, (long[] x,long []y) -> x[1] > y[1] ? -1 : (x[1]<y[1] ? 1 : (x[0] > y[0] ? 1 : (x[0]<y[0] ? -1 : 0))));
		
		for (int i =0; i<arr.length; i++) {
			long neededCuts = diners-arr[i][1];
			long cutsize = arr[i][0];
			long possibleCuts = 0;
			long freeCuts = 0;
			// sort modulo first, lowest value
			Arrays.sort(cuts2, (long[] x, long[] y) -> 
							(x[0]%cutsize == 0 && y[0]%cutsize == 1) ? -1 :
								((x[0]%cutsize == 1 && y[0]%cutsize == 0) ? 1:
									((x[0] > y[0]) ?  1 : ((x[0] < y[0]) ? -1 : 0))));
			
			for(long[] cut2 : cuts2) {
				long cut = cut2[0];
				if (cut > cutsize) {
					long oldPossibleCutsDone = possibleCuts;
					long prevSliceCount      = possibleCuts+freeCuts;
					long currentCuts = ((cut-1) / cutsize);
					possibleCuts = possibleCuts + currentCuts;
					
					if ((cut % cutsize) == 0) {
						freeCuts ++;
					}
					if (possibleCuts+freeCuts >= neededCuts) {
						if (prevSliceCount + currentCuts >= neededCuts) {
							System.out.println("Case #"+caseNr+": "+(oldPossibleCutsDone + (neededCuts-prevSliceCount)));							
						} else {						
							System.out.println("Case #"+caseNr+": "+(possibleCuts));
						}
						return;
					}
				}
			}
		}
		System.out.println("Case #"+caseNr+": "+ (diners-arr[0][1]));
	}
	
	
	


	void solve() {
		long  []x = Matrix.parseArray();
		long nrCases = x[0];
		for (int i=0; i<nrCases;i++)
			solveCase(i+1);		
	}
	
	class ProblemState implements CPState {
		public boolean isSolved() {
			// TODO Always Implement
			return false;
		}
		public List<CPState> nextStates() {
			// TODO Always Implement
			return null;
		}
		
		
		public boolean equalsOveridden() {
			// TODO implement whenever duplicates have to be reduced in Breath First search
			return false;
		}
		public int hashCode() {
			// TODO implement whenever duplicates have to be reduced in Breath First search
			return super.hashCode();
		}
		public boolean equalsSub(ProblemState other) {
			// TODO implement whenever duplicates have to be reduced in Breath First search
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
		static String toString(long [][] matrix) {
			String result = "";
			for (int i=0; i<matrix.length; i++) {
				String line = "";
				for (int j=0; j<matrix[i].length; j++) 
					line = line + matrix[i][j] + " ";
				result = result + line +"\n";
			}
			return result;
		}
		static void print(long [][] matrix) {System.out.print(toString(matrix));}		
		static long[] parseArray() {return parseArray(" ");}
		static long[] parseArray(String separator) {
			String line = input.nextLine();
			if (!separator.equals("")) {
				String [] tokens = line.split(separator);
				long[] result = new long[tokens.length];	
				for (int i= 0; i<result.length; i++) 
					result[i] = Long.parseLong(tokens[i]);
				return result;
				}
			long[] result = new long[line.length()];	
			for (int i= 0; i<result.length; i++) 
				result[i] =Long.parseLong(""+line.charAt(i));
			return result;
		}
		static long[][] parse(){
			return parse(readInt());		
		}
		static long[][] parse(int lines){
			long[][] result = new long[lines][];
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
	interface CPState{
		boolean isSolved();
		List<CPState> nextStates();
		public boolean equalsOveridden();
	}
	static class CPSolver{
		static CPState solveDF(CPState startState) {
			if (startState.isSolved()){
				return startState;
			}			
			Stack<CPState>  solveableStack = new Stack<CPState>();			
			solveableStack.add(startState);			
			while (!solveableStack.isEmpty()) {
				CPState checkState = solveableStack.pop();
				List<CPState> nextStates =  checkState.nextStates();
				if (nextStates!= null)
					for (CPState nextState : nextStates) {
						if (nextState.isSolved())
							return nextState;
						solveableStack.add(nextState);
					}
			}
			return null;			
		}
		static CPState solveBF(CPState startState) {
			Set<CPState> solutions = solveBF(startState, true, startState.equalsOveridden(), false);
			if (solutions.isEmpty())
				return null;
			return solutions.iterator().next();			
		}		
		static Set<CPState> solveAll(CPState startState) {
			return solveBF(startState, false, startState.equalsOveridden(), false);			
		}
		
		static Set<CPState> solveBF(CPState startState, boolean stopOnFirst, boolean pruneDuplicates, boolean keepHistoricDuplicateMemory) {
			Set<CPState> results = new HashSet<CPState>();
			if (startState.isSolved()){
				results.add(startState);
				if (stopOnFirst)
					return results;
			}			
			
			Queue<CPState> todoQueue = new LinkedList<CPState>();			
			Set<CPState>   todoSet = new HashSet<CPState>();			
			todoQueue.add(startState);	
			if (pruneDuplicates)
				todoSet.add(startState);
			
			while (!todoQueue.isEmpty()) {
				CPState checkState = todoQueue.poll();
				if (pruneDuplicates && !keepHistoricDuplicateMemory)
					todoSet.remove(checkState);
				List<CPState> nextStates =  checkState.nextStates();
				if (nextStates!= null)				
					for (CPState nextState : nextStates) {
						if (nextState.isSolved()) {
							results.add(nextState);
							if (stopOnFirst)
								return results;
						}
						if (pruneDuplicates) {
							if (!todoSet.contains(nextState)) {
								todoQueue.add(nextState);
								todoSet.add(nextState);
							}
						} else {
							todoQueue.add(nextState);
						}						
					}
			}
			return results;			
		}		
	}
}
