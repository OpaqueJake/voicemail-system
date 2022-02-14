// Jacob Fisher

import java.util.*;

public class theMessageQueue {
	
	static int currentc1 = 0;
	static int currentc2 = 0;
	
	public static void viewNewMessagec1() {
		if(mailBox.newMessageQueuec1.isEmpty()) {
			System.out.println("\sYou do not currently have any new messages!\n\n\sTaking you back to previous menu.\n");
			theMailbox.mailboxMenu();
		} else {
			System.out.println("\sRetrieving your new messages... \n");
			String newMessage = mailBox.newMessageQueuec1.poll();
			System.out.println("\sMessage: '" + newMessage + "'");
			System.out.println("\n\sWould you like to save this message?");
			System.out.println("\t -Type 1 to save this message.");
			System.out.println("\t -Type 2 to delete this message.");
			Scanner input = new Scanner(System.in);
			String c = input.nextLine();
			if(!c.equalsIgnoreCase("h")) {
				int choose = Integer.valueOf(c);
				switch(choose){
					case 1:
						System.out.println("\sMessage saved!\n");
						mailBox.saveMessagec1(newMessage);
						viewNewMessagec1();
						break;
					case 2:
						System.out.println("\sMessage deleted!\n");
						viewNewMessagec1();
						break;
				}
			} else {
				vmSystem.endsCall();
			}
		}
	}
	public static void viewSavedMessagesc1() {
		if(mailBox.savedMessageQueuec1.isEmpty()) {
			System.out.println("\sYou do not have any saved messages!\n\n\sTaking you back to previous menu.\n");
			theMailbox.mailboxMenu();
		} else {
			System.out.println("\sRetrieving your saved messages... \n");
			if(mailBox.savedMessageQueuec1.get(currentc1) == mailBox.savedMessageQueuec1.getLast()) {
				String m = mailBox.getNextc1(currentc1);
				System.out.println("\sMessage: '" + m + "'\n");
				System.out.println("\t -Type 1 to go to the next message");
				System.out.println("\t -Type 2 to delete this message.");
				Scanner input = new Scanner(System.in);
				String c = input.nextLine();
				if(!c.equalsIgnoreCase("h")) {
					int choose = Integer.valueOf(c);
					switch(choose){
						case 1:
							System.out.println("\sYou do not have any more saved messages!\n\n\sTaking you back to previous menu.\n");
							currentc1 = 0;
							theMailbox.mailboxMenu();
							break;
						case 2:
							System.out.println("\sMessage deleted!\n");
							mailBox.deleteSavedMessagec1();
							System.out.println("\sYou do not have any more saved messages!\n\n\sTaking you back to previous menu.\n");
							currentc1 = 0;
							theMailbox.mailboxMenu();
							break;
					}
				} else {
					vmSystem.endsCall();
				}
			} else {
				String message = mailBox.getNextc1(currentc1);
				++currentc1;
				System.out.println("\sMessage: '" + message + "'\n");
				System.out.println("\t -Type 1 to go to the next message");
				System.out.println("\t -Type 2 to delete this message.");
				Scanner input = new Scanner(System.in);
				String c = input.nextLine();
				if(!c.equalsIgnoreCase("h")) {
					int choose = Integer.valueOf(c);
					switch(choose){
						case 1:
							viewSavedMessagesc1();
							break;
						case 2:
							System.out.println("\sMessage deleted!\n");
							int q1 = currentc1; 
							if(q1 - 1 == 0) {
								mailBox.deleteSavedMessagec1();
								currentc1 = 0;
							} else {
								q1 = q1-1;
								mailBox.deleteSavedMessagec1(q1);
								--currentc1;
							}
							viewSavedMessagesc1();
							break;
					}
				} else {
					vmSystem.endsCall();
				}
			}
		}
	}
	public static void viewNewMessagec2() {
		if(mailBox.newMessageQueuec2.isEmpty()) {
			System.out.println("\sYou do not currently have any new messages!\n\n\sTaking you back to previous menu.\n");
			theMailbox.mailboxMenu();
		} else {
			System.out.println("\sRetrieving your new messages... \n");
			String savedMessage = mailBox.newMessageQueuec2.poll();
			System.out.println("\sMessage: '" + savedMessage + "'");
			System.out.println("\n\sWould you like to save this message?");
			System.out.println("\t -Type 1 to save this message.");
			System.out.println("\t -Type 2 to delete this message.");
			Scanner input = new Scanner(System.in);
			String c = input.nextLine();
			if(!c.equalsIgnoreCase("h")) {
				int choose = Integer.valueOf(c);
				switch(choose){
					case 1:
						System.out.println("\sMessage saved!\n");
						mailBox.saveMessagec2(savedMessage);
						viewNewMessagec2();
						break;
					case 2:
						System.out.println("\sMessage deleted!\n");
						viewNewMessagec2();
						break;
				}
			} else {
				vmSystem.endsCall();
			}
		}
	}
	public static void viewSavedMessagesc2() {
		if(mailBox.savedMessageQueuec2.isEmpty()) {
			System.out.println("\sYou do not have any saved messages!\n\n\sTaking you back to previous menu.\n");
			theMailbox.mailboxMenu();
		} else {
			System.out.println("\sRetrieving your saved messages... \n");
			if(mailBox.savedMessageQueuec2.get(currentc2) == mailBox.savedMessageQueuec2.getLast()) {
				String m = mailBox.getNextc2(currentc2);
				System.out.println("\sMessage: '" + m + "'\n");
				System.out.println("\t -Type 1 to go to the next message");
				System.out.println("\t -Type 2 to delete this message.");
				Scanner input = new Scanner(System.in);
				String c = input.nextLine();
				if(!c.equalsIgnoreCase("h")) {
					int choose = Integer.valueOf(c);
					switch(choose){
						case 1:
							System.out.println("\sYou do not have any more saved messages!\n\n\sTaking you back to previous menu.\n");
							currentc2 = 0;
							theMailbox.mailboxMenu();
							break;
						case 2:
							System.out.println("\sMessage deleted!\n");
							mailBox.deleteSavedMessagec2();
							System.out.println("\sYou do not have any more saved messages!\n\n\sTaking you back to previous menu.\n");
							currentc2 = 0;
							theMailbox.mailboxMenu();
							break;
					}
				} else {
					vmSystem.endsCall();
				}
			} else {
				String message = mailBox.getNextc2(currentc2);
				++currentc2;
				System.out.println("\sMessage: '" + message + "'\n");
				System.out.println("\t -Type 1 to go to the next message");
				System.out.println("\t -Type 2 to delete this message.");
				Scanner input = new Scanner(System.in);
				String c = input.nextLine();
				if(!c.equalsIgnoreCase("h")) {
					int choose = Integer.valueOf(c);
					switch(choose){
						case 1:
							viewSavedMessagesc2();
							break;
						case 2:
							System.out.println("Message deleted!\n");
							int q2 = currentc2; 
							if(q2 - 1 == 0) {
								mailBox.deleteSavedMessagec2();
								currentc2 = 0;
							} else {
								q2 = q2-1;
								mailBox.deleteSavedMessagec2(q2);
								--currentc2;
							}
							viewSavedMessagesc2();
							break;
					}
				} else {
					vmSystem.endsCall();
				}
			}
		}
	}
}
