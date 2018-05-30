
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

        get("/destinations/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Destination.clearAllDestinations();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/destinations/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDestinationToFind = Integer.parseInt(req.params("id"));
            Destination foundDestination = Destination.findById(idOfDestinationToFind);
            model.put("destination", foundDestination);
            return new ModelAndView(model, "destination-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/destinations/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDestinationToEdit = Integer.parseInt(req.params("id"));
            Destination editDestination = Destination.findById(idOfDestinationToEdit);
            model.put("editDestination", editDestination);
            return new ModelAndView(model, "newdestination-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/destinations/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newCountry = req.queryParams("country");
            String newCityArea = req.queryParams("cityArea");
            String newDate = req.queryParams("date");
            String newReason = req.queryParams("reason");
            String newPicture = req.queryParams("picture");
            String newHighlights = req.queryParams("highlights");
            int idOfDestinationToEdit = Integer.parseInt(req.params("id"));
            Destination editDestination = Destination.findById(idOfDestinationToEdit);
            editDestination.setCountry(newCountry);
            editDestination.setCityArea(newCityArea);
            editDestination.setDate(newDate);
            editDestination.setReason(newReason);
            editDestination.setPicture(newPicture);
            editDestination.setHighlights(newHighlights);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/destinations/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDestinationToDelete = Integer.parseInt(req.params("id"));
            Destination noMasDestination = Destination.findById(idOfDestinationToDelete); //use it to find post
            noMasDestination.deleteDestination();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
