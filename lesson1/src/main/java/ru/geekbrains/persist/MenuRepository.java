package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);
    public MenuRepository() {
    }

    public List<Menu> fillMenu(){
        List<Menu> res =new ArrayList<>();
        res.add(new Menu(1,"mainpage","Главная"));
        res.add(new Menu(2,"catalog","Каталог"));
        res.add(new Menu(3,"product","Товар"));
        res.add(new Menu(4,"order","Заказ"));
        res.add(new Menu(5,"cart","Корзина"));
        res.add(new Menu(6,"about","О компании"));
        res.add(new Menu(7,"personal-account","Личный кабинет"));
        logger.info("MenuRepository addNotebooks = "+res.get(1).getItem());
        return res;
    }
}
