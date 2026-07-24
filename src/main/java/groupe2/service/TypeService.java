package groupe2.service;

import groupe2.entity.Type;

import java.util.List;

public interface TypeService {

    void save(Type type);

    List<Type> findAll();

    Type findById(Long id);

    void delete(Long id);
}
