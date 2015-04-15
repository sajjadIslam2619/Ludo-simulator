package maingame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class GreenPlayer {

	public static int xPosGreen1 = 0, yPosGreen1 = 0, xPosGreen2 = 0,
			yPosGreen2 = 0, xPosGreen3 = 0, yPosGreen3 = 0, xPosGreen4 = 0,
			yPosGreen4 = 0;

	public GreenPlayer() {
	}

	public void grenPlayerPlay(GameContainer gameContainer) {

		int g1 = Play.boardStepPositionsLIST.get(0).playerId;
		int g2 = Play.boardStepPositionsLIST.get(1).playerId;
		int g3 = Play.boardStepPositionsLIST.get(2).playerId;
		int g4 = Play.boardStepPositionsLIST.get(3).playerId;

		xPosGreen1 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).xPos;
		yPosGreen1 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).yPos;
		xPosGreen2 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).xPos;
		yPosGreen2 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).yPos;
		xPosGreen3 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).xPos;
		yPosGreen3 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).yPos;
		xPosGreen4 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).xPos;
		yPosGreen4 = Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).yPos;
		 //System.out.println("###"+g1+g2+g3+g4);
		
		if (g1 == 1 && g2 == 2 && g3 == 3 && g4 == 4) {
			allBricksStartPosition(gameContainer, g1, g2, g3, g4);
			// System.out.println("###"+g1+g2+g3+g4);
		}
		else if (g1 == 1 || g2 == 2 || g3 == 3 || g4 == 4) {
			bricksStartPosition(gameContainer, g1, g2, g3, g4);
			// System.out.println("****"+g1+g2+g3+g4);
		}
		else if (g1 == 0 && g2 == 0 && g3 == 0 && g4 == 0) {
			allBricksAtPlayPosition(gameContainer, g1, g2, g3, g4);
		}

	}

	// if all bricks then it works for the first time ..if any of the bricks in
	// play state then it has on operation ..
	private void allBricksStartPosition(GameContainer gameContainer, int g1,
			int g2, int g3, int g4) {
		// TODO Auto-generated method stub
		// calling many times because of thread ... no effect till now ... will
		// concern about this later
		RollDice rollDice = new RollDice();
		rollDice.clickToRollDice(gameContainer);
		// Play.diceValue=rollDice.clickToRollDice(gameContainer);
		// System.out.println(">>>"+Play.diceValue);
		if (Play.diceValue != 6 && Play.diceValue != 0) {
			Play.playTurn = 1;
		} else if (Play.diceValue == 6) {
			Input input = gameContainer.getInput();
			Play.xposMouse = Mouse.getX();
			Play.yposMouse = Mouse.getY();
			// player 1
			if (mouseClickPosition(xPosGreen1, xPosGreen1 + 25,
					700 - (yPosGreen1 + 25), 700 - yPosGreen1)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(16, 1, 0, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen1 = 16;
					//System.out.println(">>>>>>>>>>>>>>>>>>"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId);
					// int
					// g5=Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId;
					// System.out.println("###"+g5);
					// Play.playTurn=1;
				}
			}
			// player2
			else if (mouseClickPosition(xPosGreen2, xPosGreen2 + 25,
					700 - (yPosGreen2 + 25), 700 - yPosGreen2)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(16, 2, 1, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen2 = 16;
					//System.out.println(">>>>>>>>>>>>>>>>>>"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).playerId);
					// Play.playTurn=1;
				}
			}
			// player3
			else if (mouseClickPosition(xPosGreen3, xPosGreen3 + 25,
					700 - (yPosGreen3 + 25), 700 - yPosGreen3)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(16, 3, 2, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen3 = 16;
					//System.out.println(">>>>>>>>>>>>>>>>>>"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).playerId);
					// Play.playTurn=1;
				}
			}
			// player4
			else if (mouseClickPosition(xPosGreen4, xPosGreen4 + 25,
					700 - (yPosGreen4 + 25), 700 - yPosGreen4)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(16, 4, 3, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen4 = 16;
					//System.out.println(">>>>>>>>>>>>>>>>>>"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).playerId);
					// Play.playTurn=1;
				}
			}
		}
	}

	private void bricksStartPosition(GameContainer gameContainer, int g1,
			int g2, int g3, int g4) {
		// TODO Auto-generated method stub
		RollDice rollDice = new RollDice();
		rollDice.clickToRollDice(gameContainer);

		if (Play.diceValue == 6) {
			Input input = gameContainer.getInput();
			Play.xposMouse = Mouse.getX();
			Play.yposMouse = Mouse.getY();
			// player 1
			if (mouseClickPosition(xPosGreen1, xPosGreen1 + 25,
					700 - (yPosGreen1 + 25), 700 - yPosGreen1)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen1 + Play.diceValue, 1,
							Play.listIteratorGreen1, 0);
					Play.geeenPlayerThreadControll = true;
					if (g1 == 1) {
						Play.listIteratorGreen1 = 16;
					} else if (g1 == 0) {
						Play.listIteratorGreen1 += Play.diceValue;
					}
					//System.out.println("<<<<<<<<<<<<"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId);
					// int
					// g5=Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId;
					// System.out.println("###"+g5);
					// Play.playTurn=1;
				}
			}
			// player2
			else if (mouseClickPosition(xPosGreen2, xPosGreen2 + 25,
					700 - (yPosGreen2 + 25), 700 - yPosGreen2)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen2 + Play.diceValue, 2,
							Play.listIteratorGreen2, 0);
					Play.geeenPlayerThreadControll = true;
					if (g2 == 2) {
						Play.listIteratorGreen2 = 16;
					} else if (g2 == 0) {
						Play.listIteratorGreen2 += Play.diceValue;
					}
					//System.out.println("<<<<<<<<<<<<"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).playerId);
					// Play.playTurn=1;
				}
			}
			// player3
			else if (mouseClickPosition(xPosGreen3, xPosGreen3 + 25,
					700 - (yPosGreen3 + 25), 700 - yPosGreen3)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen3 + Play.diceValue, 3,
							Play.listIteratorGreen3, 0);
					Play.geeenPlayerThreadControll = true;
					if (g3 == 3) {
						Play.listIteratorGreen3 = 16;
					} else if (g3 == 0) {
						Play.listIteratorGreen3 += Play.diceValue;
					}
					//System.out.println("<<<<<<<<<<<<"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).playerId);
					// Play.playTurn=1;
				}
			}
			// player4
			else if (mouseClickPosition(xPosGreen4, xPosGreen4 + 25,
					700 - (yPosGreen4 + 25), 700 - yPosGreen4)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen4 + Play.diceValue, 4,
							Play.listIteratorGreen4, 0);
					Play.geeenPlayerThreadControll = true;
					if (g4 == 4) {
						Play.listIteratorGreen4 = 16;
					} else if (g4 == 0) {
						Play.listIteratorGreen4 += Play.diceValue;
					}
					//System.out.println("<<<<<<<<<<<<"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).playerId);
					// Play.playTurn=1;
				}
			}
		} else if (Play.diceValue != 6) {
			Input input = gameContainer.getInput();
			Play.xposMouse = Mouse.getX();
			Play.yposMouse = Mouse.getY();
			// player 1
			if (mouseClickPosition(xPosGreen1, xPosGreen1 + 25,
					700 - (yPosGreen1 + 25), 700 - yPosGreen1)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen1 + Play.diceValue, 1,
							Play.listIteratorGreen1, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen1 += Play.diceValue;
					//System.out.println(":::::::->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId);
					// Play.diceValue=0;
					Play.playTurn = 1;
				}
			}
			// player2
			else if (mouseClickPosition(xPosGreen2, xPosGreen2 + 25,
					700 - (yPosGreen2 + 25), 700 - yPosGreen2)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen2 + Play.diceValue, 2,
							Play.listIteratorGreen2, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen2 += Play.diceValue;
					// Play.diceValue=0;
					//System.out.println(":::::::->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).playerId);
					Play.playTurn = 1;
				}
			}
			// player3
			else if (mouseClickPosition(xPosGreen3, xPosGreen3 + 25,
					700 - (yPosGreen3 + 25), 700 - yPosGreen3)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen3 + Play.diceValue, 3,
							Play.listIteratorGreen3, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen3 += Play.diceValue;
					// Play.diceValue=0;
					//System.out.println(":::::::->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).playerId);
					Play.playTurn = 1;
				}
			}
			// player4
			else if (mouseClickPosition(xPosGreen4, xPosGreen4 + 25,
					700 - (yPosGreen4 + 25), 700 - yPosGreen4)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen4 + Play.diceValue, 4,
							Play.listIteratorGreen4, 0);
					Play.geeenPlayerThreadControll = true;
					Play.listIteratorGreen4 += Play.diceValue;
					// Play.diceValue=0;
					//System.out.println(":::::::->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).playerId);
					Play.playTurn = 1;
				}
			}
		}

	}

	private void allBricksAtPlayPosition(GameContainer gameContainer, int g1,
			int g2, int g3, int g4) {
		// TODO Auto-generated method stub
		RollDice rollDice = new RollDice();
		rollDice.clickToRollDice(gameContainer);

		if (Play.diceValue == 6) {
			Input input = gameContainer.getInput();
			Play.xposMouse = Mouse.getX();
			Play.yposMouse = Mouse.getY();
			// player 1
			if (mouseClickPosition(xPosGreen1, xPosGreen1 + 25,
					700 - (yPosGreen1 + 25), 700 - yPosGreen1)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen1 + Play.diceValue, 1,
							Play.listIteratorGreen1, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen1, Play.listIteratorGreen1
									+ Play.diceValue);
					Play.listIteratorGreen1 = returnListiterator;
					// Play.listIteratorGreen1 += Play.diceValue;
					//System.out.println(":->:->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId);

				}
			}
			// player2
			else if (mouseClickPosition(xPosGreen2, xPosGreen2 + 25,
					700 - (yPosGreen2 + 25), 700 - yPosGreen2)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen2 + Play.diceValue, 2,
							Play.listIteratorGreen2, 0);
					
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen2, Play.listIteratorGreen2
									+ Play.diceValue);
					Play.listIteratorGreen2 = returnListiterator;
					//Play.listIteratorGreen2 += Play.diceValue;
					//System.out.println(":->:->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).playerId);
					// Play.playTurn=1;
				}
			}
			// player3
			else if (mouseClickPosition(xPosGreen3, xPosGreen3 + 25,
					700 - (yPosGreen3 + 25), 700 - yPosGreen3)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen3 + Play.diceValue, 3,
							Play.listIteratorGreen3, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen3, Play.listIteratorGreen3
									+ Play.diceValue);
					Play.listIteratorGreen3 = returnListiterator;
					//Play.listIteratorGreen3 += Play.diceValue;
					//System.out.println(":->:->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).playerId);
					// Play.playTurn=1;
				}
			}
			// player4
			else if (mouseClickPosition(xPosGreen4, xPosGreen4 + 25,
					700 - (yPosGreen4 + 25), 700 - yPosGreen4)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen4 + Play.diceValue, 4,
							Play.listIteratorGreen4, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen4, Play.listIteratorGreen4
									+ Play.diceValue);
					Play.listIteratorGreen4 = returnListiterator;
					//Play.listIteratorGreen4 += Play.diceValue;
					//System.out.println(":->:->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).playerId);
					// Play.playTurn=1;
				}
			}

		} else if (Play.diceValue != 6) {
			Input input = gameContainer.getInput();
			Play.xposMouse = Mouse.getX();
			Play.yposMouse = Mouse.getY();
			// player 1
			if (mouseClickPosition(xPosGreen1, xPosGreen1 + 25,
					700 - (yPosGreen1 + 25), 700 - yPosGreen1)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen1 + Play.diceValue, 1,
							Play.listIteratorGreen1, 0);
					Play.geeenPlayerThreadControll = true;
					// Play.listIteratorGreen1 += Play.diceValue;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen1, Play.listIteratorGreen1
									+ Play.diceValue);
					Play.listIteratorGreen1 = returnListiterator;
					//System.out.println("->->->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen1).playerId);
					Play.playTurn = 1;
				}
			}
			// player2
			else if (mouseClickPosition(xPosGreen2, xPosGreen2 + 25,
					700 - (yPosGreen2 + 25), 700 - yPosGreen2)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen2 + Play.diceValue, 2,
							Play.listIteratorGreen2, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen2, Play.listIteratorGreen2
									+ Play.diceValue);
					Play.listIteratorGreen2 = returnListiterator;
					// Play.listIteratorGreen2 += Play.diceValue;
					//System.out.println("->->->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen2).playerId);
					Play.playTurn = 1;
				}
			}
			// player3
			else if (mouseClickPosition(xPosGreen3, xPosGreen3 + 25,
					700 - (yPosGreen3 + 25), 700 - yPosGreen3)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen3 + Play.diceValue, 3,
							Play.listIteratorGreen3, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen3, Play.listIteratorGreen3
									+ Play.diceValue);
					Play.listIteratorGreen3 = returnListiterator;
					// Play.listIteratorGreen3 += Play.diceValue;
					//System.out.println("->->->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen3).playerId);
					Play.playTurn = 1;
				}
			}
			// player4
			else if (mouseClickPosition(xPosGreen4, xPosGreen4 + 25,
					700 - (yPosGreen4 + 25), 700 - yPosGreen4)) {
				if (input.isMouseButtonDown(0)) {
					bricksPosition(Play.listIteratorGreen4 + Play.diceValue, 4,
							Play.listIteratorGreen4, 0);
					Play.geeenPlayerThreadControll = true;
					int returnListiterator = checkOnWayHome(
							Play.listIteratorGreen4, Play.listIteratorGreen4
									+ Play.diceValue);
					Play.listIteratorGreen4 = returnListiterator;
					// Play.listIteratorGreen4 += Play.diceValue;
					//System.out.println("->->->"+Play.boardStepPositionsLIST.get(Play.listIteratorGreen4).playerId);
					Play.playTurn = 1;
				}
			}
		}
	}

	private void bricksPosition(int listIteratorIndex_1, int player_Id_1,
			int listIteratorIndex_2, int player_Id_2) {
		// TODO Auto-generated method stub
		if(listIteratorIndex_2 == 16){
			BoardStepPosition boardStepPositionGreen = Play.boardStepPositionsLIST
					.get(listIteratorIndex_1);
			boardStepPositionGreen.playerId = player_Id_1;
			Play.boardStepPositionsLIST.set(listIteratorIndex_1,boardStepPositionGreen);
		}else{
			BoardStepPosition boardStepPositionGreen = Play.boardStepPositionsLIST
					.get(listIteratorIndex_1);
			boardStepPositionGreen.playerId = player_Id_1;
			Play.boardStepPositionsLIST.set(listIteratorIndex_1,
					boardStepPositionGreen);

			BoardStepPosition boardStepPositionGreen1 = Play.boardStepPositionsLIST
					.get(listIteratorIndex_2);
			boardStepPositionGreen1.playerId = player_Id_2;
			Play.boardStepPositionsLIST.set(listIteratorIndex_2,
					boardStepPositionGreen1);
			
		}
		

	}

	private boolean mouseClickPosition(int x1, int x2, int y1, int y2) {
		if ((Play.xposMouse > x1 && Play.xposMouse < x2)
				&& (Play.yposMouse > y1 && Play.yposMouse < y2)) {
			return true;
		} else
			return false;

	}

	private int checkOnWayHome(int listIterator, int ListIteratorAndDiceValue) {

		if (ListIteratorAndDiceValue > 16 && ListIteratorAndDiceValue <= 66) {
			BeatBricks beatBricks=new BeatBricks();
			//int []a=beatBricks.beatableBricks(1,2,3,4);
			
			for(int k=17 ;k<67;k++){
				if(k!=29&&k!=42&&k!=55){
					if(Play.boardStepPositionsLIST.get(k).playerId!=0){
						//System.out.println("KKKKK->->->"+k+Play.boardStepPositionsLIST.get(k).playerId);
					}
				}	
			}
			return ListIteratorAndDiceValue;
		} else if (ListIteratorAndDiceValue > 73) {
			return listIterator;
		} else if (ListIteratorAndDiceValue == 73) {
			return listIterator = 73;
		} else if (ListIteratorAndDiceValue == 67) {
			return ListIteratorAndDiceValue = 68;
		} else if ((ListIteratorAndDiceValue > 66
				|| ListIteratorAndDiceValue < 73) && ListIteratorAndDiceValue!=67) {
			return ListIteratorAndDiceValue + 1;
		} else {
			return 0;
		}

	}

}