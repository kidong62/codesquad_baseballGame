package com.code.test;

import java.util.Random;

public class stepOne {
	public static void main(String[] args){
        
		//String baseballJudge[] = {"S", "B", "A", "O"}; //A = ��Ÿ
		String baseballCheck[] = {"��Ʈ����ũ!", "��!", "��Ÿ!", "�ƿ�!"};	
		//"O" "�ƿ�!" = S(3)
        //"A" "��Ÿ" = B(4), A
        
		int totalSafety = 0;
        String nextBatter = " ���� Ÿ�ڰ� Ÿ���� �����߽��ϴ�.";
        
		System.out.println("�ų��� �߱� ����!");
		System.out.println("ù ��° Ÿ�ڰ� Ÿ���� �����߽��ϴ�.");
        
        // ��ü 9ȸ ���� �� 18���� 
		for (int totalGame = 1; totalGame <= 18; totalGame++) {
            int out = 0;
            System.out.println("Game Count" + totalGame);
            int strike = 0;
            int ball = 0;
            
            while (out <= 2) {
            	//���� ����(��Ʈ����ũ(S), ��(B), �ƿ�(O))
                Random judgeRandom = new Random();
                int randomNum = judgeRandom.nextInt(baseballCheck.length);    

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
                        totalSafety++;
                        strike = 0;
                        ball = 0;
                    }
                    
                } else if (randomNum == 2) {
                    System.out.print(baseballCheck[randomNum]);
                    System.out.println(nextBatter);
                    totalSafety++;
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
                System.out.println();
                                
            }
        }
		
		System.out.println("���� ��Ÿ�� : " + totalSafety);
        System.out.println("GAME OVER");
	}
}