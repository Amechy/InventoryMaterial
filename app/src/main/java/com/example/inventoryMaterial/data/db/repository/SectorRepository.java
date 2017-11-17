package com.example.inventoryMaterial.data.db.repository;

import com.example.inventoryMaterial.pojo.Sector;

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
        addSector(new Sector(2,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));
        addSector(new Sector(3,"Armario inferior", "ArInf","Armario para almacenar teclados",2,false,false));
        addSector(new Sector(4,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));
        addSector(new Sector(5,"Armario inferior", "ArInf","Armario para almacenar teclados",2,false,false));
        addSector(new Sector(6,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));
        addSector(new Sector(7,"Armario inferior", "ArInf","Armario para almacenar teclados",2,false,false));
        addSector(new Sector(8,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));
        addSector(new Sector(9,"Armario inferior", "ArInf","Armario para almacenar teclados",2,false,false));
        addSector(new Sector(10,"Armario superior", "ArSup","Armario para almacenar ratones",2,false,true));

    }
    public void addSector(Sector sector){
        sectors.add(sector);
    }
    public ArrayList<Sector> getSectors(){
        return sectors;
    }

}


