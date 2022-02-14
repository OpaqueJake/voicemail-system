// Jacob Fisher

import java.util.*;

public class vmSystem {
	
	public static Caller[] Callers = new Caller[2];
	public static Caller[] User = new Caller[2];
	private static Caller currentCaller;
	private static Caller receiver;
	public static int counter;
	
	public vmSystem(Caller a, Caller b) {
		counter = 0;
		setCurrentCaller(a);
		setReceiver(b);
		User[0] = currentCaller;
		User[1] = receiver;
		Callers[0] = currentCaller;
		Callers[1] = receiver;
		vmSystem.callsPhone(currentCaller);
	}
	
	public static Caller getCurrentCaller() {
		return currentCaller;
	}
	public static void setCurrentCaller(Caller currentCaller) {
		vmSystem.currentCaller = currentCaller;
		Callers[0] = currentCaller;
	}
	
	public static Caller getReceiver() {
		return receiver;
	}
	public static void setReceiver(Caller receiver) {
		vmSystem.receiver = receiver;
		Callers[1] = receiver;
	}

	public static void callsPhone(Caller a) {
		System.out.println("\s " + ((Caller) Callers[0]).getOwnerName()+ " has reached the Voicemail System Menu!");
		System.out.println("\t -Enter 1 to call someones Mailbox");
		System.out.println("\t -Enter 2 to call your Mailbox");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		if(s.equalsIgnoreCase("h")) {
			if(counter == 0) {
				vmSystem.endsCall();
			}else {
				vmSystem.endsCall();
			}
		} else {
			int check = Integer.valueOf(s);
			switch(check) {
			case 1:
				System.out.println("\sWhat is the Extention # for the Mailbox you wish to leave a message for?");
				String extention = input.nextLine();
				if(!extention.equalsIgnoreCase("h")) {
					int ext = Integer.valueOf(extention);
					isExt(ext);
					System.out.println("\n\sMessage:");
					for(int i = 1; i > 0; ++i) {
						String z = input.nextLine();
						if(!z.equalsIgnoreCase("h")) {
							if(vmSystem.User[0] == vmSystem.Callers[0]) {
								mailBox.addMessagec2(z);
								counter = 0;
							} else {
								mailBox.addMessagec1(z);
								counter = 0;
							}
						} else {
							i = -1;
						}
					}
					vmSystem.endsCall();	
				} else {
					vmSystem.endsCall();
				}
				break;
			case 2:
				System.out.println("\sRouting to your Mailbox...\n");
				theMailbox.login();
				break;
			}
		}
		return;
	}

	public static void endsCall() {
		if(counter == 0) {
			++counter; 
			System.out.println("\s" + Callers[0].getOwnerName() + " hung up!\n");
			Caller swap = vmSystem.getCurrentCaller();
			setCurrentCaller(receiver);
			setReceiver(swap);
			vmSystem.callsPhone(currentCaller);
		} else {
			System.out.println("\s" + Callers[0].getOwnerName() + " hung up!\n");
		}
	}
	
	public static void isExt(int ext) {
		if (ext == Callers[1].getExt()) {
			System.out.println("\sYou entered " + Callers[1].getOwnerName() + "'s extention!\n");
			System.out.println(Callers[1].getGreeting());
		} else {
			System.out.println("\sTry again. Extention #:");
			Scanner input = new Scanner(System.in);
			String extention = input.nextLine();
			if(!extention.equalsIgnoreCase("h")) {
				int Ext = Integer.valueOf(extention);
				isExt(Ext);
			} else {
				vmSystem.endsCall();
			}
		}
	}
}
