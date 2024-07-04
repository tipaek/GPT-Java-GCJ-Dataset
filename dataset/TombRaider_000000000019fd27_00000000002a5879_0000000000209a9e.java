

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	Scanner input;
	int b;
	
	boolean [] field;
	int read;
	
	public Solution (Scanner input, int b) {
		this.input = input;
		this.b = b;
		this.field = new boolean [b];
		this.read = 0;
	}
	
	private boolean intToBoolean (int i) {
		if (i==1) return true;
		return false;
	}
	
	private void readNext () { // read a pair of values
		System.out.println((this.read + 1) + "");
		this.field [this.read] = this.intToBoolean(this.input.nextInt());
		System.out.println((this.b-this.read) + "");
		this.field [this.b-this.read-1] = this.intToBoolean(this.input.nextInt());
		this.read += 1;
	}
	
	private int firstEqual () {
		if (read==0) return -1;
		for (int i=0; i<read; i++) {
			if (this.field [i] == this.field [this.b-i-1]) {
				// equal
				return i;
			}
		}
		return -1;
	}
	
	private int firstUnequal () {
		if (read==0) return -1;
		for (int i=0; i<read; i++) {
			if (this.field [i] != this.field [this.b-i-1]) {
				// equal
				return i;
			}
		}
		return -1;
	}
	
	private int determineState () {  // 0 = nothing read, 1 = all same, 2 = all different, 3 = one same - one different
		if (read==0) return 0;
		if (this.firstUnequal() == -1) return 1;
		if (this.firstEqual() == -1) return 2;
		return 3;
	}
	
	private void complementField() {
		for (int i=0; i<this.b; i++) {
			this.field [i] = !this.field [i];
		}
	}
	
	private void invertField() {
		for (int i=0; 2*i<this.b; i++) {
			boolean helper = this.field [i];
			this.field [i] = this.field [this.b-i-1];
			this.field [this.b-i-1] = helper;
		}
	}
	
	public boolean solve() {
		
		int state = 0;
		boolean firstEqualValueBeforeSwitch = false;
		boolean firstUnEqualValueBeforeSwitch = false;
		
		while (2*this.read < this.b) {	
			//what happens in the next 10 tries?
			//only the first two tries differ
			if (state==0) {
				this.readNext(); 
			} else {				
				if (state==1) {
					System.out.println((this.firstEqual()+1)+"");
					boolean newFirstEqualValue = this.intToBoolean(this.input.nextInt());
					System.out.println((this.firstEqual()+1)+"");
					newFirstEqualValue = this.intToBoolean(this.input.nextInt());
					if (firstEqualValueBeforeSwitch == newFirstEqualValue) {
						// all goood - no change or inververted
					} else {
						this.complementField();
					}
				} else if (state == 2) {
					System.out.println((this.firstUnequal()+1)+"");
					boolean newFirstUnequalValue = this.intToBoolean(this.input.nextInt());
					System.out.println((this.firstUnequal()+1)+"");
					newFirstUnequalValue = this.intToBoolean(this.input.nextInt());
					if (firstUnEqualValueBeforeSwitch == newFirstUnequalValue) {
						// all gooood - no change or inverted&complemented
					} else {
						this.complementField(); // could also invert, doesn't matter
					}
				} else if (state == 3) {// state == 3
					System.out.println((this.firstEqual()+1)+"");
					boolean newFirstEqualValue = this.intToBoolean(this.input.nextInt());
					System.out.println((this.firstUnequal()+1)+"");
//				    throw new RuntimeException ("how shou---------" + this.firstUnequal() + "--------");

					boolean newFirstUnequalValue = this.intToBoolean(this.input.nextInt());
					if (newFirstEqualValue==firstEqualValueBeforeSwitch) {
						// nothing changed
						// OR invertation
						if (newFirstUnequalValue == firstUnEqualValueBeforeSwitch) {
							// yeah, nothing changed
						} else {
							// invertation
							this.invertField();
						}
					} else {
						// complement
						// OR complement and invert
						if (newFirstUnequalValue == firstUnEqualValueBeforeSwitch) {
							// complement and invert
							this.complementField();
							this.invertField();
						} else {
							// complement
							this.complementField();
						}
					}
				}
			}
			
			//the other 8 just consist of reading additional values
			for (int i=0; i<4; i++) {
				this.readNext();
			}
			//prepareNextRead
			state = this.determineState();
			if (state == 1) {
				firstEqualValueBeforeSwitch = this.field [this.firstEqual()];
			} else if (state ==2) {
				firstUnEqualValueBeforeSwitch = this.field [this.firstUnequal()];
			} else {
				firstEqualValueBeforeSwitch = this.field [this.firstEqual()];
				firstUnEqualValueBeforeSwitch = this.field [this.firstUnequal()];
			}
		}
		
		//print solution
		String solution = "";
		for (int i=0; i<this.b; i++) {
			if (this.field [i]) {
				solution += "1";
			} else {
				solution += "0";
			}
		}
		System.out.println(solution);
		return this.input.next().equals ("Y");
	}
	
	public static void main(String args[]) {
	   // Scanner input = new Scanner(System.in);
	    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = input.nextInt();
	    int b = input.nextInt();
	    for (int ks = 1; ks <= t; ks++) {
	    	Solution s = new Solution(input, b);
	    	if (!s.solve()) break;
	    }
	}
}
