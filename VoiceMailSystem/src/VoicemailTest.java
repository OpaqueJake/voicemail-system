// Jacob Fisher

public class VoicemailTest {
	public static void main(String[] args) {
		System.out.println("\n\sType H at anytime to hang up the call. \n");
		
		Caller tod = new Caller("Tod", "t", 6184);
		Caller nick = new Caller("Nick", "n", 9437);
		
		new vmSystem(tod, nick);
	}
}
