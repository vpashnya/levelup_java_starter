package ru.levelup.lesson20.dao;

import ru.levelup.lesson20.entities.Region;

import java.util.List;

public interface RegionDao {
    public List<Region> getAllRegion();

    public void saveRegion(Region region);

    public Region getRegion(int id);

    public Region getRegionByCode(String code);

    public void deleteRegion(int id);
}
