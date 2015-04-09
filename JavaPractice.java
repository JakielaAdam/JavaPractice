import java.util.Arrays;
import java.util.Stack;

public class JavaPractice {

    public static void main(String[] args) {
        System.out.println("ARRAYS");
        int[] array = {1,6,7, 2, 3, 9, 8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        int seachIndex = binarySearch(array, 6, 0, array.length - 1);
        System.out.println(seachIndex);

        System.out.println("BALANCED PARAENTHESES");
        System.out.println(isBalanced("[{()()}]"));		//true
        System.out.println(isBalanced("[{()(}]"));		//false
        
    }

    //methods for is balanced
    static boolean isBalanced(String expr) {
    	//use Character because char is primitive
    	if(expr.length() == 0) return true;

    	Stack<Character> s = new Stack<Character>();
    	for(int x = 0; x < expr.length(); x++) {
    		char c = expr.charAt(x);

    		if(isOpening(c)) {
    			s.push(c);
    			continue;
    		} 

    		if(isClosing(c) && isClosingTo(s.peek(), c)) {
    			s.pop();
    		} else {
    			return false;
    		}
    	}
    	return true;
    }

    static boolean isOpening(char c) {
    	return (c == '(' || c == '{' || c == '[');
    }

    static boolean isClosing(char c) {
    	return (c == ')' || c == '}' || c == ']');
    }

    static boolean isClosingTo(char open, char close) {
    	if(open == '(' && close == ')') 
    		return true;
    	else if(open == '{' && close == '}') 
    		return true;
    	else if(open == '[' && close == ']') 
    		return true;
    	else 
    		return false;
    }

    //O(n^2)
    static void bubbleSort(int[] a) {
    	for(int k = 0; k < a.length -1; k++) {
	    	for(int i = 0; i < a.length - 1; i++) {
	    		if(a[i] > a[i+1]) {
	    			int temp = a[i];
	    			a[i] = a[i+1];
	    			a[i+1] = temp; 
	    		}	    		
	    	}
    	}
    }

    //recursive binary search algorithm
    static int binarySearch(int[] a, int key, int imin, int imax) {
    	if(imax < imin) {
    		return -1;
    	} else {
    		int imid = midpoint(imin, imax);

    		//comparisons
    		if(a[imid] > key) {
    			//key is in low subset
    			return binarySearch(a, key, imin, imid - 1);
    		} else if(a[imid] < key) {
    			//key is in high subset
    			return binarySearch(a, key, imid + 1, imax);
    		} else {
    			//we found the index
    			return imid;
    		}
    	}
    }

    //computes the midpoint of two numbers
    static int midpoint(int low, int high) {
    	return (high - low) / 2;
    }

    //recursion
    static int factorial(int n) {
    	if(n == 1) return 1;
    	return n * factorial(n-1);
    }
}