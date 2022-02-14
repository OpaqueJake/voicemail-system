// Jacob Fisher

import java.util.*;

public class theMailbox {
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
				case 1:
					if(vmSystem.User[0] == vmSystem.Callers[0]) {
						theMessageQueue.viewNewMessagec1();
					} else if(vmSystem.User[0] == vmSystem.Callers[1]) {
						theMessageQueue.viewNewMessagec2();
					}
					break;
				case 2:
					if(vmSystem.User[0] == vmSystem.Callers[0]) {
						theMessageQueue.viewSavedMessagesc1();
					} else if(vmSystem.User[0] == vmSystem.Callers[1]) {
						theMessageQueue.viewSavedMessagesc2();
					}
					break;
				case 3:
					System.out.println(vmSystem.getCurrentCaller().getGreeting());
					System.out.println("\n\sSending you back to previous Menu...\n");
					mailboxMenu();
					break;
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
				case 6:
					vmSystem.callsPhone(vmSystem.getCurrentCaller());
					break;
			}	
		}
	}
	
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
