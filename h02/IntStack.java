public class IntStack {
	// May create private data here.
    private int stack[];
    private int index;
   

	public IntStack() {
		// TODO: Code to initialize your stack.
        stack = new int[100];
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
            stack[index] = x;
            index++;
	}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
        if (index == 0) {
            return -1;
        }
        return stack[--index];
	}

    public int size() {
        return index;
    }
}
