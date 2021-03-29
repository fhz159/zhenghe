package com.liantong.integration.service;

import com.liantong.integration.mapper.PlanMapper;
import com.liantong.integration.pojo.Plan;
import com.liantong.integration.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlanService implements PlanMapper {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public Plan select(Object id) {
        return planMapper.select(id);
    }

    @Override
    public void loadUser(User user, Plan plan) {
        user.removeAllPlan();
        plan.setUser(user);
        user.setPlan(planMapper.selectAll(plan));
    }

    @Override
    public Collection<Plan> selectAll(Plan plan) {
        return planMapper.selectAll(plan);
    }

    @Override
    public void insert(Plan plan) {
        planMapper.insert(plan);
    }
}
