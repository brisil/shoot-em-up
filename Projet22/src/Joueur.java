
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Joueur {
	
	
	private Image img;
	private int  x,y;
	private int vieJ;
	private float angle;
	
	
	 
	
	// création du constructeur par défaut
	public Joueur() throws SlickException {
			img=new Image("images/joueur.png");
	 
		x=50;
		y=500 ;
		vieJ=(int)(Math.random()*250);
		
	}
	//// création de la méthode dessiner
	  public void dessiner(Graphics g) {
	  
		g.drawImage(img, x, y);
	}
////	    la méthode pemettra de deplacera le vaisseau vers la gauche 
	 public void gauche () {
		 if(x-10>=0) {
		 x-=10; 
		 }
		
	}
	public void droite () {
		 if(x+15<905) {
			 x+=15;  
		 }
		 
   }
	 public void haut() {
		 if(y-20>=0) {
		     y-=20;
		 }
	 
	 }
	 public void bas() {
		 if(y+15<600) {
			 y+=15;
	 }
		 
		
	 }
	 
	public int getVieJ() {
		return vieJ;
	}
	public void setVieJ(int vieJ) {
		this.vieJ = vieJ;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void rotationJ(GameContainer gc) {
		Input input=gc.getInput();
		if (input.isKeyPressed(Input.KEY_A)) {
			img.rotate((float)50.0);
			angle+=55;
			angle%=360;
		}
		else if(input.isKeyPressed(Input.KEY_B)) {
			img.rotate((float)-50.0);
			angle-=55;
			angle%=360;
		}
			
		}
	}




