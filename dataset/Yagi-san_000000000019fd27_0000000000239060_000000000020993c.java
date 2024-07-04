import java.util.LinkedList;
import java.util.Scanner;

public class Matrice {
	private int size;
	private LinkedList<LinkedList<Integer>> mat=new LinkedList<LinkedList<Integer>>();
	public Matrice(int size, String matStr) {
		this.size=size;
		String[] lines=matStr.split("\\\\n+");
		for(String line: lines) {
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
		LinkedList<Matrice> matrices=new LinkedList<Matrice>();
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
						strMatTotal+=lineMat;
					}
					matrices.add(new Matrice(sizeMat, strMatTotal));
				}
			}
			numLine++;
		}
		for(int i=0; i<matrices.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+matrices.get(i).trace());
		}
	}

}
