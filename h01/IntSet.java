/*
 * This class maintains a set of ints. 
 */
public class IntSet {
    private Node start;
	//private int set[];
    //private int capacity;
    public int size;
    //public int length = 0;
    //public int index = 0;

	public IntSet() {
		Node start = new Node(0, null);
        //Node ins = new Node(0, null);
	}
	
	/* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
	public boolean find(int key) 
    {
        Node search = start;
        while (search != null)
        {
            
            if (search.digit == key)
            {
                return true;
            }
            search = search.next;
        }
        return false;
	}
	
	/* Insert a key into the set. */
	public void insert(int key) 
    {
		// Make sure that the key is not present.
		assert (!find(key));
	    
           //Create a node to hold the key
           //Create third node to traverse the list 
           Node hold = new Node(key, null);
           Node search = new Node(0, null); 
           search = start;
           //While not at end of list
           if (search != null)
           {
                while (search.next != null)
                   {
                       search = search.next;
                       size++;
                   }
           //Node that traverses the list now holds the key
           search.next = hold;
           }

           else
           {
               start = hold;
           }
     
	}
	
	/* Remove a key from the set. */
	public void remove(int key) {
		// Make sure that the key is present.
		assert (find(key));
	    
        	
        Node search = start;
        //search = search.next;
        Node prec = start;
        while (search != null)
            {
                if (search.digit == key)
                           {
                               prec.next = search.next;
                           }
                search = search.next;
                prec = search;
            }
	}
	
	/* Print the contents of the set in sorted order. */
	public void print() {
        int[] set = new int[size];
		int temp1 = 0;
        int temp2 = 0;
        int index = 0;
        int length = 0;
        //Node start = new Node(0, null);
        Node search = start;
        if (search != null)
        {
            while (search.next != null) 
            {
                search = search.next;
                temp1 = search.digit;
                set[index] = temp1;
                index++;
                length++;
            }
        }
        //System.out.println("The length is " + length);
        //System.out.println("The index is " + index);
        for (int i = 0; i < length; i++)
        {
            for (int j = i + 1; j < length; j++)
            {
                if (set[i] > set[j])
                {
                    temp2 = set[i];
                    set[i] = set[j];
                    set[j] = temp2;
                }
            }
        }
        for (int k = 0; k < length; k++)
        {
            System.out.println(set[k]);
        }
	}
}
