import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int matriz[][];
		int casos = sc.nextInt();
		int k[] = new int[casos + 1];
		int r[] = new int[casos + 1];
		int c[] = new int[casos + 1];
		for (int i = 0; i <= casos - 1; i++) {
			int n = sc.nextInt();
			matriz = new int[n + 2][n + 2];

			for (int f = 0; f <= n - 1; f++) {
				for (int s = 0; s <= n - 1; s++) {
					matriz[f][s] = sc.nextInt();
				}
			}
			for (int j = 0; j <= n - 1; j++) {
				k[i] += matriz[j][j];
			}
			for (int a = 0; a <= n - 1; a++) {
				for (int w = 0; w <= n - 1; w++) {
					for (int b = w; b <= n - 1; b++) {
						if (w != b && matriz[a][w] == matriz[a][b] && r[i] != n) {
							r[i]++;
						}
					}
				}
			}

			for (int a = 0; a <= n - 1; a++) {
				for (int w = 0; w <= n - 1; w++) {
					for (int b = w; b <= n - 1; b++) {
						if (w != b && matriz[w][a] == matriz[b][a] && c[i] != n) {
							c[i]++;
						}
					}
				}
			}

		}

		for (int i = 0; i <= casos - 1; i++) {
			System.out.println("Case #" + i + ": " + k[i] + " " + r[i]+" "+c[i]);
		}

	}
}
