package com.code.test;

import java.util.Random;

public class stepOne {
	public static void main(String[] args){
        
		//String baseballJudge[] = {"S", "B", "A", "O"}; //A = 안타
		String baseballCheck[] = {"스트라이크!", "볼!", "안타!", "아웃!"};	
		//"O" "아웃!" = S(3)
        //"A" "안타" = B(4), A
        
		int totalSafety = 0;
        String nextBatter = " 다음 타자가 타석에 입장했습니다.";
        
		System.out.println("신나는 야구 게임!");
		System.out.println("첫 번째 타자가 타석에 입장했습니다.");
        
        // 전체 9회 까지 총 18게임 
		for (int totalGame = 1; totalGame <= 18; totalGame++) {
            int out = 0;
            System.out.println("Game Count" + totalGame);
            int strike = 0;
            int ball = 0;
            
            while (out <= 2) {
            	//랜덤 문자(스트라이크(S), 볼(B), 아웃(O))
                Random judgeRandom = new Random();
                int randomNum = judgeRandom.nextInt(baseballCheck.length);    

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
		
		System.out.println("최종 안타수 : " + totalSafety);
        System.out.println("GAME OVER");
	}
}