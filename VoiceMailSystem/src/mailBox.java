// Jacob Fisher

import java.util.*;

public class mailBox {
	
	static LinkedList<String> newMessageQueuec1 = new LinkedList<String>();
	static LinkedList<String> savedMessageQueuec1 = new LinkedList<String>();
	static LinkedList<String> newMessageQueuec2 = new LinkedList<String>();
	static LinkedList<String> savedMessageQueuec2 = new LinkedList<String>();

	public static void addMessagec1(String message) {
		if(!message.equalsIgnoreCase("h")) {
			newMessageQueuec1.add(message);
		} else {
			vmSystem.endsCall();
		}
	}
	public static String getNextc1(int i) {
		return savedMessageQueuec1.get(i);
	}
	public static void saveMessagec1(String sm) {
		savedMessageQueuec1.add(sm);
	}
	public static void deleteSavedMessagec1() {
		savedMessageQueuec1.remove();
	}
	public static void deleteSavedMessagec1(int c1) {
		savedMessageQueuec1.remove(c1);
	}
	public static void addMessagec2(String message) {
		if(!message.equalsIgnoreCase("h")) {
			newMessageQueuec2.add(message);
		} else {
			vmSystem.endsCall();
		}
	}
	public static String getNextc2(int i) {
		return savedMessageQueuec2.get(i);
	}
	public static void saveMessagec2(String sm) {
		savedMessageQueuec2.add(sm);
	}
	public static void deleteSavedMessagec2() {
		savedMessageQueuec2.remove();
	}
	public static void deleteSavedMessagec2(int c2) {
		savedMessageQueuec2.remove(c2);
	}
}
