package maingame;

import java.util.Random;


public class YellowPlayer {
	
	
	public int returnValues;
	public int diceValueYellow;
	public int yellowPlayerID_1=5,yellowPlayerID_2=6,yellowPlayerID_3=7,yellowPlayerID_4=8,yellowPlayerState;
	Play play;
	public static int  returnIteratorValueYellow;
	public static boolean checkOnHomeFLAG_1= false ;
	public static boolean checkOnHomeFLAG_2= false ;
	public static boolean checkOnHomeFLAG_3= false ;
	public static boolean checkOnHomeFLAG_4= false ;
	
	
	public YellowPlayer(){
	}
	public void yellowPlayerPlay(){
		System.out.println("11111==="+Play.listIteratorYellow1);
		System.out.println("22222==="+Play.listIteratorYellow2);
		System.out.println("33333==="+Play.listIteratorYellow3);
		System.out.println("44444==="+Play.listIteratorYellow4);
		
		
		//System.out.println("diceValueYellow"+diceValueYellow);
		
		//diceValueYellow=6;
		
		//checking the initial player is at StartPosition or not if get 6
		int y1 = Play.boardStepPositionsLIST.get(4).playerId;
		int y2 = Play.boardStepPositionsLIST.get(5).playerId;
		int y3 = Play.boardStepPositionsLIST.get(6).playerId;
		int y4 = Play.boardStepPositionsLIST.get(7).playerId;
		int y1_state=Play.boardStepPositionsLIST.get(4).playerState;
		int y2_state=Play.boardStepPositionsLIST.get(5).playerState;
		int y3_state=Play.boardStepPositionsLIST.get(6).playerState;
		int y4_state=Play.boardStepPositionsLIST.get(7).playerState;
		//System.out.println(">>>>>>>>>"+y1_state+y2_state+y3_state+y4_state);
		System.out.println("->->->->>>>>>"+y1+y2+y3+y4);
		
		if(y4==2){
			y4=8;
		}
		
		if ( y1==5 && y2==6 && y3==7 && y4==8 ){
			allBricksStartPosition(y1,y2,y3,y4);
		}
		else if(y1==5 || y2==6 || y3==7 || y4==8){
			bricksStartPosition(y1,y2,y3,y4);
		}
		else if(y1==0 && y2==0 && y3==0 && y4==0){
			allbricksPlayPosition(y1,y2,y3,y4);
		}
		
	}
	
	
	private void allBricksStartPosition(int y1, int y2, int y3, int y4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueYellow=rollDice.getDiceValue();
		//diceValueYellow=6;
		//System.out.println("diceValueYellow:::"+diceValueYellow);
		if(diceValueYellow!=6){
			Play.playTurn=2;
			
		}
		if(diceValueYellow==6 && y1==5){
			bricksPosition(29, 5, 4, 0);
			Play.listIteratorYellow1=29;
			System.out.println("worked");
			
			yellowPlayerPlay();
			
		}
		
	}
	
	private void bricksStartPosition(int y1, int y2, int y3, int y4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueYellow=rollDice.getDiceValue();
		//System.out.println("diceValueYellow----"+diceValueYellow);
		
		
		if(diceValueYellow==6){
			
			if(y2==6){
				bricksPosition(29, 6, 5, 0);
				Play.listIteratorYellow2=29;
				yellowPlayerPlay();
			}else if(y3==7){
				bricksPosition(29, 7, 6, 0);
				Play.listIteratorYellow3=29;
				yellowPlayerPlay();
			}else if(y4==8 ){
				bricksPosition(29, 8, 7, 0);
				Play.listIteratorYellow4=29;
				yellowPlayerPlay();
			}
		}else if(diceValueYellow!=6 ){
			if(y1!=5){
				if(Play.listIteratorYellow1==29){
					
					bricksPosition(29+diceValueYellow, 5, 29, 0);
					Play.listIteratorYellow1=Play.listIteratorYellow1+diceValueYellow;
					Play.playTurn=2;
					
				}else if(Play.listIteratorYellow1!=29){
					
					
					bricksPosition(Play.listIteratorYellow1+diceValueYellow, 5, Play.listIteratorYellow1, 0);
					Play.listIteratorYellow1=Play.listIteratorYellow1+diceValueYellow;
					Play.playTurn=2;
				}
			}
			else if(y2!=6){
				if (Play.listIteratorYellow2==29){
					
					bricksPosition(29+diceValueYellow, 6, 29, 0);
					Play.listIteratorYellow2=Play.listIteratorYellow2+diceValueYellow;
					Play.playTurn=2;
				}else if(Play.listIteratorYellow2!=29){
					
					bricksPosition(Play.listIteratorYellow2+diceValueYellow, 6, Play.listIteratorYellow2, 0);
					Play.listIteratorYellow2=Play.listIteratorYellow2+diceValueYellow;
					Play.playTurn=2;
				}
				
			}
			else if(y3!=7){
				if (Play.listIteratorYellow3==29){
					
					bricksPosition(29+diceValueYellow, 7, 29, 0);
					Play.listIteratorYellow3=Play.listIteratorYellow3+diceValueYellow;
					Play.playTurn=2;
				}else if(Play.listIteratorYellow3!=29){
					
					bricksPosition(Play.listIteratorYellow3+diceValueYellow, 5, Play.listIteratorYellow3, 0);
					Play.listIteratorYellow3=Play.listIteratorYellow3+diceValueYellow;
					Play.playTurn=2;
				}
				
			}
			else if(y4!=8 ){
				if (Play.listIteratorYellow4==29){
					
					bricksPosition(29+diceValueYellow, 8, 29, 0);
					Play.listIteratorYellow4=Play.listIteratorYellow4+diceValueYellow;
					Play.playTurn=2;
				}else if(Play.listIteratorYellow4!=29){
					
					bricksPosition(Play.listIteratorYellow4+diceValueYellow, 5, Play.listIteratorYellow4, 0);
					Play.listIteratorYellow4=Play.listIteratorYellow4+diceValueYellow;
					Play.playTurn=2;
				}
				
			}
			
		}
	}
	
