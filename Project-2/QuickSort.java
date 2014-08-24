class QuickSort implements SortIntArray{
	
// IMPORTANT NOTE: Note that this codes mostly depends on lectures of Chris Stephenson !
// segments: intArray Start[int] End[int]
// Purpose : to sort segments in an asending order !
// Examples: I used pen and paper ! Also Cormen examples !
// Template:
// I used Chris's Lecture Notes !
// Tests are in seperate file.
	
int segments(int[] array, int start, int end){
      int indexStr = start;
      int indexEnd = end - 1;
      int pivot = array[start];
      while (indexStr < indexEnd){
        while((indexStr < indexEnd) && (pivot <= array[indexEnd])){
        	indexEnd--;
        }
        while((indexStr < indexEnd) && (pivot > array[indexStr])){
        	indexStr++;
        }
        exchange(array, indexStr, indexEnd);
      }
      array[indexStr] = pivot;
      return indexStr;
}
// quickSort: intArray Start[int] End[int]
// Purpose : to seperate array into 2 pieces considering pivot and sort seperatly.
// Examples: I used pen and paper ! Also Cormen examples !
// Template:
// I used Chris's Lecture Notes !
// Tests are in seperate file.

public void quickSort(int[] array, int Start, int End){
	if(Start >= End)
		return;
	else{
          int indexPivot = segments(array, Start, End);
          quickSort(array, Start, indexPivot); 
          quickSort(array, indexPivot + 1, End);
	}
 }
public void exchange(int[] A, int start, int end){
	int mem = A[end];
	A[end] = A[start];
	A[start] = mem;
	}
public void sortIntArray(int[]a)
{
	quickSort(a, 0, a.length);
}

}
