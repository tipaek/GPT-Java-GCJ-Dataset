import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
		Cell c = new Cell(0, 0, 1);
		c.addOthersCells();
		c.findPath(N,usedCells);
		
//		for(Cell ce : c.adjacentCell) {
//			if(ce.findPath(N,usedCells)) {
//				break;
//			}
//		}
		
		
		System.out.println(String.format("Case #%s:", useCase+1));
		
		for(Cell ce : usedCells) {
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
        return c2.getValue().compareTo(c1.getValue());
    }
}
class Cell{
	int row;
	int k;
	int value;
	List<Cell> adjacentCell = new ArrayList<Cell>();

	public Integer getValue() {
		return this.value;
	}
	
	public Cell(int row,int k,int value) {
		this.row = row;
		this.k = k;
		this.value = value;
	}
	
	
	public boolean findPath(int n, List<Cell> usedCells) {
		if(usedCells.size() > 499) return false;
		n = n - this.value;
		usedCells.add(this);
		if(n==0) return true;
		if(n<0) return false;
		for(Cell c: this.adjacentCell) {
			c.addOthersCells();
			if(c.findPath(n, usedCells)) {
				return true;
			}
		}
		return false;
		
	}


	public void addOthersCells() {
		
		int minRow = this.row > 1 ? this.row-1 : this.row;
		
		for(int r = minRow; r <= this.row +1 ; r ++) {
			for(int i = 0;i<r+1;i++) {

					if(this.k != i || this.row != r) adjacentCell.add(new  Cell(r,i,ncr(r, i)));
				
			}
			
		}	
		
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

