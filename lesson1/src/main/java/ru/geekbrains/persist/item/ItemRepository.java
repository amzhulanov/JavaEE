package ru.geekbrains.persist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);


    public ItemRepository() {
    }

    public List<Notebook> addNotebook(){
        List<Notebook> notebooks =new ArrayList<>();
        notebooks.add(new Notebook("ноутбук","25999 руб","Vivobook","Asus","black","15.6 дюймов"));
        notebooks.add(new Notebook("ноутбук1","10999 руб","NB61","Irbis","white","14 дюймов"));
        notebooks.add(new Notebook("ноутбук2","8999 руб","NB105","Irbis","grey","10.1 дюймов"));
        notebooks.add(new Notebook("ноутбук3","89949 руб","Тундра","Irbis","grey","10.1 дюймов"));
        notebooks.add(new Notebook("ноутбук4","89929 руб","ывв4","Эльбрус","grey","10.1 дюймов"));
        //logger.info("ItemRepository addNotebooks = "+notebooks.get(1).getName());
        return notebooks;
    }

    public List<Display> addDisplay(){
        List<Display> displays=new ArrayList<>();
        displays.add(new Display("Display","7499 руб","22MK600","LG","1920x1080 px"));
        displays.add(new Display("Display1","11499 руб","C27F","Samsung","1920x1080 px"));
        displays.add(new Display("Display2","15499 руб","U28E","Dell","1920x1080 px"));
        displays.add(new Display("Display3","3499 руб","U48E","Makito","1920x1080 px"));
        displays.add(new Display("Display4","15499 руб","U228E","Celeron","1920x1080 px"));

        return displays;
    }

}
