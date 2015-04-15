package maingame;

import org.lwjgl.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu  extends BasicGameState{

	Image mainGameButton,exitButton;
	int xpos,ypos;
	public String mouse="";
	
	public Menu(int state){
		
	}
	
	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
			throws SlickException {
		
		mainGameButton =new Image("res/maingamebutton.png");
		exitButton = new Image("res/exitbutton.png");
		
		System.out.println("##");
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g)
			throws SlickException {
		g.drawImage(mainGameButton,550,200);
		g.drawImage(exitButton, 550,350);
		g.drawString(mouse, 100, 100);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta)
			throws SlickException {
		 xpos =Mouse.getX();
		 ypos=Mouse.getY();
		
		 mouse="xpos: "+xpos+" ypos: "+ypos;	
		Input input =gameContainer.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			System.exit(0); 
		}
		if((xpos>550 && xpos<750) && (ypos>400 && ypos<500)){
			if(input.isMouseButtonDown(0)){
				stateBasedGame.enterState(1);
			}
		}
		if((xpos>550 && xpos<750) && (ypos>250 && ypos<350)){
			if(input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}	
	}
	
	@Override
	public int getID() {	
		return 0;
	}

}
