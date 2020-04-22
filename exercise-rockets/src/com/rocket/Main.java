package com.rocket;

public class Main {

    public static void main(String[] args) {

        // Intro

        System.out.println();
        System.out.println("////// ****** Welcome to Race Rockets! ****** //////");
        System.out.println("Sponsored by: NASA and SpaceX");
        System.out.println("Creating rockets...");

        // Creating rockets

        Rocket rocketOne = new Rocket("32WESSDS");
        System.out.println();
        System.out.println("Rocket one ready!");
        System.out.println();
        Rocket rocketTwo = new Rocket("LDSFJA32");
        System.out.println("Rocket two ready!");
        System.out.println();

        // Creating thrusters

        System.out.println();
        System.out.println("Creating thrusters Rocket One");
        rocketOne.GenerateThrusters();
        System.out.println();
        System.out.println("Creating thrusters Rocket Two");
        rocketTwo.GenerateThrusters();

        // Setting targer power

        int targetPower = SetUpTargetPower();
        rocketOne.AutomaticResponse(targetPower);
        rocketTwo.AutomaticResponse(targetPower);

    }
    public static int SetUpTargetPower() // Automatic setup target power
    {
        int power = (int)(Math.random()*30+1);
        System.out.println();
        System.out.println("Setted new power target to " + power + "!");
        return power;
    }
}
