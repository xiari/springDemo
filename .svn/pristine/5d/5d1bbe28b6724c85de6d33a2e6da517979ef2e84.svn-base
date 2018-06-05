package com.demo.mvc.callback;

class RoomMate {

    public String getAnswer(Callback callback, String question){
        // 计算结果
        String result ;
        if("1+1=?".equals(question)){
            result = "2";
        }else {
            result = "空白";
        }
        // 回调结果
        return callback.callback(question,result);
    }

//    public static void main(String[] args){
//        // 采用匿名类实现回调方法供执行计算结果后状态返回
//        RoomMate roomMate = new RoomMate();
//       System.out.print( roomMate.getAnswer(new Callback() {
//            @Override
//            public String callback(String question, String answer) {
//                System.out.println("question is : " + question + "; answer is :" + answer);
//                return  "i do ....";
//            }
//        }, "1+1=?"));
//    }
}
