/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        Comparator<Player> byPoints = (p1, p2) -> (p1.getGoals()+p1.getAssists()) > (p2.getGoals() + p2.getAssists()) ? -1 : 1;

        for (Player player : Arrays.stream(players).filter(n -> n.getNationality().equals("FIN")).sorted(byPoints).collect(Collectors.toList())) {
            System.out.println(player);
        }
    }
}