	private void allbricksPlayPosition(int y1, int y2, int y3, int y4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueYellow=rollDice.getDiceValue();
		//System.out.println("diceValueYellow:::::->"+diceValueYellow);
		
		Random randomValue=new Random();
		int yellowPlayerTurn=randomValue.nextInt(4)+1;
		
		
		
		//int beatBricksYellow=diceValueYellow+yellowPlayerTurn;
		if(yellowPlayerTurn==1){
			beatEnemyBricks(Play.listIteratorYellow1,diceValueYellow);
		}else if(yellowPlayerTurn==2){
			beatEnemyBricks(Play.listIteratorYellow2,diceValueYellow);
		}else if(yellowPlayerTurn==3){
			beatEnemyBricks(Play.listIteratorYellow3,diceValueYellow);
		}else if(yellowPlayerTurn==4){
			beatEnemyBricks(Play.listIteratorYellow4,diceValueYellow);
		}
		
		if(diceValueYellow==6){
			if(yellowPlayerTurn==1){
				
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow1);
				
				bricksPosition(Play.listIteratorYellow1+diceValueYellow, 5, Play.listIteratorYellow1, 0);
				if(Play.listIteratorYellow1+diceValueYellow>67){
					Play.listIteratorYellow1=((Play.listIteratorYellow1+diceValueYellow)-67)+15;
					System.out.println("Play.listIteratorYellow1>>>"+Play.listIteratorYellow1);
					checkOnHomeFLAG_1=true;
				}else if (checkOnHomeFLAG_1==false &&Play.listIteratorYellow1+diceValueYellow<67){
					Play.listIteratorYellow1=Play.listIteratorYellow1+diceValueYellow;
				}
				if(checkOnHomeFLAG_1==true){
					Play.listIteratorYellow1=checkOnWayHomeYellow(Play.listIteratorYellow1,diceValueYellow);
				}
				yellowPlayerPlay();
			}else if(yellowPlayerTurn==2){
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow2);
				
				bricksPosition(Play.listIteratorYellow2+diceValueYellow, 6, Play.listIteratorYellow2, 0);
				if(Play.listIteratorYellow2+diceValueYellow>67){
					Play.listIteratorYellow2=((Play.listIteratorYellow2+diceValueYellow)-67)+15;
					System.out.println("Play.listIteratorYellow2>>>"+Play.listIteratorYellow2);
					checkOnHomeFLAG_2=true;
				}else if(checkOnHomeFLAG_2==false && Play.listIteratorYellow2+diceValueYellow<67){
					Play.listIteratorYellow2=Play.listIteratorYellow2+diceValueYellow;
				}
				if(checkOnHomeFLAG_2==true){
					Play.listIteratorYellow2=checkOnWayHomeYellow(Play.listIteratorYellow2,diceValueYellow);
				}
				yellowPlayerPlay();
			}else if(yellowPlayerTurn==3){
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow3);
				
