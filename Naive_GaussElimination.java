 /**
 * CS 301: Numerical Methods
 * Professor: A. Khakpour
 *
 * Computer Exercise: 2.1 #10
 *
 * @author - Eric Schenck
 * last modified: October 12, 2017
 *   
 */
public class Naive_GaussElimination {

	public static void main(String[] args){
		int n = 4;			
		float multFactor = 1;
		float temp;							// to store temporary values
		float[][] matrix = new float[][]{
			{ 3 , -1 , 1 , 2 },
			{ 6 , -4 , 3 , 5 },
			{ 3 , -13, 9 , 3 },
			{ -6, 4 , 1 , -18}
		};
		float[] bVector = { 8 , 13, -19, -34};
		
		// print out before Naive_GaussElim
		System.out.print("Before Elimination :  Ax = b \n");
		for(int i = 0 ; i < n ; ++i){		// formatted printing 
			System.out.print("|");
			
			for(int j = 0 ; j < n ; ++j){
				System.out.printf("\t%.1f", matrix[i][j]);
			}
			System.out.printf("\t|\t| x |\t=\t|\t%.1f\t|\n" , bVector[i]);
		}
		
		// for loop handles forward elimination phase
		for (int k = 0; k < n ; ++k){
							
			temp = matrix[k][k];
			
			for ( int i = k; i < n ; ++i){	// divides row by leading integer
				matrix[k][i] /= temp;
			}
			bVector[k] /= temp;					
			
			// eliminate the first non zero entry in all other rows
			for (int i = (k+1) ; i < n ; ++i){
				boolean isFirst = true;
				for (int j = k ; j < n ; ++j){
					if(isFirst){
						multFactor = (-1) * matrix[i][j];
						bVector[i] += (multFactor * bVector[k]);
						isFirst = false;
					}
					matrix[i][j] += (multFactor * matrix[k][j]);
				}
			}									
		}
		
		// handles backwards elimination
		for (int k = (n-1); k > 0 ; --k){
			for (int i = (k-1); i >= 0; --i){
				multFactor = (-1) * matrix[i][k];
				matrix[i][k] += (multFactor * matrix[k][k]);
				bVector[i] += (multFactor * bVector[k]);
			}
		}
			
		// printout after Elimination has completed. 
		System.out.print("\nAfter Elimination :  Ax = b \n");
		for(int i = 0 ; i < n ; ++i){		// formatted printing 
			System.out.print("|");
				
			for(int j = 0 ; j < n ; ++j){
				System.out.printf("\t%.1f", matrix[i][j]);
			}
			System.out.printf("\t|\t| x |\t=\t|\t%.1f\t|\n" , bVector[i]);
		}
	}
}
