package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Stateful
@Named
public class GarbagesBean {

    private Logger logger = LoggerFactory.getLogger(GarbagesBean.class);

    @Inject
    private GarbageService service;

    @Inject
    private OrderService orderService;
    @Inject
    private ItemService itemService;


    private GarbageRepr bean_item;

    public GarbageRepr getGarbage() {
        return bean_item;
    }

    public void setGarbage(GarbageRepr garbage) {
        this.bean_item = garbage;
    }

    public List<GarbageRepr> getAllGarbages() {return service.getAllGarbages();}



    public String deleteGarbage(GarbageRepr garbage) { service.delete(garbage.getId());
        return "/garbages.xhtml?faces-redirect=true";}

    //restore record from garbage: order or item
    public String restore (GarbageRepr garbageRepr) {

        try {
            if (garbageRepr.getType().equals("order")) {
                logger.info("Restore from Garbage: Type=" + garbageRepr.getType() + " Id=" + garbageRepr.getId());
                OrderRepr order = new OrderRepr();
                order.setNum_order(garbageRepr.getNum_order());
                order.setBuyer(garbageRepr.getBuyer());
                orderService.merge(order);
                service.delete(garbageRepr.getId());
                return "/orders.xhtml?faces-redirect=true";
            }
            if (garbageRepr.getType().equals("item")) {
                logger.info("Restore from Garbage: Type=" + garbageRepr.getType() + " Id=" + garbageRepr.getId());
                ItemRepr item = new ItemRepr();
                item.setName(garbageRepr.getName());
                item.setCategory(garbageRepr.getCategory());
                item.setVendor(garbageRepr.getVendor());
                itemService.merge(item);
                service.delete(garbageRepr.getId());
                return "/items.xhtml?faces-redirect=true";
            }

        } catch (Exception ex){
            logger.error("Don`t complete restore from Garbage: Type=" + garbageRepr.getType() + " Id=" + garbageRepr.getId());
            logger.error(ex.toString());
        }
        return "/garbages.xhtml?faces-redirect=true";
    }
}
