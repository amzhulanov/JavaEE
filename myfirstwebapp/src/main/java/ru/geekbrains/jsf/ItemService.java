package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Item;
import ru.geekbrains.persist.repository.ItemRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ItemService {

    @EJB
    private ItemRepository itemRepository;

    @Transactional
    public Item merge(ItemRepr item) {
        return itemRepository.merge(new Item(item));
    }

    @Transactional
    public void delete(int id) {
        itemRepository.delete(id);
    }

    @Transactional
    public ItemRepr findById(int id) {
        return new ItemRepr(itemRepository.findById(id));
    }

    @Transactional
    public boolean existsById(int id) {
        return itemRepository.findById(id) != null;
    }

    @Transactional
    public List<ItemRepr> getAllItems() {
        return itemRepository.getAllItems().stream()
                .map(ItemRepr::new)
                .collect(Collectors.toList());
    }
}
