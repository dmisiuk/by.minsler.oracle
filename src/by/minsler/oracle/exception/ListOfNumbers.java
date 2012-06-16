package by.minsler.oracle.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListOfNumbers {

	private ArrayList<Integer> list;
	private final static int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() {
		String fileName = "/Users/minsler/test/outputfile.txt";
		PrintWriter out = null;

		try {
			out = new PrintWriter(new FileWriter(fileName));
			for (int i = 0; i < SIZE; i++) {
				out.println("Value " + i + " = " + list.get(i));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught ArrayIndexOutOfBoundsException "
					+ e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}

	}
}
