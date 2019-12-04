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
                
        // ����� ����Ȯ���ϱ� ���� 
        Map<String, ArrayList> aTeamMember = new HashMap<String, ArrayList>();
        Map<String, ArrayList> bTeamMember = new HashMap<String, ArrayList>();
        
		//String baseballJudge[] = {"S", "B", "A", "O"}; //A = ��Ÿ
		String baseballCheck[] = {"��Ʈ����ũ!", "��!", "��Ÿ!", "�ƿ�!"};	
        
        //Step 1 �߱���� ���
        //Map<String, HashMap> baseballGameResultMap = stepOne(baseballCheck[]);
       
        System.out.println("�ų��� �߱� ����");
        System.out.println("1. ������ �Է�");
        System.out.println("2. ������ ���");
        
        //�����Ͱ� �ԷµǸ� ������ ���� �� �� �ֵ��� ���� 
        //System.out.println("3. �߱����� ����");
        
        Scanner scn = new Scanner(System.in);
        String choice = scn.nextLine();
        
        Map<String, HashMap> baseballGameMap = new HashMap<String, HashMap>();
        

        // ������ �ԷµȰ� ������ �Ǿ�� ��. ���� �ٽ� 1���� �����ٸ� ���� ���� ���� 
        if (choice.equals("1")) {
        	
        	//Map�� Map��Ⱑ �ȵɰ�� Map�� ù��° ������ ���̸� �ֱ�
            for (int team = 1; team <= 2; team++) {
            	Map<String, String> playerMap = new HashMap<String, String>();
                System.out.println(team + "���� �̸��� �Է��ϼ���>");
                //�ߺ� ó��
                String teamName = scn.nextLine();
                for (int i = 1; i <= 9; i++) {
                    System.out.print(i + "�� Ÿ�� ���� �Է�>");
                    String playerName = scn.nextLine();
                    System.out.print(", ");
                    String playerBattingAverage = scn.nextLine();//�Ҽ��� 3�ڸ�����
                    
                    playerMap.put(playerName, playerBattingAverage);
                    //Double playerBattingAverage = scn.nextDouble();//�Ҽ��� 3�ڸ�����
                }
                baseballGameMap.put(teamName, (HashMap) playerMap);
            }
            
        // 1���� ���� ������ ���
        } else if (choice == "2") {
        	System.out.println(baseballGameMap);
        } else {
        	//validation ó���ϱ�
            System.out.println("1, 2 ������ �޴��� �����ϼ���.");
        }
        
        Map stepTwoResult = stepTwo(baseballGameMap, baseballCheck);
	}
    
	
    public static HashMap stepOne(String baseballCheck[]){
        HashMap resultMap = new HashMap();
        String nextBatter = " ���� Ÿ�ڰ� Ÿ���� �����߽��ϴ�.";
        
		System.out.println("�ų��� �߱� ����!");
		System.out.println("ù ��° Ÿ�ڰ� Ÿ���� �����߽��ϴ�.");
        
        // ��ü 6ȸ ���� �� 12���� 
		for (int i = 1; i <= 3; i++) {
            int out = 0;
            System.out.println("Game Count" + i);
            int strike = 0;
            int ball = 0;
            
            while (out <= 2) {//���� ����(��Ʈ����ũ(S), ��(B), �ƿ�(O))
                                                
                Random ran = new Random();
                int randomNum = ran.nextInt(baseballCheck.length);    

                if (randomNum == 0) {
                    strike++;
                    System.out.println(baseballCheck[randomNum]);
                    if (strike == 3) {
                        System.out.println("�ƿ�!" + nextBatter);
                        strike = 0;
                        ball = 0;
                        out++;
                    }
                } else if (randomNum == 1) {
                    ball++;
                    System.out.println(baseballCheck[randomNum]);
                    if (ball == 4) {
                        System.out.println("���!" + nextBatter);
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
    
    //���ӽ���
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
            
            
            //��Ÿ 3�� 1��, �ƿ� 3�� ����ü
            while (out <= 2) {//���� ����(��Ʈ����ũ(S), ��(B), �ƿ�(O))
                Random judgeRandom = new Random();
                int randomNum = judgeRandom.nextInt(baseballCheck.length);    
                
                if (totalGame % 2 ==0 ) {
                	bTeamPlayerCount++;
                } else {
                	aTeamPlayerCount++;
                }
                //���� ���ϴ� ����
                
                
                if (randomNum == 0) {
                    strike++;
                    System.out.println(baseballCheck[randomNum]);
                    if (strike == 3) {
                        System.out.println("�ƿ�!");
                        strike = 0;
                        ball = 0;
                        out++;
                    }
                } else if (randomNum == 1) {
                    ball++;
                    System.out.println(baseballCheck[randomNum]);
                    if (ball == 4) {
                        System.out.println("���!");
                        strike = 0;
                        ball = 0;
                        onBase++;
                    }
                } else if (randomNum == 2) { //��Ÿ
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
            //���� �� ��Ÿ���� ���� ���
            int score = onBase / 4;

            String gameTime = Integer.toString(totalGame);
            String scoreStr = Integer.toString(score);
            totalScore.put(gameTime, scoreStr);
            
        }
        System.out.println("��� ����");
        
        //��ü ���ھ� �����ֱ�
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