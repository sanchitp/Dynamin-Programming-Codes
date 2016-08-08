import java.util.*;

class LcsBottomUp{

		public static void main(String args[]){

			String str1 = "sunday";
			String str2 = "satuday";

			LcsValue(str1,str2);
		}

		public static void LcsValue(String str1,String str2){
			int length1 = str1.length();
			int length2 = str2.length();


			int[][] array = new int[length1+1][length2+1];

			
			/*System.out.println("String 1" + str1);

			System.out.println("String 2" + str2);
*/

			for(int i=0;i<=length1;i++){
				array[i][0] = 0;
			}

			for(int j=0;j<=length2;j++){
				array[0][j] = 0;
			}

			// thus we need to get the answer in this case... what do we need to do in here
			// the best part in this case is that we need to find the answer to the dynamic programming here




			for(int row=1;row<=length1;row++){

					for(int col=1;col<=length2;col++){
						// we get the first row and the first column now
						if(str1.charAt(row-1)==str2.charAt(col-1)){

							/*System.out.println("Element in row " + str1.charAt(row-1));
							System.out.println("Element in column " + str2.charAt(col-1));*/
							array[row][col]= array[row-1][col-1] + 1 ;
							// this helps us to get the answer in this case
							// we have the row as well as column
							// thus we need to check the answer here.. i.e what problem is doing

						}

						else{
							array[row][col] = Math.max(array[row][col-1],array[row-1][col]);
						}


					}

			}

			System.out.println("Longest common subsequece : " + array[length1][length2]);

		}
}

