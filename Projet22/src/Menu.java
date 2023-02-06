import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Menu {
private int accueil=1;// pour la premiére page 

private int zonesurvole=1;
public Font font1=new Font ("Comic",Font.BOLD,50);
public Font font2=new Font("Arial",Font.BOLD,30);
public Font font3=new Font("Comic",Font.BOLD,15);


public TrueTypeFont titre1=new TrueTypeFont(font1,true);
public TrueTypeFont titre2=new TrueTypeFont(font2,true);
public TrueTypeFont titre3=new TrueTypeFont(font3,true);

public Color white=new Color(100,132,127);

public int getAccueil() {
	return accueil;
}

public void setAccueil(int accueil) {
	this.accueil = accueil;
}

// methodes pour dessiner les différents interfaces possibles dans le jeu
                                                                                                           







public void dessinerFond(Graphics g) {
//	Color fond =new Color(236,193,156,100);
	try {
		g.drawImage(new Image("images/tran.png"),0,0);
//		g.setColor(fond);
//		g.fillRect(0, 300, 1000, 100);
	}catch(SlickException e) {
		System.out.println("erreur");
	}
	
}
//public void decoration(Graphics g) {
//	g.setColor(red);
//}
public void dessinerAccueil(Graphics g) {
	this.dessinerFond(g);
//	titre1.drawString(440-titre1.getWidth("shoot ")/2,130,"shoot em",vert);
	titre2.drawString(440-titre2.getWidth("play ")/2,300,"play",Color.white);
	titre2.drawString(440-titre2.getWidth("help ")/2,300+titre2.getHeight("play")+10,"help",Color.white);
	
//	Image img=new Image("images/")
}
public void dessinerAide(Graphics g) throws SlickException {
	this.dessinerFond(g);
	this.dessinerAccueil(g);
	g.drawImage(new Image("images/aide.png" ),0,0,Color.white);
	
	
}
public void Survol(int x,int y) {
//	verifie si x et y correspondent aux coordonnée dans une zone qui a du sens ;
//	2 vous pour le lien vers , 3 pour l'aide,0 
	
		
	if(y>200 && y<=400 && x>300 && x<600  ) {
		accueil=2;
	}
	
	if(y>300 && y<=450 && x>300 && x<600) {
		accueil=3;
	}
		if(y<=50 && x>5) {
			accueil=1;
		}
	}
	

	 public void RetourAccueil(Graphics g) throws SlickException {
		 g.drawImage(new Image("images/rentre.jpeg" ),50,5);
	 }
	
		
	

public void clicZone() {
	switch(zonesurvole) {
	case 2:
		if(accueil==1)   // on est a la page d'accueil et passe au jeu proprement dit
			accueil=2;
			break;
			case 3:
				if(accueil==1) {// on est a la page d'accueil et on passe a l'interface  l'aide
					accueil=3;
					break;
				}
	}
}
public void decorationZoneSurvole(Graphics g) {
//	surbrillance une zone de l'accueil
	g.setColor(Color.white);
	
	
	switch(zonesurvole) {
	case 2:    //zone 1 est de celle start
	g.fillRect(0, 300, 700, 40);
	break;
	case 3://sone 2 est celle de help
		g.fillRect(0, 340, 700,40);
		break;
	}
}
}

