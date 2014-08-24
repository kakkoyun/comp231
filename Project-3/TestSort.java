import java.util.Random;

class TestSort
{
    static int[] randomArray(int len) 
    {
        Random r = new Random();
        int[] a = new int[len];
        for(int i = 0; i < len; i++) 
                a[i] = r.nextInt(len);
        return a;
    }

    static int[] orderedArray(int len) 
    {
        int[] a = new int[len];
        for(int i = 0; i < len; i++) 
                a[i]=i;
        return a;
    }
   // A Funtion to generate suitable data [Descending array] to test Ascending function.
   static int[] reverseSorted(int len){
    	int[] anArray = new int[len];
    	for (int i = 0; i < anArray.length; i++){
    	  anArray[i]= anArray.length - i;
    }
	return anArray;
      }
    /**
       Helper function to print an array for debugging purposes
    */
    static void printArray(int[] a, String msg) 
    {
        System.console().format("%s ( ", msg);
        for (int i=0; i<a.length;i++) 
            System.console().format("%d ",a[i]);
        System.console().format(" )\n");
    }
    
    static boolean isSorted(int[] arr)
    {
        int i;
        for (i = 0 ; i < arr.length - 1 ; i++)
            if (arr[i] > arr[i+1])
                return false;
        return true;
    }   
    
    public static int[] cloneArray(int[]arr)
    {   
        int i;
        int [] clone = new int[arr.length];
        for (i = 0;i < arr.length; i++)
            clone[i] = arr[i];
        return clone;
    }
 
    static void testOneSort(int[] a, SortIntArray as, String sortName) 
    {
        long startTime=System.currentTimeMillis();
        as.sortIntArray(a);        
        long endTime=System.currentTimeMillis();
        if (isSorted(a))
        {
            System.console().format(sortName + " time = %d \n", endTime-startTime);
        }
        else
        {
            System.console().format(
                "%s sort failed\n", sortName);
            printArray(a,"Broken Array: ");
        }
    }
    
    /**
       Main function to test algorithms 
	command line input is a list of array sizes to test.
    */
    public static void main(String[] args) 
    {
        int len,i;
        int[] a;
        int[] b;
        int[] c;
        if (args.length < 1)
        {
        	System.console().format("Command line is java TestSort <sizetosort> ... ");
            return;
        }
        /*
        CSV style output headers
        */
        System.console().format("(c)Chris Stephenson 2008-2011 - Insertion Sort, Tests and Project Framework\n" + "(c)Kemal Akkoyun 2011 - QuickSort, CormenMergeSort and HeapSort\n");
        for (i = 0; i < args.length ; i++)
        {
            len = Integer.parseInt(args[i]);
            System.console().format("Length = %d\n", len);
            
            a = randomArray(len);
            b = reverseSorted(len);
            c = orderedArray(len);

          testOneSort(cloneArray(a),new InsertSort(),"Insert with Random Array          ");
          testOneSort(cloneArray(b),new InsertSort(),"Insert with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new InsertSort(),"Insert with Ordered Array         ");
          
          testOneSort(cloneArray(a),new CormenInsertSort(),"Cormen Insert with Random Array          ");
          testOneSort(cloneArray(b),new CormenInsertSort(),"Cormen Insert with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new CormenInsertSort(),"Cormen Insert with Ordered Array         ");
          
          testOneSort(cloneArray(a),new MergeSort(),"Merge Sort Random Array               ");
          testOneSort(cloneArray(b),new MergeSort(),"Merge Sort with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new MergeSort(),"Merge Sort with Ordered Array         ");
          
          testOneSort(cloneArray(a),new CormenMergeSort(),"Cormen Merge Random Array               ");
          testOneSort(cloneArray(b),new CormenMergeSort(),"Cormen Merge with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new CormenMergeSort(),"Cormen Merge with Ordered Array         ");
          
          testOneSort(cloneArray(a),new QuickSort(),"Quick Sort Random Array               ");
          testOneSort(cloneArray(b),new QuickSort(),"Quick Sort with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new QuickSort(),"Quick Sort with Ordered Array         ");
          
          // ATTENTION: Both quickSorts are some how blowing with reverse ordered and ordered arrays, 
          // -- something pathologically (as Chris mentioned) or I have a silly mistake! Probably, there is a problem about java itsself!
          
          testOneSort(cloneArray(a),new CormenQuickSort(),"Cormen Quick Sort Random Array               ");
          testOneSort(cloneArray(b),new CormenQuickSort(),"Cormen Quick Sort with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new CormenQuickSort(),"Cormen Quick Sort with Ordered Array         ");
          
          testOneSort(cloneArray(a),new HeapSort(),"Heap Sort Random Array               ");
          testOneSort(cloneArray(b),new HeapSort(),"Heap Sort with Reverse Ordered Array ");
          testOneSort(cloneArray(c),new HeapSort(),"Heap Sort with Ordered Array         ");

            System.console().format("\n");
        }
    }
}
