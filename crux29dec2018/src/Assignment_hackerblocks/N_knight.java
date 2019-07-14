package Assignment_hackerblocks;

import java.util.Scanner;

public class N_knight {
static int ct=0;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		boolean board[][]=new boolean[n][n];
		Nknight(board,0,0,"",n,0);
System.out.println("\n"+" "+ct);
	}

	public static void  Nknight(boolean[][] board, int row,int kpsf,String ans,int total,int col) {
		
		if(row==board.length)
		{
			
		//	System.out.println();
			return ;
		}
		
		if(kpsf==total)
		{
			System.out.print(ans+" ");
			ct++;
			return ;
		}
		if(col==board[0].length)
		{
		Nknight(board, row+1,kpsf,ans, total,0);
			return ;
		}
		
		
			if (isitsafe(board, row, col)) {
				board[row][col] = true;
				Nknight(board, row,kpsf+1,ans+" "+"{"+row+"-"+col+"}", total,col+1);
				board[row][col] = false;
			
		}
  Nknight(board,row,kpsf,ans,total,col+1);
  
	}
	public static boolean isitsafe(boolean[][]board,int row,int col)
	{  //upper
		int r=row-2;
		int c=col+1;
		if((r>=0&&c<board[0].length)&&board[r][c]==true)
			return false;
	 r=row-1;
	 c=col+2;
	 
	 if((r>=0&&c<board[0].length)&&board[r][c]==true)
		 return false;
	 
	 r=row-1;
	 c=col-2;
	 if((r>=0&&c>=0)&&board[r][c]==true)
		 return false;
	 
	 r=row-2;
	 c=col-1;
	 if((r>=0&&c>=0)&&board[r][c]==true)
	 {
		 return false;
	 }
		
	 return true;
	}
}
