package quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import quickstart.domain.QuickStartEntity;

/**
 * @author mtolstyh
 * @since 24.01.2017.
 */
@Service
public class QuickStartService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<QuickStartEntity> get(String entity, int page, int size) {
        Query query = new Query();
        query.skip(page * size).limit(size);
        return new PageImpl<>(
                mongoTemplate.find(query, QuickStartEntity.class, entity),
                new PageRequest(page, size),
                mongoTemplate.count(new Query(), entity));
    }

    public QuickStartEntity get(String entity, String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), QuickStartEntity.class, entity);
    }

    public QuickStartEntity save(String entity, QuickStartEntity document) {
        mongoTemplate.save(document, entity);
        return document;
    }

    public QuickStartEntity update(String entity, QuickStartEntity document) {
        mongoTemplate.save(document, entity);
        return document;
    }

    public void delete(String entity, String id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), entity);
    }
}
