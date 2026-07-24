package groupe2.repository;

import groupe2.entity.Type;

import java.util.List;

public interface TypeRepository {
    void save(Type type);

    List<Type> findAll();

    Type findById(Long id);

    void delete(Long id);
}
