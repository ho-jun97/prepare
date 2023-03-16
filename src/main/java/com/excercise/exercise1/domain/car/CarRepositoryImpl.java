package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.CarSearchCondition;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.excercise.exercise1.domain.car.QCar.car;
import static com.excercise.exercise1.domain.user.QUser.user;

public class CarRepositoryImpl implements CarRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CarRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<CarDto> search(CarSearchCondition condition) {

        return queryFactory
                .select(Projections.fields(CarDto.class,
                        car.id,
                        car.number,
                        car.user.username,
                        car.address,
                        car.location.lat,
                        car.location.lng
                ))
                .from(car)
                .leftJoin(car.user, user)
                .where(
                        usernameEq(condition.getUsername()),
                        targetEq(condition.getTarget()))
                .fetch();
    }

    private BooleanExpression targetEq(String target) {
        return StringUtils.hasText(target) && target.length() >= 4 ? car.number.endsWith(target) : null;
    }

    private BooleanExpression usernameEq(String username) {
        return StringUtils.hasText(username) ? car.user.username.eq(username) : null;
    }

}
