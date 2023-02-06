 import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

  public class Ennemi {
	private float x,y;
    private Image image;
    private  int vitessex,vitessey ;
    private int vieE;
    private int typeEn;
    private float angle;
    private int vd;
   
//    private int taillex;
//    private int tailley;
    

	public Ennemi(int typeEn,int x,int y) throws SlickException {
//		if(x>=0&&x<610&&y>=0&&y<450) {
		
		this.x =x;
		this.y = y;
		
		this.typeEn=typeEn;
//			
//	}else {
//			this.x = 0;
//			this.y = 0;
//		}
		

//		this.image=new Image("images/enemi.png");
//		this.vitessex=150;
//		this.vitessey=150;
////		this.taillex=50;
////		this.tailley=40;
//		this.vieE=3;
		
		if(typeEn==0) {
			this.image=new Image("images/enemi.png");
			this.vitessex=100;
			this.vitessey=100;
			this.vieE=3;
		}
		
		if(typeEn==1) {
			this.image=new Image("images/bowser.png");
			this.vitessex=100;
			this.vitessey=100;
			this.vieE=4;
		}
		
		if(typeEn==2) {
			this.image=new Image("images/champi.png");
			this.vitessex=100;
			this.vitessey=100;
			this.vieE=5;
		}
			
			this.vd=10;
			
		}
		
		
		
		
		
		
	
	
	public void dessiner(Graphics g) {
		
		g.drawImage(image,(float)x,(float)y);
	}
	

	public float getX() {
		return x;
	}

	public void setX(float x) {
//		if(x>=0&&x<640)
			this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
//		if(y>=0&&y<640)
			this.y = y;
		

}
	
public int getVieE() {
		return vieE;
	}

	public void setVieE(int vieE) {
		this.vieE = vieE;
	}

	//	public void  deplacer(int delta) {
//
//		float distance = vitessey * delta/1000f;
//		y = y + distance;
//					}
	public void gauche(int delta) {
		float distance = vitessey * delta/1000f;
		 if(x-distance>=0) {
			 x-=distance; 
			 }
	}
	
		public void droite (int delta) {
			float distance = vitessey * delta/1000f;
			 if(x+distance<905) {
				 x+=distance;  
			 }
	}
		public void haut(int delta) {
			float distance = vitessey * delta/1000f;
			 if(y-distance>=0) {
			     y-=distance;
			 }
		}
	public void bas(int delta) {
		float distance = vitessey * delta/1000f;
		 if(y+distance<600) {
			 y+=distance;
	 }
		 
	}

	

	
//	méthode de collision entre ennemis
	public boolean collisionhaut(GameContainer gc, ArrayList<Ennemi> en,int ind) {
		int c=0;	// represente le nombre d'ennemi qui ne sont pas en collision 	
		for(int i=0;i<en.size();i++) {//le +1 représente un voisinnage de au alentour ; pour verifier qu'il y'a pas d'ennemi au alentour
			if(i!=ind && ((en.get(i).getY()>this.y+ this.image.getHeight() ||(en.get(i).getY()+en.get(i).image.getHeight()+1< this.y) || (en.get(i).getX()+image.getWidth()<this.x|| en.get(i).getX()>this.x + image.getWidth())))){
				c++;
				
			}
		}
		if(c==en.size()-1) {
			return false;
		}
		return true;
	}
	
	public boolean collisionbas(GameContainer gc, ArrayList<Ennemi> en,int ind) {
		
		int c=0;		
		for(int i=0;i<en.size();i++) {
			if(i!=ind && ((en.get(i).getY()>this.y+ this.image.getHeight()+1 ||(en.get(i).getY()+en.get(i).image.getHeight()< this.y) || (en.get(i).getX()+image.getWidth()<this.x|| en.get(i).getX()>this.x + image.getWidth())))){
				c++;
				
			}
		}
		if(c==en.size()-1) {
			return false;
		}
		return true;
	}	
	
		
public boolean collisiondroite(GameContainer gc, ArrayList<Ennemi> en,int ind) {
//	ind représente l'indice de l'ennemi
	int c=0;		
	for(int i=0;i<en.size();i++) {
		if(i!=ind && ((en.get(i).getX()>this.x+ this.image.getWidth()+1 ||(en.get(i).getX()+en.get(i).image.getWidth()< this.x) || (en.get(i).getY()+image.getHeight()<this.y|| en.get(i).getY()>this.y + image.getHeight())))){
			c++;
			
		}
	}
	if(c==en.size()-1) {
		return false;
	}
	return true;
}	

public boolean collisiongauche(GameContainer gc, ArrayList<Ennemi> en,int ind) {
	
	int c=0;		
	for(int i=0;i<en.size();i++) {
		if(i!=ind && ((en.get(i).getX()>this.x+ this.image.getWidth() ||(en.get(i).getX()+en.get(i).image.getWidth()+1< this.x) || (en.get(i).getY()+image.getHeight()<this.y|| en.get(i).getY()>this.y + image.getHeight())))){
			c++;
			
		}
	}
	if(c==en.size()-1) {
		return false;
	}
	return true;
}
	
	}
	

