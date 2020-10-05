package com.byteobject.prototype.printfizzbuzz;

public class FizzBuzzMain {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(16);

        new Thread(()-> {
            try {
                fizzBuzz.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizz,");
                    }
                });
                System.out.println("done with fizz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Fizz").start();

        new Thread(()-> {
            try {
                fizzBuzz.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("buzz,");
                    }
                });
                System.out.println("done with buzz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Buzz").start();

        new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizzbuzz,");
                    }
                });
                System.out.println("done with fizzbuzz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "FizzBuzz").start();

        new Thread(()-> {
            try {
                fizzBuzz.number((i)-> System.out.println(i + ","));
                System.out.println("done with number");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Number").start();

    }

}
