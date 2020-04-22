package com.rocket;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

    private String idRocket;

    private List<Thruster> allThrusters = new ArrayList<>();

    public Rocket(String idRocket)
    {
        this.idRocket = idRocket;
    }

    public List<Thruster> getAllThrusters()
    {
        return allThrusters;
    }

    public String getIdRocket()
    {
        return idRocket;
    }

    public void setIdRocket(String idRocket)
    {
        this.idRocket = idRocket;
    }

    public List<Thruster> GenerateThrusters()
    {
        if(idRocket.equals("32WESSDS")){
            allThrusters.add(new Thruster(10));
            allThrusters.add(new Thruster(30));
            allThrusters.add(new Thruster(80));
            System.out.println(allThrusters);
        }
        else
        {
            allThrusters.add(new Thruster(30));
            allThrusters.add(new Thruster(40));
            allThrusters.add(new Thruster(50));
            allThrusters.add(new Thruster(50));
            allThrusters.add(new Thruster(30));
            allThrusters.add(new Thruster(10));
            System.out.println(allThrusters);
        }
        return allThrusters;
    }
    // Sustitute the standart toString for this on Rocket and thrusters

    @Override
    public String toString()
    {
        return "Rocket Code=" + getIdRocket() + ", thrusterList=" + allThrusters;
    }

    public void AutomaticResponse(int targetPower)
    {

        for (Thruster thruster : allThrusters )
        {
            thruster.setTargetPower(targetPower);
            Thread t = new Thread(thruster);
            t.start();
        }
    }
}
