import java.util.Scanner;

public class MolecularMass {

    private IntStack stack;
    //public int num = 0;

    public static void main(String[] args) {

        //stack = new IntStack();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the molecule: ");
        String input = scan.nextLine();
        int result = evaluate(input);
        System.out.println("The Molecular Mass of " + input + " is " + result);
    }


    public static int evaluate(String s) {
        IntStack stack = new IntStack();    
        int num = 0;
        int answer = 0;
        int sentinal = 0;
        int hold = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            switch(c) {
                case 'H':
                    num = 1;
                    stack.push(num);
                    break;
                case 'C':
                    num = 12;
                    stack.push(num);
                    break;
                case 'O':
                    num = 16;
                    stack.push(num);  
                    break;
                case '(':
                    stack.push(sentinal);
                    break;
                case ')':
                    hold = 0;
                    temp = stack.pop();
                    while (temp != 0) {
                        hold += temp;
                        temp = stack.pop();
                        //stack.push(hold);
                    }
                    stack.push(hold);
                    break;
                case '2':
                    temp = stack.pop() * 2;
                    stack.push(temp);
                    break;
                case '3':
                    temp = stack.pop() * 3;
                    stack.push(temp);
                    break;
                case '4':
                    temp = stack.pop() * 4;
                    stack.push(temp);
                    break;
                case '5':
                    temp = stack.pop() * 5;
                    stack.push(temp);
                    break;
                case '6':
                    temp = stack.pop() * 6;
                    stack.push(temp);
                    break;
                case '7':
                    temp = stack.pop() * 7;
                    stack.push(temp);
                    break;
                case '8':
                    temp = stack.pop() * 8;
                    stack.push(temp);
                    break;
                case '9':
                    temp = stack.pop() * 9;
                    stack.push(temp);
                    break;

            }            
        }
        for (;;) {
            temp = stack.pop();
            if(temp == -1){

                break;}
            answer += temp;
        }
        return answer;
    }
}
