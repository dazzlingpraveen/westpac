package org.westpac.util;


import cucumber.api.java.Before;




public class Environment_Properties {


    public static String env ;
    public static String work_book ;
    public static String work_sheet ;
    public static String user_dir ;


    @Before
    public static void Set_Environmentprop() {


        env = System.getProperty("env");
        user_dir = System.getProperty("user.dir");
        switch (env.trim().toLowerCase()) {


            case "sit":

     /* could do something like these for apps like banking login etc.. but don't connect to DB here

                 User_name = "";
                User_PWD = "";
                url = ""
                valid_user_username =;
                valid_user_password =
                        db_url = "";
                db_user = "";
                db_password = "";
                break; */

            case "st":

                work_book = user_dir+"/src/test/resources/testdata/testdata.xlsx";
                work_sheet = "Sheet1";

                break;

            case "preprod":

                System.out.println("Write something here");

                break;

            default:

                System.out.println("WARNING: Invalid test environment");

                break;
        }


    }
}


