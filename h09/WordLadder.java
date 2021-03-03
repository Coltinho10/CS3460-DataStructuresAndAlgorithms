import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
						   // The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q;				// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();
        kb.close();
		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.
        boolean match = false;
        Q = new Queue();
        R = new StringMap();
        Q.enqueue(new QNode(0, start));
        R.insert(start, "");
        
        if (start.equals(end)) {
            match = true;
        }
        while (match == false && Q.isEmpty() == false) {
            QNode dq = Q.dequeue();
            if (bfs(dq) == true) {
                match = true;
            }
        }
        if (match == true) {
            System.out.println("Yay! A word ladder is possible.");
            //print(end);
        }
        else if (match == false) {
            System.out.println("Duh! Impossible");
        }
	}

    public static boolean bfs(QNode q) {
        String str = q.getWord();

        for (int i = 0; i < str.length(); i++) {
            StringBuffer sb = new StringBuffer(str);
            for (char c = 97; c <= 122; c++) {
                sb.setCharAt(i, c);
                if (sb.toString().equals(end)) {
                    R.insert(end, str);
                    return true;
                }
                if (R.find(sb.toString()) == null && T.find(sb.toString()) != null) {
                    Q.enqueue(new QNode(q.getDist() + 1, sb.toString()));
                    R.insert(sb.toString(), str);
                }
            }
        }
        return false;
    }

    public static void print(String s) {
        if (s == null) {
            return;
        }
        StringNode sn = R.find(s);
        print(sn.getValue());
        System.out.println(s);
    }



}
