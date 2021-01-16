package com.company;

public class Runner extends Thread {

    private final int FINAL_RUNNER = 5;
    private int num = 1;

    public Runner(int num) {
        super("Runner" + num);
        this.num = num;
    }

    public Runner() {
        super("Runner" + 1);
    }

    public void run() {
        try {
            System.out.println(getName() + " берет палочку");
            if (num == FINAL_RUNNER){
                System.out.println(getName() + " бежит к финишу");
                System.out.println(getName() + " бежит к Runner " + (num -1));
            }else{
                System.out.println(getName() + " бежит к Runner " + (num+1));
                sleep(5000);
                Runner nextRunner = new Runner(num +1);
                nextRunner.start();
                nextRunner.join();
                sleep(5000);
                System.out.println(getName() + " берет палочку");
                if (num!=1){
                    System.out.println(getName() + " бежит к Runner " + (num -1));
                }
            }
        }catch (InterruptedException ie){
        }


    }

}
