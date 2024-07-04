import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt();
		String s, s2, c;
		char aux;

		sc.nextLine();

		for (int i = 0; i < y; i++) {

			s = sc.nextLine();
			s2 = "";
			aux = s.charAt(0);
			c = "";
			c += aux;
			
			for (int j = 0; j < s.length(); j++) {


				if ( s.length() != 1) {
					
					if(j != s.length() - 1) {

						if(j == 0 || s.charAt(j) != aux) {

							aux = s.charAt(j);
							c = "";
							c += aux;

							for (int j2 = 0; j2 < Integer.parseInt(c); j2++) {

								s2 += "(";
							}


						}	
					}

					else {

						if (s.charAt(j) != aux) {

							aux = s.charAt(j);
							c = "";
							c += aux;

							for (int j2 = 0; j2 < Integer.parseInt(c); j2++) {

								s2 += "(";
							}
						}

					}
				}
				
				else s2 += "(";

				s2 += aux;

				if(j != s.length() - 1) {

					if( s.charAt(j + 1) != aux ) {

						for (int j2 = 0; j2 < Integer.parseInt(c); j2++) {

							s2 += ")";
						}
						
					}
				}

				else {

					for (int j2 = 0; j2 < Integer.parseInt(c); j2++) {

						s2 += ")";
					}


				}

			}

			System.out.println("Case #" + (i + 1) + ": " + s2);


		}




	}

}
