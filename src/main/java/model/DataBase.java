//package model;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class DataBase {
//
//    public static void main(String[] args) {
//
//        // اطلاعات بازیکنان را ایجاد می‌کنیم
//        JSONObject player1 = new JSONObject();
//        player1.put("name", "John");
//        player1.put("score", 1000);
//
//        JSONObject player2 = new JSONObject();
//        player2.put("name", "Alice");
//        player2.put("score", 1500);
//
//        // یک آرایه از بازیکنان ایجاد می‌کنیم
//        JSONArray players = new JSONArray();
//        players.add(player1);
//        players.add(player2);
//
//        // فایل JSON را ایجاد و اطلاعات بازیکنان را در آن ذخیره می‌کنیم
//        try (FileWriter file = new FileWriter("players.json")) {
//            file.write(players.toJSONString());
//            file.flush();
//            System.out.println("اطلاعات بازیکنان با موفقیت در فایل ذخیره شد.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
