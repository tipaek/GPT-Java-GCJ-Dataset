

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
			int U =in.nextInt();
			HashMap<Double,String> info = new HashMap<Double,String>();
			in.nextLine();
			ArrayList <String> l=new ArrayList <String>();
			for (int i = 0; i < 10000; i++) {
				String pal = in.nextLine();
				String data [] =pal.split(" ");
				double m = Double.parseDouble(data[0]);
				String s= data[1];
				
				info.put(m, s);
				if(l.size()<10){
					for (int j = 0; j < s.length(); j++) {
						if(!l.contains(s.charAt(j)+"")){
							l.add(s.charAt(j)+"");
						}
					}
				}
			}
			boolean [][] pos = new boolean [10][10]; // primer entrada digito, segundo entrada letra indice l
			
			for (int i = 0; i < pos.length; i++) {
				for (int j = 0; j < pos.length; j++) {
					pos[i][j]=true;
				}
			}
			
			for (Map.Entry<Double, String> entry : info.entrySet()) {
			    double x = entry.getKey();
			    String tx = Double.toString(x).split(",")[0];
			    int len= (int) (Math.log(x)/Math.log(10));
			    String y = entry.getValue();
			    String s = y.charAt(0)+"";
			   /* if(pos[0][l.indexOf(s)]){
			    	System.out.println("NO PUEDE COMENZAR CON "+ s+ " index "+l.indexOf(s));
			    }*/
			    pos[0][l.indexOf(s)]=false; // no puede comenzar con 0
			  //  System.out.println(y.length());
			    //System.out.println(tx +" "+tx.length()+" "+len);
			    if(y.length()== (len+1)){
			    //	System.out.println("ENTRE");
			    	//info sobre el primer indice
			    	int ini = Integer.parseInt(tx.charAt(0)+"");
			    	for (int i = ini+1; i < 10; i++) {
						pos[i][l.indexOf(s)]=false;
					}
			    	if(y.length()>=2){
			    	if (y.charAt(0)==y.charAt(1) && tx.charAt(0)>tx.charAt(1)){
			    		pos[ini][l.indexOf(s)]=false;
			    		
			    	}
			    	}
			    	
			    	//Se que el primer indice es mas chico o igual que 
			    }
			}
			/*
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i));
			}
			System.out.println();
			for (int i = 0; i < pos.length; i++) {
				for (int j = 0; j < pos.length; j++) {
					if(pos[i][j]){
						System.out.print("t");
					}else{
						System.out.print("f");
					}
				}
				System.out.println();
			}
			*/
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < pos.length; j++) {
					if (pos[i][j]==true){
					//	System.out.println(l.get(j));
						sol= sol + l.get(j);
						pos[0][j]=false;
						pos[1][j]=false;
						pos[2][j]=false;
						pos[3][j]=false;
						pos[4][j]=false;
						pos[5][j]=false;
						pos[6][j]=false;
						pos[7][j]=false;
						pos[8][j]=false;
						pos[9][j]=false;
						j=30;
					}
				}
				
			}
			String aux="";
			
			for (int i = 9; i >= 1; i--) {
				for (int j = 0; j < pos.length; j++) {
					if (pos[i][j]==true){
						//System.out.println(l.get(j));
						aux=  l.get(j)+aux;
						pos[0][j]=false;
						pos[1][j]=false;
						pos[2][j]=false;
						pos[3][j]=false;
						pos[4][j]=false;
						pos[5][j]=false;
						pos[6][j]=false;
						pos[7][j]=false;
						pos[8][j]=false;
						pos[9][j]=false;
						j=30;
					}
				}
			}
			//System.out.println(aux);
			sol=sol+aux;
			
			System.out.println("Case #"+(a+1)+": "+sol);
			
			
			
		}

	}

}