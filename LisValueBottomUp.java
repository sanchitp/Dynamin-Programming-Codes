
import java.util.*;

class LisValueBottomUp{

// works for negative integers as well
// simply find the lis till the last values and check, it will take O(n^2) time and O(n) space
	public static void main(String args[])
	{
		int[] arr = {-7,-6,-4,-3,-8,-1};
		int totalMax = Integer.MIN_VALUE;
		int size = arr.length; 
		int[] lisArr = new int[size];
		lisArr[0] = 1 ;
		if(size==1){
			totalMax = 1;
		}


		for(int j=1;j<size;j++){
			int val = arr[j];
			int max = 0;

			for(int k=j-1;k>=0;k--){
				if(arr[k]<val){


					if(max<lisArr[k]){
						max = lisArr[k];
					}

				}
			}

			lisArr[j] = max + 1;

			if(totalMax<max+1){
				totalMax = max + 1;
			}

		}

		System.out.println("Length of the longest increasing subsequence is  " + totalMax);
	}
}