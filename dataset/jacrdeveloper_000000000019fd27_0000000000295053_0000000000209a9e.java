import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt(); // Test cases
		int b = in.nextInt(); // Num Bytes
	
		for (int i = 1; i <= t; ++i) {
			
			int b1 = 0;
			int b2 = 0;
			int bN = 0;
			int bNm1 = 0;
			int numForDetected = b;
			int posUp = 0;
			int posDown = b;
			int data = 0;
			Integer changeType = 0; // 0 - Nothing, 1 - Reverse, 2 - Complemented, 3- Mixed 2 + 1
			
			Integer[] mapB = new Integer[b];
			
			// Para determinar que operacion se ha ejecutado necesitamos:
			// Reverse: Primero y el ultimo
			// Complemented : // Cualquiera -> Esta nos la podemos ahorrar con los de reverse
			// No ha pasado nada, los valores rescatados siguen igual
			// Reverse + Complemented: // Necesitamos el
			
			for (int o = 1; o <= 150; o++) {
				
				if (o % 10 == 1) {
					changeType = 0;
					
					// Comprobamos si hay cambios
					// Para eso tenemos que realizar 4 peticiones
					// Si se trata de la primera vuelta, no hay que checkear cambios solo realizar 4 peticiones
					
					System.out.println(1);
					System.out.flush();
					b1 = in.nextInt();
					
					
					System.out.println(b);
					System.out.flush();
					bN = in.nextInt();
					
					System.out.println(2);
					System.out.flush();
					b2 = in.nextInt();
					
					System.out.println(b-1);
					System.out.flush();
					bNm1 = in.nextInt();
					
					o+=4;
					
					if (o == 5) {
						mapB[0] = b1;
						mapB[b-1] = bN;
						mapB[1] = b2;
						mapB[b-2] = bNm1;
						numForDetected-=4;
						posUp+=2;
						posDown-=2;
					} else {
						// Intentamos visualizar el cambio realizado
						// Creamos un string con los 4 valores
						StringBuffer cambioBuffer = new StringBuffer();
						cambioBuffer.append(b1);
						cambioBuffer.append(b2);
						cambioBuffer.append(bNm1);
						cambioBuffer.append(bN);
						
						// Ningun cambio
						// Creamos un string con los valores actuales
						StringBuffer ahoraBuffer = new StringBuffer();
						ahoraBuffer.append(mapB[0]);
						ahoraBuffer.append(mapB[1]);
						ahoraBuffer.append(mapB[b-2]);
						ahoraBuffer.append(mapB[b-1]);
						
						if (cambioBuffer.toString().equals(ahoraBuffer.toString())) {
							changeType = 0;
							// No se hace nada
						} else {
							// Realizamos una complementacion a los actuales
							StringBuffer complementedBuffer = new StringBuffer();
							complementedBuffer.append(complementa(mapB[0]));
							complementedBuffer.append(complementa(mapB[1]));
							complementedBuffer.append(complementa(mapB[b-2]));
							complementedBuffer.append(complementa(mapB[b-1]));
							
							if (cambioBuffer.toString().equals(complementedBuffer.toString())) {
								changeType = 2;
								
								//Complementamos el mapa actual
								for (int u = 0; u < mapB.length; u++) {
									if (mapB[u] != null) {
										mapB[u] = complementa(mapB[u]);
									}
								}
								
							} else {
								StringBuffer reverseBuffer = new StringBuffer();
								reverseBuffer.append(mapB[b-1]);
								reverseBuffer.append(mapB[b-2]);
								reverseBuffer.append(mapB[1]);
								reverseBuffer.append(mapB[0]);
								
								if (cambioBuffer.toString().equals(reverseBuffer.toString())) {
									changeType = 1;
									
									// Reverse al mapa actual
									for (int u = 0; u < mapB.length/2; u++) {
										if (mapB[u] != null) {
											Integer tmp = mapB[u];
											mapB[u] = mapB[u+((mapB.length-1) - u)];
											mapB[u+((mapB.length-1) - u)] = tmp;
										}
									}
								} else {
									reverseBuffer = new StringBuffer();
									reverseBuffer.append(complementa(mapB[b-1]));
									reverseBuffer.append(complementa(mapB[b-2]));
									reverseBuffer.append(complementa(mapB[1]));
									reverseBuffer.append(complementa(mapB[0]));
									
									if (cambioBuffer.toString().equals(reverseBuffer.toString())) {
										changeType = 3;
										
										//Complementar y reverse al mapa
										//Complementamos el mapa actual
										for (int u = 0; u < mapB.length; u++) {
											if (mapB[u] != null) {
												mapB[u] = complementa(mapB[u]);
											}
										}
										for (int u = 0; u < mapB.length/2; u++) {
											if (mapB[u] != null) {
												Integer tmp = mapB[u];
												mapB[u] = mapB[u+((mapB.length-1) - u)];
												mapB[u+((mapB.length-1) - u)] = tmp;
											}
										}
									}
								}
							}
						}
					}
				}
				
				// Obtenemos las posiciones que podamos hasta el nuevo cambio, de dos en dos
				posUp++;
				System.out.println(posUp);
				System.out.flush();
				data = in.nextInt();
				mapB[posUp - 1] = data; 
				o++;
				
				System.out.println(posDown);
				System.out.flush();
				data = in.nextInt();
				mapB[posDown - 1] = data; 
				posDown--;
				
				numForDetected -= 2;
				
				if (numForDetected == 0 || o == 149) {
					StringBuffer buffer = new StringBuffer();
					for (Integer n : mapB) {
						buffer.append(n);
					}
					System.out.println(buffer.toString());
					System.out.flush();
					if (in.next().equals("Y")) {
						o = 151;
					} else {
						System.exit(0);
					}
				}
			}
		
		}
	}
	
	private static int complementa (int value) {
		if (value == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

