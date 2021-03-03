import java.util.Scanner;
public class Jugs {
    int capA; //Capacity of A
    int capB; //Capacity of B
    int goal; //Target number
    boolean[][] visited; //Visited
    static int index;
    String[] stack;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter A: ");
        int a = scan.nextInt();
        System.out.print("Enter B: ");
        int b = scan.nextInt();
        System.out.print("Enter C: ");
        int c = scan.nextInt();
        
        Jugs jug = new Jugs(a, b, c);
        boolean correct = jug.dfs(0, 0);
        if (correct == true) {
            System.out.println("Yay! Found a solution.");
            while (index > 0) {
                System.out.println(jug.pop());
            }
        }
        else {
            System.out.println("Impossible!");
        }
    }
    public Jugs(int a, int b, int c) {
        capA = a;
        capB = b;
        goal = c;
        visited = new boolean[1000][1000];
        stack = new String[1000];
    }
    public boolean dfs(int a, int b) {
        int tempA;
        int tempB;
        if (a < 0 || a > capA) {
            return false;
        }
        if (b < 0 || a > capA) {
            return false;
        }
        if (a + b == goal) {
            return true;
        }

        boolean cur = false;
        if (visited[a][b] == true) {
            return false;
        }
        visited[a][b] = true;
        
        //Filling up A
        cur |= dfs(capA, b);
        if (cur == true) {
            tempA = capA;
            tempB = b;
            push("Fill Jug 1 [a = " + tempA + ", b = " + tempB + "]");
            return true;
        }
        //Filling up B
        cur |= dfs(a, capB);
        if (cur == true) {
            tempA = a;
            tempB = capB;
            push("Fill Jug 2 [a = " + tempA + ", b = " + tempB + "]");
            return true;
        }
        //Emptying A
        cur |= dfs(0, b);
        if (cur == true) {
            tempA = 0;
            tempB = b;
            push("Empty Jug 1 [a = " + tempA + ", b = " + tempB + "]");
            return true;
        }
        //Emptying B
        cur |= dfs(a, 0);
        if (cur == true) {
            tempA = a;
            tempB = 0;
            push("Empty Jug 2 [a = " + tempA + ", b = " + tempB + "]");
            return true;
        }
        int a2 = a;
        int b2 = b;
        //Pouring A into B, stop when B capacity is reached or A runs out
        while (a2 > 0 && b2 < capB) {
            a2--;
            b2++;
        }
        cur |= dfs(a2, b2);
        if (cur == true) {
            push("Pour Jug 1 -> Jug 2 [a = " + a2 + ", b = " + b2 + "]");
            return true;
        }
        a2 = a;
        b2 = b;
        //Pouring B into A, stop when A capacity is reached or B runs out
        while (a2 < capA && b2 > 0) {
            a2++;
            b2--;
        }
        cur |= dfs(a2, b2);
        if (cur == true) {
            push("Pour Jug 2 -> Jug 1 [a = " + a2 + ", b = " + b2 + "]");
            return true;
        }
        return false;
    }

    
    public void push(String x) {
        stack[index] = x;
        index++;
    }

    
    public String pop() {
        if (index == 0) {
            return "Invalid";
        }
        return stack[--index];
    }

    
    public int size() {
        return index;
    }
}
