import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new BufferedReader(new FileReader("resources/test.in")));
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int nbTestCases = sc.nextInt();
		for(int t = 1 ; t <= nbTestCases ; ++t) {
			System.out.println(
				"Case #" + t + ": " + testCase(sc)
			);
		}
		sc.close();
	}
	
	public static String testCase(Scanner sc) throws Exception {
		//Read data
		final int matrixSize = sc.nextInt();
		final int expectedTrace = sc.nextInt();
		
		//Identify basic elements
		final int rcValue = (matrixSize+1) * matrixSize / 2; //Value for each row/column
		
		final int mean = expectedTrace / matrixSize;
		final int remd = expectedTrace % matrixSize;
		
		LatinSquare ls = null;
		if(matrixSize%2 == 0 && expectedTrace%2 != 0) {
			ls = null;
		} else if(rcValue == expectedTrace) {
			ls = new MagicLatinSquare(matrixSize, 1);
		} else if(remd == 0) {
			ls = new SymetricLatinSquare(matrixSize, mean);
		} else {
			try {
				ls = new CyclicLatinSquare(
					matrixSize, generateTrace(expectedTrace, matrixSize, mean, remd)
				);
			} catch(IllegalStateException exc) {
				ls = null;
				exc.printStackTrace();
			};
		}
		StringBuilder output = new StringBuilder();
		if(ls == null) {
			output.append("IMPOSSIBLE\n");
		} else {
			output.append("POSSIBLE\n" + ls);
		}
		return output.toString();
	}
	
	private static List<Integer> generateTrace(int expectedTrace, int matrixSize, int mean, int remd) {
		LinkedList<Integer> choices = new LinkedList<Integer>();
		for(int i = 0 ; i < matrixSize ; ++i) {
			int tracePart = mean;
			while(remd > 0 && tracePart <= matrixSize) {
				++tracePart;
				--remd;
			}
			if(i % 2 == 0) {
				choices.addFirst(tracePart);
			} else {
				choices.addLast(tracePart);
			}
		}
		return choices;
	}
	
	private static class SymetricLatinSquare extends AdvancedLatinSquare {
		public SymetricLatinSquare(int size, int diag) {
			super(size, generateTrace(size*diag, size, diag, 0), false);
		}
		protected int diag(int d) {
			return first;
		}
	}
	
	private static class CyclicLatinSquare extends AdvancedLatinSquare {
		public CyclicLatinSquare(int size, List<Integer> trace) {
			super(size, trace, true);
		}
		protected int diag(int d) {
			return trace.get(d);
		}
	}
	
	private abstract static class AdvancedLatinSquare extends LatinSquare {
		protected final List<Integer> trace;
		protected final int first;
		public AdvancedLatinSquare(int size, List<Integer> trace, boolean transposedLeftColumn) {
			super(size);
			this.trace = trace;
			this.first = trace.get(0);
			List<Integer> numbers = new ArrayList<Integer>(dequeNumbers(first));
			//Fill upper right corner
			for(int r = 0 ; r < size ; ++r) {
				Deque<Integer> rowCandidates = dequeNumbers(first);
				List<Integer> row = new ArrayList<Integer>(size);
				for(int c = 0 ; c < size ; ++c) {
					List<Integer> colUsed = colNumbers(c);
					final Integer cn;
					if(r == c) {
						//Diagonal
						cn = diag(r);
					} else if(r == 0) {
						//First row
						cn = numbers.get(c);
					} else if(transposedLeftColumn && c == 0) {
						//First column
						cn = numbers.get(r);
					} else if(c > r) {
						//Upper right corner
						final int d = c;
						cn = rowCandidates.stream()
											.filter(i -> !colUsed.contains(i)
													&& i != diag(d))
											.findFirst()
											.orElse(0);
					} else {
						//Lower left corner
						cn = 0; //Temp value
					}
					rowCandidates.remove(cn);
					row.add(cn);
				}
				square.add(row);
			}
			//Try to fill holes & checks
			for(int r = 0 ; r < size ; ++r) {
				Deque<Integer> rowCandidates = dequeNumbers(first);
				rowCandidates.removeAll(rowNumbers(r));
				List<Integer> row = square.get(r);
				for(int c = 0 ; c < size ; ++c) {
					List<Integer> colUsed = colNumbers(c);
					Integer cn = row.get(c);
					if(cn == 0) {
						//Still to be solved
						if(c < r) {
							//Others would be errors
							cn = rowCandidates.stream()
											.filter(i -> !colUsed.contains(i))
											.findFirst()
											.orElse(0);
						}
						if(cn == 0) {
							throw new IllegalStateException(
								"Unbale to find solution for r,c = " + (r+1) + "," + (c+1)
								+ " for:\n" + toString()
							);
						}
						rowCandidates.remove(cn);
						row.set(c, cn);
					}
				}
			}
		}
		protected abstract int diag(int d);
		private List<Integer> rowNumbers(int r) {
			return Collections.unmodifiableList(
				square.get(r).stream()
					.filter(i -> i != 0)
					.collect(Collectors.toList())
			);
		}
		private List<Integer> colNumbers(int c) {
			return Collections.unmodifiableList(
				square.stream()
					.map(row -> row.get(c))
					.filter(i -> i != 0)
					.collect(Collectors.toList())
			);
		}
	}
	
	private static class MagicLatinSquare extends LatinSquare {
		public MagicLatinSquare(int size, int start) {
			super(size);
			Deque<Integer> rolling = dequeNumbers(start);
			for(int i = 0 ; i < size ; ++i) {
				square.add(new ArrayList<Integer>(rolling));
				rolling.addLast(rolling.pollFirst());
			}
		}
	}
	
	private abstract static class LatinSquare {
		protected final int size;
		protected final List<List<Integer>> square;
		protected final List<Integer> numbers;
		protected LatinSquare(int size) {
			square = new ArrayList<>(this.size = size);
			numbers = Collections.unmodifiableList(
						Stream.iterate(1, n -> n + 1)
							.limit(size)
							.collect(Collectors.toList())
			);
		}
		protected Deque<Integer> dequeNumbers(int first) {
			Deque<Integer> rolling = new ArrayDeque<>(numbers);
			while(first != 0 && rolling.peekFirst() != first) {
				rolling.addLast(rolling.pollFirst());
			}
			return rolling;
		}
		public String toString() {
			StringBuilder b = new StringBuilder();
			for(List<Integer> row : square) {
				String asText = row.stream()
									.map(Object::toString)
									.collect(Collectors.joining(" "))
									.toString();
				b.append(asText);
				b.append('\n');
			}
			return b.toString();
		}
	}
	
}
