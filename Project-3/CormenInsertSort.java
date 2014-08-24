class CormenInsertSort implements SortIntArray{
 /*
insertSort: intergerArray -> integerArray[Sorted](Ascending)
Purpose: Simple create a sorted array of integers from given array. It's a classic insertion sort implementation.

Example:
insertSort([])->[]
insertSort([1,2,3,4,5])->[1,2,3,4,5]
insertSort([3,4,5,1,2])->[1,2,3,4,5]
insertSort([5,4,3,2,1])->[1,2,3,4,5]
insertSort([11,54,12,67,101,192,992])->[11,12,54,67,101,192,992]

Template:
A pseudo code from Cormen !
 for j = 2 to A:length
	key = A[j]
	Insert A[j] into the sorted sequence A[1.. j-1]
	i = j - 1
	while i > 0 and A[i] > key
	A[i+1]= A[i]
	i=i-1
	A[i+1]=key

*/
public static int[] insertionSort(int[] array){
	for(int j=1; j<array.length; j++){
		int key=array[j];
		int i = 0;
		for(i=j-1;i>=0 && array[i]>key;i--){
			array[i+1]=array[i];
		}
	  array[i+1]=key;
	}
  return array;
    }
	public void sortIntArray(int[]a){
		insertionSort(a);
	}
}
