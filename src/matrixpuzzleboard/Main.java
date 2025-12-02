package matrixpuzzleboard;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		int[][] board = new int[5][5];
		Random ran = new Random();
		
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < 5; j ++) {
				board[i][j] = ran.nextInt(16);
			}
		}
		for(int[] b : board) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		
		

	}
	public static int detectEquivalentAdjacentPairs(int[][] arr){
		int ap = 0;
		for(int i = 0; )
			
			
		return ap;
	}

}
