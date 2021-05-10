package Lesson5.core.concretes;

import Lesson5.core.abstracts.JExternalServices;
import Lesson5.jGoogle.JGoogleManager;

public class JGoogleManagerAdapter implements JExternalServices {

	JGoogleManager jGoogleManager = new JGoogleManager();
	
	public void registerWith() {
		jGoogleManager.register();
	}

	public void loginWith() {
		jGoogleManager.login();
	}

}
