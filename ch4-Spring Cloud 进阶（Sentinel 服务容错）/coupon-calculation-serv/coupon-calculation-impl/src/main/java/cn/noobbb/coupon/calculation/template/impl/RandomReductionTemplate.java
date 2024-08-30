package cn.noobbb.coupon.calculation.template.impl;

import cn.noobbb.coupon.calculation.template.AbstractRuleTemplate;
import cn.noobbb.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * 随机减钱
 */
@Slf4j
@Component
public class RandomReductionTemplate extends AbstractRuleTemplate {

    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        // 计算使用优惠券之后的价格
        Long maxBenefit = Math.min(shopAmount, quota);
        int reductionAmount = new SecureRandom().nextInt(maxBenefit.intValue());
        Long newCost = totalAmount - reductionAmount;

        log.debug("original price={}, new price={}", totalAmount, newCost);
        return newCost;
    }
}
