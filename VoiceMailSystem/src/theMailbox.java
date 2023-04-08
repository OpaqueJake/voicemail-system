// Jacob Fisher

import java.util.*;

public class theMailbox {
	// The current caller gets access to their mailbox which they can go through options based on that
	public static void mailboxMenu() {
		System.out.println("\sPersonal Mailbox Menu:");
		System.out.println("\t -Enter 1 to view New Messages");
		System.out.println("\t -Enter 2 to view Saved Messages");
		System.out.println("\t -Enter 3 to view Greeting");
		System.out.println("\t -Enter 4 to change Greeting");
		System.out.println("\t -Enter 5 to change Password");
		System.out.println("\t -Enter 6 to return to Voicemail System Menu");
		Scanner input = new Scanner(System.in);
		String pickinMenu = input.nextLine();
		
		if(pickinMenu.equalsIgnoreCase("h")) {
			vmSystem.endsCall();
		} else {
			int pick = Integer.valueOf(pickinMenu);
			switch(pick) {
				// Case 1: views new messages, which once seen, are no longer considered "new" and are taken off the new message list
				//         that was sent to the current caller
				case 1:
					if(vmSystem.User[0] == vmSystem.Callers[0]) {
						theMessageQueue.viewNewMessagec1();
					} else if(vmSystem.User[0] == vmSystem.Callers[1]) {
						theMessageQueue.viewNewMessagec2();
					}
					break;
				// Case 2: views saved messages in the order they were saved from the new message list that was sent to the current caller
				case 2:
					if(vmSystem.User[0] == vmSystem.Callers[0]) {
						theMessageQueue.viewSavedMessagesc1();
					} else if(vmSystem.User[0] == vmSystem.Callers[1]) {
						theMessageQueue.viewSavedMessagesc2();
					}
					break;
				// Case 3: views the greeting that is associated with the current caller
				case 3:
					System.out.println(vmSystem.getCurrentCaller().getGreeting());
					System.out.println("\n\sSending you back to previous Menu...\n");
					mailboxMenu();
					break;
				// Case 4: allows for current caller to change their greeting that the other caller will see if they call
				case 4:
					System.out.println("\sChange Greeting:");
					String cgreeting =  input.nextLine();
					if(!cgreeting.equalsIgnoreCase("h")) {
						vmSystem.getCurrentCaller().setGreeting(cgreeting);
						mailboxMenu();
					}else {
						vmSystem.endsCall();
					}
					break;
				// Case 5: allows current caller to change their password
				case 5:
					System.out.println("\sChange Password:");
					String cpassword =  input.nextLine();
					if(!cpassword.equalsIgnoreCase("h")) {
						confirmPassword(cpassword);
						mailboxMenu();
					}else {
						vmSystem.endsCall();
					}
					break;
				// Case 6: goes back to the previous menu
				case 6:
					vmSystem.callsPhone(vmSystem.getCurrentCaller());
					break;
			}	
		}
	}
	// Has the current caller re-enter their password before finalizing the password change for security
	public static void confirmPassword(String a) {
		Scanner input = new Scanner(System.in);
		System.out.println("\sPlease re-enter your new password to confirm: ");
		String newpassword =  input.nextLine();
		if(a.equals(newpassword)) {
			vmSystem.getCurrentCaller().setPassword(newpassword);
			System.out.println("\sYour new password has been set!\n");
		} else {
			System.out.println("\sWrong password entered, password has not been changed.\n");
		}
	}
	// Has the current caller login to their mailbox using their password to get access to their messages, greeting, etc
	public static void login() {
		System.out.println("\sEnter Password: ");
		Scanner input = new Scanner(System.in);
		String pass = input.nextLine();
		
		if(!pass.equalsIgnoreCase("h")) {
				if(pass.equals(vmSystem.getCurrentCaller().getPassword())) {
					System.out.println("\sYou're in!\n");
					mailboxMenu();
				} else {
					System.out.println("\sSorry, wrong password! Try again.\n");
					login();
				}
		} else{
			vmSystem.endsCall();
		}
	}	
}
