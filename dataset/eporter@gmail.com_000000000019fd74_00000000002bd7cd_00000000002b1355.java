
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    final Scanner in;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
	}
	
	int rows, cols;
	Adj [][] s;
	
	private void runCase(int cs) {
	    rows = in.nextInt();
	    cols = in.nextInt();
	    s = new Adj [rows][cols];
	    HashSet<Adj> active = new HashSet<>();
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            Adj a = new Adj(i, j, in.nextInt());
	            s[i][j] = a;
	            active.add(a);
	        }
	    }
	    List<Adj> toRemove = new ArrayList<>();
	    long interest = 0;
	    do {
	        toRemove.clear();
	        for (Adj a : active) {
	            interest += a.skill;
	            if (a.isElim()) {
	                toRemove.add(a);
	            }
	        }
	        for (Adj a : toRemove) {
	            active.remove(a);
	            a.active = false;
	        }
	    } while (!toRemove.isEmpty());
        println(String.format("Case #%s: %s", cs, interest));
	}
	
	private class Adj {
	    final int r, c, skill;
	    int up, down, left, right;
	    boolean active = true;

        public Adj(int r, int c, int skill) {
            this.r = r;
            this.c = c;
            this.skill = skill;
            up = r - 1;
            down = r + 1;
            left = c - 1;
            right = c + 1;
        }
        
        boolean isElim() {
            double totSkill = 0;
            int neigh = 0;
            while (up >= 0 && !s[up][c].active) {
                up--;
            }
            if (up >= 0) {
                totSkill += s[up][c].skill;
                neigh++;
            }
            
            while (down < rows && !s[down][c].active) {
                down++;
            }
            if (down < rows) {
                totSkill += s[down][c].skill;
                neigh++;
            }
            
            while (left >= 0 && !s[r][left].active) {
                left--;
            }
            if (left >= 0) {
                totSkill += s[r][left].skill;
                neigh++;
            }
            
            while (right < cols && !s[r][right].active) {
                right++;
            }
            if (right < cols) {
                totSkill += s[r][right].skill;
                neigh++;
            }
            
            if (neigh > 0) {
                double avg = totSkill / neigh;
                return skill < avg;
            }
            return false;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + c;
            result = prime * result + r;
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
            Adj other = (Adj) obj;
            if (c != other.c)
                return false;
            if (r != other.r)
                return false;
            return true;
        }
	}
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}
