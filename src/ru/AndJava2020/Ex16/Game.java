package ru.AndJava2020.Ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static ArrayList<Integer> cards1=new ArrayList<>();
    static ArrayList<Integer> cards2=new ArrayList<>();
    static int motion=0;
    public static void start(){
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        String [] spl=s.split(" ");
        for (int i = 0; i <spl.length ; i++) {
            int a= Integer.parseInt(spl[i]);
            cards1.add(a);
        }
        s=scan.nextLine();
        spl=s.split(" ");
        for (int i = 0; i <spl.length; i++) {
            int a= Integer.parseInt(spl[i]);
            cards2.add(a);
        }
        while(cards1.size()!=0 && cards2.size()!=0){
            if(motion==106){
                System.out.println("botva");
                end();
                return;
            }
            motion++;
            round();
        }
        end();
    }
    public static void round(){
        if(compare(cards1.get(0),cards2.get(0))){
            cards1.add(cards1.get(0));
            cards1.remove(0);
            cards1.add(cards2.get(0));
            cards2.remove(0);
        }
        else{
            cards2.add(cards2.get(0));
            cards2.remove(0);
            cards2.add(cards1.get(0));
            cards1.remove(0);
        }
    }

    public static boolean compare(int a, int b){
        if(b==0 && a==9)return false;
        if((a==0 && b==9) || a>b) return true;
        return false;
    }

    public static void end(){
        if(cards1.size()==0)
            System.out.println("second "+motion);
        if(cards2.size()==0)
            System.out.println("first "+motion);
    }
}
