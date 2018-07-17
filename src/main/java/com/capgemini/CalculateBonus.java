package com.capgemini;

import static java.lang.Math.floor;
import  java.lang.Math;

/**
 * Created by DLAMMERS on 5/10/2017.
 */
public class CalculateBonus {

  static public Double calculate(String jobFunction, double salary) {
      Double bonus = 0.0d;
      Double unCappedBonus;
      Double Cap = 50_000d;
      switch (jobFunction){
          case "manager":
              unCappedBonus = salary*0.20;
              break;
          case "lab rat":
              unCappedBonus = salary*0.10;
              break;
          default:
              unCappedBonus = 0.0d;
      }
        bonus = Math.min(unCappedBonus, Cap);
        return bonus;
    }

    private static Double getBonus(Double unCappedBonus) {
        Double bonus;
        Double cap = 50_000d;
        bonus = Math.min(unCappedBonus, cap);
        return bonus;
    }

}
