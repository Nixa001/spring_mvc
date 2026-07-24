package groupe2.repository.impl;

import groupe2.entity.Type;
import groupe2.repository.TypeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TypeRepositoryImpl implements TypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Type type) {
        entityManager.merge(type);
    }

    @Override
    public List<Type> findAll() {
        return entityManager
                .createQuery("FROM Type", Type.class)
                .getResultList();
    }

    @Override
    public Type findById(Long id) {
        return entityManager.find(Type.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Type type = findById(id);

        if (type != null) {
            entityManager.remove(type);
        }
    }
}
