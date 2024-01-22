package jp.ac.uryukyu.ie.e185749;

import java.io.*;
import java.util.*;


    class QandA{
        String question;
        String[] answer;

        QandA(String question, String answerline){
            this.question = question;
            StringTokenizer token = new StringTokenizer (answerline, ",");
            answer = new String [token. countTokens()];
            for (int i = 0; token.hasMoreTokens(); i++)
                answer[i] = token.nextToken();
            
        }
        String[] getCorrect(String inputline){
            StringTokenizer token = new StringTokenizer(inputline, ",");
            int inputnum = token.countTokens();
            String[] input = new String[inputnum];
            for (int i = 0; token.hasMoreTokens(); i++)
                input[i] = token.nextToken();

            for(int i = 1; i < inputnum; i++)
                for(int j = i-1; j >= 0; j--)
                    if(input[i].equals(input[j]))
                        input[i] = "O" ;

            int correctnum = 0;
            for (int i = 0; i < inputnum; i++)
                for(int j = 0; j < answer.length; j++)
                    if(input[i].equals(answer[j]))
                        correctnum++;

            String[] correct = new String[correctnum];
            int k=0;
            for (int i = 0;i < inputnum; i++)
                for (int j = 0; j < answer.length; j++)
                    if (input[i].equals(answer[j])){
                        correct[k] = input[i];
                        k++;
                    }
            return correct;     
        }
    }



    class Quiz{
        static String getInput(){
            String input = new String();
            try{
                BufferedReader in =
                    new BufferedReader(new InputStreamReader(System.in));
                input = in.readLine();
            }catch(Exception e){
                System.out.println(e);
            }finally{
                return input;
            }
        }
        public static void main(String[] args) {
            QandA qa = new QandA("「山」がつく都道府県6つ答えよ。","山形県,山梨県,山口県,富山県,岡山県,和歌山県");
            System.out.print("[問題]" + qa.question + "＊「,」で区切って答えてね。\n> ");

            int answernum = qa.answer.length;
            String input = getInput();
            String[] correct = qa.getCorrect(input);
            int correctnum = (correct == null) ? 0 : correct.length;

            if (correctnum > 0){
                System.out.print("正解：");
                for (int j = 0; j < correctnum; j++)
                    System.out.print(correct[j] + " ");
                System.out.println();
        }
        System.out.print(correctnum + " / " + answernum + "正解");

        if (correctnum == answernum)
            System.out.println("すばらしい！！");
        else if(correctnum > answernum/2)
            System.out.println("よくできました！");
        else
            System.out.println("まだまだです。"); 
    }
}





