package com.code.test;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class codeSquadMain {
	public static void main(String[] args){
        //int totalNum = 0;
        //int totalGame = 18;
                
        // 사람별 점수확인하기 위한 
        Map<String, ArrayList> aTeamMember = new HashMap<String, ArrayList>();
        Map<String, ArrayList> bTeamMember = new HashMap<String, ArrayList>();
        
		//String baseballJudge[] = {"S", "B", "A", "O"}; //A = 안타
		String baseballCheck[] = {"스트라이크!", "볼!", "안타!", "아웃!"};	
        
        //Step 1 야구경기 결과
        //Map<String, HashMap> baseballGameResultMap = stepOne(baseballCheck[]);
       
        System.out.println("신나는 야구 시합");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 출력");
        
        //데이터가 입력되면 게임을 시작 할 수 있도록 설계 
        //System.out.println("3. 야구게임 시작");
        
        Scanner scn = new Scanner(System.in);
        String choice = scn.nextLine();
        
        Map<String, HashMap> baseballGameMap = new HashMap<String, HashMap>();
        

        // 데이터 입력된게 저장이 되어야 함. 만약 다시 1번을 누른다면 기존 정보 리셋 
        if (choice.equals("1")) {
        	
        	//Map에 Map담기가 안될경우 Map의 첫번째 순서에 팀이름 넣기
            for (int team = 1; team <= 2; team++) {
            	Map<String, String> playerMap = new HashMap<String, String>();
                System.out.println(team + "팀의 이름을 입력하세요>");
                //중복 처리
                String teamName = scn.nextLine();
                for (int i = 1; i <= 9; i++) {
                    System.out.print(i + "번 타자 정보 입력>");
                    String playerName = scn.nextLine();
                    System.out.print(", ");
                    String playerBattingAverage = scn.nextLine();//소수점 3자리까지
                    
                    playerMap.put(playerName, playerBattingAverage);
                    //Double playerBattingAverage = scn.nextDouble();//소수점 3자리까지
                }
                baseballGameMap.put(teamName, (HashMap) playerMap);
            }
            
        // 1번에 담은 정보를 출력
        } else if (choice == "2") {
        	System.out.println(baseballGameMap);
        } else {
        	//validation 처리하기
            System.out.println("1, 2 둘중의 메뉴를 선택하세요.");
        }
        
        Map stepTwoResult = stepTwo(baseballGameMap, baseballCheck);
	}
    
	
    public static HashMap stepOne(String baseballCheck[]){
        HashMap resultMap = new HashMap();
        String nextBatter = " 다음 타자가 타석에 입장했습니다.";
        
		System.out.println("신나는 야구 게임!");
		System.out.println("첫 번째 타자가 타석에 입장했습니다.");
        
        // 전체 6회 까지 총 12게임 
		for (int i = 1; i <= 3; i++) {
            int out = 0;
            System.out.println("Game Count" + i);
            int strike = 0;
            int ball = 0;
            
            while (out <= 2) {//랜덤 문자(스트라이크(S), 볼(B), 아웃(O))
                                                
                Random ran = new Random();
                int randomNum = ran.nextInt(baseballCheck.length);    

                if (randomNum == 0) {
                    strike++;
                    System.out.println(baseballCheck[randomNum]);
                    if (strike == 3) {
                        System.out.println("아웃!" + nextBatter);
                        strike = 0;
                        ball = 0;
                        out++;
                    }
                } else if (randomNum == 1) {
                    ball++;
                    System.out.println(baseballCheck[randomNum]);
                    if (ball == 4) {
                        System.out.println("출루!" + nextBatter);
                        strike = 0;
                        ball = 0;
                    }
                } else if (randomNum == 2) {
                    System.out.print(baseballCheck[randomNum]);
                    System.out.println(nextBatter);
                    strike = 0;
                    ball = 0;
                        
                } else if (randomNum == 3) {
                    System.out.print(baseballCheck[randomNum]);
                    System.out.println(nextBatter);
                    strike = 0;
                    ball = 0;
                    out++;
                        
                }
                                                        
                System.out.println(strike + "S " + ball + "B " + out + "O");
                System.out.println("out Count : " + out);
                System.out.println();
                                
            }
        }
        System.out.println("GAME OVER");
        return resultMap;
    }
    
    public static String stepOne(){
    	String result = "";
    	return result;
    }
    
    //게임실행
    public static Map stepTwo(Map<String, HashMap> baseballGameMap, String baseballCheck[]){
    	HashMap<String, HashMap> totalScoreBoard = new HashMap<String, HashMap>();
    	HashMap<String, String> totalScore = new HashMap<String, String>();
    	int aTeamPlayerCount = 0;
    	int bTeamPlayerCount = 0;
    	
    	for (int totalGame = 1; totalGame <= 6; totalGame++) {
            int out = 0;
            System.out.println("Game Count" + totalGame);
            int strike = 0;
            int ball = 0;
            int onBase = 0;
            int gamecount = 0;
            
            
            //안타 3번 1점, 아웃 3번 팀교체
            while (out <= 2) {//랜덤 문자(스트라이크(S), 볼(B), 아웃(O))
                Random judgeRandom = new Random();
                int randomNum = judgeRandom.nextInt(baseballCheck.length);    
                
                if (totalGame % 2 ==0 ) {
                	bTeamPlayerCount++;
                } else {
                	aTeamPlayerCount++;
                }
                //선수 구하는 공식
                
                
                if (randomNum == 0) {
                    strike++;
                    System.out.println(baseballCheck[randomNum]);
                    if (strike == 3) {
                        System.out.println("아웃!");
                        strike = 0;
                        ball = 0;
                        out++;
                    }
                } else if (randomNum == 1) {
                    ball++;
                    System.out.println(baseballCheck[randomNum]);
                    if (ball == 4) {
                        System.out.println("출루!");
                        strike = 0;
                        ball = 0;
                        onBase++;
                    }
                } else if (randomNum == 2) { //안타
                    System.out.println(baseballCheck[randomNum]);
                    strike = 0;
                    ball = 0;
                    onBase++;
                        
                } else if (randomNum == 3) {
                    System.out.println(baseballCheck[randomNum]);
                    strike = 0;
                    ball = 0;
                    out++;
                        
                }
                                                        
                System.out.println(strike + "S " + ball + "B " + out + "O");
                System.out.println("out Count : " + out);
                System.out.println();
                
            }
            //종료 후 안타수로 점수 계산
            int score = onBase / 4;

            String gameTime = Integer.toString(totalGame);
            String scoreStr = Integer.toString(score);
            totalScore.put(gameTime, scoreStr);
            
        }
        System.out.println("경기 종료");
        
        //전체 스코어 보여주기
        //JTablebaseballScorePanel scoreBoard = new JTablebaseballScorePanel();
        
        System.out.println("Thank you!");
    	
//    	for (String key : baseballGameMap.keySet()) {
//    	}
        totalScoreBoard.put("player", totalScore);
        totalScoreBoard.put("score", totalScore);
        totalScoreBoard.put("score", totalScore);
    	return totalScoreBoard;
    }
    
    public static String playerCheck(){
    	String player = "";
    	
    	
    	return player; 
    }
}