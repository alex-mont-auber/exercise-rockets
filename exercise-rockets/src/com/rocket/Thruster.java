package com.rocket;

public class Thruster implements Runnable
{
    private static int Counter = 1;

    private int idThruster;

    private int maxPower;
    private int actualPower;
    private int targetPower;

    public Thruster(int maxPower)
    {
        this.idThruster = Counter;
        Counter++;
        this.maxPower = maxPower;
        this.actualPower = 0;
        this.targetPower = getTargetPower();
    }

    public int getIdThruster()
    {
        return idThruster;
    }

    public void setIdThruster(int idThruster)
    {
        this.idThruster = idThruster;
    }

    public int getMaxPower()
    {
        return maxPower;
    }

    public void setMaxPower(int maxPower)
    {
        this.maxPower = maxPower;
    }

    public int getActualPower()
    {
        return actualPower;
    }

    public void setActualPower(int actualPower)
    {
        this.actualPower = actualPower;
    }

    public int getTargetPower()
    {
        return targetPower;
    }

    public void setTargetPower(int targetPower)
    {
        this.targetPower = targetPower;
    }

    @Override
    public String toString()
    {
        return "Thruster Id = " + idThruster + " maxPower = " + maxPower;
    }

    @Override
    public void run()
    {

        if (targetPower > actualPower)
        {
            do
            {
                if (idThruster == 1 || idThruster == 2 || idThruster == 3)
                {

                    actualPower++;
                    System.out.println("Rocket One Control: Accelerating thruster ID: " + idThruster + " ** Max Power: " + maxPower + " ** Target Power to: " + targetPower + " ** Actual Power: " + actualPower);
                    if(actualPower == maxPower)
                    {
                        System.out.println("Thruster " + idThruster + " at maximum power, jumping to another thruster!");
                        break;
                    }
                }
                else
                {
                    actualPower++;
                    System.out.println("Rocket Two Control: Accelerating thruster ID: " + idThruster + " ** Max Power: " + maxPower + " ** Target Power to: " + targetPower + " ** Actual Power: " + actualPower);
                    if(actualPower == maxPower)
                    {
                        System.out.println("Thruster " + idThruster + " at maximum power, jumping to another thruster!");
                        break;
                    }
                }
            }
            while (actualPower != targetPower);
            if(actualPower == maxPower) {
                System.out.println("Thruster " + idThruster + " to maximum power!");
            }
            else
            {
                if (idThruster == 1 || idThruster == 2 || idThruster == 3)
                {
                    System.out.println("Rocket One with Thruster " + idThruster + " arrive to " + targetPower + " target power!");
                }
                else
                {
                    System.out.println("Rocket Two with Thruster " + idThruster + " arrive to " + targetPower + " target power!");
                }
            }
        }
        else if (targetPower < actualPower)
        {
            do
            {
                actualPower--;
                if (idThruster == 1 || idThruster == 2 || idThruster == 3)
                {
                    try
                    {
                        actualPower--;
                        System.out.println("Rocket One Control: Accelerating thruster ID: " + idThruster + " ** Max Power: " + maxPower + " ** Target Power to: " + targetPower + " ** Actual Power: " + actualPower);
                        Thread.sleep(300);
                        if(actualPower == maxPower)
                        {
                            System.out.println("Thruster " + idThruster + " at maximum power, jumping to another thruster!");
                            break;
                        }
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
                else
                {
                    try
                    {
                        actualPower--;
                        System.out.println("Rocket Two Control: Accelerating thruster ID: " + idThruster + " ** Max Power: " + maxPower + " ** Target Power to: " + targetPower + " ** Actual Power: " + actualPower);
                        Thread.sleep(300);
                        if (actualPower == maxPower) {
                            System.out.println("Thruster " + idThruster + " at maximum power, jumping to another thruster!");
                            break;
                        }
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            while (actualPower > targetPower);
        }
    }
}
