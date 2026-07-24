package groupe2.service.impl;

import groupe2.entity.Type;
import groupe2.repository.TypeRepository;
import groupe2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository repository;

    @Override
    public void save(Type type) {
        repository.save(type);
    }

    @Override
    public List<Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
