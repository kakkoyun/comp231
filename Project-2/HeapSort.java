class HeapSort implements SortIntArray{
	// A binary heap is a special kind of binary tree structure.
	// Representation of this abstract data structure on arrays like this:
	/*
	public int parent(int i){return i / 2;}
	public int left (int i){return 2*i + 1;} // Left Branch
	public int right (int i){return 2*i + 2;} // Right Branch
	 */
	//  if left B is a child node of parent A, then key(A) ≥ key(B). 
	// This implies that an element with the greatest key is always in the root node. [max-heap]
	
	private static int[] A;
	private static int heapSize;
	
	// heapSort : Array --> Array [Sorted]
	// Purpose: To sort an array, eventually !
	public void heapSort(int[] anArray){
		A = anArray;
		heapSize = anArray.length;
		buildMaxHeap(); 
		while(heapSize >= 1) {
			heapSize--;
			exchange(0, heapSize);
			maxHeapify(0);
		}
	}
	// Purpose: To create a maximum heap 
	public void buildMaxHeap(){
		for(int i = (heapSize / 2) - 1 ; i >= 0 ; i--)
			maxHeapify(i); 
	}
	
	//Template:

	/*
	CORMEN VERSION: But didn't Work !
	
	public void maxHeapify(int i){
		int l = left(i); //Left Branch
		int r = right(i); //Right Branch
		int largest;
		if (l <= heapSize && (A[l] > A[r])){
			largest = l;
		}
		else{ largest = i; }
		if (r <= heapSize && (A[r] > A[largest])){
			largest = r;
		}
		if (largest != i){
			exchange(i, largest);
			maxHeapify(largest);
		}
	}
	*/
	
	
	// My Version of maxHeapify !
	// Purpose: To create a valid heap according to heap properties.
	public void maxHeapify(int i){
		int l = 2*i + 1; // index of Left branch node.
		//int r = l + 1; // index of Right branch node.
		while (l < heapSize)
        {
            if (l+1 < heapSize) 
                if (A[l+1]>A[l]) 
                	l++;
            if (A[i] >= A[l]) 
            	return;  // i is suitable for Heap         
            exchange(i, l); 
            i = l;        // continue
            l = 2*i+1;
        }
    }
	// Purpose: To swap two elements in a given array with given index.
	public void exchange(int i, int largest) {
		int temp = A[i];
		A[i] = A[largest];
		A[largest] = temp;
	}
	// Function call !
	public void sortIntArray(int[] a)
	{
	heapSort(a);
	}
	// Test are in another file !
}