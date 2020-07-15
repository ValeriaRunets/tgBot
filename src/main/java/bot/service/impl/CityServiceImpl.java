package bot.service.impl;

import bot.entity.City;
import bot.repository.CityRepository;
import bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public void delete(long id) {
        cityRepository.delete(cityRepository.getOne(id));
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getById(long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public City getByName(String name) {
        return cityRepository.findByName(name);
    }
}
