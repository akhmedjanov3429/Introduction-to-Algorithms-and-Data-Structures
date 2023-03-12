import java.util.*;

public class Reverse
{
	public static void reverse(String[] arr) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();
		}
	}

    public static void main(String[] args)
    {
		String[] arr = StdIn.readAllStrings();
		reverse(arr);
		for (int i = 0; i < arr.length; i++) {
			StdOut.println(arr[i]);
		}
        return;
    }
}