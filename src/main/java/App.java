
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Destination;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;



public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Destination> destinations = Destination.getAll();
            model.put("destinations", destinations);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/destinations/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newdestination-form.hbs");
        }, new HandlebarsTemplateEngine());



        post("/destinations/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String country = request.queryParams("country");
            String cityArea = request.queryParams("cityArea");
            String date = request.queryParams("date");
            String reason = request.queryParams("reason");
            String picture = request.queryParams("picture");
            String highlights = request.queryParams("highlights");
            Destination newDestination = new Destination(country, cityArea, date, reason, picture, highlights);
            model.put("destinations", newDestination);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
