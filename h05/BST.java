
public class BST {
	private Node root; // The root node of the tree.
    private Node small; //The smallest node of the tree.
    private Node big; //The biggest node of the tree.
	public BST() {
		root = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
		// TODO: Code for insert here.
        root = insert(root, time, req_index);
	}

    private Node insert(Node x, int time, int req_index) {
        if (x == null) return new Node(time, req_index);
        if (x.getTime() >= time) {
           x.setLeft(insert(x.getLeft(), time, req_index));
        }
        else {
           x.setRight(insert(x.getRight(), time, req_index));
        }
        return x;
    }

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
		// TODO: code for pred here.
        small = null;
		return pred(time, root);
	}

    private Node pred(int time, Node x) {
        if (x == null) return null;
        if (x.getTime() == time) {
            if (x.getLeft() != null) {
                return max(x.getLeft());
            }
            else if (min().getTime() == x.getTime()) {
                return x.getLeft();
            }
            else {
                return small;
            }
        }
        else if (x.getTime() > time) {
            return pred(time, x.getLeft());
        }
        else {
            small = x;
            return pred(time, x.getRight());
        }
    }

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	public Node succ(int time) {
		// TODO: code for succ here.
        big = null;
		return succ(time, root);
	}

    private Node succ(int time, Node x) {
        if (x == null) return null;
        if (x.getTime() == time) {
            if (x.getRight() != null) {
                return min(x.getRight());
            }
            else if (max().getTime() == time) {
                return x;
            }
            else {
                return big;
            }
        }
        else if (x.getTime() > time) {
            big = x;
            return succ(time, x.getLeft());
        }
        else {
            return succ(time, x.getRight());
        }
    }

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
    public Node min() {
        return min(root);
    }

	private Node min(Node x) {
		// TODO: Code for min here.
		if (x.getLeft() == null) {
            return x;
        }
        return min(x.getLeft());
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
    public Node max() {
        return max(root);
    }

	private Node max(Node x) {
		// TODO: Code for max here.
	    if (x.getRight() == null) {
            return x;
        }
        return max(x.getRight());
    }

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
		// TODO: Code for delete here.
        delete(root, time);
	}

    private Node delete(Node x, int time) {
        if (x == null) return null;
        if (x.getTime() == time) {
            if (x.getLeft() == null && x.getRight() == null) return null;
            if (x.getLeft() != null && x.getRight() == null) return x.getLeft();
            if (x.getLeft() == null && x.getRight() != null) return x.getRight();
            if (x.getLeft() != null && x.getRight() != null) {
                Node succer = succ(x.getTime());
                x.setTime(succer.getTime());
                x.setReq_index(succer.getReq_index());
                delete(x.getLeft(), x.getTime());
            }
        }
        if (time < x.getTime()) {
            x.setLeft(delete(x.getLeft(), time));
            return x;
        }
        if (time > x.getTime()) {
            x.setRight(delete(x.getRight(), time));    
            return x;
        }
        return x;
    }
	/**
		Prints the contents of the tree in sorted order.
	**/
    public void print() {
        print(root);
    }

	private void print(Node x) {
		// TODO: Code for print here.
        if (x == null) {
            return;
        }
        print(x.getLeft());
        System.out.println(x.toString());
        print(x.getRight());
	}

}
