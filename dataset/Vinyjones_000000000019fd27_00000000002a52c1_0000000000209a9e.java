
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private int B;
	private boolean endAll;
	private boolean endCase;
	private int currentTest = 0;
	private List<Parity> paires = new ArrayList<>();
	private int firstPairePart;
	private Integer identityPair;
	private Integer opposityPair;
	private int signaturePosition;
	private int[] oldSignature;
	private int[] newSignature = new int[2];
	private int[] reading;
	private int readingPosition = 0;

	List<String> result = new ArrayList<>();
	public Solution(int b) {
		B = b;
		reading = new int[B / 2];
	}

	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String[] tab = br.readLine().split(" ");;
			int nbCaseToSolve = Integer.parseInt(tab[0]);
			int arraySize = Integer.parseInt(tab[1]);
			for (int i = 1; i <= nbCaseToSolve; i++) {
				Solution solver = new Solution(arraySize);
				while (!solver.endCase()) {
					String messageOut = solver.out();
					if (messageOut.isEmpty()) {
						throw new RuntimeException("empty message generated");
					}
					System.out.println(messageOut);
					System.out.flush();

					solver.in(br.readLine());

				}
				if (solver.endAll()) {
					break;
				}
			}
		}
	}

	private boolean endAll() {
		return endAll;
	}

	private void in(String readLine) {
		if (readLine.equals("N")) {
			endCase = true;
			endAll = true;
			return;
		}
		if (readLine.equals("Y")) {
			endCase = true;
			return;
		}
		int recivedValue = Integer.parseInt(readLine);
		if (currentTest < B / 2) { // pair reading
			if (currentTest % 2 == 0) {
				firstPairePart = recivedValue;
			} else {
				paires.add(recivedValue == firstPairePart ? Parity.IDENTITY : Parity.OPPOSITY);
			}
		} else if (signaturePosition < 2) {
			newSignature[signaturePosition] = recivedValue;
			signaturePosition++;
		} else {
			reading[readingPosition] = recivedValue;
		}
		currentTest += 1;
	}

	private boolean endCase() {
		return endCase;
	}

	private String out() {
		if (currentTest < B / 2) { // pair reading
			int value;
			if (currentTest % 2 == 0) {
				value = currentTest;
			} else {
				value = B - currentTest;
			}
			return Integer.toString(value+1);
		}
		if (currentTest == B / 2) { // Paire diagnostique
			for (int i = 0; i < paires.size(); i++) {
				if (identityPair == null && Parity.IDENTITY.equals(paires.get(i))) {
					identityPair = i;
				}
				if (opposityPair == null && Parity.OPPOSITY.equals(paires.get(i))) {
					opposityPair = i;
				}
			}
		}
		if (currentTest >= B / 2 && readingPosition < B / 2) {
			if (currentTest % 10 == 0) {
				signaturePosition = 0;
			}
			if (signaturePosition == 0) {
				if (identityPair != null) {
					return Integer.toString(identityPair+1);
				} else {
					signaturePosition++;
				}
			}
			if (signaturePosition == 1) {
				if (opposityPair != null) {
					return Integer.toString(opposityPair+1);
				} else {
					signaturePosition++;
				}
			}if(signaturePosition == 2 ) { // interpreation de la signature et reprise de la lecture
				signaturePosition ++;
				if(oldSignature != null) {
					Change change = getTransformation();
					for (int i = 0; i < readingPosition; i++) {
						reading[i] = applyChange(reading[i], paires.get(i), change);
					}
				}
				oldSignature = Arrays.copyOf(newSignature, 2);
				
			}
			return Integer.toString(readingPosition+1);

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < B/2; i++) {
			sb.append(reading[i]);
		}
		for (int i = B/2-1; i >= 0; i--) {
			Parity pair = paires.get(i);
			int val = reading[i];
			sb.append(Parity.IDENTITY.equals(pair)? val: 1-val);
		}
		return sb.toString();		
	}

	private int applyChange(int val, Parity parity, Change change) {
		switch (change) {
			case NOTHING :
				return val;
			case COMPLEMENTED : 
				return 1-val;
			case REVERSED : 
				return Parity.IDENTITY.equals(parity)? val : 1-val;
			case COMPLEMENTED_AND_REVERSED : 
				return Parity.IDENTITY.equals(parity)? val-1 : val;
			default :
				throw new RuntimeException();
		}
		
	
	}

	Change getTransformation() {
		if(opposityPair == null) { // Array is symetric, only complement is effective
			if(oldSignature[0] == newSignature[0]) {
				return Change.NOTHING;
			} else {
				return Change.COMPLEMENTED;
			}
		}
		if(identityPair == null) { // complement and  reves has same effect
			if(oldSignature[1] == newSignature[1]) {
				return Change.NOTHING;
			} else {
				return Change.COMPLEMENTED;
			}
		}
		if(oldSignature[0] == newSignature[0] && oldSignature[1] == newSignature[1]) {
			return Change.NOTHING;
		}
		if(oldSignature[0] != newSignature[0] && oldSignature[1] == newSignature[1]) {
			return Change.COMPLEMENTED;
		}if(oldSignature[0] == newSignature[0] && oldSignature[1] != newSignature[1]) {
			return Change.REVERSED;
		}
	return Change.COMPLEMENTED_AND_REVERSED;
		
		
		
	}
	
	
	
	private void analyse() {

	}

	enum Change {
		COMPLEMENTED, REVERSED, COMPLEMENTED_AND_REVERSED, NOTHING
	}
	static enum Parity {
		IDENTITY, OPPOSITY
	}
}
