package maingame;

import java.util.ArrayList;

public class BeatBricks {
	
	//public static ArrayList<BeatableBricksList> beatableBricksListList;//=new ArrayList<BeatableBricksList>();
	public static int [] beatablePlayerId_index =new int[16];
	//public static int[] beatablePlayerIndex=new int[12];
	//public static int iterator=0;
	int iterator;
	
	
	
	
	public void BeatBricks(){
		
	}
	public int[] beatableBricks(){
		System.out.println(beatablePlayerId_index[0]=Play.listIteratorGreen1);
		System.out.println(beatablePlayerId_index[1]=Play.listIteratorGreen2);
		System.out.println(beatablePlayerId_index[2]=Play.listIteratorGreen3);
		System.out.println(beatablePlayerId_index[3]=Play.listIteratorGreen4);
		System.out.println(beatablePlayerId_index[4]=Play.listIteratorYellow1);
		System.out.println(beatablePlayerId_index[5]=Play.listIteratorYellow2);
		System.out.println(beatablePlayerId_index[6]=Play.listIteratorYellow3);
		System.out.println(beatablePlayerId_index[7]=Play.listIteratorYellow4);
		System.out.println(beatablePlayerId_index[8]=Play.listIteratorRed1);
		System.out.println(beatablePlayerId_index[9]=Play.listIteratorRed2);
		System.out.println(beatablePlayerId_index[10]=Play.listIteratorRed3);
		System.out.println(beatablePlayerId_index[11]=Play.listIteratorRed4);
		System.out.println(beatablePlayerId_index[12]=Play.listIteratorBlue1);
		System.out.println(beatablePlayerId_index[13]=Play.listIteratorBlue2);
		System.out.println(beatablePlayerId_index[14]=Play.listIteratorBlue3);
		System.out.println(beatablePlayerId_index[15]=Play.listIteratorBlue4);


		return beatablePlayerId_index;
	}

}


































//for(iterator=16;iterator<=67;iterator++){
////System.out.println("!!!!!!!!"+Play.boardStepPositionsLIST.get(iterator).playerId);
//
//////if(iterator!=16 && iterator!=29 && iterator!=42 && iterator!=55){
////	int id=Play.boardStepPositionsLIST.get(iterator).playerId;
////	
////	
//////	if(id!=ownPlayer_ID_1&&id!=ownPlayer_ID_2&&id!=ownPlayer_ID_3&&id!=ownPlayer_ID_4&&id!=0){
//////		//beatableBricksList.add(new BeatableBricksList(id,iterator));
////		xx=id;
////		yy=iterator;
////		beatableBricksListList.add(new BeatableBricksList(xx,yy));
////	//}
//////}
//
//if(iterator==16 || iterator==29 || iterator==42 || iterator==55){
////	int id=Play.boardStepPositionsLIST.get(Play.listIteratorYellow1).playerId;
////	//System.out.println("ID::::::"+id);
////	if((id==ownPlayer_ID_1 || id==ownPlayer_ID_2 || id==ownPlayer_ID_3 || id==ownPlayer_ID_4) && id!=0){
//////		beatablePlayerId_index[counter]=id;
//////		System.out.println("iterator->->->->"+iterator);
//////		System.out.println("ID->->->->"+id);
//////		counter++;
//////		beatablePlayerId_index[counter]=iterator;
//////		counter++;
//////		System.out.println("~~~~~"+iterator);
//////		
////	}
//}
//else{
//	int id=Play.boardStepPositionsLIST.get(Play.listIteratorYellow1).playerId;
//	int state=Play.boardStepPositionsLIST.get(iterator).stepPositionId;
//	if(id==ownPlayer_ID_1 || id==ownPlayer_ID_2 || id==ownPlayer_ID_3 || id==ownPlayer_ID_4 || id==0){
//		
//	}
//	else{
//		//System.out.println("ID::::::"+id);
//	}
//}
//}
