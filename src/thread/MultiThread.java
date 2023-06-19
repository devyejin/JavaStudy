package thread;


public class MultiThread {


    public static void main(String[] args) {
        //작업 쓰레드 생성
       Thread workThread =  new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    System.out.println("작업 쓰레드 : B 작업 수행");
                    System.out.println("B작업 수행중인 쓰레드 " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); //현재 작업 중인 쓰레드 WAITING 상태로
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        });

       workThread.start(); //작업 쓰레드 수행

        for(int i=0; i<5; i++) {
            System.out.println("메인 쓰레드 : A 작업 수행");
            System.out.println("A작업 수행중인 쓰레드 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); //현재 작업 중인 쓰레드 WAITING 상태로
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        WorkThread2 workThread2 = new WorkThread2();
        workThread2.start(); //작업 쓰레드 작업 시작

        //Thread 클래스를 상속받는 경우도 익명객체를 많이 사용
        Thread workThread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("익명객체를 통한 Thread 클래스 상속으로 구현한 작업 스레드");
            }
        };

        workThread3.start();
        System.out.println("아마 메인? 수행중인 쓰레드 " + Thread.currentThread().getName());


    }
}

//쓰레드 클래스를 상속받아 작업 쓰레드를 구현하는 방법
class WorkThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 클래스를 상속받아 작업 쓰레드 구현");
    }
}
