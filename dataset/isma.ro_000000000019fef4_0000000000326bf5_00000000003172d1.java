

////////////////////////////////////////////
////////////////////////////////////////////
///////////////////////////////////////////

import java.util.*;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a = 0; a < T; a++) {
			String sol="";
			int N = in.nextInt();
			int D = in.nextInt();
			ArrayList<Double> l = new ArrayList<Double>();
			for (int i = 0; i < N; i++) {
				l.add(in.nextDouble());
			}
			Collections.sort(l);

			boolean done=false;
			if(D==2){
				for (int i = 0; i < l.size()-1; i++) {
					
					if(l.get(i).equals(l.get(i+1))){
						sol=0+"";
						done=true;
						i=l.size();
					}
				}
				if(!done){
					sol=1+"";
				}
			}else if (D==3){
				for (int i = 0; i < l.size()-2; i++) {
					if(l.get(i).equals(l.get(i+1)) && l.get(i+1).equals(l.get(i+2))){
						sol=0+"";
						done=true;
						i=l.size();
					}
				}
				if(!done){
					for (int i = 0; i < l.size()-1; i++) {
						if(l.get(i).equals(l.get(i+1)) && i+2!=l.size()){
							sol=1+"";
							done=true;
							i=l.size();
						}
					}
				}
				if(!done){
					for (int i = 0; i < l.size()-1; i++) {
						if(l.contains(l.get(i)*2)){
							sol=1+"";
							done=true;
							i=l.size();
						}
					}
				}
				if(!done){
					sol=2+"";
				}
			}
			
			System.out.println("Case #"+(a+1)+": "+sol);
			
			
			
		}

	}

}