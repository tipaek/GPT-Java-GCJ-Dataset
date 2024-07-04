import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		
		
		 Scanner scanner = new Scanner( System.in );
		 
		int T= scanner.nextInt();

				
		for(int useCase = 0;useCase < T;useCase++) {
			
		solve(scanner,useCase);
		
		
		
		
		}
						
	}

	private static void solve(Scanner scanner,int useCase) {
		
		int N= scanner.nextInt();
		List<Cell> usedCells = new ArrayList<Cell>();
		Cell c = new Cell(0, 0);
		c.addOthersCells();
		c.findPath(N,usedCells);
		
//		for(Cell ce : c.adjacentCell) {
//			if(ce.findPath(N,usedCells)) {
//				break;
//			}
//		}
		
		
		System.out.println(String.format("Case #%s:", useCase+1));
		
		for(Cell ce : usedCells) {
			//System.out.println(String.format("%s %s %s",ce.row+1,ce.k+1,ce.value));
			System.out.println(String.format("%s %s",ce.row+1,ce.k+1));
		}
//		
//	      for(int i = 0; i <= n; i++) {
//	          for(int j = 0; j <= n-i; j++){
//	             System.out.print(" ");
//	          }
//	          for(int j = 0; j <= i; j++){
//	             System.out.print(" "+ncr(i, j));
//	          }
//	          System.out.println();
//	       }
	      
	      
	    }
		
	


	
	
}
class valueComparator implements Comparator<Cell>
{
    public int compare(Cell c1, Cell c2)
    {
        return c1.getValue().compareTo(c2.getValue());
    }
}
class Cell{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + k;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (k != other.k)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	int row;
	int k;
	int value;
	List<Cell> adjacentCell = new ArrayList<Cell>();

	public Integer getValue() {
		return this.value;
	}
	
	public Cell(int row,int k) {
		this.row = row;
		this.k = k;
		this.value = ncr(row, k);
	}
	
	
	public boolean findPath(int n, List<Cell> usedCells) {
		if(usedCells.size() > 499) return false;
		n = n - this.value;
		
		if(n<0) return false;
		usedCells.add(this);
		if(n==0) return true;		
		for(Cell c: this.adjacentCell.stream().filter(s->!usedCells.contains(s)).collect(Collectors.toList())) {
			c.addOthersCells();
		
			if(c.findPath(n, usedCells)) {
				return true;
			}
		}
		usedCells.remove(this);
		return false;
		
	}


	public void addOthersCells() {

		
		
		int row = Math.max(this.row-1,0);
		int col = this.k;
		
		//Row above
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
		col = Math.max(this.k,row);
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
		
		//Same row
		row = this.row;
		col = Math.max(this.k-1,0);
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
		col = Math.min(this.k+1,row);
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
		
		//Row below
		row = this.row+1;
		col = this.k;
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
		col = this.k+1;
		if(this.row != row && this.k != col) adjacentCell.add(new  Cell(row,col));
	

		
		Collections.sort(adjacentCell,new valueComparator());
	}
	   static int factorial(int n) {
		      int f;

		      for(f = 1; n > 1; n--){
		         f *= n;
		      }
		      return f;
		   }
	   
	   static int ncr(int n,int r) {
		      return factorial(n) / ( factorial(n-r) * factorial(r) );
		   }
}

