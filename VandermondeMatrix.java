 /**
 * CS 301: Numerical Methods
 * Professor: A. Khakpour
 *
 * Computer Exercise: 2.1 #1
 *
 * @author - Eric Schenck
 * last modified: October 11, 2017
 *   
 */
public class VandermondeMatrix {
	public static void main(String[] args){
		
		int n = 6;							// for different nxn matrices
		
		float[] bVector = new float[n];		// stores bVector data
		
		float[][] matrix = new float[n][n];	// stores matrix data
		
		float temp;							// holds temporary data
		
		for(int i = 0 ; i < n ; ++i){		// fills Vandermonde Matrix
			for(int j = 0 ; j < n ; ++j ){
				matrix[i][j] = (float) Math.pow( (i+2), j );	
			}
							// fills bVector for matrix. Assumes all X[n]=1
			temp = (float) Math.pow( (i+2), n );
			bVector[i] = (temp - 1) / (i + 1);
		}
		
		System.out.println(n + "x" + n + " Vandermonde Matrix");

		for(int i = 0 ; i < n ; ++i){		// formatted printing 
			System.out.print("|");
			
			for(int j = 0 ; j < n ; ++j){
				System.out.printf("\t%.1f", matrix[i][j]);
			}
			System.out.printf("\t|\t| x |\t=\t|\t%.1f\t|\n", bVector[i]);
		}
	}
}
