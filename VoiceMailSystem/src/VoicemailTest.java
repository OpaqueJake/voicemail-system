// Jacob Fisher

public class VoicemailTest {
	public static void main(String[] args) {
		System.out.println("\n\sType H at anytime to hang up the call. \n");
		
		// Creates 2 caller objects, Rob and Victor, with a password and extention for each
		Caller Rob = new Caller("Rob", "r", 6184);
		Caller Victor = new Caller("Victor", "v", 9437);
		
		// Starts the voicemail system, having Rob call Victor
		new vmSystem(Rob, Victor);
	}
}
