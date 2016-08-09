import java.util.*;

/* Input in main method.
	Expected output for this input is 90
	The maximum value that can be achieved using this is 90

*/

class KnapSackTopDown{

	public static void main(String args[]){
		int numElements = 4;
		int[] values = {10,40,30,50};
		int[] weights = {5,4,6,3};
		int outputWeight = 10;
		int[][] valMatrix = new  int[numElements+1][outputWeight+1];
		int max = knapSackMax(valMatrix,weights,values,outputWeight,numElements);
		System.out.println("Maximum Value obtained  : " + max);
		printMatrix(valMatrix,numElements,outputWeight);


	}

	// recursive and memoized code of top to bottom 0/1 knapsack

	public static int knapSackMax(int[][] valMatrix,int[] weights, int[] values , int outputWeight,int index)
	{
		if(index==0 || outputWeight==0){
			return 0;
		}
		else{
			if(valMatrix[index][outputWeight]!=0){
			return valMatrix[index][outputWeight];
			}

			else{
				if(outputWeight>=weights[index-1]){
					valMatrix[index][outputWeight] =Math.max(knapSackMax(valMatrix,weights,values,outputWeight,index-1),knapSackMax(valMatrix,weights,values,outputWeight-weights[index-1],index-1)+values[index-1]);
				}
				else{
					valMatrix[index][outputWeight] =knapSackMax(valMatrix,weights,values,outputWeight,index-1);
				}
				return valMatrix[index][outputWeight];
			}
		}
	}

	// prints the matrix of the top down

	public static void printMatrix(int[][] valMatrix,int numElements, int outputWeight){
		System.out.println("We are inside the printMatrix");

		for(int i=0;i<=numElements;i++){
			for(int j=0;j<=outputWeight;j++){
				System.out.print(valMatrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}












