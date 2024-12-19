
import java.util.Scanner;
import java.util.Random;
public class Game1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random ra=new Random();
        System.out.println("ONLINE GAMBLE GAME");
        System.out.println();
        System.out.println("In this game,the system and you will be separately given 4 numbers varying from 0 to 10.");
        System.out.println();
        System.out.println("Please input your ideal start-up fund:");
        int defaultmoney=sc.nextInt();
        System.out.println("Please input your ideal chip:");
        int chip=sc.nextInt();
        System.out.println("GAME START!");
        System.out.println("Your initial game point is 1000");
        int finalmoney=defaultmoney;
        int finalpoint=0;
        boolean borrow=false;
        int bormoney=0;
        int cosmoney=0;
        System.out.print("Please choose your ideal difficulty:1(easy),2(normal),3(hard),4(impossible)");
        System.out.println("(PS:The more difficult your game is, the more reward you will probably gain.)");
        int a=sc.nextInt();
        int[] bValues={9,8,7,6};
        int b=(a>=1 && a<=4)?bValues[a-1]:9;

        //above are default settings

        for (int i=1;i<1000;i++){
            System.out.println("ROUND"+i);
            System.out.print("The four numbers from the system are:");
            int sysnum1= ra.nextInt(10);
            int sysnum2= ra.nextInt(10);
            int sysnum3= ra.nextInt(10);
            int sysnum4= ra.nextInt(10);
            int sysnumsum=sysnum1+sysnum2+sysnum3+sysnum4;
            System.out.print(sysnum1+"\t");
            System.out.print(sysnum2+"\t");
            System.out.print(sysnum3+"\t");
            System.out.println(sysnum4+"\t");
            System.out.print("The sum of the numbers from the system is:");
            System.out.println(sysnumsum);
            System.out.print("The four numbers from the player are:");
            int planum1= ra.nextInt(b);
            int planum2 = ra.nextInt(b);
            int planum3= ra.nextInt(b);
            int planum4= ra.nextInt(b);
            int planumsum=planum1+ planum2 +planum3+planum4;
            System.out.print(planum1+"\t");
            System.out.print(planum2+"\t");
            System.out.print(planum3+"\t");
            System.out.println(planum4+"\t");
            System.out.print("The sum of the numbers from the player is:");
            System.out.println(planumsum);
            if(sysnumsum>planumsum){
                finalmoney=finalmoney-chip-cosmoney;
                System.out.println("You lose"+chip+"RMB.And you have only"+finalmoney+"RMB left.");
                System.out.println("Your game point is "+finalpoint+" now");
            }
            else if (sysnumsum<planumsum) {
                finalmoney=finalmoney+chip*a-cosmoney;
                System.out.println("You win"+chip*a+"RMB.And you have "+finalmoney+"RMB left.");
                finalpoint= finalpoint+200;
                System.out.println("Your game point is "+finalpoint+" now");
            }
            else{
                finalmoney=finalmoney-cosmoney;
                System.out.println("You settle for a draw.");
                System.out.println("Your game point is "+finalpoint+" now");
            }

            //above are the basic running module of the game

            Loop:if(i%(20-2*a)==0){
                int l=1;
                System.out.println("Suddenly the gamble lord"+l+" comes towards you and ask whether you wanna have a try of a bigger gamble or not.");
                System.out.println("Use all of your money. If you win, you'll get 3 times of your formal money,otherwise,you'll lose a lot.");
                System.out.println("1(yes),2(no)");
                int choise1= sc.nextInt();
                l++;
                if (choise1==1){
                    System.out.print("The four numbers from the system are:");
                    int sysnum5= ra.nextInt(10);
                    int sysnum6= ra.nextInt(10);
                    int sysnum7= ra.nextInt(10);
                    int sysnum8= ra.nextInt(10);
                    int sysnumsum0=sysnum5+sysnum6+sysnum7+sysnum8;
                    System.out.print(sysnum5+"\t");
                    System.out.print(sysnum6+"\t");
                    System.out.print(sysnum7+"\t");
                    System.out.println(sysnum8+"\t");
                    System.out.print("The sum of the numbers from the system is:");
                    System.out.println(sysnumsum0);
                    System.out.print("The four numbers from the player are:");
                    int planum5= ra.nextInt(b);
                    int planum6 = ra.nextInt(b);
                    int planum7= ra.nextInt(b);
                    int planum8= ra.nextInt(b);
                    int planumsum0=planum5+ planum6 +planum7+planum8;
                    System.out.print(planum5+"\t");
                    System.out.print(planum6+"\t");
                    System.out.print(planum7+"\t");
                    System.out.println(planum8+"\t");
                    System.out.print("The sum of the numbers from the player is:");
                    System.out.println(planumsum0);
                    if(sysnumsum0>planumsum0){
                        finalmoney=finalmoney-chip*a*10-cosmoney;
                        int c=chip*a*10;
                        System.out.println("You lose "+c+" RMB.");
                        System.out.println("Your game point is "+finalpoint+" now");
                        break Loop;
                    }
                    else if (sysnumsum0<planumsum0) {
                        finalmoney=finalmoney*3-cosmoney;
                        System.out.println("You win and you have "+finalmoney+"RMB now.");
                        finalpoint=finalpoint+200*a;
                        System.out.println("Your game point is "+finalpoint+" now");
                        break Loop;
                    }
                    else{
                        finalmoney=finalmoney-cosmoney;
                        System.out.println("You settle for a draw.");
                    }
                    System.out.println("GAME START!");
                }
                else {
                    System.out.println("Your game point is "+finalpoint+" now");
                    break Loop;
                }
            }

            //Loop:special events launch & run

            Tag:if (finalmoney<=-1&&bormoney==0){
                System.out.println("LOAN SERVICE");
                System.out.println("You can get some money if you are in badly need,but there'll be some costs.");
                System.out.println("Services:");
                System.out.println("0:not need.");
                System.out.println("1:borrow:20,cost:1/r.");
                System.out.println("2:borrow:100,cost:8/r.");
                System.out.println("3:borrow:1000,cost:80/r.");
                System.out.println("4:borrow:10000,cost:900/r.");
                System.out.println("5:borrow:100000,cost:9100/r.");
                System.out.println("Please choose your need:");
                int choise3=sc.nextInt();
                if (choise3==1){
                    bormoney=20;
                    borrow=true;
                    cosmoney=1;
                    finalmoney=finalmoney+bormoney;
                    finalpoint=finalpoint-100;
                    System.out.println("Get"+bormoney+"RMB successfully.");
                    break Tag;
                }
                else if (choise3==2){
                    bormoney=100;
                    borrow=true;
                    cosmoney=8;
                    finalmoney=finalmoney+bormoney;
                    finalpoint=finalpoint-200;
                    System.out.println("Get"+bormoney+"RMB successfully.");
                    break Tag;
                }
                else if (choise3==3){
                    bormoney=1000;
                    borrow=true;
                    cosmoney=80;
                    finalmoney=finalmoney+bormoney;
                    finalpoint=finalpoint-500;
                    System.out.println("Get"+bormoney+"RMB successfully.");
                    break Tag;
                }
                else if (choise3==4){
                    bormoney=10000;
                    borrow=true;
                    cosmoney=900;
                    finalmoney=finalmoney+bormoney;
                    finalpoint=finalpoint-1000;
                    System.out.println("Get"+bormoney+"RMB successfully.");
                    break Tag;
                }
                else if (choise3==5){
                    bormoney=100000;
                    borrow=true;
                    cosmoney=9100;
                    finalmoney=finalmoney+bormoney;
                    finalpoint=finalpoint-2000;
                    System.out.println("Get"+bormoney+"RMB successfully.");
                    break Tag;
                }
                else{
                    borrow=false;
                    break Tag;
                }
            }

            //Tag:money-borrow system

            tag:if(borrow&&finalmoney>=bormoney){
                System.out.println("Do you wanna pay back the money you have borrowed? Input'1'(Yes),'2'(No).");
                int choise4=sc.nextInt();
                if (choise4==1){
                    finalmoney=finalmoney-bormoney;
                    cosmoney=0;
                    bormoney=0;
                    borrow=false;
                    break tag;
                }
                else {
                    break tag;
                }
            }

            //tag: institution of paying back the money you have borrowed

            System.out.println("Will you continue or not? Please answer me in form of 1(yes) or 2(no) below.");
            int choise2=sc.nextInt();
            if(choise2==1){
                continue;
            }
            else if (choise2==2) {
                System.out.println("You have"+finalmoney+"RMB left at last.");
                System.out.println("But you have a "+bormoney+"RMB debt.");
                finalpoint=finalpoint+finalmoney*1000/defaultmoney;
                break;
            }
            else{
                System.out.println("You have just input an error number and we'll continue the game.");
                continue;
            }
        }

        //above: end the game and make a conclusion
        System.out.println("Your finally game point is "+finalpoint);
        if (finalpoint < 0)
        {System.out.println("You go bankrupt!!!");}
        else if(finalpoint >= 0 && finalpoint<= 1000 )
        {System.out.println("Maybe you are not so good at the game");}
        else { System.out.println("WoW,you win the game!");}
        System.out.println("PS:Gamble is STRICTLY FORBIDDEN in real world.NEVER give it a try!");

        sc.close();
    }
}

//above are the basic settings of online gambling.