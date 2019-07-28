import Login.*;

public class Run {
	public static void main(String[] args) {
		LoginModel log= new LoginModel();
		LoginView screen = new LoginView();
		screen.setVisible(true);
		LoginController operator = new LoginController(log, screen);
		operator.userSignIn();
	}
}
