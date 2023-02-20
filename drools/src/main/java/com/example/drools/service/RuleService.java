package com.example.drools.service;

import com.example.drools.model.Rule;
import com.example.drools.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public void save(String content) {
        Rule rule = new Rule();
        rule.setContent(content);
        ruleRepository.save(rule);
    }
}
