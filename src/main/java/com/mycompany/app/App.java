package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{

        public static String method(int[] array1,int[] array2,String player1,String player2)
   {
       String temp="";
       String temp2="";

       for (int i = 0; i <array1.length ; i++)
       {
           if(i==0)
           {
               temp+=array1[i];
           }
           else{
               temp+="-"+array1[i];
           }

       }
       for (int i = 0; i <array2.length ; i++)
       {
           if(i==0)
           {
               temp2+=array2[i];

           }
           else{
               temp2+="-"+array2[i];
           }
       }


       player1+=":"+temp;
       player2+=":"+temp2;



       return player1+"\n"+player2;
   }

    public static void main(String[] args) {

            port(getHerokuAssignedPort());

            get("/", (req, res) -> "Hello, World");

            post("/compute", (req, res) -> {
              //System.out.println(req.queryParams("input1"));
              //System.out.println(req.queryParams("input2"));

              String input1 = req.queryParams("input1");
              java.util.Scanner sc1 = new java.util.Scanner(input1);
              sc1.useDelimiter("[;\r\n]+");
               int[] inputList1 = new int[20];
               int flag=0;
              while (sc1.hasNext() && flag<inputList1.length)
              {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1[flag]=value;
                flag++;
              }

              System.out.println(inputList1);


              String input2 = req.queryParams("input2");
              java.util.Scanner sc2 = new java.util.Scanner(input2);
              sc2.useDelimiter("[;\r\n]+");
               int[] inputList2 = new int[20];
               int flag2=0;
              while (sc2.hasNext() && flag2<inputList2.length)
              {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2[flag2]=value;
                flag2++;
              }

              String input3=req.queryParams("input3").replaceAll("\\s","");

              String input4=req.queryParams("input4").replaceAll("\\s","");


              String result = App.method(inputList1,inputList2,input3,input4);



             Map map = new HashMap();
              map.put("result", result);
              return new ModelAndView(map, "compute.mustache");
            }, new MustacheTemplateEngine());


            get("/compute",
                (rq, rs) -> {
                  Map map = new HashMap();
                  map.put("result", "not computed yet!");
                  return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
        }

        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
         }
