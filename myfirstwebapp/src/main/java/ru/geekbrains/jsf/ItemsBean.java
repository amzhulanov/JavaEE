package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Item;
import ru.geekbrains.persist.item.ItemRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
public class ItemsBean implements Serializable {
    @Inject
    private ItemRepository itemRepository;

    private Logger logger = LoggerFactory.getLogger(ItemsBean.class);

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public String editItem(Item item) {
        this.item=item;
        return "/item.xhtml?faces-redirect=true";
    }

    public void deleteItem(Item item) {

        itemRepository.delete(item);
    }

    public String createItem() {

        this.item=new Item();
        return "/item.xhtml?faces-redirect=true";
    }

    public String saveItem() {
        itemRepository.merge(this.item);
        return "/items.xhtml?faces-redirect=true";
    }
}