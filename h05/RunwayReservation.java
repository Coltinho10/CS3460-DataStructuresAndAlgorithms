import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.

        BST tree = new BST();
        int request;
        Node pred;
        Node succ;
        for (int j = 0; j < n; j++) {
            if (reqs[j].getCommand().equals("r")) {
                //System.out.println("---NEW ITERATION---");
                request = reqs[j].getTime();
                //System.out.println(request);
                pred = tree.pred(request);
                succ = tree.succ(request);
                //System.out.println(pred);
                //System.out.println(succ);
                if (pred != null && succ != null) {
                    if (request - k > pred.getTime() && request + k < succ.getTime()) {
                        tree.insert(request, j);
                    }
                }

                else if (pred != null && succ == null) {
                    if (request - k > pred.getTime()) {
                        tree.insert(request, j);
                    }
                }

                else if (pred == null && succ != null) {
                    if (request + k < succ.getTime()) {
                        tree.insert(request, j);
                    }
                }

                else if (pred == null && succ == null) {
                    tree.insert(request, j);
                }
            }
            else if (reqs[j].getCommand().equals("t")) {
                   curtime += reqs[j].getTime();
                   System.out.println("Current time = " + curtime + " units");
                    while(tree.min().getTime() < curtime) {
                        System.out.println(reqs[tree.min().getReq_index()].getAirline());
                        tree.delete(tree.min().getTime());
                        //min = tree.min();
                    }
            }
        }
        int maxTime = tree.max().getTime();
        System.out.println("Current time = " + maxTime + " units");
        Node min = tree.min();
        while (min != null) {
            System.out.println(reqs[min.getReq_index()].getAirline());
            tree.delete(min.getTime());
            min = tree.succ(min.getTime());
        }

	}
}
