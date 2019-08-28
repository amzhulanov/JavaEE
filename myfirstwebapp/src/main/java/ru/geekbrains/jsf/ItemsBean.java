package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Item;
import ru.geekbrains.persist.item.ItemRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
public class ItemsBean implements Serializable {
    private ItemRepository itemRepository;

    private Logger logger = LoggerFactory.getLogger(ItemsBean.class);

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        itemRepository = (ItemRepository) servletContext.getAttribute("itemRepository");
    }

    public String openItem(){
        return "/items.xhtml?faces-redirect=true";
    }

    public List<Item> getAllItems() throws SQLException {
        return itemRepository.getAllItems();

    }

    public String editItem(Item item) {
        this.item = item;
        return "/item.xhtml?faces-redirect=true";
    }

    public void deleteItem(Item item) throws SQLException {
        itemRepository.deleteItem(item);

    }

    public String saveItem(Item item) throws SQLException {
        if (this.item.getId()!=-1){
            itemRepository.saveItem(this.item);
        }else{
            itemRepository.addItem(this.item);
        }

        return "/items.xhtml?faces-redirect=true";
    }

    public String addItem() {
        this.item = new Item();
        return "/item.xhtml?faces-redirect=true";
    }
}