package com.demo.mvc.callback;

/**
 * 回调故名思意，也只是一个函数，只是在某个时间点或执行点时变成了回调函数，
 * 其本质还是一个函数，只是函数的调用方式才把这个函数称为回调函数
 * 回调使用的场景一般是当某个时间点或事件到达时，执行的一个指定函数（执行事件驱动的任务），如
 * 比如有货了通知我 | 你到家了再叫我做饭 等等之类的
 * 回调函数最大的优势在于，执行异步回调，这样是其最被广为使用的原因。
 * 回调函数的使用增加了学习成本，需要一定的抽象思维能力，深入理解业务场景
 * https://www.zhihu.com/question/19801131
 * 回调函数的基本实践：
 * 1，定义回调接口（用于状态通知或其它关联时间执行）
 * 2，被通知对象或实体（student/worker）实现回调接口，如student
 * 3，业务执行对象（如 rootMate)执行回调
 *  学生或劳动者请某人做某事，当事情完成时，返回通知或结果状态，该例体现了 情况怎么样了，通知我
 *
 */
public class Student implements Callback {
    public static void main(String[] args){
        // step1: studentA 请室友写作业(调用)
        // step2: 室友写完后告诉studentA(回调)
        String question = "1+1=?";
        Student student = new Student();
        RoomMate roomMate = new RoomMate();
//        student.ask(roomMate,question); // 异步
        System.out.println(roomMate.getAnswer(student,question));// 同步
    }

    void ask(final RoomMate roomMate, final String question){
        new Thread(new Runnable() {
            @Override
            public void run() {
                roomMate.getAnswer(Student.this, question);
            }
        }).start();
    }

    @Override
    public String callback(String question, String answer) {
        System.out.println("作业本");
        if(answer != null) {
            System.out.println("作业："+question+" 答案："+ answer);
        } else {
            System.out.println("作业："+question+" 答案："+ "(空白)");
        }
        return "i executed ! ";
    }
}
