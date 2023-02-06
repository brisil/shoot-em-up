import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		
		// TODO Auto-generated method stub
		AppGameContainer app = new AppGameContainer(new Principale("jeu shoot'em up"));
	    app.setTargetFrameRate(60);
		app.setDisplayMode(1000,  700, false);//  represente la taille de la fenetre 
		app.setShowFPS(false);
		app.start();
	}

}
