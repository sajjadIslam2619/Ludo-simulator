package maingame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String gameName ="LUDO";
	public static final int menu=0;
	public static final int play=1;
	
	public Game(String gameName) {
		super(gameName);
		// if this ...then all init() called twice 
//		this.addState(new Menu(menu));
//		this.addState(new Play(play));
		// ok now 
		addState(new Menu(menu));
		addState(new Play(play));
		enterState(menu);
	}
	
	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
	
		// if this ...then all init() called twice 
//		this.getState(menu).init(gameContainer, this);
//		this.getState(play).init(gameContainer, this);
//		this.enterState(menu);
//		
		
		
	}

	public static void main(String[] args) {
		AppGameContainer appGameContainer;
		try{
			appGameContainer = new AppGameContainer(new Game(gameName));
			appGameContainer.setDisplayMode(1350, 700, false);
			appGameContainer.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	

}
