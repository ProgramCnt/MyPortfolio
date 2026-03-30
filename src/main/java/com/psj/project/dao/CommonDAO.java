package com.psj.project.dao;

import org.mybatis.spring.SqlSessionTemplate;

public abstract class CommonDAO {
    protected final SqlSessionTemplate template;
    protected final String NS;

    protected CommonDAO(SqlSessionTemplate template, String namespace) {
        this.template = template;
        this.NS = namespace.endsWith(".") ? namespace : namespace + ".";
    }
}