				bricksPosition(Play.listIteratorYellow3+diceValueYellow, 7, Play.listIteratorYellow3, 0);
				if(Play.listIteratorYellow3+diceValueYellow>67){
					Play.listIteratorYellow3=((Play.listIteratorYellow3+diceValueYellow)-67)+15;
					System.out.println("Play.listIteratorYellow3>>>"+Play.listIteratorYellow3);
					checkOnHomeFLAG_3=true;
				}else if (checkOnHomeFLAG_3==false && Play.listIteratorYellow3+diceValueYellow<67){
					Play.listIteratorYellow3=Play.listIteratorYellow3+diceValueYellow;
				}
				if(checkOnHomeFLAG_3==true){
					Play.listIteratorYellow3=checkOnWayHomeYellow(Play.listIteratorYellow3,diceValueYellow);
				}
				yellowPlayerPlay();
			}else if(yellowPlayerTurn==4){
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow4);
				
				bricksPosition(Play.listIteratorYellow4+diceValueYellow, 8, Play.listIteratorYellow4, 0);
				if(Play.listIteratorYellow4+diceValueYellow>67){
					Play.listIteratorYellow4=((Play.listIteratorYellow4+diceValueYellow)-67)+15;
					System.out.println("Play.listIteratorYellow4>>>"+Play.listIteratorYellow4);
					checkOnHomeFLAG_4=true;
				}else if(checkOnHomeFLAG_4==false &&Play.listIteratorYellow4+diceValueYellow<67){
					Play.listIteratorYellow4=Play.listIteratorYellow4+diceValueYellow;
				}
				if(checkOnHomeFLAG_4==true){
					Play.listIteratorYellow4=checkOnWayHomeYellow(Play.listIteratorYellow4,diceValueYellow);
				}
				yellowPlayerPlay();
			}
			
		}else if(diceValueYellow!=6){
			if (yellowPlayerTurn == 1) {
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow1);
				
				bricksPosition(Play.listIteratorYellow1+diceValueYellow, 5, Play.listIteratorYellow1, 0);
				if(Play.listIteratorYellow1+diceValueYellow>67){
					Play.listIteratorYellow1=((Play.listIteratorYellow1+diceValueYellow)-67)+15;
					checkOnHomeFLAG_1=true;
				}else if (checkOnHomeFLAG_1==false){
					Play.listIteratorYellow1=Play.listIteratorYellow1+diceValueYellow;
				}
				if(checkOnHomeFLAG_1==true){
					Play.listIteratorYellow1=checkOnWayHomeYellow(Play.listIteratorYellow1,diceValueYellow);
				}
				Play.playTurn=2;
			} else if (yellowPlayerTurn == 2) {
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow2);
				
				bricksPosition(Play.listIteratorYellow2+diceValueYellow, 6, Play.listIteratorYellow2, 0);
				if(Play.listIteratorYellow2+diceValueYellow>67){
					Play.listIteratorYellow2=((Play.listIteratorYellow2+diceValueYellow)-67)+15;
					checkOnHomeFLAG_2=true;
				}else if(checkOnHomeFLAG_2==false){
					Play.listIteratorYellow2=Play.listIteratorYellow2+diceValueYellow;
				}
				if(checkOnHomeFLAG_2==true){
					Play.listIteratorYellow2=checkOnWayHomeYellow(Play.listIteratorYellow2,diceValueYellow);
				}
				Play.playTurn=2;
			} else if (yellowPlayerTurn == 3) {
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow3);
				
				bricksPosition(Play.listIteratorYellow3+diceValueYellow, 7, Play.listIteratorYellow3, 0);
				if(Play.listIteratorYellow3+diceValueYellow>67){
					Play.listIteratorYellow3=((Play.listIteratorYellow3+diceValueYellow)-67)+15;
					checkOnHomeFLAG_3=true;
				}else if (checkOnHomeFLAG_3==false){
					Play.listIteratorYellow3=Play.listIteratorYellow3+diceValueYellow;
				}
				if(checkOnHomeFLAG_3==true){
					Play.listIteratorYellow3=checkOnWayHomeYellow(Play.listIteratorYellow3,diceValueYellow);
				}
				Play.playTurn=2;
			} else if (yellowPlayerTurn == 4) {
				beatEnemyBrick(diceValueYellow,Play.listIteratorYellow4);
				
				bricksPosition(Play.listIteratorYellow4+diceValueYellow, 8, Play.listIteratorYellow4, 0);
				if(Play.listIteratorYellow4+diceValueYellow>67){
					Play.listIteratorYellow4=((Play.listIteratorYellow4+diceValueYellow)-67)+15;
					checkOnHomeFLAG_4=true;
				}else if(checkOnHomeFLAG_4==false){
					Play.listIteratorYellow4=Play.listIteratorYellow4+diceValueYellow;
				}
				if(checkOnHomeFLAG_4==true){
					Play.listIteratorYellow4=checkOnWayHomeYellow(Play.listIteratorYellow4,diceValueYellow);
				}
				Play.playTurn=2;
			}
		}
		
	}
	
	
	
	private void beatEnemyBrick(int diceValueYellow2,int listIteratorYellow) {
		// TODO Auto-generated method stub
		int yCheck=diceValueYellow2+listIteratorYellow;
		
		for(int i=0;i<16;i++){
			if((BeatBricks.beatablePlayerId_index[i]!=Play.listIteratorYellow1)&&(BeatBricks.beatablePlayerId_index[i]!=Play.listIteratorYellow1)&&
					(BeatBricks.beatablePlayerId_index[i]!=Play.listIteratorYellow1)&&(BeatBricks.beatablePlayerId_index[i]!=Play.listIteratorYellow1)){
				
				if(yCheck==BeatBricks.beatablePlayerId_index[i]){
					getDiceByindexValue(i);
					}
				}
		}		
	}
	private void getDiceByindexValue(int yCheck) {
		// TODO Auto-generated method stub
		if(yCheck==0){
			Play.listIteratorGreen1=0;
		}else if(yCheck==1){
			Play.listIteratorGreen2=1;
		}else if(yCheck==2){
			Play.listIteratorGreen3=2;
		}else if(yCheck==3){
			Play.listIteratorGreen4=3;
		}else if(yCheck==4){
			Play.listIteratorYellow1=4;
		}else if(yCheck==5){
			Play.listIteratorYellow2=5;
		}else if(yCheck==6){
			Play.listIteratorYellow3=6;
		}else if(yCheck==7){
			Play.listIteratorYellow4=7;
		}else if(yCheck==8){
			Play.listIteratorRed1=8;
		}else if(yCheck==9){
			Play.listIteratorRed2=9;
		}else if(yCheck==10){
			Play.listIteratorRed3=10;
		}else if(yCheck==11){
			Play.listIteratorRed4=11;
		}else if(yCheck==12){
			Play.listIteratorBlue1=12;
		}else if(yCheck==13){
			Play.listIteratorBlue2=13;
		}else if(yCheck==14){
			Play.listIteratorBlue3=14;
		}else if(yCheck==15){
			Play.listIteratorBlue4=15;
		}
		
	}
	private void bricksPosition(int listIteratorIndex_1, int player_Id_1,
			int listIteratorIndex_2, int player_Id_2) {
		// TODO Auto-generated method stub
		if(listIteratorIndex_2 == 29){
			BoardStepPosition boardStepPositionYellow = Play.boardStepPositionsLIST
					.get(listIteratorIndex_1);
			boardStepPositionYellow.playerId = player_Id_1;
			Play.boardStepPositionsLIST.set(listIteratorIndex_1,boardStepPositionYellow);
		}else{
			BoardStepPosition boardStepPositionYellow = Play.boardStepPositionsLIST
					.get(listIteratorIndex_1);
			boardStepPositionYellow.playerId = player_Id_1;
			//System.out.println("boardStepPositionGreen.playerId::"+boardStepPositionYellow.playerId);
			Play.boardStepPositionsLIST.set(listIteratorIndex_1,
					boardStepPositionYellow);

			BoardStepPosition boardStepPositionYellow1 = Play.boardStepPositionsLIST
					.get(listIteratorIndex_2);
			boardStepPositionYellow1.playerId = player_Id_2;
			//System.out.println("boardStepPositionGreen1.playerId::"+boardStepPositionYellow1.playerId);
			Play.boardStepPositionsLIST.set(listIteratorIndex_2,
					boardStepPositionYellow1);
			
		}
	}
	
	public int checkOnWayHomeYellow( int listIteratoryellow,int diceValueYellow ){
		if(listIteratoryellow+diceValueYellow>=27){
			int x=(listIteratoryellow+diceValueYellow-27)+73;
			if (x>79){
				return listIteratoryellow;
			}else if (x<79){
				return (listIteratoryellow+diceValueYellow-27)+73;
			}
			return 79;
		}
		
		else if (listIteratoryellow+diceValueYellow>=16 && listIteratoryellow+diceValueYellow<27){
			return listIteratoryellow+diceValueYellow;
		}
		else {
			return 0;
		}
	}
	
	private void beatEnemyBricks(int listIteratorYellow, int diceValueYellow) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 53; i++) {
			int id=Play.boardStepPositionsLIST.get(16 + i).playerId;
			
			if(id!=0 && id!=5 && id!=6 && id!=7&& id!=8){
//				Play.bricksIdIndex[i] = Play.boardStepPositionsLIST.get(16 + i).playerId;
//				System.out.println("id"+id);
			}
			
			
		}
		
	}
}



