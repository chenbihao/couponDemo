package cn.noobbb.coupon.template.dao.converter;

import cn.noobbb.coupon.template.api.enums.CouponType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CouponTypeConverter
        implements AttributeConverter<CouponType, String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponCategory) {
        return couponCategory.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
