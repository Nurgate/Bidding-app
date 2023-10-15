package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConditionInit implements CommandLineRunner {
    private final ConditionRepository conditionRepository;

    public ConditionInit(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void run(String... args) {
        List<Condition> conditions = new ArrayList<>();

        boolean hasConditions = conditionRepository.count() > 0;

        if (!hasConditions) {
            Arrays.stream(ConditionName.values())
                    .forEach(conditionName -> {
                        Condition condition = new Condition();
                        condition.setName(conditionName);
                        conditions.add(condition);
                    });
            conditionRepository.saveAll(conditions);
        }
    }
}
