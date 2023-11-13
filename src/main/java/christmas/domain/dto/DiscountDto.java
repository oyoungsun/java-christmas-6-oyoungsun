package christmas.domain.dto;

import christmas.service.DiscountService;

public class DiscountDto {
    private final String discount;

    private DiscountDto(final DiscountService discount){
        this.discount = discount.toString();
    }

    public static DiscountDto fromDiscount(DiscountService discount){
        return new DiscountDto(discount);
    }

    public String getTotalDiscount() {
        return this.discount;
    }
}
