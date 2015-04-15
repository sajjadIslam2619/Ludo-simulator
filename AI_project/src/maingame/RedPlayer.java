package maingame;

import java.util.Random;

public class RedPlayer {
	public int returnValues;
	public int diceValueRed;
	public int redPlayerID_1=5,redPlayerID_2=6,redPlayerID_3=7,redPlayerID_4=8,redPlayerState;
	Play play;
	public static int  returnIteratorValueYellow;
	public static boolean redCheckOnHomeFLAG_1= false ;
	public static boolean redCheckOnHomeFLAG_2= false ;
	public static boolean redCheckOnHomeFLAG_3= false ;
	public static boolean redCheckOnHomeFLAG_4= false ;
	
	
	public RedPlayer(){
	}
	public void redPlayerPlay(){
		System.out.println("11111==="+Play.listIteratorRed1);
		System.out.println("22222==="+Play.listIteratorRed2);
		System.out.println("33333==="+Play.listIteratorRed3);
		System.out.println("44444==="+Play.listIteratorRed4);
		
		
		//System.out.println("diceValueYellow"+diceValueYellow);
		
		
		
		//checking the initial player is at StartPosition or not if get 6
		int r1 = Play.boardStepPositionsLIST.get(8).playerId;
		int r2 = Play.boardStepPositionsLIST.get(9).playerId;
		int r3 = Play.boardStepPositionsLIST.get(10).playerId;
		int r4 = Play.boardStepPositionsLIST.get(11).playerId;
		
		System.out.println("->->->->>>>>>"+r1+r2+r3+r4);
		
		if(r4==2){
			r4=12;
		}
		
		if ( r1==9 && r2==10 && r3==11 && r4==12 ){
			allBricksStartPosition(r1,r2,r3,r4);
		}
		else if(r1==9 || r2==10 || r3==11 || r4==12){
			bricksStartPosition(r1,r2,r3,r4);
		}
		else if(r1==0 && r2==0 && r3==0 && r4==0){
			allbricksPlayPosition(r1,r2,r3,r4);
		}
		
	}
	
	
	private void allBricksStartPosition(int r1, int r2, int r3, int r4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueRed=rollDice.getDiceValue();
		//diceValueRed=6;
		//System.out.println("diceValueYellow:::"+diceValueYellow);
		if(diceValueRed!=6){
			Play.playTurn=3;
			
		}
		if(diceValueRed==6 && r1==9){
			bricksPosition(42, 9, 8, 0);
			Play.listIteratorRed1=42;
			System.out.println("worked");
			redPlayerPlay();
			
		}
		
	}
	
	private void bricksStartPosition(int r1, int r2, int r3, int r4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueRed=rollDice.getDiceValue();
		//diceValueRed=6;
		//System.out.println("diceValueYellow----"+diceValueYellow);
		
		if(diceValueRed==6){
			
			if(r2==10){
				bricksPosition(42, 10, 9, 0);
				Play.listIteratorRed2=42;
				redPlayerPlay();
			}else if(r3==11){
				bricksPosition(42, 11, 10, 0);
				Play.listIteratorRed3=42;
				redPlayerPlay();
			}else if(r4==12 ){
				bricksPosition(42, 12, 11, 0);
				Play.listIteratorRed4=42;
				redPlayerPlay();
			}
		}else if(diceValueRed!=6 ){
			if(r1!=9){
				if(Play.listIteratorRed1==42){
					
					bricksPosition(42+diceValueRed, 9, 42, 0);
					Play.listIteratorRed1=Play.listIteratorRed1+diceValueRed;
					Play.playTurn=3;
					
				}else if(Play.listIteratorRed1!=42){
					
					
					bricksPosition(Play.listIteratorRed1+diceValueRed, 9, Play.listIteratorRed1, 0);
					Play.listIteratorRed1=Play.listIteratorRed1+diceValueRed;
					Play.playTurn=3;
				}
			}
			else if(r2!=10){
				if (Play.listIteratorRed2==42){
					
					bricksPosition(42+diceValueRed, 10, 42, 0);
					Play.listIteratorRed2=Play.listIteratorRed2+diceValueRed;
					Play.playTurn=3;
				}else if(Play.listIteratorRed2!=42){
					
					bricksPosition(Play.listIteratorRed2+diceValueRed, 10, Play.listIteratorRed2, 0);
					Play.listIteratorRed2=Play.listIteratorRed2+diceValueRed;
					Play.playTurn=3;
				}
				
			}
			else if(r3!=11){
				if (Play.listIteratorRed3==42){
					
					bricksPosition(42+diceValueRed, 11, 42, 0);
					Play.listIteratorRed3=Play.listIteratorRed3+diceValueRed;
					Play.playTurn=3;
				}else if(Play.listIteratorRed3!=42){
					
					bricksPosition(Play.listIteratorRed3+diceValueRed, 11, Play.listIteratorRed3, 0);
					Play.listIteratorRed3=Play.listIteratorRed3+diceValueRed;
					Play.playTurn=3;
				}
				
			}
			else if(r4!=12 ){
				if (Play.listIteratorRed4==42){
					
					bricksPosition(42+diceValueRed, 12, 42, 0);
					Play.listIteratorRed4=Play.listIteratorRed4+diceValueRed;
					Play.playTurn=3;
				}else if(Play.listIteratorRed4!=42){
					
					bricksPosition(Play.listIteratorRed4+diceValueRed, 12, Play.listIteratorRed4, 0);
					Play.listIteratorRed4=Play.listIteratorRed4+diceValueRed;
					Play.playTurn=3;
				}
				
			}
			
		}
	}
	
