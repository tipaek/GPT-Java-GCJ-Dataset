import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	private int size;
	private LinkedList<LinkedList<Integer>> mat=new LinkedList<LinkedList<Integer>>();
	public Solution(int size, String matStr) {
		this.size=size;
		String[] lines=matStr.split("\n");
		for(String line: lines) {
			//System.out.println(line);
			LinkedList<Integer> listCells=new LinkedList<Integer>();
			String[] cells=line.split(" ");
			for(String cell : cells) {
				listCells.add(Integer.parseInt(cell));
			}
			mat.add(listCells);
		}
	}
	
	public int trace() {
		int total=0;
		for(int i=0; i<size; i++) {
			total+=mat.get(i).get(i);
		}
		return total;
	}
	
	public int numRows() {
		int total=0;
		for(LinkedList<Integer> row : mat) {
			LinkedList<Integer> rowTmp=new LinkedList<Integer>();
			for(Integer cell : row) {
				if(rowTmp.contains(cell)) {
					total++;
					break;
				}
				rowTmp.add(cell);
			}
		}
		return total;
	}
	
	public int numCols() {
		int total=0;
		for(int i=0; i<mat.size(); i++) {
			LinkedList<Integer> colTmp=new LinkedList<Integer>();
			for(int j=0; j<mat.size(); j++) {
				int cell=mat.get(j).get(i);
				if(colTmp.contains(cell)) {
					total++;
					break;
				}
				colTmp.add(cell);
			}
		}
		return total;
	}
	
	public String toString() {
		return mat.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		int numLine=0;
		int nbMatrices;
		int posMat=-1;
		int sizeMat=0;
		LinkedList<String> linesMat=new LinkedList<String>();
		LinkedList<Solution> matrices=new LinkedList<Solution>();
		while(sc.hasNextLine()) {
			line=sc.nextLine();
			if(numLine==0) {
				nbMatrices=Integer.parseInt(line);
			} else if(posMat==-1) {
				sizeMat=Integer.parseInt(line);
				posMat=0;
			} else {
				linesMat.add(line);
				posMat++;
				if(posMat==sizeMat) {
					posMat=-1;
					String strMatTotal="";
					for(String lineMat : linesMat) {
						strMatTotal+=lineMat+"\n";
					}
					matrices.add(new Solution(sizeMat, strMatTotal));
				}
			}
			numLine++;
		}
		for(int i=0; i<matrices.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+matrices.get(i).trace() + " " + matrices.get(i).numRows()+" "+matrices.get(i).numCols());
		}
	}

}
