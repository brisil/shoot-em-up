import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Projectile {
	private float x, y;
	private int vy;
	private Image imag;


	public Projectile(float x, float y, int vy) throws SlickException {
//		if (x >= 0 && y >= 0 && x <900  && y < 700) {
			this.x = x;
			this.y = y;
			this.vy = vy;
//		}
//		else
//		{ 
//			this.x = 0; 
//			this.y = 0;
//			this.vy = 0;
//		}
		
		imag = new Image("images/feu.png");
		
	}
 
	public void dessiner(Graphics g) {
         g.drawImage(imag, x, y);
	}
	
	public void deplacer(int delta) {
		
		float distance = vy * delta/1000f;
		y = y + distance;
	}
	
	public boolean horsEcran() {
		if(y<0 && vy<0) {
			return true;
		}
		else if(y>700 && vy>0) {
			return true;
		}
		else if(x<0) {
			return true;
		}
		else if(x>1000) {
			return true;
		}
		return false;
	}
	
	public boolean testCollision(Ennemi e) {
		if(this.x+90< e.getX()  ||  this.x > e.getX()+90) {
			return false;
		}
			 if (this.y+90<e.getY()  ||  this.y >e.getY()+90 ) {
				 return false;
			 }
			 
			return true;
		
	}
//	collision entre ennemis et joueur
	public boolean Collision(Joueur j) {
		if(this.x<j.getX()-50  || this.x>j.getX()+50) {
			return false;
		}
		if(this.y<j.getY()-50|| this.y>j.getY()+50) {
			return false ;
		}
		return true;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	
	
}
