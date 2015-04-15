package maingame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class BluePlayer {
	
	public int returnValues;
	public int diceValueBlue;
	public int bluePlayerID_1=5,bluePlayerID_2=6,bluePlayerID_3=7,bluePlayerID_4=8,bluePlayerState;
	Play play;
	public static int  returnIteratorValueBlue;
	public static boolean blueCheckOnHomeFLAG_1= false ;
	public static boolean blueCheckOnHomeFLAG_2= false ;
	public static boolean blueCheckOnHomeFLAG_3= false ;
	public static boolean blueCheckOnHomeFLAG_4= false ;
	
	
	public BluePlayer(){
	}
	public void bluePlayerPlay(){
		Play.playTurnDisplay = "bluePlayer";
		
		//checking the initial player is at StartPosition or not if get 6
		int b1 = Play.boardStepPositionsLIST.get(12).playerId;
		int b2 = Play.boardStepPositionsLIST.get(13).playerId;
		int b3 = Play.boardStepPositionsLIST.get(14).playerId;
		int b4 = Play.boardStepPositionsLIST.get(15).playerId;
		
		if(b4==2){
			b4=16;
		}
		System.out.println("->->->->>>>>>"+b1+b2+b3+b4);
	
		if ( b1==13 && b2==14 && b3==15 && b4==16 ){
			allBricksStartPosition(b1,b2,b3,b4);
		}
		else if(b1==13 || b2==14 || b3==15 || b4==16){
			bricksStartPosition(b1,b2,b3,b4);
		}
		else if(b1==0 && b2==0 && b3==0 && b4==0){
			allbricksPlayPosition(b1,b2,b3,b4);
		}
		
	}
	
	
	private void allBricksStartPosition(int b1, int b2, int b3, int b4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueBlue=rollDice.getDiceValue();
		//diceValueBlue=6;
		//System.out.println("diceValueYellow:::"+diceValueYellow);
		if(diceValueBlue!=6){
			Play.playTurn=4;
			
		}
		if(diceValueBlue==6 && b1==13){
			bricksPosition(55, 13, 12, 0);
			Play.listIteratorBlue1=55;
			System.out.println("worked");
			bluePlayerPlay();
			
		}
		
	}
	
	private void bricksStartPosition(int b1, int b2, int b3, int b4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueBlue=rollDice.getDiceValue();
		//diceValueBlue=6;
		//System.out.println("diceValueYellow----"+diceValueYellow);
		
		if(diceValueBlue==6){
			
			if(b2==14){
				bricksPosition(55, 14, 13, 0);
				Play.listIteratorBlue2=55;
				bluePlayerPlay();
			}else if(b3==15){
				bricksPosition(55, 15, 14, 0);
				Play.listIteratorBlue3=55;
				bluePlayerPlay();
			}else if(b4==16 ){
				bricksPosition(55, 16, 15, 0);
				Play.listIteratorBlue4=55;
				bluePlayerPlay();
			}
		}else if(diceValueBlue!=6 ){
			if(b1!=13){
				if(Play.listIteratorBlue1==55){
					
					bricksPosition(55+diceValueBlue, 13, 55, 0);
					Play.listIteratorBlue1=Play.listIteratorBlue1+diceValueBlue;
					Play.playTurn=4;
					
				}else if(Play.listIteratorBlue1!=55){
					if(Play.listIteratorBlue1+diceValueBlue>67){
						Play.listIteratorBlue1=((Play.listIteratorBlue1+diceValueBlue)-67)+15;
						System.out.println("Play.listIteratorBlue1>>>"+Play.listIteratorBlue1);
						blueCheckOnHomeFLAG_1=true;
					}else if (blueCheckOnHomeFLAG_1==false &&Play.listIteratorBlue1+diceValueBlue<67){
						Play.listIteratorBlue1=Play.listIteratorBlue1+diceValueBlue;
					}
					if(blueCheckOnHomeFLAG_1==true){
						Play.listIteratorBlue1=checkOnWayHomeBlue(Play.listIteratorBlue1,diceValueBlue);
					}
					
//					bricksPosition(Play.listIteratorBlue1+diceValueBlue, 13, Play.listIteratorBlue1, 0);
//					Play.listIteratorBlue1=Play.listIteratorBlue1+diceValueBlue;
//					Play.playTurn=4;
				}
			}
			else if(b2!=14){
				if (Play.listIteratorBlue2==55){
					
					bricksPosition(29+diceValueBlue, 14, 55, 0);
					Play.listIteratorBlue2=Play.listIteratorBlue2+diceValueBlue;
					Play.playTurn=4;
				}else if(Play.listIteratorBlue2!=55){
					
					//bricksPosition(Play.listIteratorBlue2+diceValueBlue, 14, Play.listIteratorBlue2, 0);
					if(Play.listIteratorBlue2+diceValueBlue>67){
						Play.listIteratorBlue2=((Play.listIteratorBlue2+diceValueBlue)-67)+15;
						System.out.println("Play.listIteratorBlue2>>>"+Play.listIteratorBlue2);
						blueCheckOnHomeFLAG_2=true;
					}else if(blueCheckOnHomeFLAG_2==false && Play.listIteratorBlue2+diceValueBlue<67){
						Play.listIteratorBlue2=Play.listIteratorBlue2+diceValueBlue;
					}
					if(blueCheckOnHomeFLAG_2==true){
						Play.listIteratorBlue2=checkOnWayHomeBlue(Play.listIteratorBlue2,diceValueBlue);
					}
					
//					bricksPosition(Play.listIteratorBlue2+diceValueBlue, 14, Play.listIteratorBlue2, 0);
//					Play.listIteratorBlue2=Play.listIteratorBlue2+diceValueBlue;
//					Play.playTurn=4;
				}
				
			}
			else if(b3!=15){
				if (Play.listIteratorBlue3==55){
					
					bricksPosition(55+diceValueBlue, 15, 55, 0);
					Play.listIteratorBlue3=Play.listIteratorBlue3+diceValueBlue;
					Play.playTurn=4;
				}else if(Play.listIteratorBlue3!=55){
					
					if(Play.listIteratorBlue3+diceValueBlue>67){
						Play.listIteratorBlue3=((Play.listIteratorBlue3+diceValueBlue)-67)+15;
						System.out.println("Play.listIteratorBlue3>>>"+Play.listIteratorBlue3);
						blueCheckOnHomeFLAG_3=true;
					}else if (blueCheckOnHomeFLAG_3==false && Play.listIteratorBlue3+diceValueBlue<67){
						Play.listIteratorBlue3=Play.listIteratorBlue3+diceValueBlue;
					}
					if(blueCheckOnHomeFLAG_3==true){
						Play.listIteratorBlue3=checkOnWayHomeBlue(Play.listIteratorBlue3,diceValueBlue);
					}
					
//					bricksPosition(Play.listIteratorBlue3+diceValueBlue, 15, Play.listIteratorBlue3, 0);
//					Play.listIteratorBlue3=Play.listIteratorBlue3+diceValueBlue;
//					Play.playTurn=4;
				}
				
			}
			else if(b4!=16 ){
				if (Play.listIteratorBlue4==55){
					
					bricksPosition(29+diceValueBlue, 16, 55, 0);
					Play.listIteratorBlue4=Play.listIteratorBlue4+diceValueBlue;
					Play.playTurn=4;
				}else if(Play.listIteratorBlue4!=55){
					
					if(Play.listIteratorBlue4+diceValueBlue>67){
						Play.listIteratorBlue4=((Play.listIteratorBlue4+diceValueBlue)-67)+15;
						System.out.println("Play.listIteratorBlue4>>>"+Play.listIteratorBlue4);
						blueCheckOnHomeFLAG_4=true;
					}else if(blueCheckOnHomeFLAG_4==false &&Play.listIteratorBlue4+diceValueBlue<67){
						Play.listIteratorBlue4=Play.listIteratorBlue4+diceValueBlue;
					}
					if(blueCheckOnHomeFLAG_4==true){
						Play.listIteratorBlue4=checkOnWayHomeBlue(Play.listIteratorBlue4,diceValueBlue);
					}
					
//					bricksPosition(Play.listIteratorBlue4+diceValueBlue, 16, Play.listIteratorBlue4, 0);
//					Play.listIteratorBlue4=Play.listIteratorBlue4+diceValueBlue;
//					Play.playTurn=4;
				}
				
			}
			
		}
	}
	
	private void allbricksPlayPosition(int b1, int b2, int b3, int b4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueBlue=rollDice.getDiceValue();
		//System.out.println("diceValueYellow:::::->"+diceValueYellow);
		int bluePlayerTurn = beatEnemyBricksBlue(diceValueBlue);
		
		
		//Random randomValue=new Random();
		//int bluePlayerTurn=randomValue.nextInt(4)+1;
		if(bluePlayerTurn==1){
			beatEnemyBricks(Play.listIteratorBlue1,diceValueBlue);
		}else if(bluePlayerTurn==2){
			beatEnemyBricks(Play.listIteratorBlue2,diceValueBlue);
		}else if(bluePlayerTurn==3){
			beatEnemyBricks(Play.listIteratorBlue3,diceValueBlue);
		}else if(bluePlayerTurn==4){
			beatEnemyBricks(Play.listIteratorBlue4,diceValueBlue);
		}
		
		if(diceValueBlue==6){
			if(bluePlayerTurn==1){
				
				bricksPosition(Play.listIteratorBlue1+diceValueBlue, 13, Play.listIteratorBlue1, 0);
				if(Play.listIteratorBlue1+diceValueBlue>67){
					Play.listIteratorBlue1=((Play.listIteratorBlue1+diceValueBlue)-67)+15;
					System.out.println("Play.listIteratorBlue1>>>"+Play.listIteratorBlue1);
					blueCheckOnHomeFLAG_1=true;
				}else if (blueCheckOnHomeFLAG_1==false &&Play.listIteratorBlue1+diceValueBlue<67){
					Play.listIteratorBlue1=Play.listIteratorBlue1+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_1==true){
					Play.listIteratorBlue1=checkOnWayHomeBlue(Play.listIteratorBlue1,diceValueBlue);
				}
				bluePlayerPlay();
			}else if(bluePlayerTurn==2){
				
				bricksPosition(Play.listIteratorBlue2+diceValueBlue, 14, Play.listIteratorBlue2, 0);
				if(Play.listIteratorBlue2+diceValueBlue>67){
					Play.listIteratorBlue2=((Play.listIteratorBlue2+diceValueBlue)-67)+15;
					System.out.println("Play.listIteratorBlue2>>>"+Play.listIteratorBlue2);
					blueCheckOnHomeFLAG_2=true;
				}else if(blueCheckOnHomeFLAG_2==false && Play.listIteratorBlue2+diceValueBlue<67){
					Play.listIteratorBlue2=Play.listIteratorBlue2+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_2==true){
					Play.listIteratorBlue2=checkOnWayHomeBlue(Play.listIteratorBlue2,diceValueBlue);
				}
				bluePlayerPlay();
			}else if(bluePlayerTurn==3){
				
				bricksPosition(Play.listIteratorBlue3+diceValueBlue, 15, Play.listIteratorBlue3, 0);
				if(Play.listIteratorBlue3+diceValueBlue>67){
					Play.listIteratorBlue3=((Play.listIteratorBlue3+diceValueBlue)-67)+15;
					System.out.println("Play.listIteratorBlue3>>>"+Play.listIteratorBlue3);
					blueCheckOnHomeFLAG_3=true;
				}else if (blueCheckOnHomeFLAG_3==false && Play.listIteratorBlue3+diceValueBlue<67){
					Play.listIteratorBlue3=Play.listIteratorBlue3+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_3==true){
					Play.listIteratorBlue3=checkOnWayHomeBlue(Play.listIteratorBlue3,diceValueBlue);
				}
				bluePlayerPlay();
			}else if(bluePlayerTurn==4){
				
				bricksPosition(Play.listIteratorBlue4+diceValueBlue, 16, Play.listIteratorBlue4, 0);
				if(Play.listIteratorBlue4+diceValueBlue>67){
					Play.listIteratorBlue4=((Play.listIteratorBlue4+diceValueBlue)-67)+15;
					System.out.println("Play.listIteratorBlue4>>>"+Play.listIteratorBlue4);
					blueCheckOnHomeFLAG_4=true;
				}else if(blueCheckOnHomeFLAG_4==false &&Play.listIteratorBlue4+diceValueBlue<67){
					Play.listIteratorBlue4=Play.listIteratorBlue4+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_4==true){
					Play.listIteratorBlue4=checkOnWayHomeBlue(Play.listIteratorBlue4,diceValueBlue);
				}
				bluePlayerPlay();
			}
			
		}else if(diceValueBlue!=6){
			if (bluePlayerTurn == 1) {
				
				bricksPosition(Play.listIteratorBlue1+diceValueBlue, 13, Play.listIteratorBlue1, 0);
				if(Play.listIteratorBlue1+diceValueBlue>67){
					Play.listIteratorBlue1=((Play.listIteratorBlue1+diceValueBlue)-67)+15;
					blueCheckOnHomeFLAG_1=true;
				}else if (blueCheckOnHomeFLAG_1==false){
					Play.listIteratorBlue1=Play.listIteratorBlue1+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_1==true){
					Play.listIteratorBlue1=checkOnWayHomeBlue(Play.listIteratorBlue1,diceValueBlue);
				}
				Play.playTurn=4;
			} else if (bluePlayerTurn == 2) {
				
				bricksPosition(Play.listIteratorBlue2+diceValueBlue, 14, Play.listIteratorBlue2, 0);
				if(Play.listIteratorBlue2+diceValueBlue>67){
					Play.listIteratorBlue2=((Play.listIteratorBlue2+diceValueBlue)-67)+15;
					blueCheckOnHomeFLAG_2=true;
				}else if(blueCheckOnHomeFLAG_2==false){
					Play.listIteratorBlue2=Play.listIteratorBlue2+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_2==true){
					Play.listIteratorBlue2=checkOnWayHomeBlue(Play.listIteratorBlue2,diceValueBlue);
				}
				Play.playTurn=4;
			} else if (bluePlayerTurn == 3) {
				
				bricksPosition(Play.listIteratorBlue3+diceValueBlue, 15, Play.listIteratorBlue3, 0);
				if(Play.listIteratorBlue3+diceValueBlue>67){
					Play.listIteratorBlue3=((Play.listIteratorBlue3+diceValueBlue)-67)+15;
					blueCheckOnHomeFLAG_3=true;
				}else if (blueCheckOnHomeFLAG_3==false){
					Play.listIteratorBlue3=Play.listIteratorBlue3+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_3==true){
					Play.listIteratorBlue3=checkOnWayHomeBlue(Play.listIteratorBlue3,diceValueBlue);
				}
				Play.playTurn=4;
			} else if (bluePlayerTurn == 4) {
				
				bricksPosition(Play.listIteratorBlue4+diceValueBlue, 16, Play.listIteratorBlue4, 0);
				if(Play.listIteratorBlue4+diceValueBlue>67){
					Play.listIteratorBlue4=((Play.listIteratorBlue4+diceValueBlue)-67)+15;
					blueCheckOnHomeFLAG_4=true;
				}else if(blueCheckOnHomeFLAG_4==false){
					Play.listIteratorBlue4=Play.listIteratorBlue4+diceValueBlue;
				}
				if(blueCheckOnHomeFLAG_4==true){
					Play.listIteratorBlue4=checkOnWayHomeBlue(Play.listIteratorBlue4,diceValueBlue);
				}
				Play.playTurn=4;
			}
		}
		
	}
	
	private int beatEnemyBricksBlue(int diceValueRed2) {
		
		int flag=0;
		for(int i=0;i<12;i++){
			if(BeatBricks.beatablePlayerId_index[12]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=1;
				break;
			}else if(BeatBricks.beatablePlayerId_index[13]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=2;
				break;
			}else if(BeatBricks.beatablePlayerId_index[14]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=3;
				break;
			}else if(BeatBricks.beatablePlayerId_index[15]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=4;
				break;
			}
		}
		if(flag==0){
			int playerId=1;
			int playerValue=99999;
			for(int j=12;j<16;j++){
				for(int i=0;i<12;i++){
					int value = BeatBricks.beatablePlayerId_index[i] - BeatBricks.beatablePlayerId_index[j];
					if(value< 0){
						value = value + 52;						
					}
					if(value < playerValue){
						playerId = j-11;
						playerValue = value;
					}
				}				
			}
						
			return playerId;
		}
		
		return flag;
		
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
		if(listIteratorIndex_2 == 55){
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
	
	public int checkOnWayHomeBlue( int listIteratorBlue,int diceValueBlue ){
		if(listIteratorBlue+diceValueBlue>=52){
			int x=(listIteratorBlue+diceValueBlue-27)+73;
			if (x>79){
				return listIteratorBlue;
			}else if (x<79){
				return (listIteratorBlue+diceValueBlue-27)+73;
			}
			return 79;
		}
		
		else if (listIteratorBlue+diceValueBlue>=16 && listIteratorBlue+diceValueBlue<52){
			return listIteratorBlue+diceValueBlue;
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
