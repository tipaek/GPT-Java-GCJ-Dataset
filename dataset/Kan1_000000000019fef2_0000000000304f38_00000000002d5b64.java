import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {


	static Solution sol = new Solution();
	static List<Integer> switchA = new ArrayList<>();
	static  List<Integer> switchB = new ArrayList<>();


	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {
			switchA = new ArrayList<>();
			switchB = new ArrayList<>();
			List<Card> cards = new ArrayList<Card>();
			int R = scann.nextInt(); //Number of activities
			int S = scann.nextInt(); // Value to found

			for(int i = 0; i<S;i++) {

				for(int j = 0;j< R;j++) {
					cards.add(new Card(j+1, i+1));
				}

			}



			filter(cards,S);


			System.out.println(String.format("Case #%s: %s",usease+1,switchA.size()));
			for(int i = 0;i< switchA.size();i++) {
				System.out.println(String.format("%s %s",switchA.get(i),switchB.get(i)));
			}


		}


	}


	private static void filter(List<Card> cards,int numberOfRank) {



		

		


		while(!checkRank(cards,numberOfRank)) {
			List<Card> A;
			List<Card> B;
			int BHigher = 0;
			int BLower = 0;

			int AHigher = 0;
			int ALower = 0;

			int Rref= cards.get(cards.size()-1).R;
			int count = 1;
			for(int i = cards.size()-2 ; i >-1;i-- ) {
				if(Rref != cards.get(i).R) {
					if(count !=numberOfRank) {
						BLower = i;
						break;
					}
					else {
						Rref= cards.get(i).R;
						count = 1;
					}
					
				}
				else {
					count++;
				}


			}
			for(int i =0 ; i< cards.size();i++ ) {
				if(Rref == cards.get(i).R) {
					ALower = i;
					BHigher = i+1;
					break;
				}
			}
				A =  new ArrayList<>(cards.subList(AHigher, ALower+1));
				B =  new ArrayList<>(cards.subList(BHigher, BLower+1));
				List<Card> tmp =  new ArrayList<>(cards.subList(BLower+1, cards.size()));

				cards.clear();
				cards.addAll(B);
				cards.addAll(A);
				cards.addAll(tmp);
				
				switchA.add(A.size());
				switchB.add(B.size());
			
		}








		// TODO Auto-generated method stub

	}


	private static boolean checkRank(List<Card> cards, int globalR) {

		int count = 0;
		int tmpR = 0;
		for(Card card : cards) {
			if(card.R == tmpR || tmpR==0) {
				count++;
				tmpR = card.R;
			}
			else {
				if(count ==globalR) {
					count=1;
					tmpR = card.R;
				}
				else {
					return false;
				}
			}


		}



		return true;
	}





}
class Card {
	int R;
	int S;
	public Card(int r, int s) {
		this.R = r;
		this.S = s;
	}



}
