package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Garbage;
import ru.geekbrains.persist.repository.GarbageRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class GarbageService {
    @EJB
    private GarbageRepository repository;

    @Transactional
    public Garbage merge(GarbageRepr garbage) {
        return repository.merge(new Garbage(garbage));
    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Transactional
    public GarbageRepr findById(int id) {
        return new GarbageRepr(repository.findById(id));
    }

    @Transactional
    public boolean existsById(int id) {
        return repository.findById(id) != null;
    }

    @Transactional
    public List<GarbageRepr> getAllGarbages() {
        return repository.getAllGarbages().stream()
                .map(GarbageRepr::new)
                .collect(Collectors.toList());
    }
}
