import java.util.Scanner;

public class Vestigium {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, k, l, m, t, b;
		boolean column = false, row = false;
		t = sc.nextInt();
		for(b = 1; b<=t; b++) {
		int trace = 0, c = 0, r = 0;
		m = sc.nextInt();
		int a[][] = new int[m][m];
		// input elements
        for(i = 0; i < m; i++) {
        	for(j = 0; j < m; j++) {
        		a[i][j] = sc.nextInt();
        		if(i == j) {
        			trace = trace + a[i][j];
        		}
        	}
        }
        // counting number of rows
        for(i = 0; i<m; i++) {
        	row = false;
        	for(j = 0; j<m; j++) {
        		l = a[i][j];
        		for(k = j+1; k < m; k++) {
        			if(l == a[i][k]) {
        				row = true;
        				break;
        			}
        			
        		}
        		if(row == true) {
        			r = r+1;
        			break;
        		}
        	}
        }
        // counting number of columns
        for(i = 0; i<m; i++) {
        	column = false;
        	for(j = 0; j<m; j++) {
        		l = a[j][i];
        		for(k = j+1; k < m; k++) {
        			if(l == a[k][i]) {
        				column = true;
        				break;
        			}
        			
        		}
        		if(column == true) {
        			c = c+1;
        			break;
        		}
        	}
        }
        System.out.println("Case #" + b + ": " + trace + " " + r + " " + c);
		}
	}

}
