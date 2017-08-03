package main;

import stream.DefaultStream;

public class StreamMain {
	@SuppressWarnings("static-access")
	public static void main(String args[]){
		String input = args[0];
		DefaultStream stream = new DefaultStream(input);
		System.out.println(stream.firstChar(stream));
	}
}
