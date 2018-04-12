package rs.edu.devcenter.maze;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Body body = new Body();
        body.print();
        body.startAndFinish();
        if(body.execute(body.getStartI(), body.getStartJ())) {
            body.print();
            body.printPath();
        } else {
            System.out.println("The maze can't be solved");
        }
    }

}
