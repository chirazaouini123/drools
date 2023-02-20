package com.example.drools.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("rule")

public class Rule {


    @Id
    private String id;

    private String ruleKey;

    private String content;

    private String version;

    private String lastModifyTime;

    private String createTime;
}
