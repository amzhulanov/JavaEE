package ru.geekbrains.persist;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    public MenuRepository() {
    }

    public List<Menu> fillMenu(){
        List<Menu> res =new ArrayList<>();
        res.add(new Menu(1,"mainpage","Главная"));
        res.add(new Menu(2,"catalog","Каталог"));
        res.add(new Menu(3,"product","Товар"));
        res.add(new Menu(4,"order","Заказ"));
        res.add(new Menu(5,"cart","Корзина"));
        res.add(new Menu(6,"personal-account","Личный кабинет"));
        return res;
    }
}
