package Assignment_hackerblocks;

import java.util.Scanner;

public class chessboard_problem {
	static int ct = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int board[][] = new int[n][n];
		chess(board, 0, 0, n-1, n-1, "");
		System.out.println("\n" + ct);

	}

	public static void chess(int board[][], int cc, int cr, int ec, int er, String ans) {
		if (cc ==ec && cr==er) {
			System.out.print(ans);
			System.out.print("{"+cr+"-"+cc+"}"+" ");
			ct++;
			return;
		}
		if (cc > ec || cr > er)
			return;

		chess(board, cc + 1, cr + 2, ec, er, ans +"{" + cr + "-" + cc + "}"+"K" );

		chess(board, cc + 2, cr + 1, ec, er, ans + "{" + cr + "-" +cc  + "}"+"K");
if(cc==0||cc==ec||cr==0||cr==er)
{
		for (int i = 1;  i <=ec; i++) {
			chess(board, cc + i, cr, ec, er, ans +"{" +cr+ "-" + cc+ "}"+"R" );
		}
		for (int i = 1; i<=er; i++) {
			chess(board, cc, cr + i, ec, er, ans +"{" + cr + "-" +cc + "}"+"R" );
		}
		}
		if (cc == cr || cc + cr == er) {
			for(int i=1;i<=ec&&i<=er;i++)
			chess(board, cc + i, cr + i, ec, er, ans  + "{" +cr+ "-" + cc+ "}"+"B");
		}

	}

}
