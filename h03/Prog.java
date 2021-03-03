import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.
        
        HashFunctions hash = new HashFunctions(n);
        for (int i = 0; i < n * 10; i++)
        {
            int hashCode = hash.hash1(i); 
            if (hashCode % 10 == 0)
            {
                System.out.println(i);
            }
        }
	}

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	
	    
        HashFunctions hash = new HashFunctions(n);
        for (int i = 0; i < n; i++)
        {
            int hashCode = hash.hash2(i);
            if (hashCode % 10 == 0)
            {
                System.out.println(i);
            }
        }
    }

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	
        
        HashFunctions hash = new HashFunctions(n);
        Node array[] = new Node[n];
        int count[] = new int[n];
        int p = 128189;
        int C = n * n;
        int test = 0;
        Node node = new Node(0, null);
        for (int i = 0; i < C; i++)
            {
                int hashCode = hash.hash3(i);
                node = new Node(i, array[hashCode]);
                array[hashCode] = node;
                count[hashCode]++; 
            }

            int largest = 0;
            int indexNum = 0;
            for (int j = 0; j < n; j++)
            {
                if (count[j] > largest)
                {
                    largest = count[j];
                    indexNum = j;
                    
                }
            }
            node = array[indexNum];
            int counter = 0;
            while (node != null && counter < n)
            {
                System.out.println(node.digit);
                node = node.next;
                counter++;
            }
    }

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	
        int C = n * n;
        HashFunctions hash = new HashFunctions(n);
        Node array[] = new Node[n];
        int count[] = new int[n];
        Node node = new Node(0, null);
        int counter = 0; 
        for (int i = 0; i < C; i++)
        {
            int hashCode = hash.hash4(i);
            node = new Node(i, array[hashCode]);
            array[hashCode] = node;
            count[hashCode]++;

            if (count[hashCode] >= n)
            {
                while (node != null && counter < n)
                {
                    System.out.println(node.digit);
                    node = node.next;
                    counter++;
                }
            }
        }
        
        int largest = 0;
        int indexNum = 0;
        for (int j = 0; j < n; j++)
        {
            if (count[j] > largest)
            {
                largest = count[j];
                indexNum = j;
            }
        }
    }
}
