import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

    public class Principale extends BasicGame {
    	int j=10;
    	int timmer=0;
    private int score=0;
	private Image fond;
	private Image fond2;
//	private int vie=10;
//	  Accueil acc;
	boolean jeufini=true;
	  Menu menu;
    private ArrayList<Ennemi > en=new ArrayList<Ennemi>();
	private ArrayList<Projectile> listProjJ= new ArrayList<Projectile>();
	private ArrayList <Projectile> listprojE=new ArrayList<Projectile>();
	private ArrayList <Integer> MouvE=new ArrayList<Integer>();
	private ArrayList<Integer> Score=new ArrayList<Integer>();
    private Joueur img;
    private float distance;
    private float vd=50;
    private Image fin;
    
    
    private float x;
    private float y=0;
    
    private float x2;
    private float y2=0;
 Music musique;
    
   
	
	
//	seconde partie de l'ennemi 
//	private List<Game> game=new LinkedList <Game>();
	public Principale (String title) {
		super(title);
		
		// TODO Auto-generated constructor stub
	}
//	private static Music bg_music;
//	private static Sound shot; 
//	private static Sound explosion;

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
	
		
		
//		page d'accueil
//		switch(acc.getPagepr()) {
//		case 1:
//			acc.dessiner(g);
//			break;
//		case 2:
		switch(menu.getAccueil()) {
		case 1:
			menu.dessinerAccueil(g);
			break;
		case 2:
			g.drawImage(fond, x, y);

			g.drawImage(fond2, x2, y2);

//			for(Game g1:game)
//				g1.dessiner(g);
		
			
//				partie du joueur
				img.dessiner(g);
//				partie du projectile
				
				for(int i=0;i<listProjJ.size();i++) {
					Projectile project = listProjJ.get(i);
					project.dessiner(g);
				}
		// partie permettant de centrer  l'ennemi dans l'écran 
//				for(Game g1:game)
//					g1.getImg().drawCentered(g1.getX(),g1.getY());
//				

				for(int i=0;i<en.size();i++) {
					
					en.get(i).dessiner(g);

					
					
				}
				g.drawString("score:"+score, 0002,005 );
				
				
				g.drawString("vie vaisseau:"+img.getVieJ(),0002,30);
//				g.drawString("best score:"+Score, 0002, 50);
				if(img.getVieJ()==0) {
//					fin.drawCentered(100, 100);
				g.drawString("game over", 400, 400);
					
				}
			//g.drawString("game over", 00010, 30);
//				dessin de balle de l'ennemi
				for(int i=0;i<listprojE.size();i++) {
					Projectile ennemi= listprojE.get(i);
					ennemi.dessiner(g);
				}
				break;
				
		case 3:
			menu.dessinerAide(g);
//			break;
		case 4:

			menu.RetourAccueil(g);
			break;
		}
		
			
	
	
	}

	
	@Override
	public void init(GameContainer gc) throws SlickException {
		fond = new Image("images/tran.png");
//		fond2=fond.getFlippedCopy(f);
		fond2=new Image("images/tran.png");
//		acc=new Accueil();
		menu =new Menu();
		
		y2=y-fond.getHeight();
		musique =new Music ("images/GL4XMMW-game.ogg");
		musique.setVolume(0.2f);
		musique.loop();
		
//		fin=new Image("images/exist.png");

		
		

		

//		partie du joueur 
		img=new Joueur();

//			second partie du de l'ennemi
			
		
		
//	Image enem=new Image("images/enem.png");
//	game.add(new Game(enem,300,40,2,true,enem.getHeight()));
//	bg_music=new Music("sounds/game.track.wav");
//	shot=new Sound ("sounds/game.track.wav");
//	explosion =new Sound("sounds/game.track.wav");
//	bg_music.loop();
//	bg_music.setVolume(0.2f);
		
		for(int i=0;i<5;i++) {
			
				en.add(new Ennemi((int)(Math.random()*3),i*200,-50));	
		}
		
		
		for(int i=0;i<j;i++) {
			MouvE.add((int)(Math.random()*4));
			
			
		}
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		timmer+=delta;
		
		Input inp =gc.getInput();
		if(inp.isKeyDown(Input.KEY_LEFT)) {
			 img.gauche();
		}
		if(inp.isKeyDown(Input.KEY_RIGHT)) {
			img.droite();
		}
		
		if(inp.isKeyDown(Input.KEY_UP)) {
			img.haut();
		}
		if(inp.isKeyDown(Input.KEY_DOWN)) {
			img.bas();
		}
		
				
	if(inp.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
		img.gauche();
		}
		if(inp.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			img.droite();
		}
		
//		utilisation de la manette
		
		
//		partie du projectile permettant le déplacement 
		
		
		for(int i=0;i<listProjJ.size();i++) {
			Projectile project=listProjJ.get(i);
			project.deplacer(delta);
		}
		
		
		
		for(int i=0;i<listProjJ.size();i++) {
			if(listProjJ.get(i).horsEcran()) {
				listProjJ.remove(i);
				i--;
			}
		}
		
  //deplacement des ennemis
		if(timmer>1000) {
			for(int i=0;i<en.size();i++) {
				MouvE.remove(i);
				MouvE.add(i,(int)(Math.random()*4));
				
			}
			timmer=0;
		}
//		méthode de sauvegarde du meileur score
//		for(int i=0;i<Score.size();i++) {
//		if(Score.get(i)>Score.get(i)+1) {
//			
//		}
//			
//		}
		

		for(int i=0;i<en.size();i++) {
//			Ennemi enem=en.get(i);
//			enem.deplacer(delta);
			if(en.get(i).getY()<0) {
				en.get(i).bas(delta);
			}else {
				if(MouvE.get(i)==0 && !(en.get(i).collisionhaut(gc, en, i))) {
					en.get(i).haut(delta);
					}else {
						en.get(i).bas(delta);
					}
				
				if(MouvE.get(i)==1 && !(en.get(i).collisionbas(gc, en, i))) {
					en.get(i).bas(delta);
				}else  {
					en.get(i).haut(delta);
				}
				if(MouvE.get(i)==2 && !(en.get(i).collisiondroite(gc, en, i))) {
					en.get(i).droite(delta);
				}else {
					en.get(i).gauche(delta);
				}
					
				if(MouvE.get(i)==3 && !(en.get(i).collisiongauche(gc, en, i))) {
					en.get(i).gauche(delta);
				}else {
					en.get(i).droite(delta);
			}
			
		}
	}	
			
		

//collision enem
		for(int i=0;i<en.size();i++) {
			for(int j=0;j<listProjJ.size();j++) {
				
				if( listProjJ.get(j).testCollision(en.get(i))) {
					en.get(i).setVieE(en.get(i).getVieE()-1);
					if(en.get(i).getVieE()==0) {
						
						 en.remove(i);
						 
						 i--;
						 score+=10;
					}  
					
					listProjJ.remove(j);
					break;
				}
 			}

			
		}
		// ajouter les ennemis au fur et a mesure
		if(en.size()==3) {
			for(int i=0;i<3;i++) {
				en.add(new Ennemi((int)(Math.random()*3),i*200,-50));
				
			}
		}
//	methode dd'arret
		if(jeufini==true && img.getVieJ()==0) {
			musique.stop();
			
			gc.pause();
			jeufini=false;
			
		}
		
		
//		collision entre ennemis et joueur {

		     for(int i=0;i<listprojE.size();i++) {
					if(listprojE.get(i).Collision(img) && img.getVieJ()!=0){
//					img.setVieJ(img.getVieJ()-1);	
//					if(img.getVieJ()==0) {
					
						System.out.println("entre");
						listprojE.remove(i);
						
//						 i--;
						if(img.getVieJ()>0) {
						 img.setVieJ(img.getVieJ()-1);
						 if(img.getVieJ()==0) {
							 
						 }
						
//					 if((img.getVieJ()==0)) {
//							 System.out.println("game over");
//							
						 }
						
					}
		     }
//					}
		    
//			}
//...................
//		for(int i=0;i<listprojE.size();i++) {
//		   if(listprojE.get(i).Collision(img) && img.getVieJ()!=0) {
//			   listprojE.remove(i);
//			  
//			   i--;
//			   if(img.getVieJ()>0) {
//				   img.setVieJ(img.getVieJ()-1);
//			   }
//		   }
//			
//		}
		          
//		    for(int i=0;i<en.size();i++) {
//		    	for(int j=0;j<listprojE.size();j++) {
//		    		if(listprojE.get(i).Collision(img)) {
//		    			img.setVieJ(img.getVieJ()-1);
//                            if(img.getVieJ()==0) {
//							System.out.println("entre");
//							listprojE.remove(i);
//							  i--;
//	                         
//						}
//		    			
//		    			
//		    		}
//		    		
//		    		
//		    	}
//		    }
	      
		if(inp.isKeyPressed(Input.KEY_SPACE)&&listProjJ.size()<4) {
			listProjJ.add(new Projectile(img.getX()+img.getImg().getWidth()/2,img.getY(),-350));
		}
		

//			méthode concernant les ennemis 
			if(listprojE.size()==0) {
				
				for(int i=0;i<4;i++) {
					for(int j=en.size()-1;j>=0;j--) {
						listprojE.add(new Projectile(en.get(j).getX(),en.get(j).getY(),220));
						
					}
					
				}
				
			}
//			connaitre le mouvement de l'ennemis
			   
			
			for(int i=0;i<listprojE.size();i++) {
				listprojE.get(i).deplacer(delta);
			}
		for(int i=0;i<listprojE.size();i++) {
              if(listprojE.get(i).horsEcran()) {
				listprojE.remove(i);
				i--;
			}
		}
		
	     
//		la rotation du vaisseau
	img.rotationJ(gc);

			
//	seconde partie de l'ennemi
////		
//			for(Game g1:game)	
//			g1.modifier();
	
//	partie concernant la page d'acueil
	
	if(inp.isMouseButtonDown(inp.MOUSE_LEFT_BUTTON )|| inp.isMouseButtonDown(inp.MOUSE_LEFT_BUTTON)) {
	menu.Survol(inp.getMouseX(),inp.getMouseY());
	menu.clicZone(); //on regarde sur quelle zone on clique
	
			}
//	defilement . ici on prend la taille de la hauteur 
	y+=(vd*delta/1000f);
	y2+=(vd*delta/1000f);
	
	if(y>gc.getHeight())
	{
		y=y2-fond.getHeight();
	}
	if(y2>gc.getHeight())
	{
		y=y-fond.getHeight();
	}
	
	
	}
    }
		
    
		


	

