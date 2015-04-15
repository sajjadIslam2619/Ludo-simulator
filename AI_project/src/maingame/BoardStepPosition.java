package maingame;

public class BoardStepPosition {
	
	public int xPos;
	public int yPos;
	public int playerId;
	public int playerState;
	public int stepPositionId;

	public BoardStepPosition(int a, int b, int c,int d,int e)
	{
		this.xPos = a;
		this.yPos =b;
		this.playerId = c;
		this.playerState =d;
		this.stepPositionId=e;
	}
}
