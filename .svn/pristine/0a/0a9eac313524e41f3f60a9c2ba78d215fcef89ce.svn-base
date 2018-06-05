package com.demo.mvc.callback;

/**
 *
 */
public class Worker implements Callback {
    public static void main(String[] args){
        // step1: studentA 请室友写作业(调用)
        // step2: 室友写完后告诉studentA(回调)
        String question = "1+1=?";
        Worker student = new Worker();
        RoomMate roomMate = new RoomMate();
        roomMate.getAnswer(student,question);
    }

    @Override
    public String callback(String question, String answer) {
        System.out.println("工地木头数：");
        if(answer != null) {
            System.out.println("工地木头数："+question+" 答案："+ answer);
        } else {
            System.out.println("工地木头数："+question+" 答案："+ "(空白)");
        }
        return "i executed ~ ";
    }
}
