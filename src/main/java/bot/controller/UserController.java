package bot.controller;

import bot.entity.City;
import bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private CityService cityService;

    @RequestMapping(path="/city", method= RequestMethod.POST)
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

    @RequestMapping(path="/city/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id){
        cityService.delete(id);
    }

    @RequestMapping(path="/city/{name}", method=RequestMethod.GET)
    public String getByName(@PathVariable(name = "name") String name){
        City city=cityService.getByName(name);
        if (city!=null) {
            return city.getDescription();
        }else{
            return null;
        }
    }
}
