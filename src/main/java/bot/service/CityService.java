package bot.service;

import bot.entity.City;

public interface CityService {
    void delete(long id);
    City addCity(City city);
    City getById(long id);
    City getByName(String name);
}
