package com.example.inventory;

import com.example.inventory.pojo.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class SectorRepository {
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;

    static {
        sectorRepository = new SectorRepository();
    }

    public SectorRepository(){
        this.sectors = new ArrayList<>();
            initialize();
    }

    public static SectorRepository getInstance(){
        if (sectorRepository == null){
            sectorRepository = new SectorRepository();
        }
        return sectorRepository;

    }


    private void initialize(){
        addSector(new Sector(1,"Armario inferior", "ArInf","Armario para almacenar teclados",2,false,false));
        addSector(new Sector(21,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));

    }
    public void addSector(Sector sector){
        sectors.add(sector);
    }
    public ArrayList<Sector> getSectors(){
        return sectors;
    }

}


