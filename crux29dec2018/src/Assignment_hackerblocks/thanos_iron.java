package Assignment_hackerblocks;

import java.util.Scanner;

public class thanos_iron {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			boolean board[][] = new boolean[n][m];

			boolean ans = thanosiron(n, m, board, 0, 0);

			if (ans) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}
			t--;
		}

	}

	private static boolean thanosiron(int n, int m, boolean[][] board, int i, int j) {

		if (i == n - 1 && j == m - 1) {
			return board[i][j];
		}
		if (i >= n || j >= m) {
			return false;
		}
		board[i][j] = true;
		boolean bn=true;
		if (board[i][j]) {
			bn = thanosiron(n, m, board, i + 1, j);
			bn = thanosiron(n, m, board, i, j + 1);
		}
		if (board[i][j]) {
			bn = thanosiron(n, m, board, i + 1, j);
			bn = thanosiron(n, m, board, i, j + 1);
		}

		return bn;
	}

	
}
