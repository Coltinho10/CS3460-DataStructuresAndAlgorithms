import java.util.Scanner;
import java.lang.Math;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
	    PriorityQueue pq = new PriorityQueue(1);
        double initialArea = (b - a) * f(b);
        Interval firstInterval = new Interval(a,b);
        pq.insert(firstInterval);
        double newArea;
        while (true) {
            Interval interval = pq.remove_max();
            double leftSide = interval.getStart(); //m
            double rightSide = interval.getEnd();  //n
            double middle = (leftSide + rightSide) / 2; //p
            newArea = initialArea - ((rightSide - leftSide) * f(rightSide)) + ((middle - leftSide) * f(middle)) +
                ((rightSide - middle) * f(rightSide));

            Interval leftInterval = new Interval(leftSide, middle);
            Interval rightInterval = new Interval(middle, rightSide);
            pq.insert(leftInterval);
            pq.insert(rightInterval);
            //initialArea = newArea;
            if (Math.abs(newArea - initialArea) <= error) {
                initialArea = newArea;
                break;
            }
            initialArea = newArea;
        }
        
        	
		return initialArea; // Remove this statement and return the computed area.
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
