package com.liantong.integration.mapper;

import com.liantong.integration.pojo.Plan;
import com.liantong.integration.pojo.User;

import java.util.Collection;

public interface PlanMapper {
    public Plan select(Object id);
    public void loadUser(User user, Plan plan);
    public Collection<Plan> selectAll(Plan plan);
    public void insert(Plan plan);
}
