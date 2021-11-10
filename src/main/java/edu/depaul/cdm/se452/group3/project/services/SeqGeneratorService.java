package edu.depaul.cdm.se452.group3.project.services;


import edu.depaul.cdm.se452.group3.project.entities.MongoSeq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SeqGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSeq(String SeqName){
        Query query = new Query(Criteria.where("id").is(SeqName));
        Update update = new Update().inc("seq", 1);

        MongoSeq currentSeq = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),MongoSeq.class);
        return currentSeq != null ? currentSeq.getSeq() : 1;
    }
}
