package com.code.test;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class stepTwo { 
	public static void main(String[] args){
		//String baseballJudge[] = {"S", "B", "A", "O"}; //A = 안타
		String baseballCheck[] = {"스트라이크!", "볼!", "안타!", "아웃!"};	
        
        LinkedHashMap<String, LinkedHashMap> baseballGameMap = new LinkedHashMap<String, LinkedHashMap>();
        
        while (true){
        	System.out.println("신나는 야구 시합");
        	System.out.println("1. 데이터 입력");
        	System.out.println("2. 데이터 출력");
        	System.out.println("3. 시합 시작");
        	System.out.println("4. 종료");
        	
        	Scanner scn = new Scanner(System.in);
        	String choice = scn.nextLine();
        	
        	if (choice.equals("1")) {
        		baseballGameMap = stepTwoInputData(scn);
        		
        	} else if (choice.equals("2")) {
        		stepTwoOutputData(baseballGameMap);
        		
        	} else if (choice.equals("3")) {
        		System.out.println("시합 시작");
        		Map stepTwoResult = stepTwoPlayGame(baseballGameMap, baseballCheck);
        		
        	} else if (choice.equals("4")) {
        		System.out.println("종료했습니다.");
        		break;
        	} else {
        		System.out.println("1, 2 둘중의 메뉴를 선택하세요.");
        		
        	}
        	
        }
        
	}
    
	public static void stepTwoOutputData(LinkedHashMap<String, LinkedHashMap> baseballGameMap){
		if (baseballGameMap.size() < 1) {
			System.out.println("1번에 선수 정보를 입력하시길 바랍니다.");
		} else {
			for (String key : baseballGameMap.keySet()) {
				int playerNumber = 1;
				System.out.println(key + " 팀 정보");
				LinkedHashMap<String, String> playerList = baseballGameMap.get(key);
				
				for (String player : playerList.keySet()) {
					String battingAverage = playerList.get(player);
					System.out.println(playerNumber + "번  " + player + ", " + battingAverage);
					
				}
			}
		}
	}
	
    public static LinkedHashMap<String, LinkedHashMap> stepTwoInputData(Scanner scn){
    	//Map에 Map담기가 안될경우 Map의 첫번째 순서에 팀이름 넣기
    	LinkedHashMap<String, LinkedHashMap> baseballGameMap = new LinkedHashMap<String, LinkedHashMap>();
    	String result = "";
        for (int team = 1; team <= 2; team++) {
        	LinkedHashMap<String, String> playerMap = new LinkedHashMap<String, String>();
            System.out.println(team + "팀의 이름을 입력하세요>");
            //중복 처리
            String teamName = scn.nextLine();
            for (int i = 1; i <= 9; i++) {
                System.out.print(i + "번 타자 정보 입력>");
                String playerName = scn.nextLine();
                System.out.print(", ");
                String playerBattingAverage = scn.nextLine();//소수점 3자리까지
                
                playerMap.put(playerName, playerBattingAverage);
            }
            baseballGameMap.put(teamName, playerMap);
        }
        return baseballGameMap;
    }
	
    //게임실행
    public static Map stepTwoPlayGame(Map<String, LinkedHashMap> baseballGameMap, String baseballCheck[]){
    	LinkedHashMap<String, LinkedHashMap> totalScoreBoard = new LinkedHashMap<String, LinkedHashMap>();
    	LinkedHashMap<String, String> totalScore = new LinkedHashMap<String, String>();
    	int aTeamPlayerCount = 0;
    	int bTeamPlayerCount = 0;
    	int ateamScore = 0;
    	int bteamScore = 0;
    	ArrayList<String> teamName = new ArrayList<String>();
    	
    	for (String key : baseballGameMap.keySet()) {
    		teamName.add(key);
    	}
    	
    	for (int totalGame = 1; totalGame <= 6; totalGame++) {
            System.out.println("Game Count" + totalGame);
            if (totalGame % 2 ==0 ) {
            	ArrayList<Integer> playerAndScoure = playGame(bTeamPlayerCount, baseballCheck, baseballGameMap, teamName.get(1));
            	bTeamPlayerCount += playerAndScoure.get(0);
            	bteamScore +=  playerAndScoure.get(1);
            	
            } else {
            	ArrayList<Integer> playerAndScoure = playGame(aTeamPlayerCount, baseballCheck, baseballGameMap, teamName.get(0));
            	aTeamPlayerCount += playerAndScoure.get(0);
            	ateamScore += playerAndScoure.get(1);
            }
            
        }
    	
        System.out.println("경기 종료/n");
        System.out.println(teamName.get(0)+ " VS " +teamName.get(1));
        System.out.println(ateamScore+ " : " +bteamScore);
        
        System.out.println("Thank you!");
    	
        totalScoreBoard.put("player", totalScore);
        totalScoreBoard.put("score", totalScore);
        totalScoreBoard.put("score", totalScore);
    	return totalScoreBoard;
    }
    

    public static ArrayList<Integer> playGame(int playerCount, String baseballCheck[], Map<String, LinkedHashMap> baseballGameMap, String team){
    	ArrayList<Integer> resultList = new ArrayList<Integer>();
    	int score = 0;
    	//안타 3번 1점, 아웃 3번 팀교체
    	int out = 0;
    	int strike = 0;
        int ball = 0;
        int onBase = 0;
        
        while (out <= 2) {//랜덤 문자(스트라이크(S), 볼(B), 아웃(O))
        	
        	ArrayList playerAndBat = playerCheck(playerCount, team, baseballGameMap);
        	
        	System.out.println(playerAndBat.get(0) + "번 " + playerAndBat.get(1));
            Random judgeRandom = new Random();
            int randomNum = judgeRandom.nextInt(baseballCheck.length);    
            
            //선수 구하는 공식
            
            if (randomNum == 0) {
                strike++;
                System.out.println(baseballCheck[randomNum]);
                if (strike == 3) {
                    System.out.println("아웃!");
                    strike = 0;
                    ball = 0;
                    out++;
                    playerCount++;
                }
            } else if (randomNum == 1) {
                ball++;
                System.out.println(baseballCheck[randomNum]);
                if (ball == 4) {
                    System.out.println("출루!");
                    strike = 0;
                    ball = 0;
                    onBase++;
                    playerCount++;
                }
            } else if (randomNum == 2) { //안타
                System.out.println(baseballCheck[randomNum]);
                strike = 0;
                ball = 0;
                onBase++;
                playerCount++;
                    
            } else if (randomNum == 3) {// 아웃
                System.out.println(baseballCheck[randomNum]);
                strike = 0;
                ball = 0;
                out++;
                playerCount++;    
            }
                                                    
            System.out.println(strike + "S " + ball + "B " + out + "O");
            System.out.println("out Count : " + out);
            System.out.println();
            

            //종료 후 안타수로 점수 계산
            int plusScore = onBase / 4;
            score += plusScore;
           
        }
        resultList.add(playerCount);
    	resultList.add(score);
    	
    	return resultList; 
    }
    
    public static ArrayList<String> playerCheck(int playerCount, String team, Map<String, LinkedHashMap> baseballGameMap){
    	String player = "";
    	ArrayList<String> returnList = new ArrayList<String>();
    	ArrayList<String> playerList = new ArrayList<String>();
    	ArrayList<String> batList = new ArrayList<String>();
    	
    	int playerNum = playerCount % 9;
    	
    	LinkedHashMap<String, String> playerMap = baseballGameMap.get(team);
    	for (String key : playerMap.keySet()) {
    		playerList.add(key);
    		batList.add(playerMap.get(key));
    	}
    	String playNum = Integer.toString(playerNum);
    	returnList.add(playNum);
    	returnList.add(playerList.get(playerNum));
    	returnList.add(batList.get(playerNum));
    	
    	return returnList; 
    }
    
}