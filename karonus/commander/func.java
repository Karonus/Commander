package karonus.commander;

import java.io.IOException;

public class func {
	public static boolean sendCommand(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
	}
}
