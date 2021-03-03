
public class ListSmallest {

    int k = 5000;
	public static void main(String [] args) {
		
		// Creating an instance of MyList.
		MyList L = new MyList();
		
        // Get the head of the linked list.
		ListNode head = L.getHead();
		
        // Create an object of this program to avoid static context.
		ListSmallest l = new ListSmallest();

		// head is the head of my linked list L. 
		// TODO: please write a function to print the minimum element in this list. 
        // Please store this in the variable m.

		int m = 17; // Random Number we use in class
        l.getSmall(m, head, 0);

        System.out.println("The smallest is " + m);
	}

    public int getSmall(int m, ListNode head, int depth)
    {
        if (head == null) return m;
            if (depth < k)
            {
                   if (head.next.num < head.num)
                   {
                       m = head.next.num;
                       depth++;
                       runLoop(m, head, depth);
                       if (depth == k)
                       {
                           k += 5000;
                       }
                   }
                   head = head.next;
            }
        return m;
    }


    private void runLoop(int m, ListNode head, int depth)
    {
        
        if (depth < k)
        {
            getSmall(m, head, depth);
        }
    }
}