	private void allbricksPlayPosition(int r1, int r2, int r3, int r4) {
		// TODO Auto-generated method stub
		RollDice rollDice =new RollDice();
		diceValueRed=rollDice.getDiceValue();
		//System.out.println("diceValueYellow:::::->"+diceValueYellow);
		
		int retunValue = beatEnemyBricksRed(diceValueRed);
		int redPlayerTurn;
		if(retunValue==0) {
			Random randomValue=new Random();
			redPlayerTurn=randomValue.nextInt(4)+1;
		}else{
			redPlayerTurn = retunValue;
		}
		
		if(redPlayerTurn==1){
			beatEnemyBricks(Play.listIteratorRed1,diceValueRed);
		}else if(redPlayerTurn==2){
			beatEnemyBricks(Play.listIteratorRed2,diceValueRed);
		}else if(redPlayerTurn==3){
			beatEnemyBricks(Play.listIteratorRed3,diceValueRed);
		}else if(redPlayerTurn==4){
			beatEnemyBricks(Play.listIteratorRed4,diceValueRed);
		}
		
		if(diceValueRed==6){
			if(redPlayerTurn==1){
				
				bricksPosition(Play.listIteratorRed1+diceValueRed, 9, Play.listIteratorRed1, 0);
				if(Play.listIteratorRed1+diceValueRed>67){
					Play.listIteratorRed1=((Play.listIteratorRed1+diceValueRed)-67)+15;
					System.out.println("Play.listIteratorRed1>>>"+Play.listIteratorRed1);
					redCheckOnHomeFLAG_1=true;
				}else if (redCheckOnHomeFLAG_1==false &&Play.listIteratorRed1+diceValueRed<67){
					Play.listIteratorRed1=Play.listIteratorRed1+diceValueRed;
				}
				if(redCheckOnHomeFLAG_1==true){
					Play.listIteratorRed1=checkOnWayHomeRed(Play.listIteratorRed1,diceValueRed);
				}
				redPlayerPlay();
			}else if(redPlayerTurn==2){
				
				bricksPosition(Play.listIteratorRed2+diceValueRed, 10, Play.listIteratorRed2, 0);
				if(Play.listIteratorRed2+diceValueRed>67){
					Play.listIteratorRed2=((Play.listIteratorRed2+diceValueRed)-67)+15;
					System.out.println("Play.listIteratorRed2>>>"+Play.listIteratorRed2);
					redCheckOnHomeFLAG_2=true;
				}else if(redCheckOnHomeFLAG_2==false && Play.listIteratorRed2+diceValueRed<67){
					Play.listIteratorRed2=Play.listIteratorRed2+diceValueRed;
				}
				if(redCheckOnHomeFLAG_2==true){
					Play.listIteratorRed2=checkOnWayHomeRed(Play.listIteratorRed2,diceValueRed);
				}
				redPlayerPlay();
			}else if(redPlayerTurn==3){
				
				bricksPosition(Play.listIteratorRed3+diceValueRed,11, Play.listIteratorRed3, 0);
				if(Play.listIteratorRed3+diceValueRed>67){
					Play.listIteratorRed3=((Play.listIteratorRed3+diceValueRed)-67)+15;
					System.out.println("Play.listIteratorRed3>>>"+Play.listIteratorRed3);
					redCheckOnHomeFLAG_3=true;
				}else if (redCheckOnHomeFLAG_3==false && Play.listIteratorRed3+diceValueRed<67){
					Play.listIteratorRed3=Play.listIteratorRed3+diceValueRed;
				}
				if(redCheckOnHomeFLAG_3==true){
					Play.listIteratorRed3=checkOnWayHomeRed(Play.listIteratorRed3,diceValueRed);
				}
				redPlayerPlay();
			}else if(redPlayerTurn==4){
				
				bricksPosition(Play.listIteratorRed4+diceValueRed, 12, Play.listIteratorRed4, 0);
				if(Play.listIteratorRed4+diceValueRed>67){
					Play.listIteratorRed4=((Play.listIteratorRed4+diceValueRed)-67)+15;
					System.out.println("Play.listIteratorRed4>>>"+Play.listIteratorRed4);
					redCheckOnHomeFLAG_4=true;
				}else if(redCheckOnHomeFLAG_4==false &&Play.listIteratorRed4+diceValueRed<67){
					Play.listIteratorRed4=Play.listIteratorRed4+diceValueRed;
				}
				if(redCheckOnHomeFLAG_4==true){
					Play.listIteratorRed4=checkOnWayHomeRed(Play.listIteratorRed4,diceValueRed);
				}
				redPlayerPlay();
			}
			
		}else if(diceValueRed!=6){
			if (redPlayerTurn == 1) {
				
				bricksPosition(Play.listIteratorRed1+diceValueRed, 9, Play.listIteratorRed1, 0);
				if(Play.listIteratorRed1+diceValueRed>67){
					Play.listIteratorRed1=((Play.listIteratorRed1+diceValueRed)-67)+15;
					redCheckOnHomeFLAG_1=true;
				}else if (redCheckOnHomeFLAG_1==false){
					Play.listIteratorRed1=Play.listIteratorRed1+diceValueRed;
				}
				if(redCheckOnHomeFLAG_1==true){
					Play.listIteratorRed1=checkOnWayHomeRed(Play.listIteratorRed1,diceValueRed);
				}
				Play.playTurn=3;
			} else if (redPlayerTurn == 2) {
				
				bricksPosition(Play.listIteratorRed2+diceValueRed, 10, Play.listIteratorRed2, 0);
				if(Play.listIteratorRed2+diceValueRed>67){
					Play.listIteratorRed2=((Play.listIteratorRed2+diceValueRed)-67)+15;
					redCheckOnHomeFLAG_2=true;
				}else if(redCheckOnHomeFLAG_2==false){
					Play.listIteratorRed2=Play.listIteratorRed2+diceValueRed;
				}
				if(redCheckOnHomeFLAG_2==true){
					Play.listIteratorRed2=checkOnWayHomeRed(Play.listIteratorRed2,diceValueRed);
				}
				Play.playTurn=3;
			} else if (redPlayerTurn == 3) {
				
				bricksPosition(Play.listIteratorRed3+diceValueRed, 11, Play.listIteratorRed3, 0);
				if(Play.listIteratorRed3+diceValueRed>67){
					Play.listIteratorRed3=((Play.listIteratorRed3+diceValueRed)-67)+15;
					redCheckOnHomeFLAG_3=true;
				}else if (redCheckOnHomeFLAG_3==false){
					Play.listIteratorRed3=Play.listIteratorRed3+diceValueRed;
				}
				if(redCheckOnHomeFLAG_3==true){
					Play.listIteratorRed3=checkOnWayHomeRed(Play.listIteratorRed3,diceValueRed);
				}
				Play.playTurn=3;
			} else if (redPlayerTurn == 4) {
				
				bricksPosition(Play.listIteratorRed4+diceValueRed, 12, Play.listIteratorRed4, 0);
				if(Play.listIteratorRed4+diceValueRed>67){
					Play.listIteratorRed4=((Play.listIteratorRed4+diceValueRed)-67)+15;
					redCheckOnHomeFLAG_4=true;
				}else if(redCheckOnHomeFLAG_4==false){
					Play.listIteratorRed4=Play.listIteratorRed4+diceValueRed;
				}
				if(redCheckOnHomeFLAG_4==true){
					Play.listIteratorRed4=checkOnWayHomeRed(Play.listIteratorRed4,diceValueRed);
				}
				Play.playTurn=3;
			}
		}
		
	}
	
	
	
