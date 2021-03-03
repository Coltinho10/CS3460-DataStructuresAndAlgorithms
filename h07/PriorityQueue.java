
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
            Interval [] heap2 = new Interval[size * 2];
            for (int i = 1; i < numElements; i++) {
                heap2[i] = heap[i];
            }
            heap = heap2;
            size = size * 2;
		}
        heap[numElements] = k;
        siftup(numElements);
        numElements++;
        // Insert without buffer expansion here.
	}
    
    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public void swap(int first, int second) {
        Interval temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }


    public void siftup(int i) {
        int p = parent(i);
        while (p != 0 && heap[i].compareTo(heap[p]) > 0) {
            swap(i, p);
            siftup(p);
            i = p;
            p = parent(i);
        }
    }

    
    public void siftdown(int i) {
        int l = left(i);
        int r = right(i);
        int big = 0;

        if (l >= numElements && r >= numElements) {
            return;
        }
        if (l <= numElements && r >= numElements) {
            big = l;
        }
        else if (l >= numElements && r <= numElements) {
            big = r;
        }
        else if (heap[l].compareTo(heap[r]) > 0) {
            big = l; 
        }
        else if (heap[l].compareTo(heap[r]) < 0) {
            big = r;
        }
        swap(i, big);
        siftdown(big);
        i = big;
        l = left(i);
        r = right(i);
    }

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
        Interval max = heap[1];
        swap(1, numElements - 1); //numElements - 1?
        numElements--;
        siftdown(1);
        return max; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}
