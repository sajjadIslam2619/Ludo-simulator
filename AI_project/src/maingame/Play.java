package maingame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

	Image ludoBoardImage, rollDice, dice1, dice2, dice3, dice4, dice5, dice6;
	Image greenBrick1, greenBrick2, greenBrick3, greenBrick4, yellowBrick1,
			yellowBrick2, yellowBrick3, yellowBrick4, blueBrick1, blueBrick2,
			blueBrick3, blueBrick4, redBrick1, redBrick2, redBrick3, redBrick4;
	public static  int xposMouse, yposMouse;
	
	int xPos = 0, yPos = 0, PlayerID = 0, PlayerState = 0;
	
	public static ArrayList<BoardStepPosition> boardStepPositionsLIST;
	public static int listIteratorGreen1 = 0, listIteratorGreen2 = 1, listIteratorGreen3 = 2,
			listIteratorGreen4 = 3, listIteratorYellow1 = 4,
			listIteratorYellow2 = 5, listIteratorYellow3 = 6,
			listIteratorYellow4 = 7, listIteratorRed1 = 8,
			listIteratorRed2 = 9, listIteratorRed3 = 10, listIteratorRed4 = 11,
			listIteratorBlue1 = 12, listIteratorBlue2 = 13,
			listIteratorBlue3 = 14, listIteratorBlue4 = 15;
	long delay = 0;// delay for every player turn 
	int greenMove=0, yellowMove = 0, redMove = 0, blueMove = 0;
	public static boolean diceController = false;// to control GreenPlayer...
	public static int diceValue = 0;// get dice value from RollDice class
	public static int playTurn = 0;//to control thread for the player ...
	public static String playTurnDisplay = "";//display player turns in every steps ..
	public static boolean geeenPlayerThreadControll=true;
	// http://www.java-forums.org/java-2d/93439-slick-2d-mouse-click-original-java-mouse-listener.html
	public static int[] bricksIdIndex=new int[100];
	public int[] greenBrickStart = { 125, 525 };

	public Play(int state) {

	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
			throws SlickException {
		// TODO Auto-generated method stub
		ludoBoardImage = new Image("res/ludoboard.png");
		rollDice = new Image("res/rolldice.png");
		dice1 = new Image("res/dice1.png");
		dice2 = new Image("res/dice2.png");
		dice3 = new Image("res/dice3.png");
		dice4 = new Image("res/dice4.png");
		dice5 = new Image("res/dice5.png");
		dice6 = new Image("res/dice6.png");

		greenBrick1 = new Image("res/greenbrick1.png");
		greenBrick2 = new Image("res/greenbrick2.png");
		greenBrick3 = new Image("res/greenbrick3.png");
		greenBrick4 = new Image("res/greenbrick4.png");

		yellowBrick1 = new Image("res/yellowbrick1.png");
		yellowBrick2 = new Image("res/yellowbrick2.png");
		yellowBrick3 = new Image("res/yellowbrick3.png");
		yellowBrick4 = new Image("res/yellowbrick4.png");

		redBrick1 = new Image("res/redbrick1.png");
		redBrick2 = new Image("res/redbrick2.png");
		redBrick3 = new Image("res/redbrick3.png");
		redBrick4 = new Image("res/redbrick4.png");

		blueBrick1 = new Image("res/bluebrick1.png");
		blueBrick2 = new Image("res/bluebrick2.png");
		blueBrick3 = new Image("res/bluebrick3.png");
		blueBrick4 = new Image("res/bluebrick4.png");

		fileToArrayListBoardStepPosition();

	}

	@Override
	public void render(GameContainer gameContainer,
			StateBasedGame stateBasedGame, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		g.drawString("xpos: " + xposMouse + " ypos: " + yposMouse, 1150, 100);
		g.drawString(playTurnDisplay, 1150, 500);
		g.drawImage(ludoBoardImage, 0, 0);
		g.drawImage(rollDice, 1135, 100);// 151*60

		if (diceValue == 1) {
			g.drawImage(dice1, 1135, 200);
		}
		if (diceValue == 2) {
			g.drawImage(dice2, 1135, 200);
		}
		if (diceValue == 3) {
			g.drawImage(dice3, 1135, 200);
		}
		if (diceValue == 4) {
			g.drawImage(dice4, 1135, 200);
		}
		if (diceValue == 5) {
			g.drawImage(dice5, 1135, 200);
		}
		if (diceValue == 6) {
			g.drawImage(dice6, 1135, 200);
			
		}

		g.drawImage(greenBrick1,
				boardStepPositionsLIST.get(listIteratorGreen1).xPos-5,
				boardStepPositionsLIST.get(listIteratorGreen1).yPos-5);
		g.drawImage(greenBrick2,
				boardStepPositionsLIST.get(listIteratorGreen2).xPos,
				boardStepPositionsLIST.get(listIteratorGreen2).yPos);
		g.drawImage(greenBrick3,
				boardStepPositionsLIST.get(listIteratorGreen3).xPos,
				boardStepPositionsLIST.get(listIteratorGreen3).yPos);
		g.drawImage(greenBrick4,
				boardStepPositionsLIST.get(listIteratorGreen4).xPos,
				boardStepPositionsLIST.get(listIteratorGreen4).yPos);

		g.drawImage(yellowBrick1,
				boardStepPositionsLIST.get(listIteratorYellow1).xPos,
				boardStepPositionsLIST.get(listIteratorYellow1).yPos);
		g.drawImage(yellowBrick2,
				boardStepPositionsLIST.get(listIteratorYellow2).xPos,
				boardStepPositionsLIST.get(listIteratorYellow2).yPos);
		g.drawImage(yellowBrick3,
				boardStepPositionsLIST.get(listIteratorYellow3).xPos,
				boardStepPositionsLIST.get(listIteratorYellow3).yPos);
		g.drawImage(yellowBrick4,
				boardStepPositionsLIST.get(listIteratorYellow4).xPos,
				boardStepPositionsLIST.get(listIteratorYellow4).yPos);

		g.drawImage(redBrick1,
				boardStepPositionsLIST.get(listIteratorRed1).xPos,
				boardStepPositionsLIST.get(listIteratorRed1).yPos);
		g.drawImage(redBrick2,
				boardStepPositionsLIST.get(listIteratorRed2).xPos,
				boardStepPositionsLIST.get(listIteratorRed2).yPos);
		g.drawImage(redBrick3,
				boardStepPositionsLIST.get(listIteratorRed3).xPos,
				boardStepPositionsLIST.get(listIteratorRed3).yPos);
		g.drawImage(redBrick4,
				boardStepPositionsLIST.get(listIteratorRed4).xPos,
				boardStepPositionsLIST.get(listIteratorRed4).yPos);

		g.drawImage(blueBrick1,
				boardStepPositionsLIST.get(listIteratorBlue1).xPos,
				boardStepPositionsLIST.get(listIteratorBlue1).yPos);
		g.drawImage(blueBrick2,
				boardStepPositionsLIST.get(listIteratorBlue2).xPos,
				boardStepPositionsLIST.get(listIteratorBlue2).yPos);
		g.drawImage(blueBrick3,
				boardStepPositionsLIST.get(listIteratorBlue3).xPos,
				boardStepPositionsLIST.get(listIteratorBlue3).yPos);
		g.drawImage(blueBrick4,
				boardStepPositionsLIST.get(listIteratorBlue4).xPos,
				boardStepPositionsLIST.get(listIteratorBlue4).yPos);

	}

	@Override
	public void update(GameContainer gameContainer,
			StateBasedGame stateBasedGame, int delta) throws SlickException {
		// TODO Auto-generated method stub

		delay += delta;

		xposMouse = Mouse.getX();
		yposMouse = Mouse.getY();
		
		
		Input input = gameContainer.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}

		if (playTurn == 0) {
			// greenplayer
			playTurnDisplay = "greenPlayer";
			
			GreenPlayer greenPlayer =new GreenPlayer();
			greenPlayer.grenPlayerPlay(gameContainer);
			//playTurn=1;
			
		} else if (playTurn == 1) {
			// yellowPlayer
			if (delay > 5000) {
				playTurnDisplay = "yellowPlayer";
				
				YellowPlayer yellowPlayer=new YellowPlayer();
				yellowPlayer.yellowPlayerPlay();
				
				//playTurn = 2;
				yellowMove++;
				delay = 0;
			}

		} else if (playTurn == 2) {
			// redPlayer
			if (delay > 5000) {
				playTurnDisplay = "redPlayer";
				RedPlayer redPlayer=new RedPlayer();
				redPlayer.redPlayerPlay();
				//playTurn = 3;

				delay = 0;
			}

		} else if (playTurn == 3) {
			if (delay > 5000) {
				playTurnDisplay = "bluePlayer";
				System.out.println(playTurnDisplay);
				
				BluePlayer bluePlayer=new BluePlayer();
				bluePlayer.bluePlayerPlay();
				
				//playTurn = 4;
				BeatBricks beatBricks=new BeatBricks();
				beatBricks.beatableBricks();

				delay = 0;
			}
		} else if(playTurn == 4){
			if (delay > 1000) {
				playTurnDisplay = "bluePlayer";
				playTurn = 5;
				diceValue=0;
				Play.geeenPlayerThreadControll=true;

				delay = 0;
				
			}
		}else if(playTurn == 5){
			if (delay > 10) {
				playTurnDisplay = "greenPlayer";
				playTurn = 0;
				diceValue=0;
				Play.geeenPlayerThreadControll=true;

				delay = 0;
				
			}
		}
	
		// testMethod(gameContainer );
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	// read from the file and insert into the BoardStepPosition(class)
	// arrayList....
	public void fileToArrayListBoardStepPosition() {

		boardStepPositionsLIST = new ArrayList<BoardStepPosition>();

		FileInputStream fstream = null;
		try {
			//fstream = new FileInputStream("F:\\ECLIPES_JUNO_4.4\\boardStepPositionFile.txt");
			fstream = new FileInputStream("res/boardStepPositionFile.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(fstream));
		try {
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				String[] arr = line.split(",");
				// System.out.println(line+ arr.length);
				int xPos = 0, yPos = 0, PlayerID = 0, PlayerState = 0, stepPositionId = 0;
				for (int i = 0; i < arr.length; i++) {
					if (i == 0) {
						String[] temp = arr[i].split("=");
						xPos = Integer.parseInt(temp[1]);
					}
					if (i == 1) {
						String[] temp = arr[i].split("=");
						yPos = Integer.parseInt(temp[1]);
					}
					if (i == 2) {
						String[] temp = arr[i].split("=");
						PlayerID = Integer.parseInt(temp[1]);
					}
					if (i == 3) {
						String[] temp = arr[i].split("=");
						PlayerState = Integer.parseInt(temp[1]);
					}
					if (i == 4) {
						String[] temp = arr[i].split("=");
						stepPositionId = Integer.parseInt(temp[1]);
					}

				}

				boardStepPositionsLIST.add(new BoardStepPosition(xPos, yPos,
						PlayerID, PlayerState, stepPositionId));
			}
			System.out.println(boardStepPositionsLIST.size());
			for (int i = 0; i < boardStepPositionsLIST.size(); i++) {
				 //System.out.println(boardStepPositionsLIST.get(i).stepPositionId);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
