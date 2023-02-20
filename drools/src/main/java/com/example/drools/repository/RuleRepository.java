package com.example.drools.repository;

import com.example.drools.model.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends MongoRepository<Rule,Long> {

    Rule findByRuleKey(String ruleKey);
}