	private int beatEnemyBricksRed(int diceValueRed2) {
		
		int flag=0;
		for(int i=0;i<16;i++){
			if(i>=8 && i<=11) continue;
			if(BeatBricks.beatablePlayerId_index[8]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=1;
				break;
			}else if(BeatBricks.beatablePlayerId_index[9]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=2;
				break;
			}else if(BeatBricks.beatablePlayerId_index[10]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=3;
				break;
			}else if(BeatBricks.beatablePlayerId_index[11]+diceValueRed2 == BeatBricks.beatablePlayerId_index[i]){
				getDiceByindexValue(i);
				flag=4;
				break;
			}
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
		if(listIteratorIndex_2 == 42){
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
	
	public int checkOnWayHomeRed( int listIteratorRed,int diceValueRed ){
		if(listIteratorRed+diceValueRed>=40){
			int x=(listIteratorRed+diceValueRed-40)+79;
			if (x>79){
				return listIteratorRed;
			}else if (x<79){
				return (listIteratorRed+diceValueRed-40)+79;
			}
			return 85;
		}
		
		else if (listIteratorRed+diceValueRed>=16 && listIteratorRed+diceValueRed<40){
			return listIteratorRed+diceValueRed;
		}
		else {
			return 0;
		}
	}
	
	private void beatEnemyBricks(int listIteratorRed, int diceValueRed) {
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
