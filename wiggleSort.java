/*

WiggleSort

[1, 2, 3, 4, 5] -> [1, 3, 2, 5, 4] == [2, 3, 1, 5, 4]

[3,2,4,1,5] => [3] : [1,2] [4,5] => [1,4,2,5,3,3,3]

[6,6,5,6,7,8] =>[6] :  < [5]  = [6,6,6]  >[7,8] => [5,7,6,8,6,6]
O(n)

*/

public class wiggleSort
{
	public static void main(String[] args)
	{
		int[] a = {6,6,5,6,7,8};

		System.out.println("Before");
		printArray(a);

		int [] result = wiggleSort(a);

		System.out.println("\nAfter");
		printArray(result);
	}

	public static int[] wiggleSort(int[] A)
	{
		int [] less = new int[A.length];
		int [] equal = new int[A.length];
		int [] greater = new int[A.length];

		int [] result = new int[A.length];
		int iLess = 0;
		int iEqual = 0;
		int iGreater = 0;

		int pivot = getMedian(A);

		for(int i = 0 ; i < A.length ; i++)
		{
			if(A[i] < pivot)
			{
				// put in less bucket
				less[iLess] = A[i];
				iLess ++;
			}
			else if(A[i] > pivot)
			{
				// put in greater bucket
				greater[iGreater] = A[i];
				iGreater ++;
			}
			else
			{
				// put in equal bucket
				equal[iEqual] = A[i];
				iEqual++;
			}
		}
		
		int lessSize = iLess;
		int equalSize = iEqual;
		int greaterSize = iGreater;
		
		// reset the iterators for reuse
		iLess = 0;
		iEqual = 0;
		iGreater = 0;

		boolean compare = true;

		for(int i = 0 ; i < result.length ; i++)
		{
			if(compare)
			{
				if(iLess < lessSize)
				{
					result[i] = less[iLess];
					iLess ++;
				}
				else
				{
					result[i] = equal[iEqual];
					iEqual++;
				}
			}
			else
			{
				if(iGreater < greaterSize)
				{
					result[i] = greater[iGreater];
					iGreater ++;
				}
				else
				{
					result[i] = equal[iEqual];
					iEqual++;
				}
			}

			compare = !compare;
		}

		return result;
	}

	public static int getMedian(int[] a)
	{
		mergeSort.mergeSort(a);
		// printArray(a);
		return a[a.length/2];
	}

	public static void printArray(int[] a)
	{
		System.out.print("|");
		for(int i = 0 ; i < a.length ; i++)
		{
			if( new Integer(a[i]) != null)
				System.out.print(a[i] + "|");
			else
				System.out.print(" |");
		}
		System.out.println();
	}


}