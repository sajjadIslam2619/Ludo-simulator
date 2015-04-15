package maingame;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class RollDice {
	
	int diceValueGreenPlayer=0;
	
	public RollDice(){
		
	}
	
	public int getDiceValue(){
		
		Random randomValue=new Random();
		Play.diceValue=randomValue.nextInt(6)+1;
		
		return Play.diceValue;
	}
	public void clickToRollDice(GameContainer gameContainer){
		Play.xposMouse=Mouse.getX();
		Play.yposMouse=Mouse.getY();
		Play.diceController=true;
		Input input=gameContainer.getInput();
		if((Play.xposMouse > 1135 && Play.xposMouse < 1285)
				&& (Play.yposMouse > 540 && Play.yposMouse < 590)){
			if (input.isMousePressed(0)) {
				Play.diceValue = getDiceValue();
				Play.diceController=false;
				
			}
		}
		
	}
}
